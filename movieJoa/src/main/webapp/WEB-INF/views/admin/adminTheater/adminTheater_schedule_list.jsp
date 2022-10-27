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
	location.href='scheduleListView.do?day='+$('#day').val();
}
</script>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie_list.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
</div>
</div>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>