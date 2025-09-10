# Build stage
FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app
COPY gradle/ gradle/
COPY gradlew build.gradle settings.gradle ./
COPY src/ src/
RUN chmod +x gradlew
RUN ./gradlew build -x test

# Runtime stage
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
