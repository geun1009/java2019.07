<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<%
	//jsp �����Լ�
	//request, response �� ������ ����
	//request(��û)-> HttpSercletRequest
	//response(����)-> HttpSercletResponse
	//��û�� ������ ���
	//client�� �����ǰ��� ��ȯ
	String reip = request.getRemoteAddr();
	System.out.println("reip" + reip);
	//�ѱ�ó��
	
%>
</head>
<body>
	<div id=wrap>
		<table>
			<tr>
				<th colspan="2">���ϸ� ����Ʈ</th>
			</tr>
			<tr>
				<td>�̸�</td>
				<td></td>
			</tr>
			<tr>
				<td>�̸���</td>
				<td></td>
			</tr>
			<tr>
				<td>����</td>
				<td></td>
			</tr>
			<tr>
				<th colspan="2"><input type="button" value="���Գ�"></th>
			</tr>



		</table>
	</div>
</body>
</html>