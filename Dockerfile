FROM maven:3.8.5-openjdk-18 AS build
COPY . . 
RUN mvn clean package -DskipTests

FROM openjdk:18.0.1-jdk-slim
COPY --from=build /target/IndoreMetro-0.0.1-SNAPSHOT.jar IndoreMetro.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","IndoreMetro.jar" ]
