# Spring Boot 2: Reactive Yelp Clone

## API

GET    /businesses
POST   /businesses

GET    /businesses/:id
PUT    /businesses/:id
DELETE /businesses/:id

GET    /businesses/:id/comments

GET    /comments
POST   /comments

GET    /comments/:id
PUT    /comments/:id
DELETE /comments/:id

## Technologies

Spring Boot 2
Webflux
Reactor
H2 database
Actuators
Sleuth and Zipkin
Docker

## TODO

Actuators
Sleuth
POST businesses
Comment.
Use projection on GET /businesses to not return comments

Embedded mongodb
https://dzone.com/articles/spring-boot-with-embedded-mongodb
https://stackoverflow.com/questions/31568351/how-do-you-configure-embedded-mongdb-for-integration-testing-in-a-spring-boot-ap
https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-nosql.html
