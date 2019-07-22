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
<title>Insert title here</title>
<style type="text/css">
	#bbs {
	width: 600px;
	margin: auto;
	}
	#bbs table {
	    width:580px;
	    margin-left:10px;
	    border:1px solid black;
	    border-collapse:collapse;
	    font-size:14px;
	    
	}
	
	#bbs table caption {
	    font-size:20px;
	    font-weight:bold;
	    margin-bottom:10px;
	}
	
	#bbs table th,#bbs table td {
	    text-align:center;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	.no {width:15%}
	.subject {width:30%}
	.writer {width:20%}
	.reg {width:20%}
	.hit {width:15%}
	.title{background:lightsteelblue}
	
	.odd {background:silver}
	
	/* paging */
	
	table tfoot ol.paging {
	    list-style:none;
	}
	
	table tfoot ol.paging li {
	    float:left;
	    margin-right:8px;
	}
	
	table tfoot ol.paging li a {
	    display:block;
	    padding:3px 7px;
	    border:1px solid #00B3DC;
	    color:#2f313e;
	    font-weight:bold;
	}
	
	table tfoot ol.paging li a:hover {
	    background:#00B3DC;
	    color:white;
	    font-weight:bold;
	}
	
	.disable {
	    padding:3px 7px;
	    border:1px solid silver;
	    color:silver;
	}
	
	.now {
	   padding:3px 7px;
	    border:1px solid #ff4aa5;
	    background:#ff4aa5;
	    color:white;
	    font-weight:bold;
	}
		
</style>
</head>
<body>
<div id="bbs">
		<table summary="�Խ��� ���">
			<caption>�Խ��� ���</caption>
			<thead>
				<tr class="title">
					<th class="no">��ȣ</th>
					<th class="subject">����</th>
					<th class="writer">�۾���</th>
					<th class="reg">��¥</th>
					<th class="hit">��ȸ��</th>
				</tr>
			</thead>
<%

	// ���� ����¡�� ���� begin�� end���� ���ؾ� �ϸ�
	// �׸��� ����¡ ����� �ϱ� ���� ��ü������ �� ,
	// ���� ������ ������ ���ؾ� �Ѵ�.
	int nowPage = 1;// ���� ������ ��
	int nowBlock = 1;// ���� ��
	int totalRecord = 0;// �� �Խù� ��
	int numPerPage = 10;// �� �������� ������ �Խù� ��
	int pagePerBlock = 5;// �� ���� ������ ������ ��
	int totalPage = 0;// ��ü ������ ��
	int totalBlock = 0;// ��ü �� ��
	int beginPerPage = 0;// �� �������� ���� �Խù��� index��
	int endPerPage = 0;// �� �������� ������ �Խù��� index��
	
	//�� �Խù��� ���� ���ؾ� �� ������ ���� ���� �� �ְ�,
	//�� ���� ���� �� ���� ���� �� �ִ�.
	BbsDao dao = BbsDao.getDao();
	totalRecord = dao.getCnt();
	
	//�� ������ ���� ���Ѵ�.
// 	totalPage = totalRecord/numPerPage;// 52/10 = 5; ������ 2�� �߻��Ͽ�
// 	// �ٽ� ����ؾ� �Ѵ�.
// 	if(totalRecord%numPerPage != 0)
// 		totalPage++;
	totalPage = (int)Math.ceil(totalRecord/(double)numPerPage);
	
	//���� �������� ��û�� �� �Ķ���ͷ� ���� ���������� �޴´�.
	String s_page = request.getParameter("cPage");
	
	//����! �Ķ���͸� ���� ������ ��쵵 �����Ƿ�
	// �Ķ���Ͱ� ���� ���� nowPage���� �����Ѵ�.
	if(s_page != null)
		nowPage = Integer.parseInt(s_page);
	// �Ķ���Ͱ� ���ٸ� �������� ���ϴ� �ƽ����� ������
	// nowPage�� �⺻���� 1�̹Ƿ� ù �������� �����ְ� �Ǿ� �ִ�.
	
	//SQL���� begin�� end���� ������ �κ��̴�.
	// ���� ��� ���� ������(nowPage)�� 3�϶� ����index�� 21�̾�� �Ѵ�.
	//  ����: (nowPage-1)*numPerPage+1;
	beginPerPage = (nowPage-1)*numPerPage+1;
	endPerPage = (beginPerPage-1)+numPerPage;
	
	//mybatisȯ������ ������ ���� Map���� ����
  // ------------ code here ------------------------
	

