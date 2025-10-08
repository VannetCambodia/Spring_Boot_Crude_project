# Use a lightweight JDK image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the built jar file from your local machine into the container
COPY build/libs/crud_docker.jar app.jar

# Expose Spring Boot’s default port
EXPOSE 8081

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
