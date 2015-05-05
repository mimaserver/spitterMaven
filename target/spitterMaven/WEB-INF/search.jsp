<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>search</title>

</head>
<body>
	<center style="margin-top: 100px;">
		<img alt="mima" src="resources/images/mima_logo.png">
	</center>
	<center style="width: 100%; margin-top: 50px;">
		<form id="search" action="query" >
			<input id="query" name="query" size="44" style="height: 28px;" >
			<input type="submit" value="搜索"
				style="height: 28px; width: 60px; margin-left: 10px;" >
		</form>
	</center>
	<br>
	<br>
	<br>
	<br>
	<br>
	<center>
		<h2>上传文件</h2>
		<form method="post" action="form" enctype="multipart/form-data">
   		<!-- >
   		<input type="text" name="name" />    
   		 -->	
		<input type="file" name="file"/>
       <p> <span style="font:400 12px Simsun;">上传Word、PDF格式文档，大小不超过10M</span></p>
       <input type= "submit" value="提交" style="height: 28px; width: 60px; margin-left: 10px;"/>
		</form>
	</center>
	<div id="container"></div>
</body>
 <!--   <script>
            
            function sub(){
                var content = document.getElementById("query").value;
                
                request.setAttribute("content",content);
            }
            
    </script>
    --> 
</html>