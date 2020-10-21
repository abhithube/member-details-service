FROM adoptopenjdk/openjdk11:alpine-jre
VOLUME /tmp
COPY target/member-details-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]