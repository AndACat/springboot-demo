FROM eclipse-temurin:21-jdk

COPY ./target/SpringBootDemo-0.0.1-SNAPSHOT.jar /app/app.jar

LABEL author="wangzhen"

WORKDIR /app
#EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
# ENTRYPOINT ["/bin/bash", "-c", "java", "-jar", "/app/app.jar"]
