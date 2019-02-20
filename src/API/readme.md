#一、登陆接口文档

##目录
[1、user数据库表结构](##user数据库表结构)<br/>
[2、注册](##注册)<br/>
[3、登陆](##登陆)<br/>
##1、User数据库表结构
|参数名|数据类型|长度限制|是否主键|是否必须|是否可以重复|说明|
   |:-----:|:------:|:-----:|:----:|:----:|:----:|:----:|
   |user_id|varchar|100|Y|Y|N|根据用户的账号加密。|
   |username|varchar|20|N|Y|N|用户的账号|
   |password|varchar|40|N|Y|Y|用户的密码|
   |nickname|varchar|12|N|Y|Y|用户的昵称|
   |sex|varchar|10|N|Y|Y|female或male|
   |exp|int|5|N|Y|Y|用户的经验值|
   |level|int|5|N|Y|Y|用户的等级|
   |points|int|5|N|Y|Y|用户的积分点|
   |comments|int|5|N|Y|Y|用户的评论数|
   |fans|int|5|N|Y|Y|用户的的粉丝数|
   |likenum|int|10|N|Y|Y|用户获得的赞数|
   |productions|int|5|N|Y|Y|用户发表的作品数|
   |sginature|varchar|100|N|Y|Y|用户的签名|
   |avanta_path|varchar|100|N|Y|Y|用户的头像存储路径|
   |join_date|datetime|N/A|N|Y|Y|用户的注册时间|
   |last_login_date|datetime|N/A|N|Y|Y|用户最近一次登陆的时间|
   
##2、注册

###请求URL：
    localhost:8080/regist
    
###请求方式:
    POST,GET
    
###参数类型:
   |参数名|是否必须|数据类型|说明|
   |:-----:|:------:|:-----:|:----:|
   |username|Y|String|账号名|
   |password|Y|String|密码|
###返回示例:
####注册成功:
```
   {
       "code": "0",
       "comments": 0,
       "level": 1,
       "signature": "Ta很神秘~",
       "sex": "male",
       "avanta_path": "/",
       "likenum": 0,
       "points": 0,
       "fans": 0,
       "user_id": "02176521c93cd93023d9193e8bad7f72",
       "nickname": "无名侠客",
       "productions": 0,
       "exp": 0,
       "username": "wanp"
   }
``` 
####用户已被注册:
```
{
    "msg": "该用户名已经存在。",
    "code": "1"
}
```
##3、登陆

###请求URL：
    localhost:8080/login
###请求方式:
    POST,GET
    
###参数类型:
   |参数名|是否必须|数据类型|说明|
   |:-----:|:------:|:-----:|:----:|
   |username|Y|String|账号名|
   |password|Y|String|密码|
###返回示例:

####登陆成功:
```
{
    "code": "0",
    "comments": 0,
    "level": 1,
    "signature": "Ta很神秘~",
    "sex": "male",
    "avanta_path": "/",
    "likenum": 0,
    "points": 0,
    "fans": 0,
    "user_id": "02176521c93cd93023d9193e8bad7f72",
    "nickname": "无名侠客",
    "productions": 0,
    "exp": 0,
    "username": "wanp"
}

```
####账号不存在或者密码发生了错误:
```
  {
      "msg": "账号或者用户名不正确，请确认。",
      "code": "1"
  }
```