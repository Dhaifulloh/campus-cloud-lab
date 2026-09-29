param(
  [string]$Url = "http://campus.localhost/api/laboratories",
  [string]$Tenant = "SI",
  [int]$Count = 50
)

1..$Count | ForEach-Object {
  $sw = [System.Diagnostics.Stopwatch]::StartNew()
  try {
    $r = Invoke-WebRequest -Uri $Url -Headers @{"X-Tenant-ID"=$Tenant}
    $code = $r.StatusCode
  } catch {
    $code = $_.Exception.Response.StatusCode.value__
  }
  $sw.Stop()
  "$code $($sw.Elapsed.TotalSeconds)"
}
