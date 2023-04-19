FROM maven:3.6.0-jdk-11-slim AS build
ENV APP_HOME=/behealthy-api
WORKDIR $APP_HOME
COPY src $APP_HOME/src
COPY pom.xml $APP_HOME/
RUN mvn -f $APP_HOME/pom.xml clean package

FROM openjdk:11
ENV APP_HOME=/behealthy-api
COPY --from=build $APP_HOME/target/api-0.0.1-SNAPSHOT.jar $APP_HOME/behealthy-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/behealthy-api/behealthy-api.jar"]
