
## Routine Checks 
```
kubectl -n campus-cloud get deployment,pods,service,ingress
kubectl -n campus-cloud rollout status deployment/campus-cloud-app
kubectl -n campus-cloud get events --sort-by=.lastTimestamp
kubectl -n campus-cloud logs deployment/campus-cloud-app --since=10m
```

## Health probe via ingress

```
curl -i -H "Host: campus.localhost" \
  http://127.0.0.1:8088/q/health

curl -i -H "Host: campus.localhost" \
  http://127.0.0.1:8088/q/health/live

curl -i -H "Host: campus.localhost" \
  http://127.0.0.1:8088/q/health/ready
```

## Tenant Isolation Test

```
curl -i \
  -H "Host: campus.localhost" \
  -H "X-Tenant-ID: SI" \
  http://127.0.0.1:8088/api/laboratories
```

```
curl -i \
  -H "Host: campus.localhost" \
  -H "X-Tenant-ID: IF" \
  http://127.0.0.1:8088/api/laboratories
```

## Write Transaction Test

```
curl -i \
  -H "Host: campus.localhost" \
  -H "Content-Type: application/json" \
  -H "X-Tenant-ID: SI" \
  -d '{
    "laboratoryId": 1,
    "startTime": "2026-09-24T01:00:00Z",
    "endTime": "2026-09-24T03:00:00Z",
    "purpose": "Kubernetes verification"
  }' \
  http://127.0.0.1:8088/api/reservations
```
Verify

```
curl -sS \
  -H "Host: campus.localhost" \
  -H "X-Tenant-ID: SI" \
  http://127.0.0.1:8088/api/reservations
```

## Resource Monitoring

```
kubectl top pod -n campus-cloud
kubectl top node

```
Result
```
requests:
  cpu: 100m
  memory: 192Mi
limits:
  cpu: 500m
  memory: 512Mi
```

## Check weather having Out of Memory

```
kubectl -n campus-cloud get pod \
  -o custom-columns='NAME:.metadata.name,RESTARTS:.status.containerStatuses[0].restartCount,REASON:.status.containerStatuses[0].lastState.terminated.reason'
```

## Test Self Healing

```
kubectl -n campus-cloud get pods
kubectl -n campus-cloud delete pod \
  -l app=campus-cloud-app
kubectl -n campus-cloud wait \
  --for=condition=Ready pod \
  -l app=campus-cloud-app \
  --timeout=120s
```

## Scaling Test

```
kubectl -n campus-cloud scale deployment/campus-cloud-app --replicas=2

kubectl -n campus-cloud rollout status deployment/campus-cloud-app

kubectl -n campus-cloud get pods -o wide
```
Test sending repeating request

```
for i in $(seq 1 20); do
  curl -sS -o /dev/null -w '%{http_code} %{time_total}\n' \
    -H "Host: campus.localhost" \
    -H "X-Tenant-ID: SI" \
    http://127.0.0.1:8088/api/laboratories
done
```
Return to one replica after testing

```
kubectl -n campus-cloud scale deployment/campus-cloud-app --replicas=1
```

