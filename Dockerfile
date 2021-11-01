FROM gradle:jdk17 as build
COPY . /usr/src/app
WORKDIR /usr/src/app
RUN gradle clean build

FROM fabric8/java-alpine-openjdk17-jre
ENV JAVA_OPTIONS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
COPY --from=build /usr/src/app/target/lib/* /deployments/lib/
COPY --from=build /usr/src/app/target/*-runner.jar /deployments/app.jar
ENTRYPOINT [ "/deployments/run-java.sh" ]