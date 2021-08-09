#!/bin/sh

. ./env

./mvnw clean package || exit 1

docker build -t yw/whatsinme-api . || exit 1

docker run \
    -e SERVER_PORT="$LOCAL_SERVER_PORT" \
    -e DB_URL="$LOCAL_DB_URL" \
    -e DB_USER="$LOCAL_DB_USER" \
    -e DB_PASS="$LOCAL_DB_PASS" \
    --rm \
    --name whatsinme-api \
    --network="host" \
    yw/whatsinme-api