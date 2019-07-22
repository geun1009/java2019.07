<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="jquery-3.4.1.min.js"></script>
<script src="httpRequest.js"></script>
<script>
	function sendOnClick() {
		sendProcess('GET', 'sample.xml', null, callback);
	}

	function callback() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				var xmlDoc = $.parseXML(httpRequest.responseText);
				var memberList = $(xmlDoc).find("member");
				
				

				//var xmlDoc = httpRequest.responseXML;		
				//var memberList = xmlDoc.getElementsByTagName("member");

				var msg = '회원수 : ' + memberList.length + "명\n";
				for (var i = 0; i < memberList.length; i++) {
					//console.log(memberList[i]);//자바스크립트 객체
					//console.log(memberList.eq(i));//제이쿼리 객체
					//var member = memberList.eq(i);
					//var id = ${member}.find('id').html();
					//var name = ${member}.find('name').text();
					
					//msg += id + "(" + name + ")\n";
					
					memberList.each(function(index, member){
						var id = $(this).find('id').html();
						var name = ${this}.find('name').text();
						
						msg += id + "(" + name + ")\n";
					});
				}
				//console.log(memberList);
				//console.log(memberList[0].innerHTML);//javascript 객체
				//console.log(memberList.eq(0).html());//jquery 객체
				//자바스크립트와 jquery는 자식 접근방식이 다름으로 콘솔로그로 우선 확인하고 그에 맞는 접근방식을 사용해야한다.

				/*for(var i = 0; i < memberList.length; i++) {
					var member = memberList[i];
					var id = member.getElementsByTagName("id")[0].innerHTML;
					var name = member.getElementsByTagName("name")[0].innerHTML;
					msg += id + "(" + name + ")\n";
				}*/

				debugTrace(msg);
			}
		}
	}

	function debugTrace(msg) {
		var debug = document.getElementById("debug");
		debug.value += msg;
	}
</script>
</head>
<body>
	<h2>XML DATA 예제</h2>
	<textarea rows="10" cols="80" id="debug"></textarea>
	<br>
	<input type="button" value="서버에 자료요청" onclick="sendOnClick()">

</body>
</html>