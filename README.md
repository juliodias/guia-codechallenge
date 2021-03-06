[![Build Status](https://travis-ci.org/juliodias/guia-codechallenge.svg?branch=master)](https://travis-ci.org/juliodias/guia-codechallenge)

# Guia Code Challenge

## Requirements:
You should have installed Docker or Java 8+.

## Running application:
The application has two ways to be running, are: *Docker* or *IDE*.  
The best and simple way is from Docker and to do that, you only need to run from the root directory:

**./build.sh**

And the other way is openning the **GuiaCodeChallengeApplication.class** and run the *main* method.

## Tests:

To run the tests, you should run from the root directory:

**./gradlew test**

API documentation:

## API Endpoints:

The API endpoints has a Swagger documentation and you can check them in the follow URL:

http://localhost:8080/swagger-ui.html

and the database in:

http://localhost:8080/h2-console

## Stack:
**Language:** Java 11  
**Framework Web:** Spring Boot  
**Build tool:** Gradle  
**Database:** H2  
**API Documentation:** Swagger  
**Infraestructure Tools:** Docker, Travis CI
