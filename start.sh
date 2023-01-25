#!/bin/bash

# Pull new changes
git pull

docker-compose -f docker-compose-test.yml up -d

# Prepare Jar
mvn clean
mvn package

# Ensure, that docker-compose stopped
docker-compose stop
#docker-compose up db-bot

# Add environment variables
#export BOT_NAME=$1
#export BOT_TOKEN=$2
#export BOT_DB_USERNAME='root'
#export BOT_DB_PASSWORD='root'

# Start new deployment
docker-compose up --build -d