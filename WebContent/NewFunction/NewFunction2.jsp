<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Making your WorkingTable</title>
 <script src="../jquery/jquery-3.1.0.min.js" type="text/javascript">
</script> 
<!--<script src="../jquery/prototype.js" type="text/javascript">
</script>-->
<script>
$(document).ready(function(){
	$(".hide").click(function(){
		$(this).hide();
	});
	
});
function getRowAndColumn(){
	
	var a=$(".row").val();//class 使用.
	alert(a);
	var b=$(".column").val();
	alert(b);
	var c=$("#test").val();//id 使用 #
	alert(c);
};
function goClick(){
	//alert("enen");
	/*var url='/CollectionForm/add.action';
	var params=Form.serialize('paramform');
	var myAjax=new Ajax.Request(url,{
		method:'post',
		parameters:params,
		onComplete:processResponse,
		asynchronous:true
	});*/
	var a=$(".row").val();
	var b=$(".column").val();
	var c=$("#test").val();
	$("#show").append("<h3>Here is your table:<h3>");
	$("#show").append("<div id='tableshow'><table>");
	$("#show").append("<caption>"+c+"</caption>");
	for(var i=0;i<=a;i++){
		$("#show").append("<tr>");
		if(i==0){
			$("#show").append("<th></th>");
			for(var j=0;j<b;j++){
			$("#show").append("<th>"+"<input type='text' id='date"+j+"'/></th>");
			}
		}
		else{
		$("#show").append("<th><input type='text' id='time"+i+"'/></th>");
		for(var j=0;j<b;j++){
			$("#show").append("<th>"+"<input type='checkbox' name="+(i+j)+"/></th>");
		}
		}
		$("#show").append("</tr>");
	}
	$("#show").append("</div></table>");
	$("#show").append("<input type='button' id='proTable' value='submit' onclick='proTable()'/>");
}
function processResponse(request){
	var res=request.responseText.evalJSON();
	for(var propName in res){
		$("#show").innerHTML+=propName+"-->"+res[propName]+"<br/>";
	}
}
function proTable(){
	var a=$(".row").val();
	var b=$(".column").val();
	var c=$("#test").val();
	var d=$(".limitnum").val();
	var dates="",times="";
	for(var i=0;i<b;i++){
	   dates+=(($("#date"+i).val())+"&");
	}
	for(var j=1;j<=a;j++){
	   times+=(($("#time"+j).val())+"&");
	}
	//以下进行get和post方法的使用
	$.post("../CollectionForm/add.action",{row:a,column:b,workingTableName:c,limitNumOfWorkingTable:d,dates:dates,times:times},
			function(data){
		      var obj=jQuery.parseJSON(data);
		      $("#showURI").append("<p>The URI for you to share is:"+"http://123.207.100.153:8080/goodhelper/NewFunction/NewProduct2.jsp?workingTableId="+obj.workingTableId+"</p>")
		
		},"text");
}
</script>
<style>
table
{
    border-collapse: collapse;
    border-spacing: 1;
    margin-right: auto;
    margin-left: auto;
    width: 800px;
 }
 th, td
 {
    border: 1px solid #ccc;
    font-size: 12px;
    font-weight: normal;
    text-align: center;
    vertical-align: middle;
    height: 20px;
 }
 th
 {
    background-color: Gray;
 }   
</style>
<!-- 以下为使用模版部分 -->
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
<!-- 以上为使用模版部分 -->
</head>
<body>
<!--以下为使用模版部分  -->
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
<!--以上为使用模版部分  -->
<h1>Try to Make design the workingtable by yourself!</h1>
<p class="hide">If you click on me an I will go away!</p>
<p class="hide">Me too! Dont't forget to accept my help!</p>
<form id="paramform">
<p>
Please input the name of table:<input type="text" id="test"/>
</p>
<p>
The number of dates you need:

<select class="row">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>
</select>
<br/>
The number of times you need:
<select class="column">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>
</select>
</p>
The limit number of worker for each block you need:
<select class="limitnum">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>
</select>
<input id="rowAndColumnBn" type="button" value="produce" onclick="goClick()"/>
</form>

<div id="show">
</div>
<div id="showURI">
</div>
<!-- 以下为使用模版部分 -->
<div class="clearfix"> </div>
	</div>
</div>
<!-- 以上为使用模版部分 -->
</body>
</html>