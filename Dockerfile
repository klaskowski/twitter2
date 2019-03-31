FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package

FROM tomcat:9.0.16-jre11-slim

RUN apt-get update && apt-get -y upgrade

WORKDIR /usr/local/tomcat

COPY --from=MAVEN_TOOL_CHAIN /tmp/target/twitter2 $CATALINA_HOME/webapps/twitter2
COPY tomcat-config/tomcat-users.xml $CATALINA_HOME/conf/tomcat-users.xml
COPY tomcat-config/context.xml $CATALINA_HOME/webapps/manager/META-INF/context.xml


EXPOSE 8080
CMD ["catalina.sh", "run"]

