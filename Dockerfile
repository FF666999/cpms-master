# 基础镜像使用java
FROM docker.io/openjdk:11.0.4
# 作者
MAINTAINER cpms
# 时区
ENV TZ=Asia/Shanghai
#容器暴露的端口号与springboot配置的端口号一致
EXPOSE 8001
# VOLUME 指定了临时文件目录为/tmp。
VOLUME /tmp
# 将jar包添加到容器中并更名为app.jar
ADD cpms-vue.jar app.jar
# 将templates模板文件添加到容器中
ADD templates templates
# 运行jar包
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Djasypt.encryptor.password=123456","-jar","/app.jar"]