<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CollectionForm</title>
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
<script src="../jquery/jquery-3.1.0.min.js" type="text/javascript">
</script>
<script>
var obj;
var w;
$(document).ready(function(){
	
	w=getUrlParam('workingTableId');
	$.get("../CollectionForm/get.action",{workingTableId:w},function(data){
	    obj=jQuery.parseJSON(data);
		var dates=obj.dates; 
		arrd=dates.split("&");
		var times=obj.times; 
		arrt=times.split("&");
		
		$("#show").append("<table><caption align='top'>"+obj.workingTableName+"</caption>");
		for(var i=0;i<=obj.row;i++){
			$("#show").append("<tr>");
			if(i==0){
			$("#show").append("<td></td>");
			for(var j=0;j<obj.column;j++){
				$("#show").append("<td>"+arrd[j]+"</td>");
			}
			}else{
				$("#show").append("<td>"+arrt[i-1]+"</td>");
				for(var j=0;j<obj.column;j++){
					var str=String(i)+String(j);
					$("#show").append("<td>"+"<input type='checkbox' id='"+str+"'/></td>");//注意对应的id如果使用的是变量，要附加上引号
				    
				}
			}
			$("#show").append("</tr>");
		}
		$("#show").append("</table>");
		$("#show").append("<input type='button' id='tickBn' value='ok' onclick='complete()'/>");
	},"text");
});
function getUrlParam(name){
	var reg=new RegExp("(^|&)"+name+"=([^&]*)(&|$)");
	var r=window.location.search.substr(1).match(reg);
	if(r!=null)return unescape(r[2]);return null;
}
function complete(){
	
	var token="";
	var name=$("#name").val();
	for(var i=1;i<=obj.row;i++){
		for(var j=0;j<obj.column;j++){
			var str="#"+String(i)+String(j);
			var ischeck=$(str).is(':checked');
			if(ischeck){
				token+='a';
			}else{
				token+='b';
				}
		}
		token+="&";
	}
	
	$.post("../CollectionForm/setCustomer.action",{workingTableId:w,token:token,name:name});
	alert("submit successful!");
	
}

</script>
<!-- 以下为使用模版 -->
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
<!-- 以上为使用用模版 -->
</head>
<body>
<!-- 以下为使用模版 -->
<div class="contact">
	<div class="container">
		<div class="content_middle_bottom">
          <h3 class="tz-title-3">Get In Touch</h3>
		  <h4>If it can meet your mind.You can share the link to your teamates!</h4>
		</div>
		<div class="col-sm-10 grid_2">
		<!-- 以上为使用用模版 -->
Please enter your name:<input type='text' id='name'/>
<div id="show">
</div>
<!-- 以下为使用模版 -->
<div class="clearfix"> </div>
	</div>
</div>
<!-- 以上为使用用模版 -->
</body>
</html>