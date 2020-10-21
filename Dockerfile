FROM adoptopenjdk/openjdk11:alpine-jre
#RUN cp target/member-details-service-0.0.1-SNAPSHOT.jar /app/src/app.jar
RUN ls /home/travis/build
WORKDIR /app/src
ENTRYPOINT ["java","-jar","app.jar"]