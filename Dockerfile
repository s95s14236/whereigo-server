#
# Build stage
#
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:17.0.2-jdk-bullseye
COPY --from=build /target/whereigo-0.0.1-SNAPSHOT.jar whereigo.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "whereigo.jar"]