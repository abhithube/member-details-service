#!/bin/bash

docker build -t abhithube/member-details .
echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
docker push abhithube/insurance-portal