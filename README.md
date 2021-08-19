# SpringDataElasticsearchDemo

## Prerequisites

* Java 8
* Maven 3.3+
* Docker 19.03+
* Docker Compose 1.25+

## Used Technologies

* Spring Boot 2.4.3
* Spring Boot Web
* Spring Boot Test
* Maven Jib Plugin

## Installation

```sh
./mvnw compile jib:dockerBuild
```

```sh
docker-compose up -d 

## Postman Request

> You can access the Postman from the following url.

http://localhost:8080
