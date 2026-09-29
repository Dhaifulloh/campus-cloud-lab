# Beginner Glossary

| Term | Meaning in this course |
|---|---|
| JHipster | Application generator that removes CRUD/frontend/security boilerplate. |
| Blueprint | A JHipster extension that replaces or changes generator technology; here it changes the backend to Quarkus. |
| Quarkus | Java framework/runtime optimized for cloud-native applications. |
| JDL | JHipster Domain Language used to define entities and relationships. |
| Container image | Immutable package containing the application and runtime files. |
| Docker container | Running instance of a container image. |
| Kubernetes | Declarative orchestration platform for container workloads. |
| k3s | Lightweight Kubernetes distribution. |
| k3d | Tool that runs k3s nodes as Docker containers. |
| Pod | Smallest schedulable Kubernetes unit. |
| Deployment | Kubernetes controller for stateless replicated pods and rolling updates. |
| Service | Stable Kubernetes network endpoint in front of pods. |
| Ingress | HTTP routing from outside the cluster to a Service. |
| ConfigMap | Kubernetes object for non-secret configuration. |
| Secret | Kubernetes object for sensitive configuration; still requires stronger production secret management. |
| OIDC | OpenID Connect authentication protocol built on OAuth 2.0. |
| Keycloak | Identity provider used for login, roles and tokens. |
| RabbitMQ | Message broker used for asynchronous event delivery. |
| Event | Immutable statement that something happened, for example `ReservationCreated`. |
| Idempotency | Repeating the same operation does not create unintended duplicate effects. |
| Prometheus | Time-series metrics system. |
| Grafana | Visualization/dashboard tool. |
| OpenTelemetry | Vendor-neutral APIs/SDKs/protocols for metrics, logs and traces. |
| Jaeger | Trace storage and exploration UI used in the lab. |
| SLI | Measured service-level indicator. |
| SLO | Target value for an SLI. |
| RTO | Maximum target time to restore a service. |
| RPO | Maximum target data-loss window. |
| FinOps | Collaborative practice for cloud cost visibility, accountability and optimization. |
| GitOps | Desired state kept in Git and reconciled by an operator such as Argo CD. |
