# Usar uma imagem base do OpenJDK 21
FROM openjdk:21-jdk-slim

# Definir o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiar o arquivo JAR da aplicação para o contêiner
COPY target/*.jar app.jar

# Expor a porta que o Spring Boot usará (geralmente 8080)
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
