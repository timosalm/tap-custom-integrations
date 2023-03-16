# Integrate TAP with the Okta (Okta Workforce Identity Cloud) authentication provider

You first have to create an Okta Application. The steps for TAP-GUI are for example:​
- Log into Okta (generally company.okta.com)
- Navigate to Menu >> Applications >> Applications >> Create App Integration
- Fill out the Create a new app integration form:
  - Sign-in method: OIDC - OpenID Connect
  - Application type: Web Application
  - Click Next
- Fill out the New Web App Integration form:
  - App integration name: Backstage (or your custom app name)
  - Grant type: Authorization Code & Refresh Token
  - Sign-in redirect URIs: http://tap-gui.example.com/api/auth/auth0/handler/frame
  - Sign-out redirect URIs: http://tap-gui.example.com
  - Controlled access: (select as appropriate)
  - Click Save

For information on how to configure [Pinniped](https://pinniped.dev) with Okta, have a look at the [documentation](https://pinniped.dev/docs/) and following links:
https://pinniped.dev/docs/howto/configure-supervisor-with-okta/
https://core.vmware.com/blog/tkg-2-choose-your-own-authentication-integrated-pinniped-oidc-vsphere-tanzu

Information on how to configure **TAP-GUI** with Okta is available here: https://backstage.io/docs/auth/okta/provider and in this [example](tap-values.example.yaml)

To configure your application with [Application Single Sign-On for VMware Tanzu](https://docs.vmware.com/en/VMware-Tanzu-Application-Platform/1.2/tap/GUID-app-sso-about.html) using Okta as authentication provider, have a look at the sample files in the [app-sso folder](app-sso) and the [documentation](https://docs.vmware.com/en/Application-Single-Sign-On-for-VMware-Tanzu/1.0/appsso/GUID-service-operators-identity-providers.html#openid-connect-providers).
For more information about the requirement of a shared session storage for OAuth2 clients if multiple instances of the app are run behind a load balancer, you can have a look [here](https://developer.okta.com/blog/2021/09/30/oauth-sessions-with-java#setup-haproxy-and-redis).

