SUCCESS_STATUS = 1								# 操作正确
FAILURE_STATUS = 0								# 操作失败
NULL_PASSWORD = 6000							# 密码为空
NULL_USERNAME = 6001							# 用户密码为空
NULL_AVATAR = 6002								# 头像path为空
NULL_PHONE = 6003								# 电话号码为空
NULL_USER = 6004								# 用户为空
NULL_DATA = 6005                                # 查询的数据为空
SAME_USERNAME = 7000							# 用户名字已经存在
SAME_PHONE = 7001								# 用户电话号码已经存在
FORMAT_ERROR_PHONE = 8000						# 电话号码格式错误
FORMAT_ERROR_PHONE_LENGTH = 8001				# 电话号码长度有问题
FORMAT_ERROR_PASSWORD = 8002					# 用户密码错误
FORMAT_ERROR_PASSWORD_LENGTH = 8003				# 用户的密码长度不符合要求
FORMAT_ERROR_USER_LENGTH = 8004					# 用户的名字长度不符合要去
FORMAT_ERROR_FILE = 8005						# 传入的file文件有问题
FORMAT_ERROR_AVATAR = 8006						# 头像数据破损
ILLEGAL_USERNAME = 9000							# 不合法的用户名
ERROR_PASSWORD = 10000							# 密码错误
ERROR_REPEAT_LOGIN = 11000						# 重复登入
ERROR_NET = 11001								# 网络错误
ERROR_SESSION = 11001                           # session 有误，估计是没有登入
EXIST_FRIENDS = 12000                           # 好友关系已经存在