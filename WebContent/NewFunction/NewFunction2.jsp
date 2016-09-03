<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Making your WorkingTable</title>
<!-- <script src="../jquery/jquery-3.1.0.min.js" type="text/javascript">
</script> -->
<script src="../jquery/prototype.js" type="text/javascript">
</script>
<script>
$(document).ready(function(){
	$(".hide").click(function(){
		$(this).hide();
	});
	alert("hehe");
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
	alert("enen");
	var url='/CollectionForm/add.action';
	var params=Form.serialize('paramform');
	var myAjax=new Ajax.Request(url,{
		method:'post',
		parameters:params,
		onComplete:processResponse,
		asynchronous:true
	});
}
function processResponse(request){
	var res=request.responseText.evalJSON();
	for(var propName in res){
		$("#show").innerHTML+=propName+"-->"+res[propName]+"<br/>";
	}
}
</script>
</head>
<body>

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
<input id="rowAndColumnBn" type="button" value="produce" onclick="goClick()"/>
</form>
<form action="wk">
<input type="text" name="limitNumOfWorkingTable"/>
<input type="submit" value="submit"/>
</form>
<div id="show">
</div>
</body>
</html>