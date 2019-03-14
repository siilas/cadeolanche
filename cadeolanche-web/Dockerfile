FROM adoptopenjdk/openjdk11:latest

MAINTAINER Silas Maciel Ferreira

RUN ./mvnw clean install

VOLUME /tmp

COPY target/cadeolanche-web.jar app.jar

EXPOSE 8081

ENTRYPOINT java -jar /app.jar