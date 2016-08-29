<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ghpackage.*" %>
<%@ page import="ghInterface.*" %>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<html lang="en" class="no-js">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Thanks For Participating</title>
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<meta name="author" content="" />
		
		<script src="../Tool/js1/modernizr.custom.js"></script>
		<link href="../Tool/css1/bootstrap.min.css" rel="stylesheet">
		<link href="../Tool/css1/jquery.fancybox.css" rel="stylesheet">
		<link href="../Tool/css1/flickity.css" rel="stylesheet" >
		<link href="../Tool/css1/animate.css" rel="stylesheet">
		<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
	
		<link href="../Tool/css1/styles.css" rel="stylesheet">
		<link href="../Tool/css1/queries.css" rel="stylesheet">
		
		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->		
		<!--[if lt IE 9]>
		<script src="js1/html5shiv.js"></script>
		<script src="js1/respond.min.js"></script>
		<![endif]-->
	</head>

<body>

<%--
   String tmpString=request.getQueryString();
   String[] tmpArrays=tmpString.split(";");
   String[] tmpArray1=tmpArrays[0].split("=");
   String[] tmpArray2=tmpArrays[1].split("=");
   String  informationId=tmpArray1[1];
   String communityId=tmpArray2[1];
   //out.println(informationId+" "+communityId);
   String actionString="finish1&".concat(informationId+".action");%>
 <%
   ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
   InformationService informationServiceImpl=ctx.getBean("InformationService",InformationService.class);
   String title=informationServiceImpl.provideTitle(Integer.parseInt(informationId));
   String content=informationServiceImpl.provideContent(Integer.parseInt(informationId));
   List<String>menbers=informationServiceImpl.provideMenbers(Integer.parseInt(communityId));
   out.println("<form action='"+actionString+"'>");
   out.println("通知题目："+title+"<br/>");
   out.println("通知内容："+content+"<br/>");
   out.println("请看过通知的小朋友打上勾:"+"<br/>");
   int i=1;
   for(String tmp:menbers){
	   
	   out.println("<input type='radio' name='menber' value='"+tmp+"'>");
	   out.println(tmp);
	   if(i%5==0)
		   out.println("<br/>");
	   i++;
   }
   out.println("<br/><br/><input type='submit' value='submit'/>");
  
   out.println("</form>");
--%>


<header id="main">
			<section class="hero"> 
				<div class="container">
					<div class="row nav-wrapper">
						<div class="col-md-6 col-sm-6 col-xs-6 text-left">
							<a href="#"><img src="../Tool/img/logo-white.png" alt="midway Logo"></a>
						</div>
						<div class="col-md-6 col-sm-6 col-xs-6 text-right navicon">
							 <a id="trigger-overlay" class="nav_slide_button nav-toggle" href="#"><span></span></a>
						</div>
					</div>
					<div class="row hero-content">
						<div class="col-md-12 text-center">
							<h1 class="animated fadeInDown">Thanks you for your cooperation!<br/><% out.println("<input type='text' value='submit'/>");%></h1>						</div>
					</div>
				</div>
			</section>
		</header> 
		</body>
</html>
