FROM registry.cn-shanghai.aliyuncs.com/javatoai/eclipse-temurin:21-jdk

COPY target/springboot-demo-business-1.0.0-SNAPSHOT.jar /app/app.jar
#COPY ../../* /app/

LABEL author="wangzhen"
# 设置时区
ENV TZ=Asia/Shanghai

WORKDIR /app
EXPOSE 12000
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
# ENTRYPOINT ["/bin/bash", "-c", "java", "-jar", "/app/app.jar"]
