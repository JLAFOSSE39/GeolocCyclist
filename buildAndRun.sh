#!/bin/sh
mvn clean package && docker build -t com/GeolocCyclist .
docker rm -f GeolocCyclist || true && docker run -d -p 9080:9080 -p 9443:9443 --name GeolocCyclist com/GeolocCyclist