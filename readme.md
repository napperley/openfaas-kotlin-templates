# OpenFaaS Kotlin Native Template

This template provides support for [Kotlin Native](https://kotlinlang.org/docs/reference/native-overview.html) on [OpenFaaS](https://www.openfaas.com/). By using this template a basic Kotlin Native program can be quickly created and included in a Docker image, which is ready to be deployed on OpenFaaS. 

## Usage

In order to use this template go thorugh the following steps below.

1. Clone this repository
2. Run the following to build a new Kotlin Native Docker image:

```docker build --tag hello-kotlin .```

3. Start OpenFaaS
4. Go to the following web address (in a Web Browser) to access the OpenFaaS Portal: `http://127.0.0.1:8080`
5. Click on **Deploy New Function** button
6. Select **MANUALLY** tab
7. For **Docker image** enter in **hello-kotlin**
8. For **Function name** enter in **hello-kotlin**
9. Click on **DEPLOY** button

After completing the steps above you can now try out the Kotlin Native OpenFaaS function (hello-kotlin).
