#!/bin/sh

. ./env

./mvnw clean package || exit 1

docker build -t yw/whatsinme . || exit 1

case $1 in
    "local")
        docker run \
            -e SERVER_PORT="$LOCAL_SERVER_PORT" \
            -e DB_URL="$LOCAL_DB_URL" \
            -e DB_USER="$LOCAL_DB_USER" \
            -e DB_PASS="$LOCAL_DB_PASS" \
            --rm \
            -p ${LOCAL_REAL_PORT}:${LOCAL_SERVER_PORT} \
            --name whatsinme \
            --network="host" \
            yw/whatsinme
    ;;
    *)
        docker run \
            -e SERVER_PORT="$SERVER_PORT" \
            -e DB_URL="$DB_URL" \
            -e DB_USER="$DB_USER" \
            -e DB_PASS="$DB_PASS" \
            --rm \
            -p ${REAL_PORT}:${SERVER_PORT} \
            --name whatsinme \
            yw/whatsinme
    ;;
esac
