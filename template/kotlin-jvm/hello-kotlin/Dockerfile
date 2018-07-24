FROM openjdk:8u171-jdk-stretch as builder

ENV GRADLE_OPTS "-Dorg.gradle.daemon=false"
RUN mkdir /app
WORKDIR /app
COPY *.kts /app/
COPY gradlew /app
COPY entrypoint/ /app/entrypoint
COPY function/ /app/function
COPY gradle/ /app/gradle
RUN ./gradlew :entrypoint:shadowJar

FROM openjdk:8u171-jdk-stretch
ENV mode "http"
ENV upstream_url "http://127.0.0.1:9000"
RUN echo "Pulling watchdog binary from Github." \
    && curl -sSL https://github.com/openfaas-incubator/of-watchdog/releases/download/0.2.5/of-watchdog > /usr/bin/fwatchdog \
    && chmod +x /usr/bin/fwatchdog \
    && mkdir -p /app
WORKDIR /app
COPY --from=builder /app/entrypoint/build/libs/serverless-function-0.1-SNAPSHOT.jar .
ENV fprocess "java -jar /app/serverless-function-0.1-SNAPSHOT.jar"
HEALTHCHECK --interval=2s CMD [ -e /tmp/.lock ] || exit 1
CMD ["fwatchdog"]
