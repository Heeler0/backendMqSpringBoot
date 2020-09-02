FROM openjdk:8-jdk-alpine as build

WORKDIR /usr/src/app/

COPY votingmqapi-0.0.1-SNAPSHOT.jar ./voting.jar

EXPOSE 8080

CMD ["java", "-jar", "voting.jar"]