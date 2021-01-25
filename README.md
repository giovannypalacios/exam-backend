#Exam Backend
This application is the backend for the Beitech's Java developer exam, providing a REST API to get the list of customers and their orders.

This project was created with Spring Boot, Spring Data, Lombok, Maven and Java 11 

## Requirements
- JDK 11 or later
- [Maven](https://maven.apache.org/)

## Setup
A - environment variables: One alternative is to configure the O.S. environment variables with the database values:
  - MYSQL_HOST
  - MYSQL_PORT
  - MYSQL_DB
  - MYSQL_USER
  - MYSQL_PASSWORD

B - Update application.yaml: with database values.

## Compile
The project can be compiled with the following maven command:

`mvn clean package`

## Run the application
You can run the project using any of the following ways:

- Run with IntelliJ (Run OrdersApplication)
- Using the java command:  -jar target\orders-0.0.1-SNAPSHOT.jar
- Using the maven command: mvn spring-boot:run 

## Access to the application (API Url)

http://localhost:8080/api/1.0