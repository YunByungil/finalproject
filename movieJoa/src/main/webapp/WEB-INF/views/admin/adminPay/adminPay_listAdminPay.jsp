<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예매 현황 조회</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link rel="stylesheet" type="text/css" href="css/adminCoupon.css">
<script>
function deleteAdminPay(didx){
	   var delQue = window.confirm('삭제한 예매 정보는 복구할 수 없습니다. 정말 삭제하시겠습니까?');
	   	if(!delQue){return;} 
	   window.location.href = 'deleteAdminPay.do?payMov_idx='+didx;
	}
</script>
</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<div class="mainBox">
<div class="div_title"><h2 class="title">|  예매 현황 관리 / 예매 현황</h2></div>
<div class="table_wrap_list">
<fieldset class="search_wrap">
	<form action="/movieJoa/searchAdminPay.do">
		<select name="s_k">
			<option value="all" <c:if test="${s_k eq 'all'}">selected</c:if>>전체</option>
			<option value="payMov_merchant_uid" <c:if test="${s_k eq 'payMov_merchant_uid'}">selected</c:if>>예매번호</option>
			<option value="payMov_mem_id" <c:if test="${s_k eq 'payMov_mem_id'}">selected</c:if>>예매자ID</option>
			<option value="payMov_the_city" <c:if test="${s_k eq 'payMov_the_city'}">selected</c:if>>지역</option>
			<option value="payMov_mov_title" <c:if test="${s_k eq 'payMov_mov_title'}">selected</c:if>>영화명</option>
		</select>
		<input type="text" name="s_v" class="input_text_search" placeholder="검색어를 입력해주세요." <c:if test="${s_v ne '--'}">value="${s_v }"</c:if>>
		<button type="submit" class="button_main">검색</button>
	</form>
</fieldset>
<table class="main_table_list">
<colgroup>
	<col style="width:16%">
	<col style="wldth:7%">
	<col style="width:7%">
	<col style="width:10%">
	<col style="wldth:12%">
	<col style="width:15%">
	<col style="width:10%">
</colgroup>
<thead>
<tr>
	<th scope="col" class="text_c">예매 고유 코드</th>
	<th scope="col" class="text_c">지역</th>
	<th scope="col" class="text_c">지점</th>
	<th scope="col" class="text_c">회원ID</th>
	<th scope="col" class="text_c">결제가격</th>
	<th scope="col" class="text_c">결제일</th>
	<th scope="col" class="text_c">관리</th>
</tr>
</thead>
<tbody>
<c:forEach var="dto" items="${adminPayList }">
<tr>
	<td class="text_c">${dto.payMov_merchant_uid }</td>
	<td class="text_c">${dto.payMov_the_city }</td>
	<td class="text_c">${dto.payMov_the_branch }</td>
	<td class="text_c">${dto.payMov_mem_id }</td>
	<td class="text_c">${dto.payMov_price }</td>
	<td class="text_c">${dto.payMov_date }</td>
		<c:url var="dLink" value="detailAdminPay.do">
		<c:param name="payMov_idx">${dto.payMov_idx }</c:param>
	</c:url>
	<td class="text_c"><input type="button" value="상세" onclick="location.href='${dLink}'" class="list_s_btn up"><br>
					   <input type="button" value="삭제" onclick="javascript:deleteAdminPay(${dto.payMov_idx });" class="list_s_btn"></td>
	
</tr>
</c:forEach>
</tbody>
<tfoot>
	<tr>
	<td colspan="7" align="center">
	${pageStr }
	</td>
	</tr>
</tfoot>
</table>
</div>
</div>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>