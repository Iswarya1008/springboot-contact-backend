# Use an OpenJDK image
FROM openjdk:24-jdk-alpine

# Set working directory
WORKDIR /app

# Copy jar file from target folder
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose port (Render will provide PORT env variable)
EXPOSE 8080

# Start the Spring Boot app
ENTRYPOINT ["java","-jar","app.jar"]
