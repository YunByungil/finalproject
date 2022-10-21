<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 상세 정보</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie.css">
<link rel="stylesheet" type="text/css" href="css/adminEvent.css">
<script>
function deleteEvent(didx){
	   var delQue = window.confirm('삭제한 이벤트정보는 복구할 수 없습니다. 정말 삭제하시겠습니까?');
	   	if(!delQue){ return; } 
	   window.location.href = 'deleteEvent.do?eve_idx='+didx;
	}
</script>
</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<c:if test="${empty dto}">
			<div>이미 삭제되었거나 잘못된 접근입니다.</div>
</c:if>
<div class="mainBox">
<div class="div_title"><h2 class="title">| 이벤트 관리 / 이벤트 상세 정보</h2></div>
<div class="eve_img_box">
	<img src="/movieJoa/img/joaEvent_img/${dto.eve_thumb_img }" class="eve_detail_img">
</div>
<div class="eve_table_box">
<table class="eve_main_table_detail">
<tr>
	<th class="th_basic">이벤트 코드</th>
	<td class="td_basic"> ${dto.eve_idx } </td>
</tr>
<tr>
	<th class="th_basic">이벤트 유형</th>
	<td class="td_basic"> ${dto.eve_category } </td>
</tr>
<tr>
	<th class="th_basic">이벤트 제목</th>
	<td colspan="3" class="td_basic"> ${dto.eve_subject } </td>
</tr>
<tr>
	<th class="th_basic">이벤트 기간</th>
	<td class="td_basic"> ${dto.eve_start_date } - ${dto.eve_end_date }</td>
</tr>
</table>
</div>
<c:url var="uLink" value="updateEventForm.do">
		<c:param name="eve_idx">${dto.eve_idx }</c:param>
</c:url>
<c:url var="didx" value="deleteEventForm.do">
</c:url>
<div class="btn_wrap">
<input type="button" value="이벤트 삭제" class="button_main" onclick="javascript:deleteEvent(${dto.eve_idx });">
<input type="button" value="이벤트 수정" class="button_main" onclick="location.href='${uLink}'"></div>
<div class="eve_bottom_div">
<a href="#" class="fl_r"> 목록으로 </a>
</div>
</div>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>