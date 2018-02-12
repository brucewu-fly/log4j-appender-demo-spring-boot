# Build Docker Image
```
mvn clean install dockerfile:build
```

# Docker
```
docker run -e JAVA_OPTS="-Dproject={your_project} -Dlogstore={your_logstore} -Dendpoint={your_endpoint} -Daccess_key_id={your_access_key_id} -Daccess_key={your_access}" -p 8080:8080 registry.cn-hangzhou.aliyuncs.com/jaegertracing/log4j-appender-demo-spring-boot:0.0.2
```

# K8s

## Create deployment
Replace `JAVA_OPTS` with your own AliCloud Log Service configuration.
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
curl http://${K8S_SERVICE_IP}:8080/login?name=bruce
```

## Logout
```
curl http://${K8S_SERVICE_IP}:8080/logout?name=bruce
```

## Order
```
curl http://${K8S_SERVICE_IP}:8080/order?name=bruce&item=apple&amount=20
```

## RuntimeException
```
curl http://${K8S_SERVICE_IP}:8080/runtimeException
```

## NullPointerException
```
curl http://${K8S_SERVICE_IP}:8080/nullPointerException
```

## ClassNotFoundException
```
curl http://${K8S_SERVICE_IP}:8080/classNotFoundException
```

# Analysis

```
level: ERROR | select location ,count(*) as count GROUP BY  location  ORDER BY count DESC LIMIT 3
```

```
| select level ,count(*) as count GROUP BY level ORDER BY count DESC
```

```
login | SELECT regexp_extract(message, 'name=(?<name>[a-zA-Z\d]+)', 1) AS name, count(*) as count GROUP BY name ORDER BY count DESC LIMIT 3
```

```
Place and order | SELECT regexp_extract(message, 'name=(?<name>[a-zA-Z\d]+)', 1) AS name, sum(cast(regexp_extract(message, 'amount=(?<amount>[a-zA-Z\d]+)', 1) AS double)) AS amount GROUP BY name
```