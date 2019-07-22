<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<%@ page trimDirectiveWhitespaces="true"%>
<% String idv = request.getParameter("id"); 
	//dao
	int cnt = MemberDao.getDao().getIdCount(idv);
	String msg = "";
	if(cnt ==0){
		msg = "사용가능합니다";
		}else{
			msg = "이미 사용중입니다.";
	}


%>

<%=msg%>