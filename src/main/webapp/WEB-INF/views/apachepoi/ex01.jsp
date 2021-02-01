<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Apache POI 예제 01 : 엑셀 다루기</title>
<!-- jQuery 최신 버전 -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<!-- jQuery UI -->
<script src="/resources/jquery-ui/jquery-ui.js" type="text/javascript"></script>  
<link href="/resources/jquery-ui/jquery-ui.css"  rel="stylesheet">      

<!-- Bootstrap 4.4.1 -->
<script src="/resources/bootstrap/bootstrap.min.js" type="text/javascript"></script>  
<link href="/resources/bootstrap/bootstrap.css"  rel="stylesheet">   

<script>
$(document).ready(function() {
	$("#testForm").submit(function(event){
		var url = $("#testForm").attr("action");
		var data = $("#testForm").serialize();
		
		$.post(url, data).done();
	});	
});
</script>
</head>
<body>
<form id="testForm" action="/apachepoi/goToExcel.do" method="post">
<div class="container">
	<div class="row border-bottom mb-3">
		<div class="col-12">
			<p class="h1">Apache POI Excel Example</p>
		</div>
	</div>
	
	<div class="row">	
		<div class="col-4">
			<div class="input-group mb-3">
				<div class="input-group-prepend">
			    	<span class="input-group-text">성명</span>
			  	</div>
			  	<input type="text" class="form-control" id="name" name="name">
			</div>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
			    	<span class="input-group-text">메일</span>
			  	</div>
			  	<input type="text" class="form-control" id="email" name="email">
			</div>
		</div>
		
		<div class="col-4">			
			<div class="input-group">
				<div class="input-group-prepend">
			    	<span class="input-group-text">인원</span>
			  	</div>
			  	<input type="text" class="form-control" id="persons" name="persons">
			</div>
		</div>
		
		<div class="col-4">
			<div class="input-group">
				<div class="input-group-prepend">
			    	<span class="input-group-text">기본금액</span>
			  	</div>
			  	<input type="text" class="form-control" id="persons" name="money" value="25000" readonly="readonly">
			</div>
		</div>
		
		<div class="col-12">
			<button type="submit" class="btn btn-primary">제출</button>
		</div>
	</div>
</div>
</form>
</body>
</html>