# Target Learning Architecture

```text
Users
  |
  v
Ingress / API
  |
  v
JHipster Quarkus application
  |--------- PostgreSQL
  |--------- RabbitMQ
  |--------- Keycloak (OIDC)
  |
  +--> OpenTelemetry / Prometheus
          |
          +--> Grafana / Jaeger
```

For the Kubernetes practical, the application is deployed to a local k3d cluster.
PostgreSQL, Keycloak, RabbitMQ and the observability backends may remain as Docker
services on the laptop and are reached from k3d through `host.k3d.internal`.
