FROM eclipse-temurin:17-jdk-alpine as builder

WORKDIR /app

COPY pom.xml ./
COPY mvnw ./
COPY .mvn .mvn


RUN ./mvnw dependency:go-offline -B

COPY src ./src

RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=builder /app/target/library-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 50111

ENTRYPOINT ["java", "-jar", "app.jar"]