<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
请填入注册时所需要的信息：
<form method="post" action="goodhelper-main2.action">
学号：<input type="text" name="usrID"/><br>
密码：（不超过15个字母或数字）<input type="text" name="password"/><!--能否直接在这里添加判断功能，不符合要求的提醒输入有问题-->
<br>
手机号码：<input type="text" name="phone"/><br>
<input type="submit" value="login"/>
<input type="reset" value="reset"/>
</form>
</body>
</html>