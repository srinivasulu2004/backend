FROM maven:4.0.0-eclipse-temurin-21 AS build
WORKDIR /app
COPY src/pom.xml .
RUN mvn dependency:go-offline -B
COPY . .
RUN mvn clean package -DskipTests
## stage 2
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/finance-service-1.0.0.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"] 
