#!/bin/sh

. ./env

./mvnw clean package || exit 1

docker build -t yw/whatsinme . || exit 1

docker run \
    -e SERVER_PORT="$SERVER_PORT" \
    -e DB_URL="$DB_URL" \
    -e DB_USER="$DB_USER" \
    -e DB_PASS="$DB_PASS" \
    --rm \
    -p ${TEST_PORT}:${SERVER_PORT} \
    --name whatsinme \
    yw/whatsinme