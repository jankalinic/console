package com.github.streamshub.systemtests.utils.resourceutils;

import com.github.streamshub.systemtests.Environment;
import com.github.streamshub.systemtests.enums.ClusterType;
import com.github.streamshub.systemtests.exceptions.ClusterUnreachableException;
import io.fabric8.openshift.api.model.config.v1.DNS;
import io.skodjob.kubetest4j.executor.ExecResult;
import io.skodjob.kubetest4j.resources.KubeResourceManager;

import java.util.Locale;

public class ClusterUtils {
    private ClusterUtils() {}

    public static void checkClusterHealth() {
        ExecResult result = KubeResourceManager.get().kubeCmdClient().exec(false, false, "cluster-info");
        // Minikube on linux could throw ansi colors
        String output = result.out().replaceAll("\u001B\\[[;\\d]*m", "").toLowerCase(Locale.ENGLISH);

        if (!result.exitStatus() || !output.contains("kubernetes control plane is running") || output.toLowerCase(Locale.ENGLISH).contains("error")) {
            throw new ClusterUnreachableException(result);
        }
    }

    public static boolean isMicroShift() {
        return ClusterType.MICROSHIFT.equals(ClusterType.fromValue(Environment.TEST_CLUSTER_TYPE));
    }

    public static boolean isOpenshift() {
        return !isMicroShift() &&
            KubeResourceManager.get().kubeCmdClient().exec(false, false, "api-versions").out().contains("openshift.io");
    }

    public static boolean isOpenShiftLike() {
        return isOpenshift() || isMicroShift();
    }

    public static String getClusterDomain() {
        if (isMicroShift()) {
            return "apps." + KubeResourceManager.get().kubeClient().getClient()
                .nodes()
                .list()
                .getItems()
                .getFirst()
                .getStatus()
                .getAddresses()
                .stream()
                .filter(a -> a.getType().equals("InternalIP"))
                .findFirst()
                .get()
                .getAddress() + ".nip.io";
        }
        if (isOpenshift()) {
            return "apps." + ResourceUtils.getKubeResource(DNS.class, "cluster").getSpec().getBaseDomain();
        }
        return Environment.CONSOLE_CLUSTER_DOMAIN;
    }
}
