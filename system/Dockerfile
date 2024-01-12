# Stage 1: Build
FROM maven:3.9.0-eclipse-temurin-17-alpine AS build

RUN echo "Management System Cache...."

ARG DB_HOST
ARG DB_NAME
ARG DB_USER
ARG DB_PASSWORD

ENV DB_HOST=$DB_HOST \
    DB_NAME=$DB_NAME \
    DB_USER=$DB_USER \
    DB_PASSWORD=$DB_PASSWORD

COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean install -DskipTests=true

#
#COPY . .
#
#RUN mvn clean package -f pom.xml -s /usr/share/maven/ref/settings.xml -DskipTests=true

# Stage 2: Run
FROM eclipse-temurin:17-jdk-alpine

#RUN apk update
#RUN apk add curl

ENV TZ=America/Argentina/Buenos_Aires
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ARG PROFILE
ENV SPRING_PROFILES_ACTIVE=$PROFILE

ARG DB_HOST
ARG DB_NAME
ARG DB_USER
ARG DB_PASSWORD

ENV DB_HOST=$DB_HOST \
    DB_NAME=$DB_NAME \
    DB_USER=$DB_USER \
    DB_PASSWORD=$DB_PASSWORD

RUN echo "PROFILE: " + $PROFILE

#COPY --from=build /app/target/system-0.0.1-SNAPSHOT.jar app.jar
COPY --from=build /app/target/system-0.0.1-SNAPSHOT.jar /usr/local/lib/system-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/usr/local/lib/system-0.0.1-SNAPSHOT.jar"]