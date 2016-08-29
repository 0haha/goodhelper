<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Questionare</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Letrinh Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="../Tool/css2/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="../Tool/css2/style.css" rel='stylesheet' type='text/css' />	
<script src="../Tool/js2/jquery-1.11.1.min.js"> </script>
<!-- Add fancyBox main JS and CSS files -->
<script src="../Tool/js2/jquery.magnific-popup.js" type="text/javascript"></script>
<link href="../Tool/css2/magnific-popup.css" rel="stylesheet" type="text/css">
		<script>
			$(document).ready(function() {
				$('.popup-with-zoom-anim').magnificPopup({
					type: 'inline',
					fixedContentPos: false,
					fixedBgPos: true,
					overflowY: 'auto',
					closeBtnInside: true,
					preloader: false,
					midClick: true,
					removalDelay: 300,
					mainClass: 'my-mfp-zoom-in'
			});
		});
		</script>

<script type="text/javascript">
					jQuery(document).ready(function($) {
						$(".scroll").click(function(event){		
							event.preventDefault();
							$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
						});
					});
					</script>
<link href='http://fonts.useso.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
<!----- start-Share-instantly-slider---->
					 <!-- Prettify -->
						<link href="../Tool/css2/owl.carousel.css" rel="stylesheet">
					    <script src="../Tool/js2/owl.carousel.js"></script>
					    <script>
						    $(document).ready(function() {
						      $("#owl-demo , #owl-demo1").owlCarousel({
						        items : 1,
						        lazyLoad : true,
						        autoPlay : true,
						      });
						    });
					    </script>
					    <script>
						    $(document).ready(function() {
						      $("#owl-demo3").owlCarousel({
						        items : 4,
						        lazyLoad : true,
						        autoPlay : true,
						        navigation: false,
						        pagination: false,
						      });
						    });
					    </script>
					<!----- //End-Share-instantly-slider---->
<script type="text/javascript" src="../Tool/js2/move-top.js"></script>
<script type="text/javascript" src="../Tool/js2/easing.js"></script>					
</head>
<body>
<div class="contact">
	<div class="container">
		<div class="content_middle_bottom">
          <h3 class="tz-title-3">Get In Touch</h3>
		  <h4>Please to write your questionare!</h4>
		</div>
		<div class="col-sm-10 grid_2">
<% String driverName="com.mysql.jdbc.Driver";
String dbid="jdbc:mysql://localhost:3306/goodhelper";
Class.forName(driverName);
Connection conn=DriverManager.getConnection(dbid,"root","110");
Statement stmt=conn.createStatement(); 
String QID=request.getQueryString();
String[] QIDs=QID.split("=");
//out.println(QIDs[1]);
ResultSet rs=stmt.executeQuery("select * "+"from questionare natural join question "+"where questionare_ID="+QIDs[1]+";");
%>




<form  method="post" action="finish4.action">
Your name:<input type="text" name="name"><br/><br/>
<% 

while(rs.next()){ 
int se[]={1,2,3,4,5,6,7,8,9,10,11,12};
int start=0;
char type=rs.getString("type").charAt(0);
String questionID=rs.getString("question_ID");
String itemArray[]={"A","B","C","D","E","F","G"};
switch(type){
case 'r':
	out.println(se[start]+"Q:"+rs.getString("question")+"<br/>");
	for(int i=0;i<7;i++){
		String s="answer";
		String ss=s.concat(itemArray[i]);
		String sss=rs.getString(ss);
		String itemValue=questionID.concat(itemArray[i]);
		if(sss!=null){
			out.println(itemArray[i]+":"+sss);
			out.println("<input type='radio' name="+questionID+"value="+itemValue+">");
		}
	}
	out.println("<br/>");
	break;
case 'c':
	out.println(se[start]+"Q:"+rs.getString("question")+"<br/>");
	for(int i=0;i<7;i++){
		String s="answer";
		String ss=s.concat(itemArray[i]);
		String sss=rs.getString(ss);
		String itemValue=questionID.concat(itemArray[i]);
		if(sss!=null){
			out.println(itemArray[i]+":"+sss);
			out.println("<input type='checkbox' name="+questionID+"value="+itemValue+">");
		}
	}
	out.println("<br/>");
	break;
case 't':
	out.println(se[start]+"Q:"+rs.getString("question")+"<br/>");
	out.println("<input type='text' name="+questionID+">");
	out.println("<br/>");
	break;
default:

   }
start++;
  }%> 
 <input type="submit" value="submit"><br/>
</form>
</body>
</html>