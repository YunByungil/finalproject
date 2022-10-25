<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
function scheduleSubmit() {
	var date='${day}';
	$.ajax({
		url: "scheduleAdd.do?sch_day="+date+"&sch_theater="+${theater}+"&start_time="+$('#start_time').val()+"&sch_mov_title="+$('#mov_title').val(),
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
</head>
<body>
<div class="mainBox">
<form action="scheduleAdd.do"> 
<div class="table_wrap">
<table class="main_table">
<tr>
	<th class="th_basic">영화 선택</th>
	<td class="td_basic">
		<select name="mov_title" id="mov_title">
		<c:if test="${not empty list}">
			<c:forEach var="i" items="${list }">
				<option value="${i }">${i }</option>
			</c:forEach>
		</c:if>
		<c:if test="${ empty list}">
			<option value="---">-----</option>
		</c:if>
		</select>
	</td>
</tr>
<tr>
	<th class="th_basic">상영시간</th>
	<td class="td_basic"><input type="time" name="start_time" id="start_time" class="input_text_director"></td>
</tr>
</table>
</div>
	<div class="btn_wrap"><input type="button" value="돌아가기" class="button_sub"><input type="button" value="상품 등록" class="button_main" onclick="scheduleSubmit();"></div>
</form>
</div>
</body>
</html>