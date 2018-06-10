# Adapted from the unofficial OpenFaaS Swift template and the Saturnism Kotlin Native Docker.

FROM debian:jessie
ADD https://github.com/openfaas/faas/releases/download/0.8.2/fwatchdog /usr/bin
RUN chmod +x /usr/bin/fwatchdog
RUN mkdir -p /app
WORKDIR /app

COPY handler .
RUN chmod +x handler
ENV fprocess "./handler"
HEALTHCHECK --interval=2s CMD [ -e /tmp/.lock ] || exit 1
CMD ["fwatchdog"]
