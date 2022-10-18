<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie.css">
</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<div class="mainBox">
<div class="div_title"><h2 class="title">| 영화 관리 / 영화 등록</h2></div>
<form name="addMovieForm" action="addMovie.do" method="post"  enctype="multipart/form-data">
<div class="table_wrap">
<table class="main_table">
<tr>
	<th class="th_basic">영화 제목</th>
	<td colspan="3" class="td_basic"><input type="text" name="mov_title" class="input_text_title" placeholder="영화 제목을 입력해주세요"></td>
</tr>
<tr>
	<th class="th_basic">감독</th>
	<td class="td_basic"><input type="text" name="mov_director" class="input_text_director" placeholder="감독명"></td>
</tr>
<tr>
	<th class="th_basic">출연 정보</th>
	<td class="td_basic"><input type="text" name="mov_cast" class="input_text_cast" placeholder="출연진 정보"></td>
</tr>
<tr>
	<th class="th_basic">상영 활성 기간</th>
	<td class="td_basic"><input type="date" name="mov_start_date" class="input_date_box"> - <input type="date" name="mov_end_date" class="input_date_box" ></td>
</tr> 
<tr>
	<th class="th_basic">국가</th>
	<td class="td_basic"><input type="text" name="mov_country" class="input_text_basic" placeholder="개봉 국가명"></td>
</tr>
<tr>
	<th class="th_basic">장르</th>
	<td class="td_basic"><input type="text" name="mov_genre" class="input_text_basic" placeholder="영화 장르"></td>
</tr>
<tr>
	<th class="th_basic">상영시간</th>
	<td class="td_basic"><div class="time_div"><input type="text" name="mov_running_time" class="input_text_basic" placeholder="총 상영시간"> 분 <span class="caution fl_r">분 단위로 입력해주세요.</span> </div></td>
</tr>
<tr>
	<th class="th_basic">관람 등급</th>
	<td class="td_basic">
		<select name="mov_rate">
			 <c:forEach var="menu" items="${rateList}">
 				  <option value="${menu}"> ${menu}</option>
  			 </c:forEach>
		</select>
	</td>
</tr>
<tr>
	<th class="th_basic">영화 소개</th>
	<td class="td_basic"><textarea rows="10" cols="45" name="mov_info" placeholder="주요 정보를 입력해주세요"></textarea></td>
</tr>
<!-- <tr>
	<th class="th_last">포스터</th>
	<td class="td_last"><div class="bx_file "><input type="file" id="file" name="mov_poster"><label class="" for="file">파일선택</label><div class="file_item"><span class="" id="iDfileUpload1"></span><button class="btn_del">삭제</button></div></div><span class="caution fl_r"> 파일형식 : jpg / jpeg / png / bmp / gif / pdf (5MB X 1개)</span></td>
</tr>  -->
<tr>
	<th class="th_last">포스터</th>
	<td class="td_last"><input type="file" name="poster"><span class="caution fl_r"> 파일형식 : jpg / jpeg / png / bmp / gif / pdf (5MB X 1개)</span></td>
</tr>
</table>
</div>
	<div class="btn_wrap"><input type="button" value="돌아가기" class="button_sub"><input type="submit" value="영화 등록" class="button_main"></div>
</form>
</div>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>