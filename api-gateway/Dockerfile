#FROM maven:3.8.6-openjdk-18 AS build
#COPY src /api-gateway/src
#COPY pom.xml /api-gateway
#RUN mvn -f /api-gateway/pom.xml clean package
#
FROM openjdk:17
MAINTAINER Vugar Mammadli <mammadli.vugar@hotmail.com>
EXPOSE 8082
ADD target/*.jar api-gateway-1.0-SNAPSHOT
ENTRYPOINT ["java", "-jar","api-gateway-1.0-SNAPSHOT"]