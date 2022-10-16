<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/joaStore.css">
</head>
<body>
<c:import url="../header.jsp"></c:import>
	<div class="store_cart_container">
		<div class="store_cart_title_img">
			<img src="/movieJoa/img/joaStore_img/store_top_cart.jpg">
		</div>
		<div class="store_spaceMaker"></div>
		<table class="store_cart_table">
			<thead>
				<th><input type="checkbox" checked></th>
				<th colspan="2">상품명</th>
				<th>판매금액</th>
				<th>수량</th>
				<th>구매금액</th>
				<th>구매</th>
			</thead>
			<tbody>
			<c:if test="${empty storeCartList }">
					<tr>
						<td colspan="5" align="center">
							장바구니에 담긴 상품이 없습니다.
						</td>
					</tr>
			</c:if>
			<c:forEach var="dto" items="${storeCartList }">
				<tr>
					<td><input type="checkbox" checked></td>
					<td><img src="/movieJoa/img/joaStore_img/combo1.jpg" width="100" height="100"></td>
					<td>${dto.pro_name}</td>
					<td>${dto.pro_price }</td>
					<td>${dto.car_count }</td>
					<td>9,000원</td>
					<td><input type="button" value="바로구매"></td>
					<td></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div class="store_cart_select_del">
			<input type="button" value="선택상품 삭제">
			<span style="float:right">장바구니에 담긴 상품은 최대 30일까지 보관됩니다.</span>
		</div>
		<div class="store_cart_total_payment">
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
			<div class="store_cart_button_final">
				<a href="joaStorePay.do"><input type="button" value="구매하기"></a>
			</div>
		</div>
	</div>
<c:import url="../footer.jsp"></c:import>
</body>
</html>