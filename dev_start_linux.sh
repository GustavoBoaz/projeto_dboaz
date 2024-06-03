#!/bin/bash

mvn clean package

sudo docker-compose up -d --build