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
<div class="header">
	<div class="container">
		<h1>Im letrinhdesign</h1>
		<h2>im a good helper</h2>
		
	    <div class="header_arrow">
	       <a href="#arrow" class="scroll"><span> </span></a>
	    </div>
	</div>
</div>	
<!-- 
<a href="/goodhelper-main.action">返回上一级</a>
<a href="/goodhelper-login.action">返回主页</a><br/><br/> -->


<br/>
<div class="contact">
	<div class="container">
		<div class="content_middle_bottom">
          <h3 class="tz-title-3">Get In Touch</h3>
		  <h4>Try to write down the content you want to tell the informant.And choose the community!</h4>
		  
		</div>
<form id="function1" method="post" action="product1.action">
<div class="col-sm-10 grid_2">
		  <h3><a href="goodhelper-main3.action">BACK TO MAIN</a></h3>

<input type="text" class="text" value="title" name="title"><br/>
<%
String usrID=(String)session.getAttribute("username");
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
<textarea value="Message" name="content">Message</textarea>
<input type="submit" value="DONE">
      </div>
</form>
<div class="clearfix"> </div>
	</div>
</div>

</body>
</html>