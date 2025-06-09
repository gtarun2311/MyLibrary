def download (repo)
{
  git https://github.com/gtarun2311/${repo}.git
}
def build ()
{
  sh "mvn package"
}
def deployment (job,ip,name)
{
  sh "scp /var/lib/jenkins/workspace/${job}/webapp/target/webapp.war ubuntu@${ip}:/var/lib/tomcat10/webapps/${name}.war"
}
def test (name)
{
  sh "java -jar /var/lib/jenkins/workspace/${name}/testing.jar"
}
