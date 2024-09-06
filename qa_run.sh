#!/bin/bash

# Nome do arquivo JAR (pode ser passado como argumento)
JAR_FILE="$1"

if [ -d "$JAR_FILE" ]; then
    # Executa o comando 'mvn clean package'
    mvn -B install -DskipTests -Dgatling.skip=true --file pom.xml

    # Executa o comando 'java -jar' para iniciar o módulo
    mvn -pl "$JAR_FILE" clean verify
else
    echo "Modulo '"$JAR_FILE"' não existe neste diretório."
fi
