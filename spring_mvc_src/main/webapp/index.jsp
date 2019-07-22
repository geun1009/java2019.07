<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<%= request.getContextPath() %>/hello/hello.do">hello</a><br>
	<a href="<%= request.getContextPath() %>/method/method.do">method</a><br>
	<a href="<%= request.getContextPath() %>/form/joinForm.do">form</a><br>
	<a href="<%= request.getContextPath() %>/ajax/resBody.do">문자열 응답</a><br>
	<a href="<%= request.getContextPath() %>/ajax/resBody.json">JSON 응답</a><br>
	<a href="<%= request.getContextPath() %>/ajax/resVOBody.json">JSON VO 응답</a><br>
	<a href="<%= request.getContextPath() %>/ajax/resStringListBody.json">JSON List(문자열) 응답</a><br>
	<a href="<%= request.getContextPath() %>/ajax/resVOListBody.json">JSON List(VO) 응답</a><br>
	<a href="<%= request.getContextPath() %>/ajax/restBody.do">rest 문자열 응답</a><br>
	<a href="<%= request.getContextPath() %>/ajax/restBody.json">rest JSON 응답</a><br>
	<a href="<%= request.getContextPath() %>/ajax/restVOBody.json">rest JSON VO 응답</a><br>
	<a href="<%= request.getContextPath() %>/ajax/restStringListBody.json">rest JSON List(문자열) 응답</a><br>
	<a href="<%= request.getContextPath() %>/ajax/restVOListBody.json">rest JSON List(VO) 응답</a><br>
	<a href="<%= request.getContextPath() %>/file/uploadForm.do">파일업로드</a><br>
</body>
</html>









