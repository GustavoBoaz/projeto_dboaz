#!/bin/bash

mvn clean package -Dmaven.test.skip=true

docker-compose up -d --build