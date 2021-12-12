# Spring+MVC+MyBatis的登录页面

## 一、搭建java框架的web项目

地址：[https://blog.csdn.net/qq_56180999/article/details/121856276](https://blog.csdn.net/qq_56180999/article/details/121856276)

## 二、配置tomcat

地址： [https://blog.csdn.net/qq_56180999/article/details/121855908](https://blog.csdn.net/qq_56180999/article/details/121855908)

## 三、创建数据库

![image](https://user-images.githubusercontent.com/84628055/145697124-d2314b34-e78b-4dc1-b097-51462fb2eafc.png)


## 四、修改相关内容

### 1、tomcat的启动项目地址（url和我保持一样，不然项目使用端口的地方都要修改）

![image](https://user-images.githubusercontent.com/84628055/145697249-9d74e8eb-08cd-43bd-8fd7-e13021848556.png)

### 2、前端jsp部分

网页标题：
![image](https://user-images.githubusercontent.com/84628055/145696887-9af8ec39-4471-4ea2-947e-c1f66b722aa0.png)

### 3、MySQL连接

![PEP{PLDW7_WI7K{03) BDLL](https://user-images.githubusercontent.com/84628055/145697132-504c6f4f-70ee-4282-914d-64cc271af178.png)

### 4、session(分)和cookie(秒)的过期时间

![image](https://user-images.githubusercontent.com/84628055/145697221-86dd55c4-a5d9-4b8a-92ac-586b607f4af7.png)

cookie在LoginController多个地方都有使用，这里只截了一张图
![image](https://user-images.githubusercontent.com/84628055/145697281-86af2701-97f4-4469-845c-b84ca32353a9.png)

## 五、启动

1、下载仓库到本地

2、使用idea打开项目

3、修改一些上面提到的（web、tomcat、mysql）配置

4、点击tomcat运行

5、打开浏览器，在地址栏输入：`http://localhost:8080/java22e/toLogin `或 `http://localhost:8080/java22e/login`

## 六、效果

1、登录页面
![image](https://user-images.githubusercontent.com/84628055/145697412-d71c5adb-10fc-4af6-b6ae-ee00c8092eb2.png)

2、输入错误信息或不输入信息，点击登录将提示
![image](https://user-images.githubusercontent.com/84628055/145697456-0e9bd16a-c52a-4365-8d89-45355c0ca607.png)
