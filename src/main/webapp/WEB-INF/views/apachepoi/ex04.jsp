<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Apache POI Example</title>
<%@ include file="/WEB-INF/views/include/source.jsp" %>
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
<form id="testForm" action="/apachepoi/goToWord.do" method="post">
	<div class="container">
		<div class="row border-bottom mb-3">
			<div class="col-12">
				<p class="h1">EX04. Apache POI Word 데이터 쓰기</p>
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

			<div class="col-12">
				<button type="submit" class="btn btn-primary">제출</button>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/common/bottom.jsp" %>
</form>
</body>
</html>