<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Search</title>

</head>
<body>
	<center style="margin-top:100px;"><img alt="mima" src="resources/images/mima_logo.png"></center>
	<center style="width:100%;margin-top:50px;">
		<form id="search" action="query" >
			<input id="query" name="query" size="44" style="height:28px;">
			<input type="submit" value="搜索2" style="height:28px;width:60px;margin-left:10px;">
		</form>
	</center>
	<center>
		<h1>Please upload a file</h1>  
        <form method="post" action="/form" enctype="multipart/form-data">  
            <input type="text" name="name"/>  
            <input type="file" name="file"/>  
            <input type="submit" value="上传"/>  
        </form>  
	</center>
	<div id="container" ></div>
</body>
</html>