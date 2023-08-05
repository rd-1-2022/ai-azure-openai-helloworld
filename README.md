# Simple Spring AI Application with Azure OpenAI

This project contains a web service that will accept HTTP GET requests at
`http://localhost:8080/ai/simple`

There is optional `text` parameter whose default value is "Tell me a joke".

The response to the request is from the Azure OpenAI Service.

## Prerequisite

Before using the AI commands, obtain your Azure OpenAI `endpoint` and `api-key` from the Azure OpenAI Service section on [Azure Portal](https://portal.azure.com)

The Spring AI project defines a configuration property named `spring.ai.openai.api-key` that you should set to the value of the `API Key` obtained from `openai.com`.

Exporting an environment variables is one way to set these configuration properties.
```shell
export SPRING_AI_AZURE_OPENAI_API_KEY=<INSERT KEY HERE>
export SPRING_AI_AZURE_OPENAI_ENDPOINT=<INSERT ENDPOINT URL HERE>
```

## Building and running

```
./mvnw spring-boot:run
```

## Access the endpoint

To get a response to the default request of "Tell me a joke"

```shell
curl http://localhost:8080/ai/simple
```

A sample response is

```text
Why don't scientists trust atoms?

Because they make up everything!
```

Now using the `text` request parameter
```shell
curl --get  --data-urlencode 'text=Tell me a joke about a cow.' http://localhost:8080/ai/simple 
```
A sample response is

```text
Why did the cow go to outer space? To see the moooon!
```

