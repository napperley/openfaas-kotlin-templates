# OpenFaaS Kotlin Native (Linux amd64) Template

This template provides support for [Kotlin Native](https://kotlinlang.org/docs/reference/native-overview.html) (Linux amd64) on [OpenFaaS](https://www.openfaas.com/). By using this template a basic Kotlin Native program can be quickly created and included in a Docker image, which is ready to be deployed on OpenFaaS. 

## Usage

In order to use this template go thorugh the following steps below.

1. Clone this repository
2. Change working directory to the cloned repository
3. Run the following to build a new Kotlin Native Docker image:

```docker build --tag hello-kotlin .```

4. Start OpenFaaS
5. Go to the following web address (in a Web Browser) to access the OpenFaaS Portal: http://127.0.0.1:8080
6. If a Login dialog appears enter in the username and password for the OpenFaaS instance
7. Click on **Deploy New Function** button
8. Select **CUSTOM** tab
9. For **Docker image** enter in **hello-kotlin**
10. For **Function name** enter in **hello-kotlin**
11. Click on **DEPLOY** button

After completing the steps above you can now try out the Kotlin Native OpenFaaS function (hello-kotlin).
