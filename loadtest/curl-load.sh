#!/usr/bin/env bash
set -euo pipefail
URL="${1:-http://campus.localhost/api/laboratories}"
TENANT="${2:-SI}"
COUNT="${3:-50}"

for i in $(seq 1 "$COUNT"); do
  curl -s -o /dev/null -w "%{http_code} %{time_total}\n" \
    -H "X-Tenant-ID: ${TENANT}" "$URL"
done
