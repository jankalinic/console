#!/usr/bin/env bash
set -e

KAFKA_VERSION=$1
BASE_IMAGE=$2
CONNECT_IMAGE=${3:-"localhost/kafka-connect-file-plugin:latest"}

function buildImage() {
    local dockerFileDir=$(dirname "$0")

    if [ -z "${BASE_IMAGE}" ]; then
        docker build $dockerFileDir \
            --build-arg KAFKA_VERSION=$KAFKA_VERSION \
            -t $CONNECT_IMAGE
    else
        docker build $dockerFileDir \
            --build-arg KAFKA_VERSION=$KAFKA_VERSION \
            --build-arg BASE_IMAGE=$BASE_IMAGE \
            -t $CONNECT_IMAGE
    fi
}

buildImage
echo "Built: $CONNECT_IMAGE"