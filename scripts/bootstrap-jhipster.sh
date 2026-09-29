#!/usr/bin/env bash
set -euo pipefail

APP_DIR="${1:-campus-cloud-lab}"
BLUEPRINT_VERSION="${JHIPSTER_QUARKUS_VERSION:-4.0.0}"

command -v node >/dev/null || { echo "Node.js is required."; exit 1; }
command -v npm >/dev/null || { echo "npm is required."; exit 1; }

npm install -g "generator-jhipster-quarkus@${BLUEPRINT_VERSION}"

mkdir -p "${APP_DIR}"
cd "${APP_DIR}"

echo
echo "Run the generator interactively:"
echo "  jhipster-quarkus"
echo
echo "After generation, import the JDL from this starter kit:"
echo "  jhipster-quarkus jdl ../jdl/campus-cloud-lab.jdl"
