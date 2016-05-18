# oneops-client

This library provides REST endpoints for several Oneops features such as:
- Find variables, environments, platforms, components
- Update variables
- Commit and deploy to an environment
- Get deployment status, pause and cancel deployments
- Find details of computes in an environment

### Building and running tests:
For unit tests to run, some parameters have to be passed as shown below:
- `mvn clean install -DONEOPS_ENDPOINT=<Oneops-endpoint> \
                  -DONEOPS_API_TOKEN=<Oneops-Api-token> \
                  -DONEOPS_ORG=<Oneops-organization-name> \
                  -DONEOPS_ASSEMBLY=<Oneops-assembly-name> \
                  -DONEOPS_ENVIRONMENT=<Oneops-environment-name> \
                  -DONEOPS_PLATFORM=<Oneops-platform-name> \
                  -DONEOPS_USER_ID=<Oneops-user-id> \
                  -DONEOPS_COMPONENTS=<Oneops-component-name> \
                  -DONEOPS_VARIABLES=<Oneops-variable-to-be-updated>`
