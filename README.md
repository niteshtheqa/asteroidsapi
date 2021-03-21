<p class="has-line-data" data-line-start="0" data-line-end="2">Asteroidsapi<br>
Rest API Automation</p>
<p class="has-line-data" data-line-start="3" data-line-end="4">This is rest api automation project develope to autoamtion SBDB Close-Approach Data API</p>
<p class="has-line-data" data-line-start="5" data-line-end="6">Getting Started</p>
<p class="has-line-data" data-line-start="7" data-line-end="8">These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.</p>
<p class="has-line-data" data-line-start="9" data-line-end="10">##Prerequisites</p>
<p class="has-line-data" data-line-start="11" data-line-end="12">You need to have below list of softwares in order to run given automation project in your local machine</p>
<p class="has-line-data" data-line-start="13" data-line-end="14">1.IDE of your choice [Eclipse / VSCode / NetBeans / IntelliJ ] <a href="https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2021-03/R/eclipse-inst-jre-win64.exe">https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2021-03/R/eclipse-inst-jre-win64.exe</a></p>
<p class="has-line-data" data-line-start="15" data-line-end="19">2.JDK 8 <a href="https://cdn.azul.com/zulu/bin/zulu8.52.0.23-ca-jdk8.0.282-win_x64.zip">https://cdn.azul.com/zulu/bin/zulu8.52.0.23-ca-jdk8.0.282-win_x64.zip</a><br>
3.Maven <a href="https://mirrors.estointernet.in/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip">https://mirrors.estointernet.in/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip</a><br>
4.Gitbash to clone project <a href="https://github.com/git-for-windows/git/releases/download/v2.31.0.windows.1/Git-2.31.0-64-bit.exe">https://github.com/git-for-windows/git/releases/download/v2.31.0.windows.1/Git-2.31.0-64-bit.exe</a><br>
5.Docker based on OS <a href="https://hub.docker.com/editions/community/docker-ce-desktop-windows/">https://hub.docker.com/editions/community/docker-ce-desktop-windows/</a></p>
<p class="has-line-data" data-line-start="20" data-line-end="21">##Installation and prepare environment for asteroidsapi automation</p>
<p class="has-line-data" data-line-start="22" data-line-end="30">Install java8.<br>
Set Environment Variables for Java e.g. JAVA_HOME = “location of JDK” then add this varibale to PATH Varibale PATH = %JAVA_HOME%\bin;<br>
Install Maven<br>
Set Environment Variables for Maven MAVEN_HOME = “Location of maven project”<br>
Install latest version of Eclipse recomended Photon Release (4.8.0).<br>
Clone autoamtion project <a href="https://github.com/Nitsss2611/asteroidsapi.git">https://github.com/Nitsss2611/asteroidsapi.git</a> using git bash in directory of your workspace<br>
Import the project in eclipse as maven project<br>
Build the project</p>
<p class="has-line-data" data-line-start="32" data-line-end="36">##To prepare environment for TestHelloService<br>
Follow the instruction to launch service using kubernetes and minikube<br>
Document attached with project and seperate mail as well “Steps to create hello-service”<br>
Please follow 2. Using kubernetes Section to create and run hell-service in minikube pods</p>
<p class="has-line-data" data-line-start="37" data-line-end="38">##Running the asteroidsapi tests on local machine</p>
<p class="has-line-data" data-line-start="39" data-line-end="43">GO to eclipse<br>
Right click on Project name i.e. com.qa.api.sbdb<br>
Run As =&gt; Maven Clean =&gt; Maven Test<br>
OR</p>
<p class="has-line-data" data-line-start="44" data-line-end="47">Go to Project Explorer and Open CMD<br>
Use below maven command to run Test Suite ==&gt; mvn clean test<br>
OR #To run single test class ==&gt;mvn -Dtest = TestClassName clean test e.g. mvn -Dtest =TestAllCloseApproach clean test</p>
<p class="has-line-data" data-line-start="48" data-line-end="54">*Note To RUN TestHelloService in local machine<br>
You need to first create hello-service and run it sucessfully.<br>
you will find Port number when you run command minikube service hello-service<br>
Please update port =’’ in config.properties ==&gt;.\asteroidsapi\src\main\resources<br>
e.g. port = 61853<br>
mvn -Dtest =TestHelloService test</p>
<p class="has-line-data" data-line-start="57" data-line-end="64">##Running asteroidsapi automation suite in docker container<br>
There are two ways that you can run atuomation suite in docker container<br>
1] Manually with powershell<br>
Make sure you have docker up and running<br>
Clone git project URL : <a href="https://github.com/Nitsss2611/asteroidsapi.git">https://github.com/Nitsss2611/asteroidsapi.git</a><br>
Execute below command on same location<br>
docker run --rm -it --name api-automation -v ${PWD}/asteroidsapi:/usr/src/maven -w /usr/src/maven maven:3.3-jdk-8-alpine mvn clean test</p>
<p class="has-line-data" data-line-start="65" data-line-end="68">2]Using powershell scripting<br>
Run below file using powershell<br>
&amp; .\ asteroidsapi.ps1</p>
<p class="has-line-data" data-line-start="69" data-line-end="70">Or right clicke on file and choose Run With Powershell</p>
<p class="has-line-data" data-line-start="73" data-line-end="74">Break down into end to end tests</p>
<p class="has-line-data" data-line-start="75" data-line-end="78">TestAllCloseApproach ==&gt; Having tests for asteroids data within date range and distance in AU<br>
TestEarthCloseApproach ==&gt; Tests for asteroids withing date range Lunar distance and sorting distance in ascending and descending order<br>
TestHelloSvc ==&gt; This are tests for dockerised hello-service . This test must need kubernetes set up given in pre-requisites else you can expect to failed as result</p>
<p class="has-line-data" data-line-start="80" data-line-end="81">Happy Testing!</p>
