# Stage 1: Build
FROM ubuntu:latest AS build

# Install Java and necessary tools
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk curl

# Install Gradle
RUN curl -sSL https://services.gradle.org/distributions/gradle-7.6-bin.zip -o gradle.zip && \
    unzip gradle.zip -d /opt && \
    rm gradle.zip && \
    ln -s /opt/gradle-7.6/bin/gradle /usr/bin/gradle

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build the JAR file
RUN gradle bootJar --no-daemon

# Stage 2: Runtime
FROM openjdk:17-jdk-slim

# Expose the port the app runs on
EXPOSE 8080

# Set working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/build/libs/demo-1.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
