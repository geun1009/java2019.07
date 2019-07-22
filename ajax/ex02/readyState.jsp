<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	var httpRequest = null;

	function getXMLHttpRequest() {
		if (window.XMLHttpRequest)
			return new XMLHttpRequest();
		if (window.activeXobject)
			return new activeXobject("microsoft.XMLHTTP");
		return null;
	}

	function sendProcess() {
		//1단계
		httpRequest = getXMLHttpRequest();
		//console.log(httpRequest);

		//2단계
		httpRequest.onreadystatechange = callbackFunc

		//3단계
		httpRequest.open("GET", "../ex01/hello.html", true); // true 비동기방식
		httpRequest.send(null);
	}
	function callbackFunc() {
		/*
		readyState
		0 : open()호출전
		1 : send()호출전 
		2 : send()호출, 서버 응답전
		3 : 서버응답중, header 전송, body 미전송
		4 : 서버응답환료, body 전송 완료
		
		상태코드
		200 : 성공
		403 : 엑세스 거부
		404 : FILE NOT FOUND
		405 : Servlet 에러
		500: 내부서버 에러
		 */
		var debug = document.getElementById("debug");

		switch (httpRequest.readyState) {
		case 1:
			debug.value += "Loading...\n";
			break;
		case 2:
			debug.value += "Loading...\n";
			break;
		case 3:
			debug.value += "Interactive...\n";
			break;
		case 4:
			debug.value += "Complete...\n";
			if (httpRequest.status == 200) {
				debug.value += "정상적으로 처리가 완료되었습니다.\n\n";
			} else {
				debug.value += "웹서버에서 오류가 발생되었습니다\n";
				debug.value += "오류코드 : " + httpRequest.status + '\n';
				debug.value += "오류내용 : " + httpRequest.statusText + '\n';
			}
			break;
		}
	}

	function clearOnclick() {
		var debug = document.getElementById("debug");
		debug.value = "";
	}
</script>
</head>
<body>
	<textarea rows="10" cols="80" id="debug"></textarea>
	<br>
	<input type="button" value="서버호출" onclick="sendProcess()">
	<input type="button" value="초기화" onclick="clearOnclick()">
</body>
</html>