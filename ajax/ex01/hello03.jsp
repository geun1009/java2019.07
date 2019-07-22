<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#msgView {
		border: 1px solid red;
		height: 200px;
		width: 500px;
	}
</style>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>//0717 ex06 이후
	/*script 
	function requestMsg(){
		
	}*/
	//jQuery
	$(document).ready(function(){//body까지 다 읽고 나면 호출해라
		$(':button').click(function(){//input태그를 클릭했다면..(input)태그와 상관없이 type으로 구분!
										//input, input:button , :button, button
			/*
			ajax의 주요 key
			-type	: 메소드(문자열)
			-url	: 요청주소(문자열)
			-data	: 파라미더(문자열, (JSON)객체형)
			-success: 요청시 응답성공(함수)
			-error	: 요청시 응답실패(함수)
			-async	: 동기/비동기 설정
			*/
			$.ajax({
				type : "get",//type 설정하지 않으면 get방식
				url : "hello.html",
				success: function(data){
					//document.getElementById("msgView").innerHTML += data;
					//$('div#msgView').html(data);// 위처럼 이어 붙이기 하려면..append**
					//$('div#msgView').append(data);// 아래로 붙음 1 2 3
					$('div#msgView').prepend(data);// 위에로 붙음 3 2 1
				},
				error: function(){
					console.log(arguments);
				}
			});					
		});
	});
	
</script>
</head>
<body>
	<h1>서버에서 받은 메세지</h1>
	<div id="msgView"></div>
	<input type="button" value="서버에 자료요청" >
	<input type="text" value="서버에 자료요청" >
</body>
</html>