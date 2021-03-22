$asteroidsapi = "${PWD}\asteroidsapi"
If (Test-Path $asteroidsapi)
{
rm -r -fo  $asteroidsapi
echo "asteroidsapi deleted..."
}
git clone https://github.com/Nitsss2611/asteroidsapi.git
echo "Repository cloned..."
docker run --rm -it --name api-automation -v ${PWD}/asteroidsapi:/usr/src/maven -w /usr/src/maven maven:3.3-jdk-8-alpine mvn clean test

#start "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe" $path\asteroidsapi\test-output\Report\ExtentReport.html

start chrome E:\Educational\Dockerfiles\sbdb\asteroidsapi\test-output\Report\ExtentReport.html
