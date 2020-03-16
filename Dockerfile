# FROM adoptopenjdk/openjdk13
FROM openjdk:13-oracle

ADD target/wya-app-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "java", "-jar", "/app.jar" ]

EXPOSE 8080