<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 스케줄 등록</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie.css">
</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<div class="mainBox">
<div class="div_title"><h2 class="title">| 상영 스케줄 등록</h2></div>
<form name="addProductForm" action="scheduleAdd.do"> 
<div class="table_wrap">
<table class="main_table">
<tr>
	<th class="th_basic">상영 날짜</th>
	<td colspan="3" class="td_basic"><input type="date" name="day" class="input_text_director" min="${nDate }"></td>
</tr>
<tr>
	<th class="th_basic">영화 선택</th>
	<td class="td_basic"><select name="mov_title">
		<option value="combo">영화제목</option>
		<option value="popcorn">팝콘</option>
		<option value="drink">음료</option>
		<option value="snack">스낵</option>
		</select>
	</td>
</tr>
<tr>
	<th class="th_basic">상영시간</th>
	<td class="td_basic"><input type="time" name="start_time" class="input_text_director"></td>
</tr>
<tr>
	<th class="th_basic">상영관 선택</th>
	<td class="td_basic"><select name="theater">
		<option value="combo">1관</option>
		<option value="popcorn">팝콘</option>
		<option value="drink">음료</option>
		<option value="snack">스낵</option>
		</select>
	</td>
</tr>
</table>
</div>
	<div class="btn_wrap"><input type="button" value="돌아가기" class="button_sub"><input type="submit" value="상품 등록" class="button_main"></div>
</form>
</div>
</body>
</html>