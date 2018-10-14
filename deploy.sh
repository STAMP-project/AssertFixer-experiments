#!/usr/bin/env bash

# Pull in the .env file
if [ -f .env ]
then
  export $(cat .env | xargs)
else
    export $(cat ../../.env | xargs)
fi

# Check if its latest or dev and deploy accordingly
if [ $1 == 'latest' ]
then
    echo "latet"
    export TAG=latest

    docker login -u=$DOCKER_USER -p=$DOCKER_PASS
    docker tag $IMAGE_TOMCAT:$TAG $IMAGE_TOMCAT:$VERSION
    docker push $IMAGE_TOMCAT:$TAG
    docker push $IMAGE_TOMCAT:$VERSION
elif [ $1 == 'dev' ]
then
    echo "dev"
    export TAG=dev

    docker login -u=$DOCKER_USER -p=$DOCKER_PASS
    docker tag ${IMAGE_TOMCAT}:latest ${IMAGE_TOMCAT}:${TAG}
    docker push ${IMAGE_TOMCAT}:${TAG}
fi
