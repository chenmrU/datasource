FROM openjdk:8
MAINTAINER cmr
LABEL name="datasource" version="1.0" author="cmr"
COPY target/datasource-0.0.1-SNAPSHOT.jar datasource-image.jar
CMD ["java","-jar","datasource-image.jar"]