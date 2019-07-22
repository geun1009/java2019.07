<%@page import="dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
 
<% request.setCharacterEncoding("euc-kr");%>

<jsp:useBean id="vo" class="vo.BbsVo"/>

<jsp:setProperty property="*" name="vo"/>

<%
	vo.setReip(request.getRemoteAddr());
	BbsDao.getDao().bbsIn(vo);
	response.sendRedirect("bbsList2.jsp");
%>
