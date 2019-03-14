FROM adoptopenjdk/openjdk11:latest

MAINTAINER Silas Maciel Ferreira

RUN ../mvnw clean install

VOLUME /tmp

COPY target/cadeolanche-api.jar app.jar

EXPOSE 8082

ENTRYPOINT java -jar /app.jar