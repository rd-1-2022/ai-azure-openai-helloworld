# Simple Spring AI Application with Azure OpenAI

This project contains a web service that will accept HTTP GET requests at
`http://localhost:8080/ai/simple`

There is optional `message` parameter whose default value is "Tell me a joke".

The response to the request is from the Azure OpenAI Service.

## Prerequisite

Before using the AI commands, obtain your Azure OpenAI `endpoint` and `api-key` from the Azure OpenAI Service section on [Azure Portal](https://portal.azure.com)

The Spring AI project defines a configuration property named `spring.ai.azure.openai.api-key` that you should set to the value of the `API Key` obtained from Azure.

Exporting an environment variables is one way to set these configuration properties.
```shell
export SPRING_AI_AZURE_OPENAI_API_KEY=<INSERT KEY HERE>
export SPRING_AI_AZURE_OPENAI_ENDPOINT=<INSERT ENDPOINT URL HERE>
```

### Create an Azure AI Deployment

Follow these steps to create an Azure AI Deployment via the [Azure AI Portal](https://oai.azure.com/portal) so that you can use the default values in the Spring Boot Autoconfiguration

**NOTE:** In Azure, it's mandatory for each client to identify a `Deployment Name` for connecting to the Azure OpenAI service. Note that the `Deployment Name` is distinct from the actual model you intend to deploy. For example, a deployment called 'MyAiDeployment' might be set up to utilize the GPT 3.5 Turbo or the GPT 4.0 model.

For now, to create an easy setup, create a deployment in the [Azure AI Portal](https://oai.azure.com/portal) with these parameters:

- Deployment Name: `gpt-35-turbo`
- Model Name: `gpt-35-turbo`

This configuration is compatible with the default settings of the Spring Boot Azure AI Starter and its auto-configuration capabilities.

If you have a different `Deployment Name`, modify the corresponding configuration property as shown below:


```shell
spring.ai.azure.openai.chat.options.model=<my deployment name>
```

The terminology used in Azure OpenAI, specifically the mix-up between `Deployment Name` and `Model Name`, stems from the structural differences between Azure OpenAI and OpenAI deployments.
In the context of OpenAI, there is only a `Model Name` without a `Deployment Name`.
This discrepancy has led a property named `deploymentOrModelName` within the Azure OpenAI client library.

To avoid this confusion, a future update of Spring AI will rename the property `spring.ai.azure.openai.chat.options.model` to `spring.ai.azure.openai.chat.options.deployment-name`.

## Building and running

```
./mvnw spring-boot:run
```

## Access the endpoint

To get a response to the default request of "Tell me a joke"

```shell
http http://localhost:8080/ai/simple
```

A sample response is

```text
Why don't scientists trust atoms?

Because they make up everything!
```

Now using the `text` request parameter
```shell
curl --get  --data-urlencode 'message=Tell me a joke about a cow.' http://localhost:8080/ai/simple 
```
A sample response is

```text
Why did the cow go to outer space? To see the moooon!
```



