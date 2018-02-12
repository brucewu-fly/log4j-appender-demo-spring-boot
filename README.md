# Build Docker Image
```
mvn clean install dockerfile:build
```

# Run
```
docker run -e JAVA_OPTS="-Dproject={your_project} -Dlogstore={your_logstore} -Dendpoint={your_endpoint} -Daccess_key_id={your_access_key_id} -Daccess_key={your_access}" -p 8080:8080 registry.cn-hangzhou.aliyuncs.com/jaegertracing/log4j-appender-demo-spring-boot:0.0.1
```
