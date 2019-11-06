FROM java:8
VOLUME /tmp
ADD target/mongorest-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8654
# The application's jar file
ARG JAR_FILE=target/mongorest-0.0.1-SNAPSHOT.jar
ARG KEY_STORE=keystore.p12

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar
ADD ${KEY_STORE} keystore.p12
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://invoicemongodb:4QYFGUGDYbWC7Y7c6uBeysOUIRmz3SzE2JCMwqUo9zEk1FlpG0XMGlbM4xdio0hITzLJJQdPk7KHSkVMGv8KiQ==@invoicemongodb.documents.azure.com:10255/?ssl=true&replicaSet=globaldb", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
