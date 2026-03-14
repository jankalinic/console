ARG KAFKA_VERSION
ARG BASE_IMAGE=quay.io/strimzi/kafka:latest-kafka-${KAFKA_VERSION}

FROM ${BASE_IMAGE}

USER root
# File sink/source plugin is already bundled in the Kafka image at this path
# Just need to make it available as a connector plugin
RUN mkdir -p /opt/kafka/plugins/file-plugin && \
    cp /opt/kafka/libs/connect-file-*.jar /opt/kafka/plugins/file-plugin/

USER 1001