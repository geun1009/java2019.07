<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="dao.BbsDao"%>
<%@page import="vo.BbsVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>bbsList.jsp</title>
<style type="text/css">
#contents {
	width: 600px;
	margin: auto;
}

table {
	width: 100%;
}
/* thead 와 tfoot 에게 동시에 스타일 적용*/
thead,tfoot {
	background-color: orange;
	font-size: 15px;
	font-weight: bold;
}
/* table 안에 있는 tbody안에 하위 요소인 tr 태그에게 스타일을 적용*/
tbody tr {
	height: 30px;
}
/* 
		#id : 한페이지에서 딱 한번만 사용
		.id : 클래스는 한페이지에서 여러번 사용이 가능
	*/
.tdV {
	height: 50px;
}

tfoot {
	text-align: right;
	margin-right: 20px;
}
</style>
</head>
<body>
	<%@include file="page.jsp"%>
	<%
		BbsDao dao = BbsDao.getDao();
		//총 게시물을 먼저 구해야 총 페이지 수를 구할 수 있고,
		//그 다음 블럭의 수 등을 구할 수 있다.
		totalRecord = dao.getCnt();
		totalPage = (int) Math.ceil(totalRecord / (double) numPerPage);
		String s_page = request.getParameter("cPage");
		if (s_page != null)
			nowPage = Integer.parseInt(s_page);
		beginPerPage = (nowPage - 1) * numPerPage + 1;
		endPerPage = (beginPerPage - 1) + numPerPage;

		//mybatis환경으로 보내기 위해 Map구조 생성

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", beginPerPage);
		map.put("end", endPerPage);
		List<BbsVO> list = dao.getList(map);
	%>
	<div id="contents">
		<table>
			<thead>
				<tr>
					<td colspan="5" class="tdV">BBS 리스트</td>
				</tr>
				<tr class="tdV">
					<td>번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>조회수</td>
					<td>날짜</td>
				</tr>
			</thead>
			<tbody>
				<!-- 데이터 반복 구간 시작 -->
				<%
					for (int i = 0; i < list.size(); i++) {
						//list에는 BbsVO가 들어가 있으므로 하나씩 가져온다.
						BbsVO e = list.get(i);
				%>
				<tr>
					<td><%=e.getNum()%></td>
					<td><a href=""><%=e.getSub()%></a></td>
					<td><%=e.getWrite()%></td>
					<td><%=e.getHit()%></td>
					<td><%=e.getRedate()%></td>
				</tr>
				<%
					}
				%>
				<!-- 데이터 반복 구간 끝 -->
			</tbody>
			
			<tfoot>
				<tr>
					<td colspan="5" class="tdV"><input type="button" value="글작성" />
					</td>
				</tr>
			</tfoot>

		</table>
	</div>
</body>
</html>