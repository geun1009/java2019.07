<%@ page import=" java.util.ArrayList, java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
	List <String> arList = new ArrayList<>();
	arList.add("��浿1");
	arList.add("��浿2");
	arList.add("��浿3");
	arList.add("��浿4");
	arList.add("��浿5");
	arList.add("��浿6");
	arList.add("��浿7");
	arList.add("��浿8");
	arList.add("��浿9");
	arList.add("��浿10");
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
				<td>�̸�</td>
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