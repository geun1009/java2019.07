<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>today.jsp</title>
</head>
<body>
	<ul>
		<li>Today : ${today }</li>
		
		<li>������ : ${v.bizView }</li>
		<li>BizClass 1 : ${v.insertBiz('hello^^ ')}</li>
		<%--setter ȣ�� --%>
		<li>BizClass 2 : ${v.setBizV('what ')}</li>
		<%--get property ȣ�� --%>
		<li>BizClass 3 : ${v.bizView }</li>
	</ul>
</body>
</html>