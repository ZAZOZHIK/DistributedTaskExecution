FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/task.executer-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
