<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>upload</title>
</head>
<body>


<center style="margin: 20px 0;">
		<a href="http://211.87.234.13:8080"><img alt="mima"
			src="resources/images/mima_logo.png"></a> <img alt="mima"
			src="resources/images/logo.png" style="margin: 0 50px;"> <img
			alt="mima" src="resources/images/sdu_logo.png">
	</center>
	<div id="container" style="width: 100%; border-top: 2px black solid;">
	<br>
	<br>

	<center>
		<p>上传成功!</p>
		<br> 
		<form>
		<input type="button" name="reupload" value="继续上传"
			onclick="location.href='http://211.87.234.13:8080'" 
			style="height: 28px; width: 60px; margin-left: 10px;"/> &nbsp;&nbsp;
			<input type="button" name="research" value="检索"
			onclick="location.href='http://211.87.234.13:8080/query?query='" 
			style="height: 28px; width: 60px; margin-left: 10px;"/>
		</form>
	</center>

	</div>
</body>
</html>
