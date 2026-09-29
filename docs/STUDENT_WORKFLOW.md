# Cumulative Student Workflow

## Practical 01
Generate/run the application -> connect PostgreSQL -> add tenant context -> connect Keycloak ->
publish RabbitMQ event -> prove tenant isolation and duplicate-event handling.

## Practical 02
Build container image -> create k3d cluster -> deploy with Kubernetes YAML -> health probes ->
self-healing -> scale -> rolling update -> rollback -> optional Argo CD.

## Practical 03
Start observability profile -> metrics -> dashboard -> traces -> SLI/SLO -> RBAC ->
secret review -> Trivy scan -> simulated security incident.

## Practical 04
Define criticality -> inject failure -> backup -> destructive local test -> restore -> measure
RTO/RPO -> resource analysis -> showback/unit cost -> optimization roadmap.

## Evidence habit
For every major action, save:
1. command/configuration,
2. observed result,
3. interpretation,
4. limitation,
5. next decision.

A screenshot without interpretation is not sufficient evidence.
