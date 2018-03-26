# startup.sh 启动项目
#!/bin/sh
export JAVA_HOME=/home/shopin/jdk1.8.0_121
echo ${JAVA_HOME}
echo "授予当前用户权限"
chmod 777 /home/shopin/mall-search/search-1.0-SNAPSHOT.jar
echo "执行....."
cd /home/shopin/mall-search/
nohup ${JAVA_HOME}/bin/java -jar search-1.0-SNAPSHOT.jar > /dev/null &
echo "启动成功..."
