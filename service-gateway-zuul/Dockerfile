FROM java:8
MAINTAINER Lei
ADD target/service-gateway-zuul-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8020
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]