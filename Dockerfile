FROM openjdk:8-jre-alpine

LABEL maintainer: "Julio Dias<julioocdias@gmail.com>"

RUN mkdir /app
COPY build/libs/guia-codechallenge-1.0.jar /app

WORKDIR /app

EXPOSE 8080

ENTRYPOINT java -jar /app/guia-codechallenge-1.0.jar