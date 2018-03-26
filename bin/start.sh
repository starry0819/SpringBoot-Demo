# startup.sh 启动项目
#!/bin/sh
export JAVA_HOME=/opt/jdk
echo ${JAVA_HOME}
echo "授予当前用户权限"
chmod 777 /opt/apache-tomcat-8.5.28/webapps/jenkins/workspace/
echo "执行....."
cd /opt/apache-tomcat-8.5.28/webapps/jenkins/workspace/SpringBoot-Demo/target/
nohup ${JAVA_HOME}/bin/java -jar SpringBoot-Demo.jar > /dev/null &
echo "启动成功..."
