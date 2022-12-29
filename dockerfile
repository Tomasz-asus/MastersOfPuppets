FROM openjdk:17
EXPOSE 8080
ADD target/MastersOfPuppets-0.0.1-SNAPSHOT.jar MastersOfPuppets-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "/MastersOfPuppets-0.0.1-SNAPSHOT.jar"]
