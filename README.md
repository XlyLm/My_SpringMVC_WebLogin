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

3、信息输入正确，进入main页面
![image](https://user-images.githubusercontent.com/84628055/145697626-e6b10b32-5570-4055-8fb0-9af4bdf7784d.png)

4、在main页面可以修改用户名和注销用户
![image](https://user-images.githubusercontent.com/84628055/145697635-8cc220ff-b3c1-4d0e-a63c-d5bbbb3f4dc4.png)
![image](https://user-images.githubusercontent.com/84628055/145697640-ea8a1722-850d-475d-bb89-f46fb532c330.png)

5、短期登录后，可以在cookie期限内点击免密登录
![image](https://user-images.githubusercontent.com/84628055/145697661-ee0abc6c-47bf-4852-933a-7fc8b82236e8.png)
如果cookie过期将提示你超期，需要你输入信息登录

6、输入用户信息，点击快速注册，将注册用户（手机号格式、验证码输入错误将提示，用户手机号已注册也会提示）
![image](https://user-images.githubusercontent.com/84628055/145697972-c7fffad2-e0f6-4ad6-b5c3-043af9858b31.png)
如果输入正确，并且该手机号未注册，则注册成功，自动跳转到main页面

7、用户已注册，输入信息，输入新密码到密码框，点击忘记密码，则修改密码
![image](https://user-images.githubusercontent.com/84628055/145698033-cb7298d2-b13a-4082-93d7-740e82a1a718.png)
修改后自动跳转到main页面
