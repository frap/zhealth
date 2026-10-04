# ONCE-compatible image: serves HTTP on port 80 with a healthcheck at /up.
#
#   docker build -t zhealth .
#   docker run --rm -p 8080:80 zhealth

FROM clojure:temurin-21-tools-deps-bookworm-slim AS build

ARG TARGETARCH
ARG TAILWIND_VERSION=v4.0.0

RUN apt-get update \
 && apt-get install -y --no-install-recommends curl ca-certificates \
 && rm -rf /var/lib/apt/lists/*

RUN case "$TARGETARCH" in arm64) tw=arm64 ;; *) tw=x64 ;; esac \
 && curl -fsSL -o /usr/local/bin/tailwindcss \
      "https://github.com/tailwindlabs/tailwindcss/releases/download/${TAILWIND_VERSION}/tailwindcss-linux-${tw}" \
 && chmod +x /usr/local/bin/tailwindcss

WORKDIR /app

# Resolve dependencies in their own layer so source edits don't refetch them
COPY deps.edn build.clj ./
RUN clojure -P && clojure -T:build clean

COPY src ./src
COPY resources ./resources

RUN tailwindcss -i resources/tailwind.css -o target/resources/public/css/main.css --minify \
 && clojure -T:build uber

FROM eclipse-temurin:21-jre

# Links the GHCR package to the (public) repo so it can inherit visibility
LABEL org.opencontainers.image.source=https://github.com/frap/zhealth

WORKDIR /app
COPY --from=build /app/target/zhealth.jar /app/zhealth.jar

ENV PORT=80
EXPOSE 80

CMD ["java", "-XX:-OmitStackTraceInFastThrow", "-XX:+CrashOnOutOfMemoryError", "-XX:MaxRAMPercentage=75", "-jar", "/app/zhealth.jar"]
