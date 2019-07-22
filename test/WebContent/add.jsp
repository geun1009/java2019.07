<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- 
	useBean : 자바빈즈를 생성하는 액션 태그.
	CustomerVO vo = new CustomerVO(); 
--%>
<jsp:useBean id="vo" class="vo.CustomerVO" scope="page"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	StringBuffer ph = new StringBuffer();
	ph.append(request.getParameter("phone1")).append("-");
	ph.append(request.getParameter("phone2")).append("-");
	ph.append(request.getParameter("phone3"));
	vo.setPhone(ph.toString());
%>
	<%-- 
		증명1 : userBean이 VO객체를 생성을 대신함을 증명!
			vo.setName(request.getParameter("name"));
	--%>
	<%--=vo.getName() --%>
	<%--
		name="vo" vo.setName 에서 VO객체의 레퍼런스
		property="name"  vo객체안에 set/get를 의미
		param="name" request.getParameter("name")를 의미
	 
	<jsp:setProperty name="vo" property="name"  param="name"/>
	<jsp:setProperty name="vo" property="email"  value="aa@a.com"/>
	--%>
	<!-- form에서부터 전송되어온 파라미터를 매핑해서 한번에 처리함 -->
	<jsp:setProperty property="*" name="vo"/>
	<%=vo.getName()%>
	<%=vo.getEmail()%>
	<hr/>
	<jsp:getProperty property="name" name="vo"/><br/>
	<jsp:getProperty property="email" name="vo"/><br/>
	<jsp:getProperty property="phone" name="vo"/><br/>
	<jsp:getProperty property="age" name="vo"/><br/>
	
	
	
	
</body>
</html>