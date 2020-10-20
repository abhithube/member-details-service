FROM adoptopenjdk/openjdk11:alpine-jre
COPY target/member-details-service-0.0.1-SNAPSHOT.jar /usr/src/app.jar
WORKDIR /usr/src
ENTRYPOINT ["java","-jar","app.jar"]