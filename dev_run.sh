#!/bin/bash

# Nome do arquivo JAR (pode ser passado como argumento)
JAR_FILE="$1"

if [ -d "$JAR_FILE" ]; then
    # Executa o comando 'mvn clean package'
    mvn clean package -Dmaven.test.skip=true

    # Executa o comando 'java -jar' para iniciar o módulo
    java -jar -Dspring.profiles.active=dev "$JAR_FILE"/target/*.jar
else
    echo "Modulo '"$JAR_FILE"' não existe neste diretório."
fi
