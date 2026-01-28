# Stage 1: Build stage
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# คัดลอกไฟล์ตั้งค่า Maven เพื่อทำ Caching dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# คัดลอก Source code และทำการ Build
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run stage
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# คัดลอกเฉพาะไฟล์ .jar ที่ build เสร็จแล้วมาจาก Stage แรก
COPY --from=build /app/target/*.jar app.jar

# กำหนด Port ที่ Spring Boot ใช้งาน (ปกติคือ 8080)
EXPOSE 8080

# คำสั่งสำหรับรัน Application
ENTRYPOINT ["java", "-jar", "app.jar"]