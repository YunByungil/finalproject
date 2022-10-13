<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie_detail.css">
<script>
function deleteMovie(didx){
	   var delQue = window.confirm('삭제한 영화정보는 복구할 수 없습니다. 정말 삭제하시겠습니까?');
	   	if(!delQue){ return; } 
	   window.location.href = 'deleteMovie.do?mov_idx='+didx;
	}
</script>
</head>
<body>
<c:import url="../../header.jsp"></c:import>
<c:if test="${empty dto}">
			<div>이미 삭제된 게시글이거나 잘못된 접근입니다.</div>
</c:if>
<div class="mainBox">
<div class="div_title"><h2 class="title">| 영화 관리 / 영화 상세 정보</h2></div>

<div class="poster_box">
	<img src="/movieJoa/img/movie_poster/${dto.mov_poster }" class="detail_img">
</div>
<div class="table_box">
<table class="main_table_detail">
<tr>
	<th class="th_basic">영화 코드</th>
	<td class="td_basic"> ${dto.mov_idx } </td>
</tr>
<tr>
	<th class="th_basic">영화 제목</th>
	<td colspan="3" class="td_basic"> ${dto.mov_title } </td>
</tr>
<tr>
	<th class="th_basic">감독</th>
	<td class="td_basic"> ${dto.mov_director } </td>
</tr>
<tr>
	<th class="th_basic">출연 정보</th>
	<td class="td_basic"> ${dto.mov_cast } </td>
</tr>
<tr>
	<th class="th_basic">상영 활성 기간</th>
	<td class="td_basic"> ${dto.mov_start_date } - ${dto.mov_end_date }</td>
</tr>
<tr>
	<th class="th_basic">국가</th>
	<td class="td_basic"> ${dto.mov_country } </td>
</tr>
<tr>
	<th class="th_basic">장르</th>
	<td class="td_basic"> ${dto.mov_genre } </td>
</tr>
<tr>
	<th class="th_basic">상영시간</th>
	<td class="td_basic"> ${dto.mov_running_time } </td>
</tr>
<tr>
	<th class="th_basic">관람 등급</th>
	<td class="td_basic"> ${dto.mov_rate } </td>
</tr>
<tr>
	<th class="th_last">영화 소개</th>
	<td class="td_last"> ${dto.mov_info } </td>
</tr>
</table>
</div>
<c:url var="uLink" value="updateMovieForm.do">
		<c:param name="mov_idx">${dto.mov_idx }</c:param>
</c:url>
<c:url var="didx" value="deleteMovieForm.do">
</c:url>
<div class="btn_wrap">
<input type="button" value="영화 삭제" class="button_main" onclick="javascript:deleteMovie(${dto.mov_idx });">
<input type="button" value="영화 수정" class="button_main" onclick="location.href='${uLink}'"></div>
<div class="bottom_div">
<a href="#" class="fl_r"> 목록으로 </a>
</div>
</div>

<c:import url="../../footer.jsp"></c:import>
</body>
</html>