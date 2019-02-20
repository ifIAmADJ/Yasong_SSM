#一、用户相关接口文档

##目录
[1、完善用户信息](##完善用户信息)<br/>
[2、获取用户信息的公共接口](##获取用户信息的公共接口)<br/>
[3、注销Cookie（退出登陆）](##获取用户信息的公共接口)<br/>
##1、完善用户信息

###请求URL：
    localhost:8080/supplement
    
###请求方式:
    POST,GET
    
###参数类型:
   |参数名|是否必须|数据类型|长度限制|说明|
   |:-----:|:------:|:-----:|:----:|:----:|
   |nickname|N|String|12|账号昵称|
   |sex|N|String|10|用户的性别|
   |signature|N|String|100|用户的个性签名|
###返回示例:
* 操作成功时(无论更改了几项，甚至没有更改)，总会返回用户信息。
```
{
    "comments": 0,
    "code": "0",
    "level": 1,
    "signature": "正方形打野",
    "sex": "male",
    "avanta_path": "/",
    "likenum": 0,
    "points": 0,
    "fans": 0,
    "user_id": "02176521c93cd93023d9193e8bad7f72",
    "nickname": "小怪",
    "productions": 0,
    "exp": 0
}
```
* 当cookie失效时:
```
{
    "msg": "您的cookie过期了。",
    "code": "1"
}
```
##2、获取用户信息的公共接口

###请求URL：
    localhost:8080/getUserView
    
###请求方式:
    POST,GET
    
###参数类型:
    该方法不需要任何参数。只要cookie没有过期
    就可以通过在任意页面凭借user_id获取必要的用户信息。
###返回示例:
* 若cookie没有过期或被销毁，则总会返回用户信息。
```
{
    "comments": 0,
    "code": "0",
    "level": 1,
    "signature": "正方形打野",
    "sex": "male",
    "avanta_path": "/",
    "likenum": 0,
    "points": 0,
    "fans": 0,
    "user_id": "02176521c93cd93023d9193e8bad7f72",
    "nickname": "小怪",
    "productions": 0,
    "exp": 0
}
```
* 当cookie失效时:
```
{
    "msg": "您的cookie过期了。",
    "code": "1"
}
```
##3、注销Cookie（退出登陆）

###请求URL：
    localhost:8080/logout
    
###请求方式:
    POST,GET
    
###参数类型:
    该方法不需要任何参数。Cookie销毁后，
    任何需要Cookie携带user_id参数的接口都将失效。
###返回示例:

```
{
    "msg": "退出成功",
    "code": "0"
}
```