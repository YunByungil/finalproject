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
</head>
<body>
<c:import url="../../header.jsp"></c:import>



<div class="mainBox">
<div class="div_title"><h2 class="title">| 영화 관리 / 영화 상세 정보</h2></div>

<div class="poster_box">
	<img src="/movieJoa/img/movie_poster/josseAndTiger.jpg" class="detail_img">
</div>
<div class="table_box">
<table class="main_table_detail">
<tr>
	<th class="th_basic">영화 코드</th>
	<td class="td_basic"> ex) 2938 </td>
</tr>
<tr>
	<th class="th_basic">영화 제목</th>
	<td colspan="3" class="td_basic"></td>
</tr>
<tr>
	<th class="th_basic">감독</th>
	<td class="td_basic"></td>
</tr>
<tr>
	<th class="th_basic">출연 정보</th>
	<td class="td_basic"></td>
</tr>
<tr>
	<th class="th_basic">개봉일</th>
	<td class="td_basic"></td>
</tr>
<tr>
	<th class="th_basic">예매 활성 기간</th>
	<td class="td_basic"></td>
</tr>
<tr>
	<th class="th_basic">국가</th>
	<td class="td_basic"></td>
</tr>
<tr>
	<th class="th_basic">장르</th>
	<td class="td_basic"></td>
</tr>
<tr>
	<th class="th_basic">상영시간</th>
	<td class="td_basic"></td>
</tr>
<tr>
	<th class="th_basic">관람 등급</th>
	<td class="td_basic"></td>
</tr>
<tr>
	<th class="th_last">영화 소개</th>
	<td class="td_last"></td>
</tr>
</table>
</div>

<div class="btn_wrap"><input type="button" value="영화 삭제" class="button_main"><input type="button" value="영화 수정" class="button_main"></div>
<div class="bottom_div">
<a href="#" class="fl_r"> 목록으로 </a>
</div>
</div>

<c:import url="../../footer.jsp"></c:import>
</body>
</html>