# Usamos una imagen base de Java
FROM openjdk:17

WORKDIR /app

# Copiamos el archivo JAR generado por Spring Boot
COPY taller.jar app.jar

# Exponemos el puerto donde corre la app
EXPOSE 8002

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
