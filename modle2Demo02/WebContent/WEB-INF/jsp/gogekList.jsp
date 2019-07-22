<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>gogekList.jsp</title>
<style>
#wrap { width: 500px; margin: auto; }
table {border: 1px dotted; width: 100% }
td { border: 1px solid; }
</style>
</head>
<body>
	<div id = "wrap">
		<table>
			<tr><td colspan="5">������Ʈ</td></tr>
			<c:forEach var="listv" items="${list }">
				<tr>
					<td>${listv.gobun }</td>
					<td>${listv.goname }</td>
					<td>${listv.gotel }</td>
					<td>${listv.gojumin }</td>
					<td>${listv.godam}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5">
					<form method="post" action="search.bit">
						<input type="hidden" name="cmd" value="search"> <select
							name="searchType">
							<option value="1">���̸�</option>
							<option value="2">��ȭ��ȣ</option>
							<option value="3">�ֹι�ȣ</option>
							
						</select>&nbsp;
						<input type="text" name="searchValue">
						<input type="submit" value="�˻�">
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>