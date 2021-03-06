Reactive Apps
=============
A simple demo application showcases end-to-end `Functional Reactive Programming (FRP)` with Spring 5.

![Reactive](./docs/reactive-apps.png "Reactive App")

##### Technology stack
* Spring Framework 5
* Spring Boot 2.0.0
* Spring WebFlux
* Embedded MongoDB
* Reactive MongoDB Driver
* Gradle 4

##### Highlights
* Use of Server-Sent Events (SSE) rendered in HTML by Thymeleaf from a reactive data stream.
* Use of Server-Sent Events (SSE) rendered in JSON by Spring WebFlux from a reactive data stream. 
* Use of Spring Data MongoDB's reactive (Reactive Streams) driver support.
* Use of Spring Data MongoDB's support for infinite reactive data streams based on MongoDB tailable cursor (see [here](https://docs.mongodb.com/manual/core/tailable-cursors/)). 
* Use of Thymeleaf's fully-HTML5-compatible syntax.
* Use of `webjars` for client-side dependency managements.
* Reactive Netty as a server
* Multi-project builds with Gradle Kotlin Script. 
* Kotlin as a language
* Cross-Origin Resource Sharing (CORS)
* Docker deployment


### Prerequisites
1. Gradle 4 (Install via [sdkman](http://sdkman.io/))
2. Docker for Mac [Setup Instructions](./docs/Docker.md)

### Build
```bash
# build all 3 executable jars
gradle build
# continuous build with `-t`. 
# this shoud be started before any run tasks i.e., `gradle ui-app:bootRun`, for spring's devtools to work.
gradle -t build
# build all 3 apps
gradle build -x test -x shared:build
# build all 3 docker images
gradle docker -x test -x shared:build
```

### Test
```bash
gradle test
```

### Run
##### Manual 
Start all 3 apps: [mongo-data-service](./mongo-data-service/), [stream-service](./stream-service/), [ui-app](./ui-app/)
> If you want to debug the app, add --debug-jvm parameter to Gradle command line

##### Docker
You can also build Docker images and run all via `Docker Compose`
```bash
# start containers in the background
docker-compose up -d
# start containers in the foreground
docker-compose up 
# show runnning containers 
docker-compose ps
# scaling containers and load balancing
docker-compose scale stream=2
# 1. stop the running containers using
docker-compose stop
# 2. remove the stopped containers using
docker-compose rm -f
# start specific docker-compose file
docker-compose  -f docker-compose-all.yml up
# see logs of a service 
docker-compose -f docker-compose-all.yml logs  mongodb
# connect(ssh) to a service and run a command
docker-compose -f docker-compose-all.yml exec mongodb mongo -u "admin" -p "admin" --authenticationDatabase "admin"
# restart single service
docker-compose -f docker-compose-all.yml restart mongodb
# start single service
docker-compose -f docker-compose-all.yml up mongodb
# check health for a service
docker inspect --format "{{json .State.Health.Status }}" reactiveapps_app_1
docker ps
```
>Access UI App at http://localhost:8080


### Gradle Commands
```bash
# upgrade project gradle version
gradle wrapper --gradle-version 4.2-rc-2 --distribution-type all
# gradle daemon status 
gradle --status
gradle --stop
```

### Credits
* [MiXiT](https://github.com/mixitconf/mixit)
* [Stéphane Nicoll](https://github.com/snicoll-demos/demo-webflux-streaming)
* [Daniel Fernández](https://github.com/danielfernandez/reactive-matchday)
* [Stathis Souris](https://ssouris.github.io/2017/06/02/petclinic-spring-5-kotlin-reactive-mongodb.html)
* [Sébastien Deleuze](https://github.com/sdeleuze/spring-kotlin-functional) 

### TODO
* [spring-kotlin-functional](https://github.com/sdeleuze/spring-kotlin-functional)
* [service-blocks](https://github.com/kbastani/service-block-samples)
