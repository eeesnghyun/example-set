<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<title>Hello world!</title>
<%@ include file="/WEB-INF/views/include/source.jsp" %>
</head>
<body>
<div class="container">
	<div class="row mb-2">
		<P> The time on the server is ${serverTime}. </P>
	</div>
	
	<div class="row mb-2">
		<div class="col-12">
			<h2>Apache POI Example</h2>
		</div>
		<div class="col-12">
			<ul class="list-group">
			  <li class="list-group-item"><a href="/apachepoi/ex01.do">Ex01 : Apache POI Excel 데이터 쓰기</a></li>
			</ul>
		</div>
	</div>
	
	<div class="row mb-2">
		<div class="col-12">
			<h2>Exception Handler Example</h2>
		</div>
		<div class="col-12">
			<ul class="list-group">
			  <li class="list-group-item"><a href="/exception/ex01.do">Ex01 : @RestControllerAdvice - Get</a></li>    
			  <li class="list-group-item"><a href="/exception/ex02.do">Ex02 : @RestControllerAdvice - Post </a></li>
			</ul>
		</div>
	</div>
</div>
</body>
</html>