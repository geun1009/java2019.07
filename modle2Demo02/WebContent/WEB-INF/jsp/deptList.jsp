<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap">
		<table>
			<tr>
				<th>부서번호</th>
				<th>부서명</th>
				<th>위치</th>
			</tr>
			<c:forEach var="e" items="${dlist }">
				<tr>
					<td class="no">${e.deptno }</td>
					<td>&nbsp;&nbsp;${e.dname }</td>
					<td>&nbsp;&nbsp;${e.loc }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>