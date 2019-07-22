<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>test</title>

<style>
div {
	width: 300px;
	height: 200px;
	background: orange;
	margin: auto;
}

div>h1 {
	color: white;
	font-size: 30px
}
</style>
</head>

<script type="text/javascript">
	function clickfn() {
		console.log("자바스크르립트 디버깅")
	}
</script>
<body>
	<div>
		<h1>hello jsp 입니다.</h1>
		<a href="javascript:clickfn()">click</a>
	</div>
</body>
</html>
	