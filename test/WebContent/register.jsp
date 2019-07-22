<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>register.jsp</title>
</head>
<body>
	<div id="content">
		<form method="post" action="add.jsp">
			<fieldset>
				<legend>Customer 가입 폼</legend>
				<p>
				<label for="이름">이름</label>
				<input name="name" id="name" maxlength="34"/>
				</p>
				<p>
				<label for="이메일">이메일</label>
				<input name="email" id="email" />
				</p>
				<p>
				<label for="전화번호">전화번호</label>
				<input name="phone1" id="phone1"  size="5" maxlength="5"/>-
				<input name="phone2" id="phone2"  size="5" maxlength="5"/>-
				<input name="phone3" id="phone3"  size="5" maxlength="5"/>
				</p>
				<p>
				<label for="나이">나이</label>
				<input name="age" id="age" />
				</p>
				<p>
					<input type="submit" value="ADD"/>
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>