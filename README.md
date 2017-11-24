# quoteservice
This quoteservice is a simple microservice that returns a random quote.

See a live demo [here](https://quoteservice.sloppy.zone/)

## Motivation
The world of cloud, microservices and containers is fairly new to me. By
developing a small microservice, I am able to experiment with all the cool
new technologies that come with it.

## Prerequisites
Make sure you have [Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git) (to be able to clone this repo),
[Java](https://www.java.com/) and [Maven](https://maven.apache.org/) installed.

> Optional:
> If you want to run the service inside a docker container, you should also have [Docker](https://www.docker.com/) installed.

## Getting started
How to start the quoteservice application
---
1. Clone this repository
```
git clone https://github.com/DarthSid78/quoteservice.git
```
2. Build the project
```
mvn clean install
```
4. Start the application
```
java -jar target/quoteservice-1.0-SNAPSHOT.jar server config.yml
```
5. To check that your application is running enter url `http://localhost:8080`

Health Check
---
To see your applications health enter url `http://localhost:8081/healthcheck`

## Docker Container

A docker image is available on dockerhub
```
docker pull darthsid78/quoteservice
docker run -p 8080:8080 darthsid78/quoteservice
```

## Built With

* [Java](https://www.java.com/) - The nr.1 general-purpose computer programming language
* [Dropwizard](http://www.dropwizard.io/1.2.1/docs/) - The webservices framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Swagger](https://swagger.io/) - API specification documentation
* [Docker](https://www.docker.com/) - Software container technology

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
