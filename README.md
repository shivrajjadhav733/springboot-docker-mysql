# Spring Boot on Docker connecting to MySQL Docker container

1. Use MySQL Image published by Docker Hub (https://hub.docker.com/_/mysql/)
Command to run the mysql container
`docker run --name mysql-standalone <-p 3306:3306> -e MYSQL_ROOT_PASSWORD=admin123 -e MYSQL_DATABASE=test -e MYSQL_USER=testuser -e MYSQL_PASSWORD=testuser@123 -d mysql:5.7`

## optional -p 3306:3306

2. In the Spring Boot Application, use the same container name of the mysql instance in the application.properties
`spring.datasource.url = jdbc:mysql://mysql-standalone:3306/test?useSSL=false`

3. Create a `Dockerfile` for creating a docker image from the Spring Boot Application
`FROM openjdk:8
VOLUME /tmp
ADD target/springboot-docker-mysql.jar springboot-docker-mysql.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","springboot-docker-mysql.jar"]`

4. Using the Dockerfile create the Docker image.
From the directory of Dockerfile - `docker build . -t springboot-docker-mysql`

5. Run the Docker image (springboot-docker-mysql) created in #4.
`docker run -p 8083:8083 --name springboot-docker-mysql-app --link mysql-standalone:mysql -d springboot-docker-mysql`

## Useful Docker commands
- `docker images`
- `docker container ls`
- `docker logs <container_name>`
- `docker container rm <container_name>`
- `docker image rm <image_name>`
