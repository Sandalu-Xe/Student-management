# 1. Start with a base image that already has Java 17
FROM eclipse-temurin:17-jdk-jammy

# 2. Set a working directory inside the container
WORKDIR /app

# 3. Copy the .jar file from your 'target' folder
#    (Make sure this file name is correct!)
COPY target/student-management-0.0.1-SNAPSHOT.jar app.jar

# 4. Tell Docker your app will listen on port 8080
EXPOSE 8080

# 5. This is the final command to run when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]