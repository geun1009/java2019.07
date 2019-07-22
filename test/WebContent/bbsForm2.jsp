<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String nowPage = request.getParameter("cPage");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	
	#bbs table th {
	    text-align:center;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	#bbs table td {
	    text-align:left;
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
	
		
</style>
<script type="text/javascript">
	function sendData(){
		for(var i=0 ; i<document.forms[0].elements.length ; i++){
			if(document.forms[0].elements[i].value == ""){
				alert(document.forms[0].elements[i].name+
						"�� �Է��ϼ���");
				document.forms[0].elements[i].focus();
				return;//���� �ߴ�
			}
		}

//		document.forms[0].action = "test.jsp";
		document.forms[0].submit();
	}
	
	//������� ���ư��� �Լ�
	function viewList(p){
		console.log(typeof(p))
		let pageVal="<%=nowPage%>";
		
		if(p ==="null"){
			pageVal = "1";
		}
		location.href="bbsList2.jsp?cPage="+pageVal;
	}
</script>
</head>
<body>
	<div id="bbs">
	<form action="bbsadd.jsp" method="post" >
		<table summary="�Խ��� �۾���">
			<caption>�Խ��� �۾���</caption>
			<tbody>
				<tr>
					<th>����:</th>
					<td><input type="text" name="sub" id="sub" size="45"/></td>
				</tr>
				<tr>
					<th>�̸�:</th>
					<td><input type="text" name="write" id="write" size="12"/></td>
				</tr>
				<tr>
					<th>����:</th>
					<td><textarea name="cont" id="cont" cols="50" 
							rows="8"></textarea></td>
				</tr>
				<tr>
					<th>��й�ȣ:</th>
					<td><input type="password" name="pwd" id="pwd" size="12"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="���ۼ�"/>
						<input type="reset" value="�ٽ�"/>
						<input type="button" value="���"
						 onclick="viewList('<%=nowPage%>')"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	</div>
</body>
</html>


