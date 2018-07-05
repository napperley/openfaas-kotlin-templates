FROM openjdk:8u171-jdk-stretch as builder

RUN mkdir -p /app/src/main/kotlin/org/example/function/handler
WORKDIR /app
COPY *.kts /app/
COPY gradlew /app
COPY src /app
COPY gradle /app/gradle
RUN ./gradlew shadowJar

FROM adoptopenjdk/openjdk9-openj9:jdk-9.181
ADD https://github.com/openfaas/faas/releases/download/0.8.2/fwatchdog /usr/bin
RUN chmod +x /usr/bin/fwatchdog
RUN mkdir -p /app
WORKDIR /app
COPY --from=builder /app/build/libs/serverless-function-0.1-SNAPSHOT.jar /app/serverless-function-0.1-SNAPSHOT.jar
ENV fprocess "java -jar /app/serverless-function-0.1-SNAPSHOT.jar"
HEALTHCHECK --interval=2s CMD [ -e /tmp/.lock ] || exit 1
CMD ["fwatchdog"]
