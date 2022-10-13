<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 상품등록</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie.css">
</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<div class="mainBox">
<div class="div_title"><h2 class="title">| 상품등록</h2></div>
<form name="addProductForm" action="addProduct.do" method="post" enctype="multipart/form-data"> 
<div class="table_wrap">
<table class="main_table">
<tr>
	<th class="th_basic">상품명</th>
	<td colspan="3" class="td_basic"><input type="text" name="pro_name" class="input_text_title" placeholder="상품명을 입력해주세요."></td>
</tr>
<tr>
	<th class="th_basic">가격</th>
	<td class="td_basic"><input type="text" name="pro_price" class="input_text_director" placeholder="5,000"></td>
</tr>
<tr>
	<th class="th_basic">상품종류</th>
	<td class="td_basic"><select name="pro_category">
		<option value="combo">콤보</option>
		<option value="popcorn">팝콘</option>
		<option value="drink">음료</option>
		<option value="snack">스낵</option>
		</select>
	</td>
</tr>
<tr>
	<th class="th_basic">상품 소개</th>
	<td class="td_basic"><textarea rows="10" cols="45" name="pro_info" placeholder="상품소개를 입력해주세요."></textarea></td>
</tr>
<tr>
	<th class="th_last">사진</th>
	<td class="td_last"><input type="file" name="filename"><span class="caution fl_r"> 파일형식 : jpg / jpeg / png / bmp / gif / pdf (5MB X 1개)</span></td>
</tr>
</table>
</div>
	<div class="btn_wrap"><input type="button" value="돌아가기" class="button_sub"><input type="submit" value="상품 등록" class="button_main"></div>
</form>
</div>
</body>
</html>