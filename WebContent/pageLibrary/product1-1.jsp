<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ghpackage.*" %>
<%@ page import="ghInterface.*" %>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Annoucement</title>
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
		  <h4>Please ticket your name if you have received the information!</h4>
		</div>
		<div class="col-sm-10 grid_2">
<% 
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
   out.println("Title："+title+"<br/>");
   out.println("Content："+content+"<br/>");
   out.println("Please ticket your name if you have read the information:"+"<br/>");
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
%>
<div class="clearfix"> </div>
	</div>
</div>

</body>
</html>