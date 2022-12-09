#
# Package stage
#
FROM openjdk:17.0.2-jdk-slim
COPY . .
RUN ["./mvnw", "clean", "package", "-DskipTests"]
COPY --from=build /target/whereigo-0.0.1-SNAPSHOT.jar whereigo.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "whereigo.jar"]