@echo off
echo Starting Swedifying the other application ...
set SPRING_PROFILES_ACTIVE=prod
set DATASOURCE_USERNAME=%1
set DATASOURCE_PASSWORD=%2
java -jar ./swedifying-1.0.0.jar
set DATASOURCE_USERNAME=
set DATASOURCE_PASSWORD=