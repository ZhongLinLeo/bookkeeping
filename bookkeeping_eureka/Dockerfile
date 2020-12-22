# 基于Java8镜像
FROM java:8

# 将本地文件夹挂在到当前容器
VOLUME /Users/zl/dockers/app

# 复制文件到容器
ADD bookkeeping_eureka-1.0.0-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'

# 声明需要暴露的端口
EXPOSE 8761

# 配置容器启动后执行的命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]