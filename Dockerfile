#FROM openjdk:17-alpine
#ARG JAR_FILE=target/*.jar
#ENV BOT_NAME='GoyraMenubot'
#ENV BOT_TOKEN=5238207911:AAGNe7SAptlVfWvZeD2dxd_W74LCJ-sXogI
###ENV BOT_DB_USERNAME=root
###ENV BOT_DB_PASSWORD=root
#COPY ${JAR_FILE} app.jar
#
#ENTRYPOINT ["java",
##"-Dspring.datasource.url=jdbc:postgresql://db:5430/goyra_bot",
## "-Dspring.datasource.password=root",
##  "-Dspring.datasource.username=root",
# "-Dbot.username=${BOT_NAME}",
#  "-Dbot.token=${BOT_TOKEN}",
#
#   "-jar", "/app.jar"]

FROM openjdk:17-alpine
ADD target/test-bot-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]