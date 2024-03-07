# Використовуємо офіційний образ PostgreSQL для ініціалізації бази даних
FROM postgres:latest as postgres

ENV POSTGRES_DB ownership
ENV POSTGRES_USER admin
ENV POSTGRES_PASSWORD adminpassword

COPY init.sql /docker-entrypoint-initdb.d/

# Використовуємо офіційний образ OpenJDK для Java 8
FROM openjdk:8-jre-alpine

WORKDIR /app

# Копіюємо JAR файл зі збірки вашого проекту (переконайтеся, що файл існує)
COPY target/SpringApp-1.0-SNAPSHOT.jar /app/SpringApp-1.0-SNAPSHOT.jar

# Задаємо команду для запуску додатку при старті контейнера
CMD ["java", "-jar", "SpringApp-1.0-SNAPSHOT.jar"]
