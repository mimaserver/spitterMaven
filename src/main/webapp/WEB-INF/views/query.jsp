<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	
	<center style="margin:20px 0;"><img alt="mima" src="resources/images/mima_logo.png"> 
									<img alt="mima" src="resources/images/logo.png" style="margin:0 50px;"> 
									<img alt="mima" src="resources/images/sdu_logo.png"> 
	</center>
	<div id="container" style="width:100%;border-top:2px black solid;">
	
	<div style="margin:50px;">
	    <div style="width:100%;margin-top:50px;">
			<form id="search" action="query" >
				<input id="query" name="query" size="44" style="height:28px;">
				<input type="submit" value="搜索" style="height:28px;width:60px;margin-left:10px;">
			</form>
		</div>
		<c:forEach var="item" items="${queryItemList }">
	 		<div class="block" style="width:100%;margin:15px 0;border-bottom: 1px solid #DDDEE2;">
	 			<div class="row"><strong style="color:#444;">${item.id }   </strong></div>
	 			<div class="row" style="color:#444;margin:5px 0;"><span>${item.text }</span></div>
	 		</div>
	 	</c:forEach>
	</div>
	
	</div>

</body>
</html>

