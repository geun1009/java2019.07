<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<%
	//jsp 내장함수
	//request, response 의 개념을 이해
	//request(요청)-> HttpSercletRequest
	//response(응답)-> HttpSercletResponse
	//요청한 정보를 출력
	//client의 아이피값을 반환
	String reip = request.getRemoteAddr();
	System.out.println("reip" + reip);
	//한글처리
	
%>
</head>
<body>
	<div id=wrap>
		<table>
			<tr>
				<th colspan="2">메일링 리스트</th>
			</tr>
			<tr>
				<td>이름</td>
				<td></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td></td>
			</tr>
			<tr>
				<td>나이</td>
				<td></td>
			</tr>
			<tr>
				<th colspan="2"><input type="button" value="가입끝"></th>
			</tr>



		</table>
	</div>
</body>
</html>