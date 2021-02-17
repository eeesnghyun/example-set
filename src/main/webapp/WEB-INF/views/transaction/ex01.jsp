<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Spring Transaction Example</title>
<%@ include file="/WEB-INF/views/include/source.jsp" %>
<script>
function testTransaction() {
	var params = {
			testno   : $("#testno").val(),
			testname : $("#testname").val()
	};

	$.ajax({
        type       : "POST",
        async      : false,
        url        : "/transaction/testTransaction.do",
        cache      : false,
        dataType   : "json",
        data       : JSON.stringify(params),
        contentType: "application/json; charset=utf-8",
        success: function(data) {
        	var msg = data.msg;

        	$("#result").html(msg);
        },
		error : function(request, status, error) {
			alert("code : " + request.status + "\n" + "message : " + request.responseText + "\n" + "error : " + error);
		}
	});
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
				<p class="h1">1. 선언적 트랜잭션</p>
			</div>
		</div>

		<div class="row">
			<div class="col-4">
				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">TESTNO</span>
				  	<input type="text" class="form-control" id="testno" name="testno">
				</div>
				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">TESTNAME</span>
				  	<input type="text" class="form-control" id="testname" name="testname">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-4">
				<button type="button" class="btn btn-primary mb-3" onclick="testTransaction()">전송</button>
			</div>
		</div>

		<div class="row">
			<div class="col-auto">
				결과 : <span id="result"></span>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/common/bottom.jsp" %>
</form>
</body>
</html>