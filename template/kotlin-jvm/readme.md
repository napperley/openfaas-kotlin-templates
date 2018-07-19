# OpenFaaS Kotlin JVM Template

This template provides support for [Kotlin JVM](https://kotlinlang.org/docs/reference/server-overview.html) on [OpenFaaS](https://www.openfaas.com/). By using this template a basic Kotlin program (via JVM) can be quickly created and included in a Docker image, which is ready to be deployed on OpenFaaS.

## Usage

In order to use this template go through the following steps below.

1. Clone this repository
2. Change working directory to the cloned repository
3. Build the Docker image via **faas-cli**: ```faas-cli build -f hello-kotlin.yml```
4. Deploy the *hello-kotlin* Docker image via **faas-cli**: 
```faas-cli deploy --image hello-image --name hello-kotlin```

After completing the steps above you can now try out the Kotlin OpenFaaS function (hello-kotlin). Here is a example of invoking the Serverless Function: 
```echo 'Joe Bloggs' | faas-cli invoke hello-kotlin```
