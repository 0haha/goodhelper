/**
 * 
 */
                            i = 1; 
                            var list=[0,0,0,0,0,0,0,0,0,0];//意味着问题数是有上限的10道
						    function addQ(){
						      alert("hehe");
						      document.getElementById("q1").innerHTML+='<div id="div_'+i+'"><input name="question'+i+'" type="text" /><input type="button" value="delete Question"  onclick="delQ('+i+')"/><div id="answer_'+i+'"></div></div>';
						      i = i + 1;
						    }
						    function delQ(o){
						     document.getElementById("q1").removeChild(document.getElementById("div_"+o));
						    }
						    function addAnswer(t){
						    	document.getElementById("answer_"+t).innerHTML+='<div id="innerDiv_'+list[t]+'"><input name="answer'+t+list[t]+'" type="text"/><input type="button" value="delete answer" onclick="delAnswer('t+','+list[t]+')"/></div>';
						    }
						    function delAnswer(s1,s2){
						    	document.getElementById("answer_"+s1).removeChild(document.getElementById("innerDiv_"+s2));
						    }