FROM java:8
VOLUME /tmp
ADD target/backend-0.1.jar app.jar
EXPOSE 8654
# The application's jar file
ARG JAR_FILE=target/backend-0.1.jar
ARG KEY_STORE=keystore.p12

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar
ADD ${KEY_STORE} keystore.p12
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://localhost:27017", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

