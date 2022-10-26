<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰 등록</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link rel="stylesheet" type="text/css" href="css/adminCoupon.css">
<script type="text/javascript" src="js/adminCouponValidation.js"></script>
</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<div class="mainBox">
<div class="div_title"><h2 class="title">| 쿠폰 관리 / 쿠폰 등록</h2></div>
<form:form modelAttribute="co" name="addCouponForm" action="addCoupon.do" method="post" onsubmit="return addCouponSubmitCheck();">
<div class="table_wrap">
<table class="main_table">
<tr>
	<th class="th_basic">쿠폰명</th>
	<td colspan="3" class="td_basic">
	<form:input path="cou_name" type="text" name="cou_name" class="input_text_basic" placeholder="쿠폰 이름을 입력해주세요"/>
	<br><form:errors path="cou_name" class="error_span"/>
	</td>
</tr>
<tr>
	<th class="th_basic">할인 적용 금액</th>
	<td class="td_basic"><div class="time_div">
	<form:input type="text" path="cou_discount" name="cou_discount" id="cd" class="input_text_basic" placeholder="가격 입력" onkeyup="addCouponNumberCheck();"/> 원 <span id="ersp" class="error_span_general"></span><span class="caution fl_r">숫자만 입력해주세요.</span> </div>
	
	<form:errors path="cou_discount" class="error_span"/>
	</td>
</tr>
<tr>
</tr>
</table>
</div>
	<div class="btn_wrap"><input type="button" value="돌아가기" class="button_sub"><input type="submit" value="쿠폰 등록" class="button_main"></div>
</form:form>
</div>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>