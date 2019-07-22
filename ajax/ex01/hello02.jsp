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

<script type="text/javascript">
	var httpRequest = null;
	function requestMsg() {

		//1. XMLHttpRequest객체 생성
		if (window.XMLHttpRequest) { // 만약 window 객체안에 xml 이 있으면 만들겠다 , 버전이 낮으면 없을수도있음
			httpRequest = new XMLHttpRequest();
		} else if (window.activeXobject) { // 없으면 이걸사용하겠다
			httpRequest = new ActiveXObject("microsoft.XMLHTTP");
		}
		//2. callback 함수 설정
		//요청이 들어오면 responseMsg를 실행하겠다
		httpRequest.onreadystatechange = responseMsg;

		//3. 서버에 비동기 요청 
		httpRequest.open("GET", "/ajax/hello", true) // true가 비동기방식임 
		httpRequest.send();

	}

	function responseMsg() {
		//4.서버에서 응답완료(성공)
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				console.log("responseMsg 호출...");
				var msgView = document.getElementById("msgView");
				msgView.innerHTML += httpRequest.responseText;
			}
		}
	}
</script>
</head>


<body>

	<h1>서버에서 받은 메세지</h1>
	<div id="msgView"></div>
	<input type="button" value="서버에 자료요청" onclick="requestMsg()">

</body>
</html>