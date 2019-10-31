FROM java:8
MAINTAINER Lei
ADD target/service-hystrix-dashboard-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8050
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]