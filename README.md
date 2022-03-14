# SDA Tracking App 

SDA it's like a history for people who you are met,

## Local Environment
1- Java version 17

2- NodeJs version 16.13.2 

2- Docker (Optional)


Clone SDA tracking repo to your machine and open the terminal inside it.

## Run The Backend
Backend built with spring boot . 
run backend project using  any Java IDE (Eclipse , Neatbeans ...)
Backend will run on default port of spring boot 8080, http://localhost:8080


## Run The Frontend
Frontend built with NuxtJs framework.
```bash
# change directory to frontend app
cd tracking-app
# install frontend npm packages
npm i 
# run 
npm run dev
```
Frontend app now running on http://localhost:3000

## Dockerizing

Prerequisites

[Docker](https://docs.docker.com/get-started/) must be installed on your machine and you have created an  account on [Docker Hub](https://hub.docker.com/)

inside project root folder run the following commands to build  docker images for frontend and backend
```bash
# build docker image for frontend
docker build --file=app/DockerFile  -t calcuco .
# build docker image for backend
docker build --file=api/app/DockerFile  -t calcuco-api .

```
then run docker compose using the following command

```bash

docker-compose -f docker-compose.yml up

```
