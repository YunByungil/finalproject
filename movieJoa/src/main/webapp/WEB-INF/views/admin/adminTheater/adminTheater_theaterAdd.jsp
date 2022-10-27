<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
text {
	width:100px;
}
</style>
</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<div class="mainBox">
<div class="div_title"><h2 class="title">| 상영 스케줄 등록</h2></div>
<div class="table_wrap">
<table class="main_table">
	<tr>
		<th class="th_basic">상영관 입력</th>
		<td class="td_basic"><input type="text" id="theater" class="input_text_director"></td>
	</tr>
	<tr>
		<th class="th_basic">가로</th>
		<td class="td_basic">
			<input type="text" name="width" id="width" class="input_text_director">
		</td>
		<th class="th_basic">세로</th>
		<td class="td_basic"><input type="text" name="height" id="height" class="input_text_director" style="width:70px;"></td>
		<td class="td_basic"><input type="button" value="좌석 선택" onclick="movieSeatCreate();" class="button_sub"></td>
	</tr>
</table>
</div>
</div>
<div id="seat"></div>
<c:import url="../../footer.jsp"></c:import>
</body>
<script>
function movieSeatCreate() {
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