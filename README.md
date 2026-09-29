# Campus Cloud Laboratory Service - JHipster Quarkus Starter Kit

This repository is the base material for the Cloud Computing practical sequence.

## Two supported paths

1. **Preferred classroom path — JHipster Quarkus**
   - Install Node.js compatible with the JHipster Quarkus blueprint.
   - Install `generator-jhipster-quarkus`.
   - Generate a monolithic JHipster Quarkus application.
   - Import `jdl/campus-cloud-lab.jdl`.
   - Add the extensions and configuration described in the practical guides.

2. **Reference backend path — `reference-app/`**
   - A small Quarkus application is included so students can inspect and experiment
     with multi-tenancy, PostgreSQL, RabbitMQ events, metrics, health, and OpenTelemetry
     even when JHipster generation is unavailable.
   - This reference application is intentionally simpler than a generated JHipster full-stack app.

## Recommended generator versions for the course snapshot

The course snapshot was prepared in September 2026 with:
- JHipster Quarkus blueprint: 4.0.0
- generator-jhipster: 9.2.0
- Node.js: use a version accepted by the blueprint (Node 22.18+ or current supported Node 24 line)

Install:

```bash
npm install -g generator-jhipster-quarkus@4.0.0
jhipster-quarkus --version
```

Generate an application:

```bash
mkdir campus-cloud-lab
cd campus-cloud-lab
jhipster-quarkus
```

Recommended choices:
- application type: monolith
- authentication: OAuth 2.0 / OIDC
- production database: PostgreSQL
- build tool: Maven
- client: Angular, React, or Vue according to class preference
- caching: keep simple for the first practical
- service discovery: none for the monolith

Then import the domain model:

```bash
jhipster-quarkus jdl ../jdl/campus-cloud-lab.jdl
```

## Project purpose

The same workload is extended throughout the semester:

1. Multi-tenancy, DBaaS/PaaS concepts, OIDC, and event integration
2. Kubernetes/k3s deployment, scaling, rolling updates, rollback, CI/CD and GitOps
3. Observability, SLI/SLO, IAM, vulnerability scanning and security evidence
4. Reliability, backup/restore, RTO/RPO, capacity and FinOps analysis

## Important design rule

JHipster removes application boilerplate. Students are still expected to implement and explain
cloud engineering controls themselves: tenant isolation, messaging reliability, Kubernetes
manifests, GitOps, telemetry, security controls, recovery procedures and cost/capacity analysis.

