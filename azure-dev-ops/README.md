This sample shows how to use Azure DevOps for CI and VMWare Tanzu Application Platform for the continuous path to production (CD) for the seperation of concerns.

The [Workload configuration](workload.yaml) should be copied to the `config/` path of the source code.

The [Azure DevOps Pipeline](azure-pipelines.yaml) should be copied to the root of the source code. You have to set the `kubernetesServiceEndpoint` in line 32 and maybe the namespace in line 33.
To set up a Kubernetes Service Endpoint in your Azure DevOps project, navigate to `Pipelines/Environments`, click on `New environment`, select the `Kubernetes` Resource, and follow the instructions.

To make your developers as productive as possible, I recommend creating an [TAP Accelerator](https://docs.vmware.com/en/VMware-Tanzu-Application-Platform/1.4/tap/application-accelerator-about-application-accelerator.html) that already includes the [Workload configuration](workload.yaml) and [Azure DevOps Pipeline](azure-pipelines.yaml).

Azure DevOps requires you to use libgit2 as the server-side implementation as it only supports GIT's v2 protocol. Therefore you've to configure the ClusterSupplyChain for it.
```
apiVersion: carto.run/v1alpha1
kind: ClusterSupplyChain
spec:
 resources:
 - name: source-provider
 params:
 - name: gitImplementation
 value: libgit2 // default value is go-git
...
```
In a future version of TAP, it will be possible to change the `gitImplementation` value also via the Workload `params`. You can also achieve this today by setting the `gitImplementation` value in the ClusterSupplyChain with `default: go-git` instead of `value: go-git`.

Azure DevOps is currently also not compatible with TAP's [Pull-Request capabilities for GitOps](https://docs.vmware.com/en/VMware-Tanzu-Application-Platform/1.4/tap/scc-gitops-vs-regops.html#pull-requests-2). This will be fixed in a future update, and [here](https://vrabbi.cloud/post/tap-pr-flow-with-azure-devops/) is also a blog article from the community on how to get it working with the current version of TAP.


