FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY mvnw mvnw
COPY .mvn .mvn
COPY pom.xml ./

RUN ./mvnw dependency:go-offline -B

COPY src ./src
RUN ./mvnw clean package -DskipTests

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/library-0.0.1-SNAPSHOT.jar"]