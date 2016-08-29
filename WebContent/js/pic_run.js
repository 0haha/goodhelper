// JavaScript Document
//显示滚动箭头
$(document).ready(function(e) {
	//鼠标移过图片时显示滑动箭头
	var i=1;
	var slidetotal=2;
    $('#container').mouseover(function(){
		$('#pic_direct').show();
		});
	//鼠标离开图片时隐藏滑动箭头
	$('#container').mouseout(function(){
		$('#pic_direct').hide();
		});
	
	//点击滑动箭头时图像滑动
	$('#pic_direct').click(function(){
		i++;
		if(i==3)i=1;
		for(var j=1;j<=slidetotal;j++){
			if($('#slide'+j).hasClass('active'))
			{$('#slide'+j).removeClass('active');
			}
			}
		$('#slide'+i).addClass('active');
		});
	
});