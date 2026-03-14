#!/usr/bin/env bash
set -xEeuo pipefail

KUBECONFIG_PATH=${KUBECONFIG:-$HOME/.kube/config}
PROJECT_DIR=${PROJECT_DIR:-$HOME/streamshub}
TEST_CASE=${TEST_CASE:-""}
TEST_PROFILE=${TEST_PROFILE:-""}
BROWSER_TYPE=${BROWSER_TYPE:-"chromium"}
SETTINGS_XML=${SETTINGS_XML:-$HOME/.m2/settings.xml}
RETRY_COUNT=${RETRY_COUNT:-4}
SKIP_BUILD=${SKIP_BUILD:-false}
SKIP_IMAGE_BUILD=${SKIP_IMAGE_BUILD:-false}
COMMAND=${COMMAND:-all}
CONSOLE_INSTALL_TYPE=${CONSOLE_INSTALL_TYPE:-"yaml"}

# Trap Ctrl+C and kill running podman containers
PODMAN_PID=""
cleanup() {
    echo "[INFO] Caught interrupt, stopping containers..."
    if [ -n "${PODMAN_PID}" ]; then
        kill "${PODMAN_PID}" 2>/dev/null || true
    fi
    podman stop $(podman ps -q) 2>/dev/null || true
    exit 1
}
trap cleanup INT TERM

HOST_IP=$(ip route get 1 | awk '{print $7; exit}')
CONSOLE_CLUSTER_DOMAIN=${CONSOLE_CLUSTER_DOMAIN:-"apps.${HOST_IP}.nip.io"}

echo "[INFO] Host IP: ${HOST_IP}"
echo "[INFO] Cluster domain: ${CONSOLE_CLUSTER_DOMAIN}"
echo "[INFO] Install type: ${CONSOLE_INSTALL_TYPE}"

# Patch kubeconfig to skip TLS verification for fabric8 client
cp ${KUBECONFIG_PATH} /tmp/kubeconfig-insecure
python3 - <<'EOF'
import yaml

with open('/tmp/kubeconfig-insecure', 'r') as f:
    kc = yaml.safe_load(f)

for cluster in kc.get('clusters', []):
    cluster['cluster'].pop('certificate-authority-data', None)
    cluster['cluster']['insecure-skip-tls-verify'] = True

with open('/tmp/kubeconfig-insecure', 'w') as f:
    yaml.dump(kc, f)

print("[INFO] Patched kubeconfig with insecure-skip-tls-verify=true")
EOF

# Patch config.yaml CONSOLE_INSTALL_TYPE to match our env var
if [ -f "${PROJECT_DIR}/systemtests/config.yaml" ]; then
    cp "${PROJECT_DIR}/systemtests/config.yaml" /tmp/config-patched.yaml
    sed -i "s|CONSOLE_INSTALL_TYPE:.*|CONSOLE_INSTALL_TYPE: ${CONSOLE_INSTALL_TYPE}|" /tmp/config-patched.yaml
    echo "[INFO] Patched config.yaml CONSOLE_INSTALL_TYPE=${CONSOLE_INSTALL_TYPE}"
    CONFIG_MOUNT="-v /tmp/config-patched.yaml:/workspace/systemtests/config.yaml:z"
else
    CONFIG_MOUNT=""
fi

build_image() {
    if [ "${SKIP_IMAGE_BUILD}" = "false" ]; then
        echo "[INFO] Building container image..."
        podman build -t streamshub-systemtests .
    else
        echo "[INFO] Skipping image build (SKIP_IMAGE_BUILD=true)"
    fi
}

build_project() {
    if [ "${SKIP_BUILD}" = "true" ]; then
        echo "[INFO] Skipping mvn install (SKIP_BUILD=true)"
        return
    fi

    echo "[INFO] Building project..."
    podman run --rm \
        --network host \
        -w /workspace \
        -v ${PROJECT_DIR}:/workspace:z \
        -v $HOME/.m2:/root/.m2:z \
        -v ${SETTINGS_XML}:/root/.m2/settings.xml:z \
        streamshub-systemtests \
        bash -c "mvn clean install -B -DskipTests --no-transfer-progress" &
    PODMAN_PID=$!
    wait $PODMAN_PID
}

run_tests() {
    echo "[INFO] Running tests:"
    echo "       Test case:   ${TEST_CASE:-<none>}"
    echo "       Profile:     ${TEST_PROFILE:-<none>}"
    echo "       Browser:     ${BROWSER_TYPE}"
    echo "       Cluster:     ${CONSOLE_CLUSTER_DOMAIN}"
    echo "       Install type: ${CONSOLE_INSTALL_TYPE}"
    echo "       Retry count: ${RETRY_COUNT}"

    MVN_CMD="mvn verify -B --no-transfer-progress -pl systemtests"
    MVN_CMD+=" -DskipSTs=false"
    MVN_CMD+=" -Djava.net.preferIPv4Stack=true"
    MVN_CMD+=" -Dkubernetes.trust.certificates=true"
    MVN_CMD+=" -Dfailsafe.rerunFailingTestsCount=${RETRY_COUNT}"
    MVN_CMD+=" -Dconsole.cluster.domain=${CONSOLE_CLUSTER_DOMAIN}"

    if [ -n "${TEST_PROFILE}" ]; then
        MVN_CMD+=" -P ${TEST_PROFILE}"
    fi

    if [ -n "${TEST_CASE}" ]; then
        MVN_CMD+=" -Dit.test=${TEST_CASE}"
    fi

    podman run --rm \
        --network host \
        -w /workspace \
        -v ${PROJECT_DIR}:/workspace:z \
        -v $HOME/.m2:/root/.m2:z \
        -v ${SETTINGS_XML}:/root/.m2/settings.xml:z \
        -v /tmp/kubeconfig-insecure:/root/.kube/config:z \
        ${CONFIG_MOUNT} \
        -e KUBECONFIG=/root/.kube/config \
        -e BROWSER_TYPE="${BROWSER_TYPE}" \
        -e CONSOLE_CLUSTER_DOMAIN="${CONSOLE_CLUSTER_DOMAIN}" \
        streamshub-systemtests \
        bash -c "${MVN_CMD}" &
    PODMAN_PID=$!
    wait $PODMAN_PID
}

# --- Main ---

build_image

case "${COMMAND}" in
    build)
        build_project
        ;;
    test)
        run_tests
        ;;
    all)
        build_project
        run_tests
        ;;
    *)
        echo "[ERROR] Unknown COMMAND: ${COMMAND}. Use: build | test | all"
        exit 1
        ;;
esac