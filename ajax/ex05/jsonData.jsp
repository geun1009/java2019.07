<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON DATA 예제</title>
<script src ="httpRequest.js"></script>
<script>
	var data;
	function sendOnClick(){
		sendProcess("GET", 'sample.jsp', null, callback);
	}
	function callback(){
		if(httpRequest.readyState==4){
			if(httpRequest.status == 200){
				data = httpRequest.responseText
				//data = JSON.parse(data);
				memberList = eval(data);
				//console.log(memberList);
				
				var msg = '회원수 : '+ memberList.length + "명\n";
				
				memberList.forEach(function(member){ //callback 함수,, 함수도 인자로 넘길수 있다.
					var id = member['id'];
					var name = member['name'];
					msg += id + '[' + name + ']\n';
				});
				
				/*
				for(var i=0;i<memberList.length;i++){
					var member = memberList[i];
					var id = member.id;
					var name = member.name;
					//일반적으로는 . 키값들을 변수화 할때는  [] 이전 예제의 params[key] 같은 경우,,
					
					msg += id + '(' + name + ')\n';
				}
				*/
				debugTrace(msg);
			}
		}
	}
	function debugTrace(msg){
		var debug = document.getElementById("debug");
		debug.value += msg;
	}
</script>
</head>
<body>
	<h2>JSON DATA 예제</h2>
	<textarea rows="10" cols="80" id="debug"></textarea><br>
	<input type="button" value="서버에 자료요청" onclick="sendOnClick()">
</body>
</html>