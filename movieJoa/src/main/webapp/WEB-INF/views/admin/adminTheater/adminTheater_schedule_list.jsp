<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
function dayCho() {
	$.ajax({
		url: "scheduleListView.do?day="+$('#day').val(),
		type: "GET",
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
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<input type="date" name="day" id="day" class="input_text_director" min="${nDate }">
<input type="button" value="날짜 선택" class="button_sub" onclick="dayCho();">
<div id="seat"></div>
</body>
</html>