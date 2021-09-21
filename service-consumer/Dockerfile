FROM openjdk:11
ADD target/service-consumer-0.0.1-SNAPSHOT.jar service-consumer.jar
ENTRYPOINT ["java", "-jar","service-consumer.jar"]
EXPOSE 8092