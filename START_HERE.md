# START HERE - Campus Cloud Laboratory Service

This kit supports four cumulative Cloud Computing practicals. You do not need to understand
every tool before starting. Use the sequence below.

## The mental model

```text
JHipster Quarkus = application scaffold
Quarkus          = Java cloud-native runtime
PostgreSQL       = application data service
Keycloak         = identity and access management
RabbitMQ         = asynchronous integration / event broker
Docker           = local service runtime
k3d / k3s        = local Kubernetes platform
Prometheus       = metrics backend
Grafana          = dashboard
Jaeger           = trace exploration
Trivy            = image vulnerability scanner
Git / Argo CD    = desired-state delivery and GitOps
```

## First-time learning path

### Stage A - Prove the laptop is ready
1. Install JDK 21, Node.js, Git and Docker.
2. Run `java -version`, `node --version`, `npm --version`, `git --version`, `docker version`.
3. Start the Docker infrastructure from the infrastructure package.

### Stage B - Choose your application path
- **Preferred:** generate a JHipster Quarkus application using `jdl/campus-cloud-lab.jdl`.
- **Fallback/reference:** run `reference-app/`.

### Stage C - Do not skip checkpoints
Each practical guide contains checkpoints. If a checkpoint fails, stop and troubleshoot before
continuing. Cloud work is cumulative; a broken database connection in Practical 01 becomes a
Kubernetes failure in Practical 02.

## Useful folders

- `jdl/` - domain model for the generated JHipster Quarkus application.
- `reference-app/` - compact Quarkus backend for inspection/fallback.
- `k8s/base/` - Kubernetes manifests.
- `gitops/` - Argo CD example.
- `ci/` - CI example.
- `examples/` - REST/curl examples.
- `docs/` - glossary, workflow and challenge map.

## Safety
All demo credentials are intentionally weak and are only for a localhost classroom lab.
Never reuse them for a real system.


## New students

Read `docs/BEGINNER_APPLICATION_GUIDE.md` before generating the application, and use `docs/CHALLENGE_MAP_V2.md` for extension work.
