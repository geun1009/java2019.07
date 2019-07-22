<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>WebContent/uptestform.jsp</title>
</head>
<body>		<h1>File Upload</h1>
	<form action="uptest.bit" method="post" enctype="multipart/form-data">
	<input type="hidden" name="cmd" value="uptest">
	<input type="file" name="file" size="60"/><br />
	<input type="submit" value="upload" />
	
	</form>
</body>
</html>