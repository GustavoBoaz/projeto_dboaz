# Use uma imagem base com o JDK 21
FROM maven:3-sapmachine-22

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo JAR da aplicação para o contêiner
COPY target/*.jar /app/myapp.jar

# Exponha a porta que a aplicação vai usar (por exemplo, 8080)
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT java -jar /app/myapp.jar