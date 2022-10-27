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
<link rel="stylesheet" type="text/css" href="css/adminMovie_list.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
function scheduleDelete(idx){
	if(window.confirm('정말 스케줄 삭제를 하시겠습까?')){
		location.href='scheduleDelete.do?sch_idx='+idx;
	}else{
		window.alert('최소되었습니다.');
	}
}
function dayCho() {
	location.href='scheduleListView.do?day='+$('#day').val();
}
</script>
<style>
td{
	text-align:center;
}
</style>
</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<div class="mainBox">
<div class="div_title"><h2 class="title">| 상영 스케줄 목록</h2></div>
<div class="table_wrap_list">
<fieldset class="search_wrap">
<input type="date" name="day" id="day" class="input_text_director" value="${day }">
<input type="button" value="날짜 선택" class="button_sub" onclick="dayCho();">
</fieldset>
<c:if test="${not empty list }">
<table class="main_table_list">
	<thead>
		<tr>
			<th>영화제목</th>
			<th>상영관</th>
			<th>상영날짜</th>
			<th>상영시간</th>
			<th>관리</th>
		</tr>
	</thead>
	<tfoot>
		<tr>
			<td colspan="4" align="center">${pageStr }</td>
			<td><a href="scheduleAddForm.do">스케줄 등록</a></td>
		</tr>
	</tfoot>
	<tbody>
		<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.sch_mov_title }</td>
			<td>${dto.sch_theater }</td>
			<td>${dto.sch_day }</td>
			<td>${dto.sch_start_hour }:${dto.sch_start_min }~${dto.sch_end_hour }:${dto.sch_end_min }</td>
			<td><input type="button" value="스케줄 삭제" onclick="scheduleDelete(${dto.sch_idx})" class="list_s_btn"></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</c:if>
<c:if test="${empty list }">
	<h3>등록된 스케줄이 없습니다.</h3>
	<a href="scheduleAddForm.do">스케줄 등록</a>
</c:if>
</div>
</div>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>