# Adapted from the unofficial OpenFaaS Swift template and the Saturnism Kotlin Native Docker.

FROM openjdk:8u171-jdk-stretch as builder
ENV KOTLIN_VER "1.3.61"
WORKDIR /opt
RUN wget https://github.com/JetBrains/kotlin/releases/download/v$KOTLIN_VER/kotlin-native-linux-$KOTLIN_VER.tar.gz
RUN tar -xzf kotlin-native-linux-$KOTLIN_VER.tar.gz
RUN rm kotlin-native-linux-$KOTLIN_VER.tar.gz

ENV KOTLIN_NATIVE_HOME "/opt/kotlin-native-linux-$KOTLIN_VER"
RUN mkdir -p /app/function
WORKDIR /app
COPY function /app/function
COPY main.kt /app
RUN $KOTLIN_NATIVE_HOME/bin/konanc -opt -o handler -e function.main main.kt function
RUN mv handler.kexe handler

FROM frolvlad/alpine-glibc
ADD https://github.com/openfaas/faas/releases/download/0.18.4/fwatchdog /usr/bin
RUN chmod +x /usr/bin/fwatchdog
RUN mkdir -p /app
WORKDIR /app
COPY --from=builder /app/handler .
RUN chmod +x handler
ENV fprocess "./handler"
HEALTHCHECK --interval=2s CMD [ -e /tmp/.lock ] || exit 1
CMD ["fwatchdog"]
