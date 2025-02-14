FROM registry.cn-shanghai.aliyuncs.com/wz-hub/eclipse-temurin:21-jdk

COPY springboot-demo-business/target/springboot-demo-business-0.0.1-SNAPSHOT.jar /app/app.jar

LABEL author="wangzhen"
# 设置时区
ENV TZ=Asia/Shanghai

WORKDIR /app
EXPOSE 12000
#ENTRYPOINT ["java", "-jar", "/app/app.jar"]
# ENTRYPOINT ["/bin/bash", "-c", "java", "-jar", "/app/app.jar"]
