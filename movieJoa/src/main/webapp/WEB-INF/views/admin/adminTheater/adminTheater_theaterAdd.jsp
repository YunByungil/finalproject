<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<form action="theaterAdd.do" method="post">
<table>
	<tr>
		<th>몇 관인가요</th>
		<td><input type="text" name="theater"></td>
	</tr>
</table>
<hr>
<table>
	<tr>
		<td>
		가로 : <input type="text" name="width" id="width">
		세로 : <input type="text" name="height" id="height">
		<input type="button" value="자리선택" onclick="movieSeat();">
		</td>
	</tr>
</table>
</form>
<div id="seat"></div>
</body>
<script>
function movieSeat() {
	$.ajax({
		url: "theaterAdd.do?width="+$('#width').val()+"&height="+$('#height').val()+"&theater="+$('#theater').val(),
		type: "get",
		dataType: "html",
		success: function(data) {
			$('#seat').html(data);
		},
		error: function(){
			alert('다시 시도 바람');
		}
	});
};
</script>
</html>