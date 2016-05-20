# oneops-client

This library provides a client for several Oneops features such as:
- Find variables, environments, platforms, components
- Update variables
- Commit and deploy to an environment
- Get deployment status, pause and cancel deployments
- Find details of computes in an environment

## Gather IPs of Computes

```java
OneOpsClient client = OneOpsClient.builder()
  .baseUrl("https://oneops.prod.walmart.com")
  .apiToken("XXX")
  .build();
     
List<String> ips = client.computeIps(
  "platform", // organization
  "TestDevtoolsNexus", // assembly
  "PerfTest",  // environment
  "Java", // platform
  "compute" // componentName
);
```

## Deploy an artifact version to an environment

```java
OneOpsClient client = OneOpsClient.builder()
  .baseUrl("https://oneops.prod.walmart.com")
  .apiToken("XXX")
  .build();
     
Variable variable = client.updateVariable(
	"platform", // organization
	"TestDevtoolsNexus", // assembly
	"PerfTest", // environment
	"Java", // platform
	"appVersion", // variableName
	"1.0.8-SNAPSHOT", // variableValue (this is the only value that needs to be changed every time a deployment is being done!)
	"artifact" // name of component to be touched (in case variable value is same as previous value)
); 
    
Deployment deployment = client.commitAndDeploy(
	"platform", // organization
	"TestDevtoolsNexus", // assembly
	"PerfTest", // environment
	"Java", // platform
	true, // cancel an ongoing active deployment 
	true, // deploy to all platforms or not
	null, // list of platforms to be deployed to in case deployAllPlatforms is false
	"30000" // pollFrequency - wait time in milliseconds before checking for deployment status
	);
```