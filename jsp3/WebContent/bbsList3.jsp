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
		<table summary="게시판 목록">
			<caption>게시판 목록</caption>
			<thead>
				<tr class="title">
					<th class="no">번호</th>
					<th class="subject">제목</th>
					<th class="writer">글쓴이</th>
					<th class="reg">날짜</th>
					<th class="hit">조회수</th>
				</tr>
			</thead>
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
	
	//총 게시물을 먼저 구해야 총 페이지 수를 구할 수 있고,
	//그 다음 블럭의 수 등을 구할 수 있다.
	BbsDao dao = BbsDao.getDao();
	totalRecord = dao.getCnt();
	
	//총 페이지 수를 구한다.
// 	totalPage = totalRecord/numPerPage;// 52/10 = 5; 나머지 2가 발생하여
// 	// 다시 계산해야 한다.
// 	if(totalRecord%numPerPage != 0)
// 		totalPage++;
	totalPage = (int)Math.ceil(totalRecord/(double)numPerPage);
	
	//현재 페이지를 요청할 때 파라미터로 현재 페이지값을 받는다.
	String s_page = request.getParameter("cPage");
	
	//만약! 파라미터를 받지 못했을 경우도 있으므로
	// 파라미터가 있을 때만 nowPage값을 변경한다.
	if(s_page != null)
		nowPage = Integer.parseInt(s_page);
	// 파라미터가 없다면 수행하지 못하는 아쉬움이 있지만
	// nowPage의 기본값이 1이므로 첫 페이지는 보여주게 되어 있다.
	
	//SQL문에 begin과 end값을 지정할 부분이다.
	// 예를 들어 현재 페이지(nowPage)가 3일때 시작index는 21이어야 한다.
	//  연산: (nowPage-1)*numPerPage+1;
	beginPerPage = (nowPage-1)*numPerPage+1;
	endPerPage = (beginPerPage-1)+numPerPage;
	
	//mybatis환경으로 보내기 위해 Map구조 생성
  // ------------ code here ------------------------
	

%>			
			<tfoot>
                      <tr>
                          <td colspan="5">
                              <ol class="paging">
                                  
<%
	// 시작페이지 값 구하기
	int startPage = (int)((nowPage-1)/pagePerBlock)*pagePerBlock+1;

	// 한 블럭에 표현될 마지막 페이지 값 구하기
	int endPage = startPage + pagePerBlock - 1;
	
	// 위와 같이 하다보면 마지막 페이지(endPage)가
	// 전체 페이지 값(totalPage)보다 큰 경우가 생길 수 있다.
	// 예) 총 게시물 : 37
	//     총 페이지 수 : 4
	//  이런 경우 반복문에서 충 페이지 수를 넘지 못하게
	//  if문으로 제어를 할 수 있어야 한다.
	if(endPage > totalPage)
		endPage = totalPage;
	
	// 시작 페이지가 1이 아닌 경우에만 [이전으로]라는 기능을
	// 활성화 시킨다.
	if(startPage < 6){
%>
	<li class="disable">이전으로</li>
<%		
	}else{
%>
	<li><a href="bbsList2.jsp?cPage=<%=nowPage-pagePerBlock%>">이전으로</a></li>
<%		
	}
	
	// 페이지 번호를 출력하는 반복문
	for(int i=startPage ; i<= endPage ; i++){
		//만약! i값이 현재페이지값(nowPage)과 같을 경우는 
		//a태그를 적용하지 않는다.
		if(i == nowPage){
%>
			<li class="now"><%=i %></li>
<%			
		}else{
%>
			<li><a href="bbsList2.jsp?cPage=<%=i%>"><%=i %></a></li>
<%			
		}
	}// 페이지 번호를 출력하는 반복문 끝!
	
	
	//다음으로 기능을 적용한다.
	if(endPage >= totalPage){
%>
		<li class="disable">다음으로</li>
<%		
	}else{
		System.out.println(nowPage+pagePerBlock);
		System.out.println("totalPage:"+totalPage);
		int blockPage = nowPage+pagePerBlock;
		if(totalPage < nowPage+pagePerBlock) {
			blockPage = totalPage;
		}
%>
		<li><a href="bbsList2.jsp?cPage=<%=blockPage%>">다음으로</a></li>
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
			//list에는 BbsVO가 들어가 있으므로 하나씩 가져온다.
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
						현재 등록된 게시물이 없습니다.
					</td>
				</tr>
<%			
		}
%>
			</tbody>
		</table>
		<input type="button" value="글쓰기"
			onclick="javascript:location.href='bbsForm2.jsp?cPage=<%=nowPage%>'"/>
	</div>
</body>
</html>