# Member Details Service [![Build Status](https://travis-ci.com/abhithube/member-details-service.svg?branch=master)](https://travis-ci.com/abhithube/member-details-service) ![Uptime Robot status](https://img.shields.io/uptimerobot/status/m786310900-fa52e03e0fe63ff0ba93b3f0?label=status)


This is the member-details microservice of the AT Insurance web application. It defines the REST API for retrieving and updating a member's account. In addition, Apache Kafka is used to notify other services when a new user has registered.

The [README](https://github.com/abhithube/insurance-portal-angular) in the front end repo has more details about the whole project.

**NOTE:** To save on AWS server costs, the application is only up during the day. A cron job scheduler on AWS auto-scaling terminates all of the EC2 instances every night, and start them up again in the morning. The "status" badge at the top indicates if the application is currently up.

## API Documentation
The API documentation for this microservice was generated using Swagger. It can be found at https://at-insurance.com/member-details-service/swagger-ui/.

## Technologies
- **Programming Language**: Java
- **Framework**: Spring Boot
- **DBMS**: MongoDB
- **Messaging**: Kafka
- **Testing**: JUnit, Mockito
- **Build**: Maven
- **CI/CD**: Travis CI, Docker, AWS
