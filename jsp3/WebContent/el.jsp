<%@ page import="vo.CustomerVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
CustomerVO ctv = new CustomerVO();
ctv.setNum(10);
ctv.setName("김길동");
ctv.setEmail("javabook@naver.com");
ctv.setPhone("010-1212-1212");
request.setAttribute("ctvs", ctv);

%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; pageEncoding=UTF-8">
<title>Insert title here</title>
</head>
<body>
이름 :      ${ctvs.name }
</body>
</html>