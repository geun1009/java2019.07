<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	// 현재 페이징에 의한 begin과 end값을 구해야 하며
	// 그리고 페이징 기법을 하기 위한 전체페이지 수 ,
	// 현재 페이지 값등을 구해야 한다.
	int nowPage = 1;// 현재 페이지 값
	int nowBlock = 1;// 현재 블럭
	int totalRecord = 0;// 총 게시물 수
	int numPerPage = 10;// 한 페이지당 보여질 게시물 수
	int pagePerBlock = 5;// 한 블럭당 보여질 페이지 수
	int totalPage = 0;// 전체 페이지 수
	int totalBlock = 0;// 전체 블럭 수
	int beginPerPage = 0;// 각 페이지별 시작 게시물의 index값
	int endPerPage = 0;// 각 페이지별 마지막 게시물의 index값
%>