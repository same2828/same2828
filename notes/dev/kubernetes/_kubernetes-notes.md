# Table of Contents

- [Table of Contents](#table-of-contents)
- [Commands](#commands)

# Commands

Note: `${podName}` == `<podName>`

```sh
alias k="kubectl"
export USE_GKE_GCLOUD_AUTH_PLUGIN=True
export PATH=/usr/local/google-cloud-sdk/bin:$PATH

# Show clusters
kubectx

# View nodes
k get no
k get ns
kubectl get nodes

# Show namespaces
kubens

# View all pods (after selecting namespace with `kubens`)
k get po
kubectl get pods

# View all pods within specific namespace
k get po -n ${namespace}
k get po -n dev
k get po -n stg
kubectl get pods -n ${namespace}
kubectl get pods -n dev
kubectl get pods -n sit

# View pod logs
k logs -n ${namespace} -f ${podName}
k logs -n dev -f webscraper_v1-a1b2c3d4
kubectl logs -n ${namespace} -f ${podName}
kubectl logs -n dev -f webscraper_v1-a1b2c3d4

# View config map
k get cm -n ${namespace}
k get cm -n dev
kubectl get cm -n ${namespace}
kubectl get cm -n dev

# View pod configuration (Note: we do NOT add `-UID` suffix to microservice)
k get cm -n ${namespace} ${microserviceName} -oyaml
k get cm -n dev webscraper_v1 -oyaml
kubectl get cm -n ${namespace} ${microserviceName} -oyaml
kubectl get cm -n dev webscraper_v1 -oyaml

# View specific pod's config values i.e. ${VAULT}
k describe po ${podName} -n ${namespace}
k describe po ${podName} -n dev
kubectl describe po ${podName} -n ${namespace}
kubectl describe po ${podName} -n dev

# View current context
k config current-context
kubectl config current-context

# Watch pods in namespace
k get po -n ${namespace} -w
k get po -n ${namespace} --watch
kubectl get po -n ${namespace} -w
kubectl get po -n ${namespace} --watch

# Test GCP microservice with Postman (with port forwarding)
# http://localhost:8087/api/webscraper_v1
k port-forward -n ${namespace} svc/${microserviceName} 8087:8080
k port-forward -n dev svc/webscraper_v1 8087:8080
kubectl port-forward -n ${namespace} svc/${microserviceName} 8087:8080
kubectl port-forward -n dev svc/webscraper_v1 8087:8080
```

Workflow

```sh
# Choose cluster
kubectx
# Show namespaces within cluster
kubens
# Show pods within namespace
k get po
# Check/view pod logs
k logs -n ${namespace} -f ${podName}
k logs -n dev -f ${podName}
# Check/view pod config
k get cm -n ${namespace} ${microserviceName} -oyaml
k get cm -n dev webscraper_v1 -oyaml
# Check/view pod config values
k describe po ${podName} -n ${namespace}
k describe po webscraper_v1-a1b2c3d4 -n dev
```

- Random Setup Docs
  - Set cert filepath
    - `gcloud config set core/custom_ca_certs_file ${filePathOfCertFileOnMac}`
  - Setup Commands
    - `sudo gcloud components update`
    - Unset proxy/env vars
      - `unset http_proxy https_proxy HTTP_PROXY HTTPS_PROXY`
    - Set default account
      - `gcloud config set core/account ${yourEmail}`
    - Disable load Google Auth
      - `gcloud config set auth/disable_load_google_auth True`
    - Disable Core cert
      - `gcloud config unset core/custom_ca_certs_file`
    - Initialise Google Cloud
      - `gcloud init`
  - Pick configuration to use [1 Current, 2 New]: `Pick 1`
  - Do you have a network proxy: `N`
  - Network errors detected. Continue?: `Y`
  - You must login: `Y`
  - Choose account: `Enter email`
  - Do you want to configure a default Compute Region and Zone: `N`
  - Install gke-gcloud-auth-plugin
    - `sudo gcloud components install gke-gcloud-auth-plugin`
  - Update Google Cloud Components
    - `sudo gcloud components update`
  - Generate Kube Config Entry
    - Fetch cluster credentials for desired clusters: `gcloud container clusters get-credentials ${gkeCluster} --region australia-southeast1 --project ${gcpProject}`
    - Run once per cluster
    - Info is stored in `~/.kube/config`
  - Set up proxies for clusters
    - `kubectl config set clusters.${gkeCluster}.proxy-url ${customUrl}`
  - [kubectx+kubens](https://github.com/ahmetb/kubectx)
    - `kubectx` == Switch between context/GKE clusters
    - `kubens` == Switch between namespaces
    - Install `fzf`
  - Troubleshooting
    - `unset http_proxy https_proxy HTTP_PROXY HTTPS_PROXY`
    -
