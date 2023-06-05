Run `kubectl get secret tap-tap-install-values -n tap-install -o jsonpath='{.data}' | jq 'keys[0]''` to identify the correct key for the value we want to override. For this example, it's "values.yaml", so replace all the occurrence of `.data.values\.yaml` with e.g. `.data.tap-values\.yaml`.

This example configures an overlay in the tap-values secret which changes the SecurityContext configuration of running Workloads.
```
UPDATED_TAP_VALUES=$(kubectl get secret tap-tap-install-values -n tap-install -o jsonpath='{.data.values\.yaml}' | base64 -d | grep -v '.*#! ' | yq '.package_overlays += [{ "name": "ootb-templates", "secrets": [{"name": "run-workloads-with-crac-overlay"}]}]' | base64 -w0) && kubectl patch secret tap-tap-install-values -n tap-install --type json -p="[{\"op\" : \"replace\" ,\"path\" : \"/data/values.yaml\" ,\"value\" : ${UPDATED_TAP_VALUES}}]"
cat <<EOF | kubectl apply -f -
apiVersion: v1
kind: Secret
metadata:
  name: run-workloads-with-crac-overlay
  namespace: tap-install
stringData:
  run-workloads-as-root-overlay.yaml: |
    #@ load("@ytt:overlay", "overlay")

    #@overlay/match by=overlay.subset({"metadata":{"name":"convention-template"}, "kind": "ClusterConfigTemplate"})
    ---
    spec:
      #@overlay/replace via=lambda a,_: a.replace("runAsUser: 1000", "capabilities:\n              add: [\"CHECKPOINT_RESTORE\"]")
      ytt: {}
EOF
```
