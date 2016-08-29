<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.lang.*" %>
<%@ page import="org.hibernate.*" %>
<%@ page import="javassist.bytecode.Descriptor.Iterator" %>
<%@ page import="java.util.*" %>
<%@ page import="org.hibernate.cfg.Configuration" %>
<%@ page import="ghpackage.*" %>
<%@ page import="org.hibernate.criterion.Restrictions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布通知</title>
</head>
<body>
<a href="/goodhelper-main.action">返回上一级</a>
<a href="/goodhelper-login.action">返回主页</a><br/><br/>
<form id="function1" method="post" action="product1.action">
<input type="submit" value="完成编辑"/ >
<br/>
发布通知的题目：<input type="text" name="title"/><br/>
发布通知的内容：<input type="text" name="content"/><br/>
选择发布通知的群体：
<%
String usrID=(String)session.getAttribute("username");
out.println(usrID);
Configuration conf=new Configuration().configure();
SessionFactory sf=conf.buildSessionFactory();
Session sess=sf.openSession();
Transaction tx=sess.beginTransaction();
List l=sess.createCriteria(community.class).add(Restrictions.eq("usrID",usrID)).list();
int sequenceArray[]={1,2,3,4,5,6,7,8,9,10,11,12};
int t=0;
java.util.Iterator it= l.iterator();
while(it.hasNext()){
   out.println("<br/>");
   community c=(community)it.next();
   out.println("<input type='radio' name='Community_ID' value='"+c.getCommunity_ID()+"'/>");
   out.println(sequenceArray[t]+"."+c.getNameOfCommunity()+":<br/>");
   
}

tx.commit();
sess.close();
sf.close();%>
</form>
</body>
</html>