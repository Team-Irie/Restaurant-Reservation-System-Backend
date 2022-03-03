FROM openjdk:11
COPY project2/build/libs/project2-0.0.1-SNAPSHOT-plain.jar demo.jar
CMD ["java", "-jar", "demo.jar"]