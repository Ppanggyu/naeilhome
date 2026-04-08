# 1. Build 단계 (Maven)
FROM maven:3.8.3-openjdk-8 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# 2. Runtime 단계
FROM openjdk:8-jdk-slim
WORKDIR /app
COPY --from=build /target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]