<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Apache POI 예제 02. 엑셀 다루기</title>
<%@ include file="/WEB-INF/views/include/source.jsp" %>
<script>
$(document).ready(function() {
	
});
</script>
</head>
<body>
<div class="container">
	<div class="row border-bottom mb-3">
		<div class="col-12">
			<p class="h1">EX02. Apache POI Excel 데이터 읽기 결과</p>
		</div>
	</div>
	
	<div class="row">	
		<div class="col-4">				
			<table class="table table-hover">
				<thead>
					<tr>
				    	<th>NAME</th>
				      	<th>AGE</th>
				      	<th>Dept</th>				      	
				    </tr>
				</thead>
				<tbody>
				<c:forEach var="parentList" items="${list}"> 				
					<tr>
						<c:forEach items="${parentList }" var="childList">
				    		<td>${childList }</td>				      		
				    	</c:forEach>
				    </tr>
				</c:forEach>				    
				</tbody>
			</table>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/bottom.jsp" %>
</body>
</html>