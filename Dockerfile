FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/goods-*-SNAPSHOT.jar app.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","app.jar"]