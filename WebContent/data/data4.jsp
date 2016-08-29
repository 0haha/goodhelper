<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Questionare Data</title>
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
		  <h4>Here are some data you need!</h4>
		</div>
		<div class="col-sm-10 grid_2">
		<h3><a href="goodhelper-main3.action">BACK TO MAIN</a></h3>

 <% String driverName="com.mysql.jdbc.Driver";
String dbid="jdbc:mysql://localhost:3306/goodhelper";
Class.forName(driverName);
Connection conn=DriverManager.getConnection(dbid,"root","110");
Statement stmt=conn.createStatement(); 
String username=(String)session.getAttribute("username");
//String questionareID=(String)session.getAttribute("questionareID");

ResultSet rs=stmt.executeQuery("select distinct questionare_ID,name,answer "+"from usr_questionare natural join question_answer "+"where usr_ID="+username+";");
while(rs.next()){
	out.println("<br/><br/>");


out.println(rs.getString("questionare_ID")+"  "+rs.getString("name")+":<br>");

String answer=rs.getString("answer");
String [] answers=answer.split("&");
for(int j=0;j<answers.length;j++){
	if(answers[j].length()>1){
		if(answers[j].charAt(1)==';'){
			String[] tokens=answers[j].split(";");
			out.println("the answer of NO."+(j+1)+" is:");
			for(int t=0;t<tokens.length;t++){
				out.println(tokens[t]+" ");
			}
			out.println("<br/>");
		}
		else{
			out.println("the answer of NO."+(j+1)+" is:");
			out.println(answers[j]);
			out.println("<br/>");
		}
	}
	else{
		out.println("the answer of NO."+(j+1)+" is:");
		out.println(answers[j]);
		out.println("<br/>");
	}
}

}%>
 <div class="clearfix"> </div>
	</div>
</div>
</body>
</html>