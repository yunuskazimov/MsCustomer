FROM openjdk:16-slim-buster

COPY build/libs/customer-0.0.1-SNAPSHOT.jar .

ENTRYPOINT java -jar customer-0.0.1-SNAPSHOT.jar