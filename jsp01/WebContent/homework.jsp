<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap">
		<form method="post" action="homework.jsp">
			<input type="hidden" name="mode" value="ok"> ��:<input
				type="number" name="don" id="don"> ����:<input type="color"
				name="color" id="color"> ����:<select name="limits">
				<option>3</option>
				<option>5</option>
				<option>7</option>
			</select> <input type="submit" value="����">
		</form>

		<%
			String mode = request.getParameter("mode");
			if (mode != null) {
				String col = request.getParameter("color");
		%>
		<table style="background:<%=col%>">
			<tr>
				<td>Test</td>
			</tr>
		</table>
	</div>
	<%
		}
	%>

</body>
</html>