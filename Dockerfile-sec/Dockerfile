FROM alpine:latest

RUN apk update

#bash
RUN apk add bash

#docker
RUN apk add --update docker openrc
RUN rc-update add docker boot

# Install Java.
RUN apk --update --no-cache add openjdk8 curl

# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/default-jvm/

#cosign
RUN wget "https://github.com/sigstore/cosign/releases/download/v1.6.0/cosign-linux-amd64"
RUN  mv cosign-linux-amd64 /usr/local/bin/cosign
RUN chmod +x /usr/local/bin/cosign

#syft
RUN apk add curl
RUN curl -sSfL https://raw.githubusercontent.com/anchore/syft/main/install.sh | sh -s -- -b /usr/local/bin

#jq
RUN apk add jq

#grype
RUN curl -sSfL https://raw.githubusercontent.com/anchore/grype/main/install.sh | sh -s -- -b /usr/local/bin

#aqua
RUN curl -O https://get.aquasec.com/aquactl/v3/aquactl && chmod +x ./aquactl

#trivy
RUN apk add curl \
    && curl -sfL https://raw.githubusercontent.com/aquasecurity/trivy/master/contrib/install.sh | sh -s -- -b /usr/local/bin \ 
    && trivy filesystem --exit-code 1 --no-progress  --severity CRITICAL /

#CMD ["/bin/bash"]

