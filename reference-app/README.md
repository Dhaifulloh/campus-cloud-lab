# Reference Quarkus Backend

This is a deliberately small backend used as a fallback/reference implementation.

It demonstrates:
- PostgreSQL persistence
- tenant-aware API filtering through `X-Tenant-ID`
- RabbitMQ `ReservationCreated` events
- persistent duplicate-event markers
- health and Prometheus endpoints
- OpenTelemetry trace export
- optional OIDC configuration

## Build

```bash
mvn test
mvn package
```

## Run against the local Docker infrastructure

```bash
mvn quarkus:dev
```

Example:

```bash
curl -H "X-Tenant-ID: SI" http://localhost:8080/api/laboratories

curl -i \
  -H "Content-Type: application/json" \
  -H "X-Tenant-ID: SI" \
  -d '{"laboratoryId":1,"startTime":"2026-09-20T01:00:00Z","endTime":"2026-09-20T03:00:00Z","purpose":"Cloud Computing Lab"}' \
  http://localhost:8080/api/reservations
```

This reference backend is not a replacement for the preferred JHipster Quarkus application.
It is included so students can inspect the cloud-specific extensions in a compact codebase.
