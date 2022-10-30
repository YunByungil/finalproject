<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 등록</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link rel="stylesheet" type="text/css" href="css/adminEvent.css">
<script>
	window.alert('${msg}');
</script>
</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<div class="mainBox">
<div class="div_title"><h2 class="title">| 이벤트 당첨자 게시글 작성</h2></div>
<form name="E_B_FM" action="E_B_insert.do">
<div class="table_wrap">
	<input type="hidden" name="e_b_members" value="${members }">
	<input type="hidden" name="e_b_eventcode" value="${app_event_code }">
	<div>제목 | <input type="text" name="e_b_subject"></div>
	<div>이벤트 상세설명 | <textarea rows="50" cols="50" name="e_b_content"></textarea></div>

</div>
	<div class="btn_wrap"><input type="button" value="돌아가기" class="button_sub"><input type="submit" value="게시글 등록" class="button_main"></div>
</form>
</div>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>