#set( $symbol_dollar = '$' )
FROM adoptopenjdk/openjdk11:alpine-jre as builder
MAINTAINER gyl "shiyindaxiaojie@gmail.com"
WORKDIR application
ARG JAR_FILE=${rootArtifactId}-start/target/*.jar
COPY ${symbol_dollar}{JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM adoptopenjdk/openjdk11:alpine-jre as runtime
MAINTAINER gyl "shiyindaxiaojie@gmail.com"
ARG USER=tmpuser
ARG HOME=/home/${symbol_dollar}USER
RUN addgroup --gid 1000 "${symbol_dollar}USER" \
  && adduser -u 1000 -G "${symbol_dollar}USER" -h "${symbol_dollar}HOME" "${symbol_dollar}USER" --disabled-password
RUN chown ${symbol_dollar}USER:${symbol_dollar}USER ${symbol_dollar}HOME
USER ${symbol_dollar}USER
WORKDIR ${symbol_dollar}HOME
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader ./
COPY --from=builder application/organization-dependencies ./
COPY --from=builder application/modules-dependencies ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
ADD src/main/docker/entrypoint.sh bin/entrypoint.sh

ENV RUN_SLEEP 1
ENV JAVA_OPTS '-Xmx512m -Xms512m -Xss256k'
ENV JAVA_AGENT ''

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo 'Asia/Shanghai' >/etc/timezone \
    && mkdir logs \
    && cd logs \
    && touch entrypoint.out \
    && ln -sf /dev/stdout entrypoint.out \
    && ln -sf /dev/stderr entrypoint.out

RUN chmod +x bin/entrypoint.sh
ENTRYPOINT [ "sh", "-c", "sh bin/entrypoint.sh"]
