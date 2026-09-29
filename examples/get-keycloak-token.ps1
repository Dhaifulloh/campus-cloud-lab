param(
  [string]$User = "student01",
  [string]$Password = "student01"
)

Invoke-RestMethod `
  -Method Post `
  -Uri "http://localhost:8081/realms/campus-cloud/protocol/openid-connect/token" `
  -ContentType "application/x-www-form-urlencoded" `
  -Body @{
    client_id = "campus-cloud-app"
    username = $User
    password = $Password
    grant_type = "password"
  }
