<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- 
	useBean : �ڹٺ�� �����ϴ� �׼� �±�.
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
		����1 : userBean�� VO��ü�� ������ ������� ����!
			vo.setName(request.getParameter("name"));
	--%>
	<%--=vo.getName() --%>
	<%--
		name="vo" vo.setName ���� VO��ü�� ���۷���
		property="name"  vo��ü�ȿ� set/get�� �ǹ�
		param="name" request.getParameter("name")�� �ǹ�
	 
	<jsp:setProperty name="vo" property="name"  param="name"/>
	<jsp:setProperty name="vo" property="email"  value="aa@a.com"/>
	--%>
	<!-- form�������� ���۵Ǿ�� �Ķ���͸� �����ؼ� �ѹ��� ó���� -->
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