<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예매 상세 정보</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie_detail.css">
<script>
function deleteAdminPay(didx){
	   var delQue = window.confirm('삭제한 예매 정보는 복구할 수 없습니다. 정말 삭제하시겠습니까?');
	   	if(!delQue){ return; } 
	   window.location.href = 'deleteAdminPay.do?payMov_idx='+didx;
	}
</script>
</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<c:if test="${empty dto}">
			<div>이미 삭제된 게시글이거나 잘못된 접근입니다.</div>
</c:if>
<div class="mainBox">
<div class="div_title"><h2 class="title">| 예매 현황 관리 / 예매 상세 정보</h2></div>

<div class="table_box">
<table class="main_table_detail">
<tr>
	<th class="th_basic">예매 고유 코드</th>
	<td class="td_basic"> ${dto.payMov_merchant_uid } </td>
</tr>
<tr>
	<th class="th_basic">상영관 정보</th>
	<td colspan="3" class="td_basic"> ${dto.payMov_the_city }  ${dto.payMov_the_branch }점 ${dto.payMov_sch_theater } 관</td>
</tr>
<tr>
	<th class="th_basic">예매자 아이디</th>
	<td class="td_basic"> ${dto.payMov_mem_id } </td>
</tr>
<tr>
	<th class="th_basic">예매 영화</th>
	<td class="td_basic"> ${dto.payMov_mov_title } </td>
</tr>
<tr>
	<th class="th_basic">상영일자</th>
	<td class="td_basic"> ${dto.payMov_sch_day } ${dto.payMov_sch_start_hour }:${dto.payMov_sch_start_min } </td>
</tr>
<tr>
	<th class="th_basic">좌석 정보</th>
	<td class="td_basic"> ${dto.payMov_sch_seat }</td>
</tr>
<tr>
	<th class="th_basic">결제수단</th>
	<td class="td_basic"> ${dto.payMov_method } </td>
</tr>
<tr>
	<th class="th_basic">결제 금액</th>
	<td class="td_basic"> ${dto.payMov_price } </td>
</tr>
<tr>
	<th class="th_basic">결제일자</th>
	<td class="td_basic"> ${dto.payMov_date  } </td>
</tr>
</table>
</div>
</div>
<c:url var="didx" value="deleteAdminPay.do">
</c:url>
<div class="btn_wrap">
<input type="button" value="정보 삭제" class="button_main" onclick="javascript:deleteAdminPay(${dto.payMov_idx });">
<div class="bottom_div">
</div>
</div>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>