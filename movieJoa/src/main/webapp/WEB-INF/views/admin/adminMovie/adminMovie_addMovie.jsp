<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie.css">
<script type="text/javascript" src="js/adminMovieValidation.js"></script>
</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<div class="mainBox">
<div class="div_title"><h2 class="title">| 영화 관리 / 영화 등록</h2></div>
<form:form modelAttribute="vo" name="addMovieForm" action="addMovie.do" method="post" enctype="multipart/form-data" onsubmit="return addMovieSubmitCheck();">
<div class="table_wrap">
<table class="main_table">
<tr>
	<th class="th_basic">영화 제목</th>
	<td colspan="3" class="td_basic">
			<form:input path="mov_title" type="text" name="mov_title" class="input_text_title" placeholder="영화 제목을 입력해주세요"/>
			<br><form:errors path="mov_title" class="error_span"/>
	</td>
<tr>
	<th class="th_basic">감독</th>
	<td class="td_basic">
			<form:input path="mov_director" type="text" name="mov_director" class="input_text_director" placeholder="감독명"/>
			<br><form:errors path="mov_director" class="error_span"/>
	</td>
</tr>
<tr>
	<th class="th_basic">출연 정보</th>
	<td class="td_basic">
		<form:input path="mov_cast" type="text" name="mov_cast" class="input_text_cast" placeholder="출연진 정보"/>
		<br><form:errors path="mov_cast" class="error_span"/>
	</td>
</tr>
<tr>
	<th class="th_basic">상영 활성 기간</th>
	<td class="td_basic">
		<input name="mov_start_date" type="date" class="input_date_box" required/> - <input name="mov_end_date" type="date" class="input_date_box" required/>  
	</td>
</tr> 
<tr>
	<th class="th_basic">국가</th>
	<td class="td_basic">
		<form:input type="text" path="mov_country" class="input_text_basic" placeholder="개봉 국가명"/>
		<br><form:errors path="mov_country" class="error_span"/>
	</td>
</tr>
<tr>
	<th class="th_basic">장르</th>
	<td class="td_basic">
		<form:input type="text" path="mov_genre" class="input_text_basic" placeholder="영화 장르"/>
		<br><form:errors path="mov_genre" class="error_span"/>
	</td>
</tr>
<tr>
	<th class="th_basic">상영 시간</th>
	<td class="td_basic"><div class="time_div">
		<form:input type="text" path="mov_running_time" id="mrt" class="input_text_basic" placeholder="총 상영시간" onkeyup="addMovieNumberCheck();"/> 분<form:errors path="mov_running_time" class="error_span"/> <span id="ersp" class="error_span_general"></span><span class="caution fl_r">분 단위로 입력해주세요.</span></div>
	
</tr>
<tr>
	<th class="th_basic">관람 등급</th>
	<td class="td_basic">
		<form:select path="mov_rate" name="mov_rate">
			 <c:forEach var="menu" items="${rateList}">
 				  <option value="${menu}"> ${menu}</option>
  			 </c:forEach>
		</form:select>
		<br><form:errors path="mov_rate" class="error_span"/>
	</td>
</tr>
<tr>
	<th class="th_basic">영화 소개</th>
	<td class="td_basic">
		<form:textarea rows="10" cols="45" path="mov_info" placeholder="주요 정보를 입력해주세요"></form:textarea>
		<br><form:errors path="mov_info" class="error_span"/> 
	</td>
</tr>
<tr>
	<th class="th_last">포스터</th>
	<td class="td_last"><input type="file" name="poster" accept=".jpg,.jpeg,.png,.gif,.pdf" required/>
	<span class="caution fl_r"> 파일형식 : jpg / jpeg / png / gif / pdf (5MB X 1개)</span>
		<br><form:errors path="mov_poster" class="error_span"/>
	</td>
</tr>
</table>
</div>
	<div class="btn_wrap"><input type="button" value="돌아가기" class="button_sub"><input type="submit" value="영화 등록" class="button_main"></div>
</form:form>
</div>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>