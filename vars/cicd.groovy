def gitdownload(repo)
{
git "https://github.com/IntelliqDevops/${repo}.git"
}
def builtartifact()
{
  git "mvn package"
}
def deploytomcat(jobname,ip,context)
{
sh "scp /var/lib/jenkins/workspace/${jobname}/webapp/target/webapp.war ubuntu@${ip}:/var/lib/tomcat10/webapps/${context}.war"
}
def runselenium(jobname)
{
  sh "java -jar /var/lib/jenkins/workspace/${jobname}/testing.jar"
}
