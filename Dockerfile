FROM adoptopenjdk:8u292-b10-jdk-openj9-0.26.0

COPY ./target/SpringDemo-0.0.1-SNAPSHOT.jar /app/app.jar

LABEL author="wangzhen"

WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
# ENTRYPOINT ["/bin/bash", "-c", "java", "-jar", "/app/app.jar"]
