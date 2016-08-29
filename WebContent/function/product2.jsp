<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ghpackage.*" %>
<%@ page import="ghInterface.*" %>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>WorkingTable</title>
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
		  <h4>If it can meet your mind.You can share the link to your teamates!</h4>
		</div>
		<div class="col-sm-10 grid_2">
		<h3><a href="goodhelper-main3.action">BACK TO MAIN</a></h3>
		<h3><a href="fuction1.action">BACK TO REMAKE</a></h3>
 <%
 ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
 workingTableDao workingTableDaoImpl=ctx.getBean("workingTableDao",workingTableDaoImpl.class);
 String ID=(String)request.getAttribute("workingTableID");
 workingTable workingTable=workingTableDaoImpl.get(Integer.parseInt(ID));
 int row=workingTable.getTableRow();
 int column=workingTable.getTableColumn();
 List<String>dates=workingTable.getDates();
 List<String>times=workingTable.getTimes();
 String tempstr="finish2".concat("&"+ID).concat(".action");
 out.println("<form id='product2' method='post' action="+tempstr+">");
 out.println("<input type='submit' value='完成编辑'/ >");
 out.println("名字是："+"<input type='text' name='name'/><br/><br/>");
 out.println("<table border=4 width=250 align=center>");
 out.println("<caption>lala</caption>");
 out.println("<tr bgcolor='#cccccc'>");
 out.println("<th><br></th>");
 for(int i=0;i<column;i++){
	 out.println("<td>"+dates.get(i)+"</td>");
 }
 out.println("</tr>");
 for(int j=0;j<row;j++){
	 out.println("<tr><td>"+times.get(j)+"</td>");
	 for(int i=0;i<column;i++){
	 out.println("<td>"+"<label><input type='checkbox' name='"+String.valueOf(j).concat(String.valueOf(i))+"'></label>");
	  }
	 out.println("</tr>");
 }
 out.println("</table>");
 String url = "http://localhost:7648/goodhelper/pageLibrary/product2-1.jsp"+"?workingTableID="+ID; 
 out.println("<br>the link for you:"+url);
 %>
 <div class="clearfix"> </div>
	</div>
</div>
 </form>
</body>
</html>