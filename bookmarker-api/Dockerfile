FROM eclipse-temurin:21.0.5_11-jre

ADD target/*.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]

#https://www.youtube.com/watch?v=UhEMh-HZIMY&list=PLuNxlOYbv61h66_QlcjCEkVAj6RdeplJJ&index=3