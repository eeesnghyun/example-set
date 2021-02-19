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
			<ul class="list-group list-group-flush">
			  <li class="list-group-item"><a href="/apachepoi/ex01.do" class="text-decoration-none">EX01. Apache POI Excel 데이터 쓰기</a></li>
			  <li class="list-group-item"><a href="/apachepoi/ex02.do" class="text-decoration-none">EX02. Apache POI Excel 데이터 읽기(서버단)</a></li>
			  <li class="list-group-item"><a href="/apachepoi/ex03.do" class="text-decoration-none">EX03. Apache POI Excel 데이터 읽기(클라이언트단)</a></li>
			  <li class="list-group-item"><a href="/apachepoi/ex04.do" class="text-decoration-none">EX04. Apache POI Word 데이터 쓰기</a></li>
			</ul>
		</div>
	</div>

	<div class="row mb-2">
		<div class="col-12">
			<h2>Exception Handler Example</h2>
		</div>
		<div class="col-12">
			<ul class="list-group list-group-flush">
			  <li class="list-group-item"><a href="/exception/ex01.do" class="text-decoration-none">EX01. @RestControllerAdvice - Get</a></li>
			  <li class="list-group-item"><a href="/exception/ex02.do" class="text-decoration-none">EX02. @RestControllerAdvice - Post </a></li>
			</ul>
		</div>
	</div>

	<div class="row mb-2">
		<div class="col-12">
			<h2>XSS Filter Example</h2>
		</div>
		<div class="col-12">
			<ul class="list-group list-group-flush">
			  <li class="list-group-item"><a href="/xss/ex01.do" class="text-decoration-none">EX01. Lucy-xss-servlet-filter 적용</a></li>
			  <li class="list-group-item"><a href="/xss/ex02.do" class="text-decoration-none">EX02. Lucy-xss-servlet-filter 필터 규칙사용</a></li>
			  <li class="list-group-item"><a href="/xss/ex03.do" class="text-decoration-none">EX03. Lucy-xss-servlet-filter JSON 데이터는?</a></li>
			</ul>
		</div>
	</div>

	<div class="row mb-2">
		<div class="col-12">
			<h2>Spring Transaction Example</h2>
		</div>
		<div class="col-12">
			<ul class="list-group list-group-flush">
			  <li class="list-group-item"><a href="/transaction/ex01.do" class="text-decoration-none">EX01. 선언적 트랜잭션</a></li>
			  <li class="list-group-item"><a href="/transaction/ex02.do" class="text-decoration-none">EX02. AOP를 이용해 Log 기록하기</a></li>
			</ul>
		</div>
	</div>
</div>
</body>
</html>