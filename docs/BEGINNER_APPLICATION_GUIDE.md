# Beginner Application Guide

## Why two application paths exist

### Path A - JHipster Quarkus

This is the preferred course path. JHipster generates the repetitive application foundation:
domain entities, REST APIs, persistence mappings, database migrations, authentication integration,
client application and build files.

You still implement and explain the cloud-specific work:
multi-tenancy, event reliability, Kubernetes deployment, GitOps, telemetry, security, recovery and FinOps.

### Path B - Reference Quarkus Backend

Use `reference-app/` if the generator/toolchain is temporarily blocked or when you want a compact example.
It is intentionally small and exposes the cloud-specific extensions more clearly.

## Before generating

Verify:

```bash
java -version
node --version
npm --version
```

JHipster requires Java 21 or later. The course blueprint snapshot expects a compatible Node 22.18+ or supported Node 24 line.

## Recommended working pattern

1. Keep this starter project unchanged as reference material.
2. Create your own application under `student-work/campus-cloud-lab`.
3. Commit after generation.
4. Commit again after JDL import.
5. Add one cloud capability at a time.
6. Never mix "make it compile" changes with a large infrastructure change in the same commit.

## When a command fails

Record:
- command,
- current directory,
- version output,
- first meaningful error,
- what you changed.

Do not delete the project and restart immediately. Troubleshooting evidence is part of cloud engineering practice.
