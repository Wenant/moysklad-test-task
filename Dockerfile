FROM openjdk:17-jdk-alpine

COPY target/moysklad-test-task-1.0-SNAPSHOT.jar /app/moysklad-test-task.jar

CMD ["java", "-jar", "/app/moysklad-test-task.jar"]