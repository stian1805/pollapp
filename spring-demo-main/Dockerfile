# Use the official Gradle image as the base image
FROM gradle:8-jdk21 AS builder

# Copy the necessary project files into the container
COPY settings.gradle.kts gradlew build.gradle.kts ./
COPY src src
COPY gradle gradle
RUN chmod +x gradlew

# Build the Spring Boot JAR file
RUN ./gradlew bootJar

RUN mv build/libs/demo-0.0.1-SNAPSHOT.jar app.jar

# Use a lighter image for running the app
FROM eclipse-temurin:21-alpine

RUN addgroup -g 1000 app
RUN adduser -G app -D -u 1000 -h /app app
USER app
WORKDIR /app


# Copy the JAR file from the builder stage
COPY --from=builder --chown=1000:1000 /home/gradle/app.jar .

# Set the entrypoint to run the JAR file
CMD ["java", "-jar", "app.jar"]
