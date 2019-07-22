<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import=" vo.CustomerVO, java.util.ArrayList, java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	List<CustomerVO> clist = new ArrayList<>();
	clist.add(new CustomerVO(1, "��浿1", "AAA@NAVER.COM", "010-1111-1111"));
	clist.add(new CustomerVO(2, "��浿2", "BBB@NAVER.COM", "010-2222-2222"));
	clist.add(new CustomerVO(3, "��浿3", "CCC@NAVER.COM", "010-3333-3333"));
	clist.add(new CustomerVO(4, "��浿4", "DDD@NAVER.COM", "010-4444-4444"));
	clist.add(new CustomerVO(5, "��浿5", "EEE@NAVER.COM", "010-5555-5555"));

	request.setAttribute("clist", clist);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Clist-CustomerVO</title>
</head>
<body>
	<div>
		<table style="border: 1px solid;">
			<tr>
				<td>�̸�</td>
			</tr>
			<c:forEach var="e" items="${clist}">
				<tr>
					<td>${e.num }</td>
					<td>${e.name}</td>
					<td>${e.email}</td>
					<td>${e.phone}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>