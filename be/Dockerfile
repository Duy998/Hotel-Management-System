
FROM maven:3.8.4-openjdk-11-slim AS build

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn clean install

FROM openjdk:11-jre-slim

WORKDIR /app

COPY --from=build /app/target/hotel-management-system-1.0-SNAPSHOT.jar .

ENV SPRING_PROFILES_ACTIVE=production

CMD ["java", "-jar", "hotel-management-system-1.0-SNAPSHOT.jar"]
