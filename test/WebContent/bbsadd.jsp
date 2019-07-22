<%@page import="dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>  
<%	request.setCharacterEncoding("euc-kr");%>
<jsp:useBean id="vo" class="vo.BbsVO"/>
<jsp:setProperty property="*" name="vo"/>
<%
	vo.setReip(request.getRemoteAddr());
// Dao에 해당 VO객체를 주입해서 입력처리를 해야 한다.
	
	BbsDao.getDao().bbsAdd(vo);
	response.sendRedirect("bbsList2.jsp");
%>