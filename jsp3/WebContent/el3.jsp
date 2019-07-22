<%@ page import="vo.CustomerVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import=" java.util.HashMap, java.util.ArrayList"%>
<%
	ArrayList singerList = new ArrayList();
	singerList.add("소녀시대");
	singerList.add("원더걸스");
	request.setAttribute("singerList", singerList);
	
	Customer[] CustomerList = new Customer[2];
	Customer cust1 = new Customer();
	cust1.setName("홍길동");
	cust1.setEmail("hong.nate.com");
	cust1.setPhone("011-1234-5678");
	
	Customer cust2 = new Customer();
	cust2.setName("홍길동");
	cust2.setEmail("hong.nate.com");
	cust2.setPhone("011-1234-5678");

	CustomerList[0] = cust1;
	CustomerList[1] = cust2;
	
	request.setAttribute("customerList", CustomerList);
%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; pageEncoding=UTF-8">
<title>JSP Page</title>
</head>
<body>
	<ul>
		<li>$singerList[0].singerList[1]</li>
	<ul>
		<li>이름 : ${customerList[0],name}</li>
		<li>메일 : ${customerList[0],email}</li>
		<li>전화 : ${customerList[0],phone}</li>
	</ul>
	<ul>
		<li>이름 : ${customerList[1],name}</li>
		<li>메일 : ${customerList[1],email}</li>
		<li>전화 : ${customerList[1],phone}</li>
	</ul>
</body>
</html>