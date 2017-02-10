# About
This is a simple example of spring boot dockerizing.

### Docker settings

Docker plugin for gradle is used: [link](https://github.com/Transmode/gradle-docker)

In build.gradle file

> group= 'erhan277'

is used for Docker namespace.

Dockerfile is here: [src/main/docker/Dockerfile](src/main/docker/Dockerfile)



### Building
> gradlew build buildDocker

### Run docker
> docker run -p 8080:8080 -t erhan277/spring-boot-with-docker-example



