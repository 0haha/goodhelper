<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.lang.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<script>
 var q=0,a=0;
 function addQuestion(){
	 q++;a=0;
	 $(".col-sm-10 grid_2").append("Type:<select name='type'"+q+">"+
	         "<option value='0'></option>"+
	         "<oprion value='r'>Single Choice question</oprion>"+
	         "<option value='c'>Multiple Choice question</option>"+
	         "<option value='t'>essay question</option>"+
	       "</select>&nbsp;");
	 $(".col-sm-10 grid_2").append("Question:<input type='text' name='question'"+q+"/>&nbsp;<input type='button' id='bn_add_Q' onclick='addQuestion();'/>&nbsp;")
	 $(".col-sm-10 grid_2").append("Answer:<input type='text' name='answer'"+q+a+"/>&nbsp;<input type='button' id='bn_add_A' onclock='addAnswer(q);'/>")
 }
 function addAnswer(q){
	 a++;
	 $(".col-sm-10 grid_2").append("Answer:<input type='text' name='answer'"+q+a+"/>&nbsp;<input type='button' id='bn_add_A' onclock='addAnswer(q);'/>")
 }
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
<form id="function4" method="post" action="product4.action">

<div class="col-sm-10 grid_2">
		  <h3><a href="goodhelper-main3.action">BACK TO MAIN</a></h3>


<% String usr=(String)session.getAttribute("username");
out.println("问卷名:"+"<input type='text' name='nameOfQuestionare'/>"+"<br/>");
request.setAttribute("usrID",usr );%>
<%--
for(int i=0;i<7;i++){
	StringBuilder question=new StringBuilder();
	question.append("question");
	StringBuilder type=new StringBuilder();
	type.append("type");
	String tempquestion=question.append(String.valueOf(i)).toString();
	String temptype=type.append(String.valueOf(i)).toString();
	out.println("<select name='"+temptype+"'>"+  //type+i
	"<option value='0'> </option>"+
	"<option value='r'>单选题 </option>"+
	"<option value='c'>多选题</option>"+
	"<option value='t'>问答题</option>"+
	"</select>" +
	"<br/>");
	out.println("Q:"+"<input type='text' name='"+tempquestion+"'/>");//question+i
	out.println("<br/>A:");
	for(int j=0;j<7;j++){
		StringBuilder answer=new StringBuilder();
		answer.append("answer");
		String tempanswer=answer.append(String.valueOf(i)).append(String.valueOf(j)).toString();
		out.println("<input type='text' name='"+tempanswer+"'/>");//answer+i+j
		
	}
	out.println("<br/><br/>");
}
--%>
<!-- Here are the section to be test -->
<div id="q1">
 Type:<select name="type0">
         <option value="0"></option>
         <option value="r">Single Choice question</oprion>
         <option value="c">Multiple Choice question</option>
         <option value="t">essay question</option>
       </select><br/>Question:<input type="text" name="question0"/>&nbsp;<input type="button" id="p1" value="add Question" onclick="addQ();"/><br/><input type="button" id="bn_add_A" onclick="addAnswer(0);" value="add Answer"/>                              


<div id="answer_0"></div>
</div>
<!-- just go back -->
 
<script language="javascript">
i = 1; 
var list=[0,0,0,0,0,0,0,0,0,0];

function addQ(){
  document.getElementById("q1").innerHTML+='<div id="div_'+i+'">Type:<select name="type'+i+'"><option value="0"></option><option value="r">Single Choice question</oprion><option value="c">Multiple Choice question</option><option value="t">essay question</option></select><br/>Question:<input name="question'+i+'" type="text" /><br/><input type="button" id="bn_add_A" onclick="addAnswer('+i+');" value="add Answer"/>&nbsp;<input type="button" value="delete Question"  onclick="delQ('+i+')"/><div id="answer_'+i+'"></div></div>';
  i = i + 1;
}
function delQ(o){

 document.getElementById("q1").removeChild(document.getElementById("div_"+o));
 
}
function addAnswer(t){
	
	document.getElementById("answer_"+t).innerHTML+='<div id="innerDiv_'+list[t]+'"><input name="answer'+t+list[t]+'" type="text"/><input type="button" value="delete answer" onclick="delAnswer('+t+','+list[t]+')"/></div>';
	list[t]++;
}
function delAnswer(s1,s2){
	
	document.getElementById("answer_"+s1).removeChild(document.getElementById("innerDiv_"+s2));
	
	}
</script>	 
<!-- The End of test -->
<input type="submit" value="完成编辑"/>
</div>

<div class="clearfix"> </div>
</div>
</div>
</form>
</body>
</html>