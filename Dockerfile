# Utilizar la imagen oficial de OpenJDK 17 para la base
FROM openjdk:17-oracle
# Argumento para el JAR_FILE
ARG JAR_FILE=target/*.jar
# Copiar el JAR de la aplicación al contenedor
COPY target/*.jar springboot-cassandra-int.jar
# Exponer el puerto en el que se ejecuta la aplicación
EXPOSE 8080
# Comando para ejecutar la aplicación
ENTRYPOINT ["java","-jar","/app.jar"]
