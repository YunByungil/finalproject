<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록된 쿠폰 목록</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/adminCoupon.css">
</head>
<body>
<c:import url="../../header.jsp"></c:import>
<div class="mainBox">
<div class="div_title"><h2 class="title">| 쿠폰 관리 / 쿠폰 목록</h2></div>
<div class="table_wrap_list">
<fieldset class="search_wrap">
	<form>
		<select name="sc_t">
			<option value="식별번호" selected>식별번호</option>
			<option value="쿠폰명">쿠폰명</option>
		</select>
		<input type="text" name="sc_k" class="input_text_search" placeholder="검색어를 입력해주세요.">
		<button type="submit" class="button_main">검색</button>
	</form>
</fieldset>
<table class="main_table_list">
<colgroup>
	<col style="width:20%">
	<col style="wldth:35%">
	<col style="width:25%">
	<col style="width:20%">
</colgroup>
<thead>
<tr>
	<th scope="col" class="text_c">식별코드</th>
	<th scope="col" class="text_c">쿠폰명</th>
	<th scope="col" class="text_c">할인금액</th>
	<th scope="col" class="text_c">관리</th>
</tr>
</thead>
	<c:if test="${empty movieList}">
		<tr>
			<td>등록되어있는 쿠폰이 존재하지 않습니다.</td>
		</tr>
	</c:if>
<tbody>
<c:forEach var="dto" items="${couponList }">
<tr>
	<td class="text_c">${dto.cou_idx }</td>
	<td class="text_c">${dto.cou_name }</td>
	<td class="text_c">${dto.cou_discount }</td>
	<c:url var="uLink" value="updateMovieForm.do">
		<c:param name="mov_idx">${dto.mov_idx }</c:param>
	</c:url>
	<td class="text_c">
	<input type="button" value="삭제" onclick="javascript:deleteMovie(${dto.cou_idx });" class="list_s_btn">
	</td>
</tr>
</c:forEach>
</tbody>

<tfoot>
	<tr>
	<td colspan="5" align="center">
	${pageStr }
	</td>
	<td colspan="1"><a href="addMovieForm.do">새 영화 등록</a></td>
	</tr>
</tfoot>
</table>
</div>
</div>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>