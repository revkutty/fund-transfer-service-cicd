# Use a lightweight base image with Java support
#FROM openjdk:17-jdk-alpine

FROM amazoncorretto:17

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY build/libs/fund-transfer-ms-1.0.0.jar app.jar

# Expose the application's port (default for Spring Boot is 8080)
EXPOSE 8083

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
