<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 수정</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link rel="stylesheet" type="text/css" href="css/adminEvent.css">
</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<div class="mainBox">
<div class="div_title"><h2 class="title">| 이벤트 관리 / 이벤트 수정</h2></div>
<form name="updateEventForm" method="post" action="updateEvent.do" enctype="multipart/form-data">
<div class="table_wrap">
<table class="main_table">
<tr>
	<th class="th_basic">이벤트 코드</th>
	<td class="td_basic"> ${dto.eve_idx }
	<input type="hidden" name="eve_idx" value="${dto.eve_idx }"></td>
</tr>
<tr>
	<th class="th_basic">이벤트 유형</th>
	<td class="td_basic">
		<select name="eve_category">
			 <c:forEach var="cate" items="${cateList}">
 				  <option value="${cate}"
 	  				 <c:if test ="${dto.eve_category eq cate}">selected="selected"</c:if> 
 	  				> ${cate}</option>
  			 </c:forEach>
		</select>
	</td>
</tr>
<tr>
	<th class="th_basic">이벤트 제목</th>
	<td colspan="3" class="td_basic"><input type="text" name="eve_subject" class="input_text_basic" placeholder="이벤트 제목을 입력해주세요" value="${dto.eve_subject }"></td>
</tr>
<tr>
	<th class="th_last">메인 이미지 첨부</th>
	<td class="td_last"><input type="file" name="event_main_img"><span class="caution fl_r"> 파일형식 : jpg / jpeg / png / bmp / gif / pdf (5MB X 1개)</span></td>
</tr>
<tr>
	<th class="th_last">썸네일 이미지 첨부</th>
	<td class="td_last"><input type="file" name="event_thumb_img"><span class="caution fl_r"> 파일형식 : jpg / jpeg / png / bmp / gif / pdf (5MB X 1개)</span></td>
</tr>
<tr>
	<th class="th_basic">이벤트 기간</th>
	<td class="td_basic"><input type="date" name="eve_start_date" class="input_date_box"> - <input type="date" name="eve_end_date" class="input_date_box"></td>
</tr>
</table>
</div>
	<div class="btn_wrap"><input type="button" value="돌아가기" class="button_sub"><input type="submit" value="이벤트 수정" class="button_main"></div>
</form>
</div>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>