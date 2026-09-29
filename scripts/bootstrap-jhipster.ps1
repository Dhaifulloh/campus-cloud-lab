param(
    [string]$AppDir = "campus-cloud-lab",
    [string]$BlueprintVersion = "4.0.0"
)

if (-not (Get-Command node -ErrorAction SilentlyContinue)) { throw "Node.js is required." }
if (-not (Get-Command npm -ErrorAction SilentlyContinue)) { throw "npm is required." }

npm install -g "generator-jhipster-quarkus@$BlueprintVersion"
New-Item -ItemType Directory -Force -Path $AppDir | Out-Null
Set-Location $AppDir

Write-Host ""
Write-Host "Run: jhipster-quarkus"
Write-Host "Then import: jhipster-quarkus jdl ../jdl/campus-cloud-lab.jdl"
