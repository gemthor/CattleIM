[TOC]

------

### 公共访问接口

```json
{
 "status": 0,
  "result": [],
  "message": "",
  "Date": "2018/3/6"
}
```

#### login 登入接口约定

> 登入的信息：

```json
{
    "phone": 18870742138,
    "password": "lkkzbl"
}
```

### session设定

```
request.session["userId"] = str(user.uid)
# 获取
if request.session.get("userId", "") == "":
   return error_response.session_error()
holder_id = request.session["userId"]
```



#### 公共的状态码

```
SUCCESS_STATUS = 1								# 操作正确
FAILURE_STATUS = 0								# 操作失败
NULL_PASSWORD = 6000							# 密码为空
NULL_USERNAME = 6001							# 用户密码为空
NULL_AVATAR = 6002								# 头像path为空
NULL_PHONE = 6003								# 电话号码为空
NULL_USER = 6004								# 用户为空
SAME_USERNAME = 7000							# 用户名字已经存在
SAME_PHONE = 7001								# 用户电话号码已经存在
FORMAT_ERROR_PHONE = 8000						# 电话号码格式错误
FORMAT_ERROR_PHONE_LENGTH = 8001				# 电话号码长度有问题
FORMAT_ERROR_PASSWORD = 8002					# 用户密码错误
FORMAT_ERROR_PASSWORD_LENGTH = 8003				# 用户的密码长度不符合要求
FORMAT_ERROR_USER_LENGTH = 8004					# 用户的名字长度不符合要去
FORMAT_ERROR_FILE = 8005						# 传入的file文件有问题
ILLEGAL_USERNAME = 9000							# 不合法的用户名
ERROR_PASSWORD = 10000							# 密码错误
ERROR_REPEAT_LOGIN = 11000						# 重复登入
ERROR_NET = 11001								# 网络错误


```



#### register 传入信息接口约定

```json
{
  "phone":"18870742138",
  "username": "kevin",
  "password": "199shadjfk",
  "avatar": "media/avatars/android/xx.jpg"
}
```

### 用户信息接口

```json
{
  "user":{
      "id": "",
      "username": "name",
      "phone": "188707421",
      "avatar": "media/avatars/android/xx.jpg",
      "desc": "",
      "sex": 0,
      "alias": "备注",
      "friends": 0,
      "isFriend": false,
      "modifyAt": "2018/12/15"
  },
  "account": "",
  "isBind": true
}

```



### 存储文件接口

from

```json
{
  "name": "当前文件的名字",
  "content": "经过md5的加密"
}
```

to

```json
{
  "path": "media/avatars/android/xx.jpg"
}
```



### 推送

------

#### message

可以为空(心跳包)，也可以是一个字符串(反馈),  正式通信如下：

```
{
	"chatId": "",
	"fromId": "",
	"toId": "",
	"type": "",
	"info": [{
			"category": "",
			"content": ""
		},
		{}
	],
	"createTime": ""
}
```

type

```json
{ 
	"0":"系统消息",
	"1":"普通消息",
	"2":"请求消息",
	"3":"主题消息",
	"4":"公告消息",
	"5":"任务消息",
	"6":"关联消息"
}
```

category

```json
{
	"0":"文本",
	"1":"图片",
	"2":"语音",
	"3":"文件"
}
```



#### 心跳包/回送包

```json
{
    "status": 1,
    "pushId": "",
    "message": ""
}
```



#### message_queue(消息队列)

```json
{
	"pushId": [{
			"chatId": "",
			"fromId": "",
			"toId": "",
			"type": "",
			"info": [{
					"category": "",
					"content": ""
				},
				{}
			],
			"createTime": ""
		},
		{},
		{}
	],
	"second": []
}
```



### search搜索

user的搜索

```python 
# 使用get请求，传入username 或则 phone
```

返回接口为空的情况

```json
{"status": 0, "result": [], "message": "ok", "date": "2018-11-14T21:40:56"}
```



#### friends

```
# 好友关系建立用get，请求,传入用户的id，将好友账户信息反馈
/(?P<field>\w+)/(?P<page>\d+)/
```



### Group

```python
# get方式传入name
```

