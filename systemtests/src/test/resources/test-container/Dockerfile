FROM ubuntu:24.04

# System dependencies
RUN apt-get update && apt-get install -y \
    curl \
    wget \
    git \
    jq \
    unzip \
    ca-certificates \
    gnupg \
    lsb-release \
    software-properties-common \
    build-essential \
    docker.io \
    conntrack \
    socat \
    iptables \
    && rm -rf /var/lib/apt/lists/*

# Install Java 21 (Temurin like setup-java action)
RUN apt-get update && apt-get install -y openjdk-21-jdk maven

# Install Node LTS (same as actions/setup-node)
RUN curl -fsSL https://deb.nodesource.com/setup_lts.x | bash - \
    && apt-get install -y nodejs

# Install Playwright + browsers
RUN npm install -g playwright \
    && npx playwright install --with-deps

# Install kubectl
RUN curl -LO https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl \
    && install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl \
    && rm kubectl

# Install oc client
RUN curl -sL https://mirror.openshift.com/pub/openshift-v4/clients/ocp/stable/openshift-client-linux.tar.gz | \
    tar xz -C /usr/local/bin oc

# Install yq (same version used in workflow)
ENV YQ_VERSION=v4.44.1
RUN wget https://github.com/mikefarah/yq/releases/download/${YQ_VERSION}/yq_linux_amd64 \
    -O /usr/local/bin/yq \
    && chmod +x /usr/local/bin/yq