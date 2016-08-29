<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.lang.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Making The WorkingTable</title>
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
<div class="contact">
	<div class="container">
		<div class="content_middle_bottom">
          <h3 class="tz-title-3">Get In Touch</h3>
		  <h4>If it can meet your mind.You can share the link to your teamates!</h4>
		</div>
		<div class="col-sm-10 grid_2">
		<h3><a href="goodhelper-main3.action">BACK TO MAIN</a></h3>
<form id="function2" method="post" action="product2.action">
<input type="submit" value="完成编辑"/ >

<br>

需要日期数：<select name="numberOfDates">
<option value="0"> </option>
<option value="3">3</option>
</select> 
<br/>
需要的时段数：<select name="numberOfTimes">
<option value="0"> </option>
<option value="3">3</option>
</select> 
<br/>
填表的人数：<select name="numberOfCustomer">
<option value="0"> </option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
</select> 
<br/>
每块填表人数：<select name="numberOfEachBlock">
<option value="0"> </option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
</select>
<br/> 
工作表的名称：<input type="text" name="nameOfTable"/>
<br/>
各日期名称：<% StringBuilder date=new StringBuilder();
date.append("date");
for(int i=0;i<7;i++){
	
	String p=date.append(String.valueOf(i)).toString();
	out.println("<input type='text' name='"+p+"'/>");
}
%>
<br/><br/>
各时间段的名称：<% StringBuilder time=new StringBuilder();
time.append("time");
 for(int j=0;j<7;j++){
	 String t=time.append(String.valueOf(j)).toString();
	 out.println("<input type='text' name='"+t+"'/>");
 }%>
<div class="clearfix"> </div>
	</div>
</div>
</form>
</body>
</html>