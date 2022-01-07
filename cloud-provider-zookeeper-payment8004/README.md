zookeeper 使用

1。 官网下载 https://zookeeper.apache.org/releases.html

2。 安装步骤 https://www.cnblogs.com/qingjiawen/p/14359062.html

3。 启动命令 进入bin目录下 输入命令：

        ./zkServer.sh start启动命令
        ./zkServer.sh status查看状态
        ./zkServer.sh stop 停止命令
        
1。 pom.xml引入依赖

       <!-- 需要注意引入的zookeeper jar包版本跟 安装的zookeeper版本是否匹配-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zookeeper-discovery</artifactId>
        </dependency>
   
2。 修改application.yml 配置文件

       spring:
         application:
           name: cloud-prowider-payment-server
         cloud:
           zookeeper:
             connect-string: localhost:2181
             
3。 启动类添加注解
    
        //向consul 或者zookeeper作为注册中心时注册服务
        @EnableDiscoveryClient
