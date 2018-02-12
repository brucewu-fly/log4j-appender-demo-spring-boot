# Build Docker Image
```
mvn clean install dockerfile:build
```

# Docker
```
docker run -e JAVA_OPTS="-Dproject={your_project} -Dlogstore={your_logstore} -Dendpoint={your_endpoint} -Daccess_key_id={your_access_key_id} -Daccess_key={your_access}" -p 8080:8080 registry.cn-hangzhou.aliyuncs.com/jaegertracing/log4j-appender-demo-spring-boot:0.0.1
```

# K8s

## Create deployment
```
kubectl create -f demo-deployment.yaml
```

## Create service
```
kubectl create -f demo-service.yaml
```

# Visit

## Login
```
curl ${K8S_SERVICE_IP}:8080/login?name=bruce
```

## Logout
```
curl ${K8S_SERVICE_IP}:8080/logout?name=bruce
```

## Order
```
curl ${K8S_SERVICE_IP}:8080/order?name=bruce&item=apple&amount=20
```