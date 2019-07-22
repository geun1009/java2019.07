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
/* thead �� tfoot ���� ���ÿ� ��Ÿ�� ����*/
thead,tfoot {
	background-color: orange;
	font-size: 15px;
	font-weight: bold;
}
/* table �ȿ� �ִ� tbody�ȿ� ���� ����� tr �±׿��� ��Ÿ���� ����*/
tbody tr {
	height: 30px;
}
/* 
		#id : ������������ �� �ѹ��� ���
		.id : Ŭ������ ������������ ������ ����� ����
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
		//�� �Խù��� ���� ���ؾ� �� ������ ���� ���� �� �ְ�,
		//�� ���� ���� �� ���� ���� �� �ִ�.
		totalRecord = dao.getCnt();
		totalPage = (int) Math.ceil(totalRecord / (double) numPerPage);
		String s_page = request.getParameter("cPage");
		if (s_page != null)
			nowPage = Integer.parseInt(s_page);
		beginPerPage = (nowPage - 1) * numPerPage + 1;
		endPerPage = (beginPerPage - 1) + numPerPage;

		//mybatisȯ������ ������ ���� Map���� ����

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", beginPerPage);
		map.put("end", endPerPage);
		List<BbsVO> list = dao.getList(map);
	%>
	<div id="contents">
		<table>
			<thead>
				<tr>
					<td colspan="5" class="tdV">BBS ����Ʈ</td>
				</tr>
				<tr class="tdV">
					<td>��ȣ</td>
					<td>����</td>
					<td>�ۼ���</td>
					<td>��ȸ��</td>
					<td>��¥</td>
				</tr>
			</thead>
			<tbody>
				<!-- ������ �ݺ� ���� ���� -->
				<%
					for (int i = 0; i < list.size(); i++) {
						//list���� BbsVO�� �� �����Ƿ� �ϳ��� �����´�.
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
				<!-- ������ �ݺ� ���� �� -->
			</tbody>
			
			<tfoot>
				<tr>
					<td colspan="5" class="tdV"><input type="button" value="���ۼ�" />
					</td>
				</tr>
			</tfoot>

		</table>
	</div>
</body>
</html>