FROM java:8
VOLUME /tmp
ADD target/backend-0.1.jar app.jar
EXPOSE 8080
# The application's jar file
ARG JAR_FILE=target/backend-0.1.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongo:27017/pointTest", "-Djava.security.egd=file:/dev/./urandom","-jar","./app.jar"]