%>			
			<tfoot>
                      <tr>
                          <td colspan="5">
                              <ol class="paging">
                                  
<%
	// ���������� �� ���ϱ�
	int startPage = (int)((nowPage-1)/pagePerBlock)*pagePerBlock+1;

	// �� ���� ǥ���� ������ ������ �� ���ϱ�
	int endPage = startPage + pagePerBlock - 1;
	
	// ���� ���� �ϴٺ��� ������ ������(endPage)��
	// ��ü ������ ��(totalPage)���� ū ��찡 ���� �� �ִ�.
	// ��) �� �Խù� : 37
	//     �� ������ �� : 4
	//  �̷� ��� �ݺ������� �� ������ ���� ���� ���ϰ�
	//  if������ ��� �� �� �־�� �Ѵ�.
	if(endPage > totalPage)
		endPage = totalPage;
	
	// ���� �������� 1�� �ƴ� ��쿡�� [��������]��� �����
	// Ȱ��ȭ ��Ų��.
	if(startPage < 6){
%>
	<li class="disable">��������</li>
<%		
	}else{
%>
	<li><a href="bbsList2.jsp?cPage=<%=nowPage-pagePerBlock%>">��������</a></li>
<%		
	}
	
	// ������ ��ȣ�� ����ϴ� �ݺ���
	for(int i=startPage ; i<= endPage ; i++){
		//����! i���� ������������(nowPage)�� ���� ���� 
		//a�±׸� �������� �ʴ´�.
		if(i == nowPage){
%>
			<li class="now"><%=i %></li>
<%			
		}else{
%>
			<li><a href="bbsList2.jsp?cPage=<%=i%>"><%=i %></a></li>
<%			
		}
	}// ������ ��ȣ�� ����ϴ� �ݺ��� ��!
	
	
	//�������� ����� �����Ѵ�.
	if(endPage >= totalPage){
%>
		<li class="disable">��������</li>
<%		
	}else{
		System.out.println(nowPage+pagePerBlock);
		System.out.println("totalPage:"+totalPage);
		int blockPage = nowPage+pagePerBlock;
		if(totalPage < nowPage+pagePerBlock) {
			blockPage = totalPage;
		}
%>
		<li><a href="bbsList2.jsp?cPage=<%=blockPage%>">��������</a></li>
<%		
	}
%>               

                              </ol>
                          </td>
                      </tr>
                  </tfoot>
			<tbody>
<%
		for(int i=0; i<list.size() ; i++){
			//list���� BbsVO�� �� �����Ƿ� �ϳ��� �����´�.
			BbsVO vo = list.get(i);
		
%>			
				<tr>
					<td><%=totalRecord - ((nowPage-1)*numPerPage+i) %></td>
					<td style="text-align: left">
						<a href="view.jsp?index=<%=i%>&cPage=<%=nowPage%>">
					<%=vo.getSub() %>
		
					</a></td>
					<td><%=vo.getWrite() %></td>
					<td><%=vo.getRedate()%></td>
					<td><%=vo.getHit() %></td>
				</tr>
<%
		}
		if(list.size() < 1){
%>
				<tr>
					<td colspan="5" class="init">
						���� ��ϵ� �Խù��� �����ϴ�.
					</td>
				</tr>
<%			
		}
%>
			</tbody>
		</table>
		<input type="button" value="�۾���"
			onclick="javascript:location.href='bbsForm2.jsp?cPage=<%=nowPage%>'"/>
	</div>
</body>
</html>