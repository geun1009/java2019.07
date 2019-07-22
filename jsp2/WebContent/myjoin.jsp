<%@page import="dao.MemberDao"%>
<%@page import="javax.websocket.SendResult"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%
   //myjoin.jsp
   request.setCharacterEncoding("euc-kr");
%>
<jsp:useBean id="vo" class="dto.MyMemberDTO"/>

<jsp:setProperty property="*" name="vo"/>
<%
   MemberDao.getDao().addMember(vo);
   response.sendRedirect("success.jsp");
%>