FROM gradle:8.5.0-jdk21 AS builder

WORKDIR /app

COPY . .

RUN gradle clean build

FROM openjdk:21-jdk-slim

WORKDIR /app

COPY --from=builder /app/build/libs/test-0.0.1-SNAPSHOT.jar test.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "test.jar"]
