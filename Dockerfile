FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy the Spring Boot fat jar created by Maven
COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]