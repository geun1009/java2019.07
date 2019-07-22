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
<title>sawonPhoneList.jsp</title>
</head>
<body>
	<div id="wrap">
		<table>
			<tr>
				<td>사원번호</td>
				<td>사원직책</td>
				<td>사원이름</td>
				<td>폰번호</td>
				<td>폰모델</td>	
			</tr>
			<c:forEach var="sawon" items="${splist }">
				<tr>
					<td>${sawon.sabun }</td>
					<td>${sawon.sajob }</td>
					<td>${sawon.saname }</td>
					<td>${sawon.sphone.phnum }</td>
					<td>${sawon.sphone.pmodel }</td>
					
				</tr>
			</c:forEach>		
		</table>
		
	</div>
</body>
</html>