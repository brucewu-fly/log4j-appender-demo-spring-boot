[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/aliyun/aliyun-log-python-sdk/blob/master/LICENSE)

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

Top 3 locations which generated most error logs.

```
level: ERROR | select location ,count(*) as count GROUP BY location  ORDER BY count DESC LIMIT 3
```

The number of the logs in different log level.
```
| select level ,count(*) as count GROUP BY level ORDER BY count DESC
```

Top 3 users with the most logging times.
```
login | SELECT regexp_extract(message, 'name=(?<name>[a-zA-Z\d]+)', 1) AS name, count(*) as count GROUP BY name ORDER BY count DESC LIMIT 3
```

The purchase number of different users.
```
Place and order | SELECT regexp_extract(message, 'name=(?<name>[a-zA-Z\d]+)', 1) AS name, sum(cast(regexp_extract(message, 'amount=(?<amount>[a-zA-Z\d]+)', 1) AS double)) AS amount GROUP BY name
```
