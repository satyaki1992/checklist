# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine
# copy jar into image
COPY checklist-service/target/checklist-service-0.0.1.jar /checklist.jar
# run application with this command line
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=dev", "/checklist.jar"]