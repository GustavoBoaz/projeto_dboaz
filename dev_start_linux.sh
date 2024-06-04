#!/bin/bash

mvn clean package -Dmaven.test.skip=true

sudo docker-compose up -d --build