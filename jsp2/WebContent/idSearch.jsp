<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<%@ page trimDirectiveWhitespaces="true"%>
<% String idv = request.getParameter("id"); 
	//dao
	int cnt = MemberDao.getDao().getIdCount(idv);
	String msg = "";
	if(cnt ==0){
		msg = "��밡���մϴ�";
		}else{
			msg = "�̹� ������Դϴ�.";
	}


%>

<%=msg%>