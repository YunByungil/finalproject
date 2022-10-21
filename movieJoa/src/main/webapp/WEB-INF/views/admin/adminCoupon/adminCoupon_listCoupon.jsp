<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록된 쿠폰 목록</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link rel="stylesheet" type="text/css" href="css/adminCoupon.css">
<script>
function deleteCoupon(didx){
	   var delQue = window.confirm('삭제한 쿠폰정보는 복구할 수 없으며, 쿠폰을 보유한 회원에게도 정보가 삭제됩니다. 정말 삭제하시겠습니까?');
	   	if(!delQue){return;} 
	   window.location.href = 'deleteCoupon.do?cou_idx='+didx;
	}
</script>
</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<div class="mainBox">
<div class="div_title"><h2 class="title">| 쿠폰 관리 / 쿠폰 목록</h2></div>
<div class="table_wrap_list">
<fieldset class="search_wrap">
	<form action="searchCoupon.do">
		<select name="s_k">
			<option value="all" <c:if test="${s_k eq 'all'}">selected</c:if>>전체</option>
			<option value="cou_idx" <c:if test="${s_k eq 'cou_idx'}">selected</c:if>>식별번호</option>
			<option value="cou_name" <c:if test="${s_k eq 'cou_name'}">selected</c:if>>쿠폰명</option>
		</select>
		<input type="text" name="s_v" class="input_text_search" placeholder="검색어를 입력해주세요." <c:if test="${s_v ne '--'}">value="${s_v }"</c:if>>
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
	<c:if test="${empty couponList}">
		<tr>
			<td>등록되어있는 쿠폰이 존재하지 않습니다.</td>
		</tr>
	</c:if>
<tbody>
<c:forEach var="dto" items="${couponList }">
<tr>
	<td class="text_c">${dto.cou_idx }</td>
	<td class="text_c">${dto.cou_name }</td>
	<td class="text_c">${dto.cou_discount } 원</td>
	<c:url var="uLink" value="updateCouponForm.do">
		<c:param name="cou_idx">${dto.cou_idx }</c:param>
	</c:url>
	<td class="text_c">
	<input type="button" value="삭제" onclick="javascript:deleteCoupon(${dto.cou_idx });" class="list_s_btn">
	</td>
</tr>
</c:forEach>
</tbody>

<tfoot>
	<tr>
	<td colspan="3" align="center">
	${pageStr }
	</td>
	<td colspan="1"><a href="addCouponForm.do">새 쿠폰 등록</a></td>
	</tr>
</tfoot>
</table>
</div>
</div>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>