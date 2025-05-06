var hostName = "http://127.0.0.1:8082/api";//接口公共的ip或者域名
//path里定义了所有的接口
var path = {
	'userList': hostName + '/users/list',//获取所有用户数据
	'userPage': hostName + '/users/page',//获取分页用户数据
	'userCount': hostName + '/users/count',//获取用户记录总数
	'userRead': hostName + '/users/',//获取用户所有数据
	'userInsert': hostName + '/user',//添加用户
	'userUpdate': hostName + '/user',//修改用户
	'userDelete': hostName + '/user',//删除用户
	'userLogin':hostName+'/login',//用户登录
	'userNews':hostName+'/news/userId',//获取用户新闻
};