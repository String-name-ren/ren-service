#!/usr/bin
#编译+部署项目站点

#需要配置如下参数
# 项目路径, 在Execute Shell中配置项目路径, pwd 就可以获得该项目路径
# export $PROJECT_PATH=这个jenkins任务在部署机器上的路径

# 输入你的环境上tomcat的全路径
# export APP_PATH=tomcat在部署机器上的路径

### base 函数
killTomcat()
{
    PID=$(ps -ef | grep ren-service.jar | grep -v grep | awk '{ print $2 }')
    if [ -z "$PID" ]
    then
        echo Application is already stopped
    else
        echo kill $PID
        kill -9 $PID
    fi

}

echo $PROJECT_PATH
echo $APP_PATH

cd $PROJECT_PATH/ren-service
mvn clean install

# 停tomcat
killTomcat

# 删除原有工程
rm -f $APP_PATH/ren-service.jar
echo "删除原jar包成功"

# 复制新的工程到tomcat上
cp $PROJECT_PATH/ren-service/target/ren-service.jar $APP_PATH/

cd $APP_PATH/
ll -a


# 启动Tomcat
echo Application is starting!!!
nohup java -jar ren-1.0.0-SNAPSHOT.jar > catalina.out 2>&1 &