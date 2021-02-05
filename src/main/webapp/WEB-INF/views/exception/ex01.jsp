<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Exception 예제 01. @Restcontrolleradvice(Get방식)</title>
<%@ include file="/WEB-INF/views/include/source.jsp" %>
<script>
function sendMsg() {
	var msg = $("#inputMsg").val();
	
	location.href="/exception/sqlExceptionGet.do?msg=" + msg;
}

$(document).ready(function() {
	
});
</script>
</head>
<body>
<form id="testForm">
	<div class="container">
		<div class="row border-bottom mb-3">
			<div class="col-12">
				<p class="h1">EX01. @RestControllerAdvice - Get</p>
			</div>
		</div>
		
		<div class="row">
			<div class="col-4">
				<div class="row">			
					<div class="col-2">
		  				<label for="inputLabel" class="visually-hidden"></label>
		  				<input type="text" readonly class="form-control-plaintext" id=inputLabel value="메세지">
					</div>
					<div class="col-auto">
		  				<label for="inputMsg" class="visually-hidden"></label>
		  				<input type="text" class="form-control" id="inputMsg" placeholder="Y 입력시 예외 발생">
					</div>
					<div class="col-auto">
		  				<button type="button" class="btn btn-primary mb-3" onclick="sendMsg()">전송</button>
					</div>
				</div>
			</div>
		</div>		
	</div>
	
	<%@ include file="/WEB-INF/views/common/bottom.jsp" %>
</form>
</body>
</html>