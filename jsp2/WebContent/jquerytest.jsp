<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<script>
		//jquery에서 지급한 라이브러리, 현재브라우저가 dom 만을 대기한다
		//$ 선택자 () : CSS의 개념을 이해하면 쉽다
		//#id : 한페이지에서 유일
		//.classs : 한페이지에서 중복가능
		//element : 태그요소
		$(document).ready(function() {
			alert("test2")
		});
		//js 일대 모든 리소스를 대기한다
//		window.onload = function() {
//			alert("test");
//		}
	</script>
</body>
</html>