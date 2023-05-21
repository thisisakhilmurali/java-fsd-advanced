## OAuth 2.0 With Google
---
NOTE: The steps below may change due to the updation of google cloud console. Please verify with the official documentation of google cloud/..

1. Create a google account and login to [GCP](https://console.cloud.google.com/).

2. Click on API & Services --> Credentials --> Create Credentials --> Create oauth client ID

3. Application type: web application, give a name,
    give your applications endpoint as "Authorized javaScript origins" ex: `http://localhost:9191`.
    <br> and authorized redirect URIs as `http://localhost:9191/login/oauth2/code/google`.
    <br>
    click on "create"

4. Copy `client id` and `client secret` and place it to "application.yaml" file.

5. Run the spring boot app

6. Paste the endpoint in the browser. Login with your credentials.
