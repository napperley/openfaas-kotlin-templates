FROM openjdk:8u171-jdk-stretch as builder

RUN mkdir /app
WORKDIR /app
COPY *.kts /app/
COPY gradlew /app
COPY entrypoint/ /app/entrypoint
COPY function/ /app/function
COPY gradle/ /app/gradle
RUN ./gradlew :entrypoint:shadowJar

FROM openjdk:8u171-jdk-stretch
ADD https://github.com/openfaas/faas/releases/download/0.8.2/fwatchdog /usr/bin
RUN chmod +x /usr/bin/fwatchdog && mkdir -p /app
WORKDIR /app
COPY --from=builder /app/entrypoint/build/libs/serverless-function-0.1-SNAPSHOT.jar .
ENV fprocess "java -jar /app/serverless-function-0.1-SNAPSHOT.jar"
HEALTHCHECK --interval=2s CMD [ -e /tmp/.lock ] || exit 1
CMD ["fwatchdog"]
