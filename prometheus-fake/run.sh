#!/bin/bash
docker rm -f prometheus_fake
docker build -t prometheus_fake . 
docker run --privileged --name prometheus_fake -p 1022:22 -d prometheus_fake