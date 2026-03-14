# Use lightweight OpenJDK runtime
FROM eclipse-temurin:21-jdk-jammy

# Set working directory
WORKDIR /app

# Copy the packaged Spring Boot jar
COPY target/eureka-service.jar app.jar

# Expose Eureka default port
EXPOSE 8761

# Run the application
ENTRYPOINT ["java","-jar","/app/app.jar"]