# Stage 1: Build the application
FROM maven:3.8.1-openjdk-17-slim AS MAVEN_BUILD
#Se construye la carpeta
RUN mkdir /api-retekki
##########
COPY ./ /
# Se construye el archivo jar de springboot
RUN echo "Building app..." && mvn clean package -DskipTests
# Utilizar la imagen oficial de eclipse temurin 17
# Stage 2: Springboot
FROM eclipse-temurin:17-jdk
# Volumen para copia y construccion en memoria
VOLUME /tmp
# Argumento para el JAR_FILE
#ARG JAR_FILE=target/*.jar
# Copiar el JAR de la aplicación al contenedor--con el alias app
COPY target/*.jar app.jar
# Exponer el puerto en el que se ejecuta la aplicación
#EXPOSE 8080
# Comando para ejecutar la aplicación
ENTRYPOINT ["java","-jar","/app.jar"]
