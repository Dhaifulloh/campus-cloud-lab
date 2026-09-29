#!/usr/bin/env bash
set -euo pipefail
USER="${1:-student01}"
PASSWORD="${2:-student01}"

curl -s \
  -d "client_id=campus-cloud-app" \
  -d "username=${USER}" \
  -d "password=${PASSWORD}" \
  -d "grant_type=password" \
  http://localhost:8081/realms/campus-cloud/protocol/openid-connect/token
