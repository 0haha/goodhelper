<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The WorkingTable Here!</title>
<script src="../jquery/jquery-3.1.0.min.js" type="text/javascript">
</script> 
<style>
table
{
align:center;
text-align:center;
border: 1px solid black;
}
tr
{
text-align:center;
border: 1px solid black;
}

td
{
text-align:center;
border: 1px solid black;
width:100px;
height:20px;
}

</style>
<script type="text/javascript">
$(document).ready(function(){
	var uId=<%=session.getAttribute("username")%>;
	$.get("../ResultForm/list.action",{usrId:uId},function(data){
	
		var test=JSON.parse(data);
	
	for(var i in test.n){
			var column=test.n[i].column;
			var row=test.n[i].row;
			arrdate=test.n[i].datesToken.split("&");
			arrtime=test.n[i].timesToken.split("&");
			arrNameToken=test.n[i].namesToken.split("&");
			
			$("#show").append("<table>");
			for(var i=0;i<=row;i++){
				$("#show").append("<tr>");
				if(i==0){
				$("#show").append("<td></td>");
				for(var j=0;j<column;j++){
					$("#show").append("<td>"+arrdate[j]+"</td>");
				}
				}else{
					$("#show").append("<td>"+arrtime[i-1]+"</td>");
					for(var j=0;j<column;j++){
						var str="";
						
						
						$("#show").append("<td>"+arrNameToken[(i-1)*column+j]+"</td>");//注意对应的id如果使用的是变量，要附加上引号
					    
					}
				}
				$("#show").append("</tr>");
			}
			$("#show").append("</table></br>");
	   
	}
	
	},"text"); 
});
</script>
<!-- 一下为使用模版部分 -->
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
<!-- 以上为使用模版部分 -->
</head>
<body>
<!--以下为使用模版部分  -->
<div class="contact">
	<div class="container">
		<div class="content_middle_bottom">
          <h3 class="tz-title-3">Get In Touch</h3>
		  <h4>Here are some date you need!</h4>
		</div>
		<div class="col-sm-10 grid_2">
		<h3><a href="goodhelper-main3.action">BACK TO MAIN</a></h3>
<!-- 以上为使用模版部分 -->
<div id="show">

</div>
<!-- 以下为模版部分 -->
<div class="clearfix"> </div>
	</div>
</div>
<!-- 以上为模版部分 -->
</body>
</html>