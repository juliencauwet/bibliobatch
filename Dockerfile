FROM openjdk:8
ADD target/bibliobatch.jar bibliobatch.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "bibliobatch.jar"]
CMD echo "Lancement de l'application"
CMD java -jar bibliobatch.jar