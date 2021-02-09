<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Apache POI Example</title>
<%@ include file="/WEB-INF/views/include/source.jsp" %>
<script>
$(document).ready(function() {
	
});
</script>
</head>
<body>
<form id="testForm" action="/apachepoi/readExcel.do" method="post" enctype="multipart/form-data">
	<div class="container">
		<div class="row border-bottom mb-3">
			<div class="col-12">
				<p class="h1">EX02. Apache POI Excel 데이터 읽기(서버단)</p>
			</div>
		</div>
		
		<div class="row">
			<div class="col-6">
				<button type="submit" class="btn btn-primary">실행</button>
			</div>			
		</div>
	</div>
	
	<%@ include file="/WEB-INF/views/common/bottom.jsp" %>
</form>
</body>
</html>