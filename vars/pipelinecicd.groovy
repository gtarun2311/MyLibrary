node('built-in')
{
stage('Mcontinous download')
{
    git 'https://github.com/IntelliqDevops/maven1.git'
}
stage('Mcontinous build')
{
    sh 'mvn package'
}
stage('Mcontinous deployment')
{
    sh 'scp /var/lib/jenkins/workspace/scriptedpipeline2/webapp/target/webapp.war ubuntu@172.31.82.37:/var/lib/tomcat10/webapps/testapp.war'
}
stage('Mcontinous testing')
{
  git 'https://github.com/IntelliqDevops/FunctionalTesting.git'  
  sh 'java -jar /var/lib/jenkins/workspace/scriptedpipeline2/testing.jar'
}
stage('Mcontinous delivery')
{
    sh 'scp /var/lib/jenkins/workspace/scriptedpipeline2/webapp/target/webapp.war ubuntu@172.31.90.238:/var/lib/tomcat10/webapps/prodapp.war'
}
}
