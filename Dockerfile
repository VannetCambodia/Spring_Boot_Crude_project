# ---------- BUILD ----------
FROM gradle:8.5-jdk17 AS build
WORKDIR /build
COPY . .
RUN gradle clean bootJar --no-daemon

# ---------- RUN ----------
FROM eclipse-temurin:17-jre
WORKDIR /app

# Security
RUN useradd -m appuser
USER appuser

COPY --from=build /build/build/libs/*.jar app.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
