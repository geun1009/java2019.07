<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>bbsForm.jsp</title>
<style type="text/css">
#contents {
	width: 500px;
	margin: auto;
}

fieldset {
	width: 450px;
}
</style>
</head>
<body>
	<div id="contents">
		<form action="bbsadd.jsp" method="post" id="bbsf">
			<fieldset>
				<legend>BBS �Է���</legend>
				<p>
					<label>����</label>
					<input name="sub" id="sub"/>
				</p>
				<p>
					<label>�ۼ���</label>
					<input name="write" id="write"/>
				</p>
				<p>
					<label>��й�ȣ</label>
					<input name="pwd" id="pwd"/>
				</p>
				<p>
					<label>����</label>
					<textarea name="cont" id="cont" rows="15" cols="10"></textarea>
				</p>
				<p>
					<input type="submit" value="���ۼ�"/>
					&nbsp;
					<input type="button" value="����Ʈ"/>
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>