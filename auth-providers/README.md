There are several levels and components an Authentication provider has to be integrated in.

The first level relevant for us is the Kubernetes clusters for role-based access control (RBAC).
With [Pinniped](https://pinniped.dev) we've create an OSS solution that not only works with TKG, but also with EKS, AKS, and GKE and supports OIDC, LDAP, and Microsoft AD.

The next integration point is TAP-GUI. As [Backstage](https://backstage.io) as the underlying technology [supports a variety of Authentication providers](https://backstage.io/docs/auth/).

For applications running on TAP, we've a component called [Application Single Sign-On for VMware Tanzu](https://docs.vmware.com/en/VMware-Tanzu-Application-Platform/1.2/tap/GUID-app-sso-about.html) which supports OIDC, LDAP, and SAML.

Sample integrations:
- [Auth0 by Okta](auth0)
- [Okta](okta)
