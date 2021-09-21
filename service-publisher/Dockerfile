FROM openjdk:11
ADD target/service-publisher-0.0.1-SNAPSHOT.jar service-publisher.jar
ENTRYPOINT ["java", "-jar","service-publisher.jar"]
EXPOSE 8091