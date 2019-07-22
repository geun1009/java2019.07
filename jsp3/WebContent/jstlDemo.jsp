<%@ page import=" java.util.ArrayList, java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
	List <String> arList = new ArrayList<>();
	arList.add("김길동1");
	arList.add("김길동2");
	arList.add("김길동3");
	arList.add("김길동4");
	arList.add("김길동5");
	arList.add("김길동6");
	arList.add("김길동7");
	arList.add("김길동8");
	arList.add("김길동9");
	arList.add("김길동10");
	request.setAttribute("list", arList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div>
		<table style="border: 1px solid;">
			<tr>
				<td>이름</td>
			</tr>
			<c:forEach var="e" items="${list }">
				<tr>
					<td>${e }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>