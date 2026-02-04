FROM gradle:jdk21 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon -x test

FROM eclipse-temurin:21-jre
EXPOSE 8080
COPY --from=build /home/gradle/src/build/libs/*[!i][!n].jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
