# Integrate TAP with the Auth0 by Okta (Okta Customer Identity Cloud) authentication provider

You first have to create an Auth0 Application. The steps for TAP-GUI are for example:​
- Log in to the [Auth0 dashboard](https://manage.auth0.com/dashboard/)
- Navigate to **Applications**
- Create an Application
- Name: Backstage (or your custom app name)
- Application type: Single Page Web Application
- Click on the Settings tab
- Add under Application URIs > Allowed Callback URLs: http://tap-gui.example.com/api/auth/auth0/handler/frame
- Click Save Changes

For information on how to configure [Pinniped](https://pinniped.dev) with Okta, have a look at the documentation:
https://pinniped.dev/docs/

Information on how to configure **TAP-GUI** with Auth0 is available here: https://backstage.io/docs/auth/okta/provider and in this [example](tap-values.example.yaml)

To configure your application with [Application Single Sign-On for VMware Tanzu](https://docs.vmware.com/en/VMware-Tanzu-Application-Platform/1.2/tap/GUID-app-sso-about.html) using Auth0 as authentication provider, have a look at the sample files in the [app-sso folder](app-sso) and the [documentation](https://docs.vmware.com/en/Application-Single-Sign-On-for-VMware-Tanzu/1.0/appsso/GUID-service-operators-identity-providers.html#openid-connect-providers).
For more information about the requirement of a shared session storage for OAuth2 clients if multiple instances of the app are run behind a load balancer, you can have a look [here](https://developer.okta.com/blog/2021/09/30/oauth-sessions-with-java#setup-haproxy-and-redis).
