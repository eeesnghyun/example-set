<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Apache POI Example</title>
<%@ include file="/WEB-INF/views/include/source.jsp" %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.15.5/xlsx.full.min.js"></script>
<script>
function readExcel() {		
 	var result;
	var reader = new FileReader();
 
 	reader.onload = function () {
		var data = reader.result;
    	var workBook = XLSX.read(data, { type: 'binary' });
     
     	workBook.SheetNames.forEach(function (sheetName) {        	    
        	result = XLSX.utils.sheet_to_json(workBook.Sheets[sheetName]);
        	
        	console.log(result);
        	console.log(JSON.stringify(result));
    	})
    	
    	createTable(result);
 	};
 
 	reader.readAsBinaryString($("#testFile")[0].files[0]); 	
}

function createTable(result) {
	var html = "";
	
	for(var i=0; i<result.length; i++) {
		html += "<tr>";
		html += "	<td>" + result[i].name + "</td>";
		html += "	<td>" + result[i].age + "</td>";
		html += "	<td>" + result[i].dept + "</td>";
		html += "</tr>";
	}
	
	$("#dataList").append(html);
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
				<p class="h1">EX03. Apache POI Excel 데이터 읽기(클라이언트단)</p>
			</div>
		</div>
		
		<div class="row">	
			<div class="col-4">				
				<label for="testFile" class="form-label"></label>
  				<input class="form-control form-control-sm" id="testFile" name="testFile" type="file">  				  					
			</div>			
			<div class="mt-2">
				<button type="button" class="btn btn-primary" onclick="readExcel()">실행</button>
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
					<tbody id="dataList"></tbody>
				</table>
			</div>
		</div>
	</div>
	
	<%@ include file="/WEB-INF/views/common/bottom.jsp" %>
</form>
</body>
</html>