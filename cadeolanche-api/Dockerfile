FROM adoptopenjdk/openjdk11:latest

MAINTAINER Silas Maciel Ferreira

VOLUME /tmp

COPY target/cadeolanche-api.jar app.jar

EXPOSE 8082

ENTRYPOINT java -jar /app.jar