FROM gradle:jdk17 as build
COPY . /usr/src/app
WORKDIR /usr/src/app
RUN gradle build -x test

FROM openjdk:17-alpine
ENV JAVA_OPTIONS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"

COPY --from=build --chown=1001 /usr/src/app/build/quarkus-app/lib/ /deployments/lib/
COPY --from=build --chown=1001 /usr/src/app/build/quarkus-app/*.jar /deployments/
COPY --from=build --chown=1001 /usr/src/app/build/quarkus-app/app/ /deployments/app/
COPY --from=build --chown=1001 /usr/src/app/build/quarkus-app/quarkus/ /deployments/quarkus/

RUN ls -la /deployments/

ENTRYPOINT [ "java", "-jar", "/deployments/quarkus-run.jar" ]