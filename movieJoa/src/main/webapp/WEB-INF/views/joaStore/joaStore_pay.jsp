<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/joaStore.css">
<style>

.store_cart_container{
	max-width:1100px;
	margin:auto;
}
.store_cart_table{
	border-top:3px solid black;
	border-bottom:1px solid black;
	width:1100px;
	border-collapse : collapse;
	text-align:center;
}

.store_cart_table th{
	background:#f8f8f8;
	padding-top:15px;
	padding-bottom:15px;
}

.store_cart_table td{
	border-top:1px solid #f3f3f3;
	padding-top:20px;
	padding-bottom:20px;
}
.store_cart_select_del{
	padding-top:30px;
	padding-bottom:30px;
}

.store_cart_total_payment{
	padding-top:50px;
	padding-bottom:30px;
}

.store_cart_total_payment_table{
	border-top:1px solid #838485;
	border-bottom:1px solid #838485;
	width:1100px;
	border-collapse : collapse;
	text-align:center;
}

.store_cart_total_payment_table th{
	background:#f8f8f8;
	padding-top:15px;
	padding-bottom:15px;
}

.store_cart_total_payment_table td{
	padding-top:20px;
	padding-bottom:20px;
}

.store_cart_title_img{
	text-align:center;
}

.store_cart_button_final{
	padding-top:30px;
	padding-bottom:50px;
	text-align:center;
}
.store_pay_customer_info,
.store_pay_payments_system{
	padding-top:50px;
	padding-bottom:30px;
}

.store_pay_customer_info_table,
.store_pay_payments_system_table{
	padding-top:20px;
	padding-bottom:20px;
	border-top:3px solid black;
	border-bottom:1px solid black;
	width:1100px;
	
}

</style>
</head>
<body>
<c:import url="../header.jsp"></c:import>
<c:import url="joaStore_category.jsp"></c:import>
	<div class="store_cart_container">
		<div class="store_cart_title_img">
			<img src="/movieJoa/img/joaStore_img/store_top_paying.jpg">
		</div>
		<div class="store_spaceMaker"></div>
		<h2>구매상품 정보</h2>
		<table class="store_cart_table">
			<thead>
				<th colspan="2">상품명</th>
				<th>판매금액</th>
				<th>수량</th>
				<th>구매금액</th>
			</thead>
			<tbody>
				<tr>
					<td><img src="/movieJoa/img/joaStore_img/combo1.jpg" width="100" height="100"></td>
					<td>MJOA콤보</td>
					<td>9,000원</td>
					<td>1</td>
					<td>9,000원</td>
				</tr>
				<tr>
					<td><img src="/movieJoa/img/joaStore_img/combo1.jpg" width="100" height="100"></td>
					<td>MJOA콤보</td>
					<td>9,000원</td>
					<td>1</td>
					<td>9,000원</td>
				</tr>
			</tbody>
		</table>
		<div class="store_cart_total_payment">
		<h2>결제금액</h2>
			<table class="store_cart_total_payment_table">
				<thead>
					<tr>
						<th>총 상품 금액</th>
						<th></th>
						<th>할인금액</th>
						<th></th>
						<th>총 결제 금액</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>18,000원</td>
						<td><img src="/movieJoa/img/joaStore_img/store_total_pay_minus.jpg"></td>
						<td>0원</td>
						<td><img src="/movieJoa/img/joaStore_img/store_total_pay_same.jpg"></td>
						<td>18,000원</td>
					</tr>
				</tbody>
			</table>
			<h2>주문자 정보 확인</h2>
			<div class="store_pay_customer_info">
				<table class="store_pay_customer_info_table">
					<tr>
						<td>이름</td>
						<td><input type="text" value=""></td>
						<td>휴대전화 번호</td>
						<td><input type="text" value=""></td>
					</tr>
				</table>			
			</div>
			<h2>결제수단</h2>
			<div class="store_pay_payments_system">
				<table class="store_pay_payments_system_table">
					<tr>
						<td><input type="radio">신용카드</td>
						<td><input type="radio">카카오페이</td>
					</tr>
				</table>			
			</div>
			<div class="store_pay_payments_final">
				<input type="button" value="결제하기">			
			</div>
		</div>
	</div>
<c:import url="../footer.jsp"></c:import>
</body>
</html>