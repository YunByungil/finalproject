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
	function nullCheck(){
		if(!document.getelementbyname('app_event_code').value){
			window.alert('코드를 입력해주세요.');
			return false;
		}if(!document.getelementbyname('member_count').value){
			window.alert('얼마나 추출하실건지 입력해주세요.');
			return false;
		}
	}
</script>
</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<div class="mainBox">
<div class="div_title"><h2 class="title">| 이벤트 당첨자 추출</h2></div>
<form name="luck_mem_FM" action="luck_mem_extraction.do" onsubmit="return nullCheck();">
<div class="table_wrap">
	<div>이벤트 코드를 입력해주세요.</div>
	<div><input type="text" name="app_event_code"></div>
	<div><input type="text" name="member_count"></div>
	<div><input type="submit" value="입력하기"></div>
</div>
	<div class="btn_wrap"><input type="button" value="돌아가기" class="button_sub"><input type="submit" value="이벤트 등록" class="button_main"></div>
</form>
</div>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>