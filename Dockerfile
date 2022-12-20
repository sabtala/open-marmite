FROM openjdk:8
ADD target/*.jar openmarmite.jar
EXPOSE 8081
ENTRYPOINT ["-java","-jar","openmarmite.jar"]