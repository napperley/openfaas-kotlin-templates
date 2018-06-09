# Adapted from the unofficial OpenFaaS Swift template and the Saturnism Kotlin Native Docker.

FROM saturnism/kotlin-native:0.7 AS build
WORKDIR /kotlin/src/handler
RUN mkdir -p /app

WORKDIR /app
COPY . .
RUN konanc -opt -o handler .
RUN curl -sSL https://github.com/openfaas/faas/releases/download/0.8.2/fwatchdog > ./fwatchdog
RUN chmod +x ./fwatchdog

ENV fprocess="./handler.kexe"
HEALTHCHECK --interval=2s CMD [ -e /tmp/.lock ] || exit 1
CMD ["./fwatchdog"]
