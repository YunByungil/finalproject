<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 스케줄 등록</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
function dayChoice4() {
	$.ajax({
		url: "dayChoice2.do?day="+$('#day').val()+"&theater="+$('#theater').val(),
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
</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<div class="mainBox">
<div class="div_title"><h2 class="title">| 상영 스케줄 등록</h2></div>
<form action="scheduleAdd.do"> 
<div class="table_wrap">
<table class="main_table">
<tr>
	<th class="th_basic">상영 날짜</th>
	<td colspan="3" class="td_basic">
	<input type="date" name="day" id="day" class="input_text_director" min="${nDate }">
	<input type="button" value="날짜 선택" class="button_sub" onclick="dayChoice4();">
	</td>
</tr>
<tr>
	<th class="th_basic">상영관 선택</th>
	<td class="td_basic"><select name="theater" id="theater">
			<c:forEach var="i" items="${tList }">
				<option value="${i }">${i }관</option>
			</c:forEach>
		</select>
	</td>
</tr>
</table>
</div>
</form>
</div>
<div id="seat"></div>
</body>
</html>