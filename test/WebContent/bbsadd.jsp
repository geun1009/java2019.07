<%@page import="dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>  
<%	request.setCharacterEncoding("euc-kr");%>
<jsp:useBean id="vo" class="vo.BbsVO"/>
<jsp:setProperty property="*" name="vo"/>
<%
	vo.setReip(request.getRemoteAddr());
// Dao�� �ش� VO��ü�� �����ؼ� �Է�ó���� �ؾ� �Ѵ�.
	
	BbsDao.getDao().bbsAdd(vo);
	response.sendRedirect("bbsList2.jsp");
%>