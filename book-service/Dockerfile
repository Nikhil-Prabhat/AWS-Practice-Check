FROM openjdk:8-jdk-alpine
ADD target/books-service.jar app.jar
ENTRYPOINT ["java","-jar", "/app.jar"]