## Introduction

This application is used as a to-do app.

### Development

<b>Prerequisite softwares</b>
1. Java JDK 8 or higher
2. Maven

The project is developed with Maven and thus uses pom.xml for dependency management. To play with the project, download and import in your IDE of choice as a Maven project.


### Deployment

There are multiple ways to deploy the project. The first step in any of those will be to package the project into choice of packaging (war, jar etc).
To package/build/compile the project, we open a terminal:

```console
saty@tech:~/root-of-your-project$ mvn clean install
```

##### 1. Web Server deployment
Deploy your war file in a web/application server like Apache Tomcat. <br/>
Run jar file : java -jar </path to jar file>

##### 2. Docker

<i>create a docker image</i> :-
```console
saty@tech:~/root-of-your-project$ docker build -t <name-of-image>:latest .
```

<i>run a docker image</i> :-
```console
saty@tech:~/root-of-your-project$ docker run -d  -p 8080:8080 <name-of-image>:latest
```

<i>check running containers</i> :-
```console
saty@tech:~/root-of-your-project$ docker ps
```