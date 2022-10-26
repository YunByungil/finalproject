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
</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<div class="mainBox">
<div class="div_title"><h2 class="title">| 이벤트 관리 / 이벤트 등록</h2></div>
<form:form modelAttribute="eo" name="addEventForm" action="addEvent.do" method="post"  enctype="multipart/form-data">
<div class="table_wrap">
<table class="main_table">
<tr>
	<th class="th_basic">이벤트 유형</th>
	<td class="td_basic">
		<form:select path="eve_category" name="eve_category">
			 <c:forEach var="cate" items="${cateList}">
 				  <option value="${cate}"> ${cate}</option>
  			 </c:forEach>
		</form:select><br>
		<form:errors path="eve_category" class="error_span"/>
	</td>
</tr>
<tr>
	<th class="th_basic">이벤트 제목</th>
	<td colspan="3" class="td_basic">
	<form:input path="eve_subject" type="text" name="eve_subject" class="input_text_basic" placeholder="이벤트 제목을 입력해주세요."/>
	<form:errors path="eve_subject" class="error_span"/>
	</td>
</tr>
<tr>
	<th class="th_last">썸네일 이미지 첨부</th>
	<td class="td_last"><input type="file" name="event_thumb_img" accept=".jpg,.jpeg,.png,.gif,.pdf" required><span class="caution fl_r"> 파일형식 : jpg / jpeg / png / gif / pdf (5MB X 1개)</span></td>
</tr>
<tr>
	<th class="th_last">메인 이미지 첨부</th>
	<td class="td_last"><input type="file" name="event_main_img" accept=".jpg,.jpeg,.png,.gif,.pdf" required><span class="caution fl_r"> 파일형식 : jpg / jpeg / png /  gif / pdf (5MB X 1개)</span></td>
</tr>
<tr>
	<th class="th_basic">이벤트 기간</th>
	<td class="td_basic"><input type="date" name="eve_start_date" class="input_date_box" required> - <input type="date" name="eve_end_date" class="input_date_box" required></td>
</tr> 
</table>
</div>
	<div class="btn_wrap"><input type="button" value="돌아가기" class="button_sub"><input type="submit" value="이벤트 등록" class="button_main"></div>
</form:form>
</div>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>