<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰 할당 목록 조회</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link rel="stylesheet" type="text/css" href="css/adminCoupon.css">
<script>
function deleteOwncou(didx){
	   var delQue = window.confirm('삭제한 쿠폰 할당 정보는 복구할 수 없습니다. 정말 삭제하시겠습니까?');
	   	if(!delQue){ return; } 
	   window.location.href = 'deleteOwncou.do?own_idx='+didx;
	}
</script>
</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<div class="mainBox">
<div class="div_title"><h2 class="title">| 쿠폰 관리 / 쿠폰 할당 목록</h2></div>
<div class="table_wrap_list">
<fieldset class="search_wrap">
	<form action="/searchOwncou.do">
		<select name="s_k">
			<option value="all" <c:if test="${s_k eq 'all'}">selected</c:if>>전체</option>
			<option value="own_idx" <c:if test="${s_k eq 'own_idx'}">selected</c:if>>식별번호</option>
			<option value="own_name" <c:if test="${s_k eq 'own_name'}">selected</c:if>>쿠폰명</option>
			<option value="own_member_id" <c:if test="${s_k eq 'own_member_id'}">selected</c:if>>회원명</option>
		</select>
		<input type="text" name="s_v" class="input_text_search" placeholder="검색어를 입력해주세요." <c:if test="${s_v ne '--'}">value="${s_v }"</c:if>>
		<button type="submit" class="button_main">검색</button>
	</form>
</fieldset>
<table class="main_table_list">
<colgroup>
	<col style="width:13%">
	<col style="wldth:23%">
	<col style="width:13%">
	<col style="width:13%">
	<col style="width:13%">
	<col style="wldth:13%">
	<col style="width:12%">
</colgroup>
<thead>
<tr>
	<th scope="col" class="text_c">식별코드</th>
	<th scope="col" class="text_c">쿠폰명</th>
	<th scope="col" class="text_c">보유회원</th>
	<th scope="col" class="text_c">할인금액</th>
	<th scope="col" class="text_c">발급일</th>
	<th scope="col" class="text_c">유효기간</th>
	<th scope="col" class="text_c">관리</th>
</tr>
</thead>
<tbody>
<c:forEach var="dto" items="${owncouList }">
<tr>
	<td class="text_c">${dto.own_idx }</td>
	<td class="text_c">${dto.own_name }</td>
	<td class="text_c">${dto.own_member_id }</td>
	<td class="text_c">${dto.own_discount } 원</td>
	<td class="text_c">${dto.own_issue_date }</td>
	<td class="text_c">${dto.own_limit_date }</td>
	<td class="text_c">
	<input type="button" value="삭제" onclick="javascript:deleteOwncou(${dto.own_idx });" class="list_s_btn"></td>
	
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