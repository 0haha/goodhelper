<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的好帮手-好帮网</title>
</head>
<body>
<% String usr=(String)request.getAttribute("usr");
session.setAttribute("username", usr);
out.println(usr);
%>
welcome!<br>
功能：
<a href="fuction1.action">发布通知</a>
<br><br>
<a href="fuction2.action">制作工作表</a>
<br><br>
<a href="fuction3.action">制作通讯录</a>
<br><br>
<a href="fuction4.action">制作小问卷</a>
<br><br>
<a href="fuction5.action">建立工作群</a>
<br><br>
<a href="data.action">获取回收数据</a>
</body>
</html>