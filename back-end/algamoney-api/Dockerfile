
# Imagem base com Java 17 (Amazon Corretto)
FROM amazoncorretto:17

WORKDIR /app

COPY target/algamoney-api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
