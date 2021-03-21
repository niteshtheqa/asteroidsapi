Asteroidsapi
Rest API Automation

This is rest api automation project develope to autoamtion SBDB Close-Approach Data API

Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

##Prerequisites

You need to have below list of softwares in order to run given automation project in your local machine

IDE of your choice [Eclipse / VSCode / NetBeans / IntelliJ ] https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2021-03/R/eclipse-inst-jre-win64.exe
JDK 8 https://cdn.azul.com/zulu/bin/zulu8.52.0.23-ca-jdk8.0.282-win_x64.zip
Maven https://mirrors.estointernet.in/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip
Gitbash to clone project https://github.com/git-for-windows/git/releases/download/v2.31.0.windows.1/Git-2.31.0-64-bit.exe
Docker based on OS https://hub.docker.com/editions/community/docker-ce-desktop-windows/

##Installation and prepare environment for asteroidsapi automation

Install java8.
Set Environment Variables for Java e.g. JAVA_HOME = "location of JDK" then add this varibale to PATH Varibale PATH = %JAVA_HOME%\bin;
Install Maven
Set Environment Variables for Maven MAVEN_HOME = "Location of maven project"
Install latest version of Eclipse recomended Photon Release (4.8.0).
Clone autoamtion project https://github.com/Nitsss2611/asteroidsapi.git using git bash in directory of your workspace
Import the project in eclipse as maven project
Build the project


##To prepare environment for TestHelloService
Follow the instruction to launch service using kubernetes and minikube
Document attached with project and seperate mail as well "Steps to create hello-service"
Please follow 2. Using kubernetes Section to create and run hell-service in minikube pods

##Running the asteroidsapi tests on local machine

GO to eclipse
Right click on Project name i.e. com.qa.api.sbdb
Run As => Maven Clean => Maven Test
OR

Go to Project Explorer and Open CMD
Use below maven command to run Test Suite ==> mvn clean test
OR #To run single test class ==>mvn -Dtest = TestClassName clean test e.g. mvn -Dtest =TestAllCloseApproach clean test

*Note To RUN TestHelloService in local machine
You need to first create hello-service and run it sucessfully.
you will find Port number when you run command minikube service hello-service
Please update port ='' in config.properties ==>.\asteroidsapi\src\main\resources
e.g. port = 61853
mvn -Dtest =TestHelloService test



##Running asteroidsapi automation suite in docker container
There are two ways that you can run atuomation suite in docker container
1] Manually with powershell
Make sure you have docker up and running
Clone git project URL : https://github.com/Nitsss2611/asteroidsapi.git
Execute below command on same location
docker run --rm -it --name api-automation -v ${PWD}/asteroidsapi:/usr/src/maven -w /usr/src/maven maven:3.3-jdk-8-alpine mvn clean test

2]Using powershell scripting 
Run below file using powershell
& .\ asteroidsapi.ps1

Or right clicke on file and choose Run With Powershell



Break down into end to end tests

TestAllCloseApproach ==> Having tests for asteroids data within date range and distance in AU
TestEarthCloseApproach ==> Tests for asteroids withing date range Lunar distance and sorting distance in ascending and descending order
TestHelloSvc ==> This are tests for dockerised hello-service . This test must need kubernetes set up given in pre-requisites else you can expect to failed as result


Happy Testing!