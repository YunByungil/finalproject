<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/joaStore.css">
<script>
function selectAll(selectAll)  {
	
	var checkBoxes  = document.getElementsByName('chx');
	var checkValues = new Array(); 
	var sum = 0;
	
	for(var i=0;i<checkBoxes.length;i++){
	 checkValues[i]=document.getElementsByName('chx')[i].value;
	 sum += parseInt(checkValues[i]);
	}
  
    checkBoxes.forEach((checkbox) => (checkbox.checked = selectAll.checked));
	if(selectAll.checked==true){
		document.getElementById("priceSum").value=sum;
		document.getElementById("totalSum").value=sum;
	}else{
		document.getElementById("priceSum").value=0;
		document.getElementById("totalSum").value=0;
	}
}

function itemCheck(){
		
	var checkBoxes  = document.getElementsByName('chx');
	var checkValues = new Array(); 
	var sum = 0;
	
	for(var i=0;i<checkBoxes.length;i++){
		if(checkBoxes[i].checked==true){
			checkValues[i]=document.getElementsByName('chx')[i].value;
			sum += parseInt(checkValues[i]);
		}
	} 	
    
	document.getElementById("priceSum").value=sum;
	document.getElementById("totalSum").value=sum;
	
	const chxAll     = document.querySelectorAll('input[name="chx"]');
	const checked    = document.querySelectorAll('input[name="chx"]:checked');
	const selectAll  = document.querySelector('input[name="select"]');
	
	if(chxAll.length === checked.length)  {
	  selectAll.checked = true;
	}else {
	  selectAll.checked = false;
	}
}

function cartSubmit(index) {
	
	 if (index == 1) {
		document.joaStoreCart.action='joaStoreCartDelete.do';
	 }else if (index == 2) {

		var checkBoxes  = document.getElementsByName('chx');
		var count=0;		
		var checkIdxs   = new Array();	
		
		for(var i=0;i<checkBoxes.length;i++){
			
			if(checkBoxes[i].checked==true){
				checkIdxs[count]=checkBoxes[i].id;
				count++;
				}
			}		
		
		var idxsJson=JSON.stringify(checkIdxs);
		document.joaStoreCart.idxsJson.value=idxsJson;
		document.joaStoreCart.action='joaStorePay.do';		
		
		}	 
	 
	 document.joaStoreCart.submit();	
}

function showCoupon(){
	window.open('selectCoupon.do','coupon','width=400,height=300');
}
</script>
</head>
<body>
<c:import url="../header.jsp"></c:import>
	<div class="store_cart_container">
		<div class="store_cart_title_img">
			<img src="/movieJoa/img/joaStore_img/store_top_cart.jpg">
		</div>
		<div class="store_spaceMaker"></div>
			<form name="joaStoreCart">
				<input type="hidden" name="idxsJson">
					<table class="store_cart_table">
						<thead>
							<th><input type='checkbox' name="select" onclick="selectAll(this);"></th>
							<th colspan="2">상품명</th>
							<th>판매금액</th>
							<th>수량</th>
							<th>구매금액</th>
							<th>삭제<th>
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
								<td><input type="checkbox" name="chx" id="${dto.car_pro_idx }" value="${dto.pro_price*dto.car_count }" onclick="itemCheck()"></td>
								<td><img src="/movieJoa/img/joaStore_img/${dto.pro_filename }" width="100" height="100"></td>
								<td>${dto.pro_name}</td>
								<td><fmt:formatNumber value="${dto.pro_price }" pattern="#,###"/></td>
								<td>${dto.car_count }</td>
								<td><fmt:formatNumber value="${dto.pro_price*dto.car_count}" pattern="#,###"/></td>
								<input type="hidden" name="pro_filename" value="${dto.pro_filename}">
								<input type="hidden" name="pro_name" value="${dto.pro_name }">
								<input type="hidden" name="pro_price" value="${dto.pro_price }">
								<input type="hidden" name="car_count" value="${dto.car_count }">
								<input type="hidden" name="pro_priceSum" value="${dto.pro_price*dto.car_count }">
								<input type="hidden" name="car_pro_idx" value="${dto.car_pro_idx }">
								<td><input type="button" value="삭제" onclick="cartSubmit(1)"></td>
							</tr>
						</c:forEach>
						<input type="hidden" name="mem_name" value="구매자 이름">
						<input type="hidden" name="mem_tel" value="구매자 전화번호">
						<input type="hidden" name="mem_email" value="구매자 이메일">				
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
							<th colspan="2">할인금액</th>
							<th></th>
							<th>총 결제 금액</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>												
							<input type="text" name="pay_price_sum" id="priceSum" size="20" readonly></td>						
							<td><img src="/movieJoa/img/joaStore_img/store_total_pay_minus.jpg"></td>												
							<td><input type="text" name="pay_discount" id="discount" size="20" readonly></td>
							<td><a href=""><input type="button" value="쿠폰" onclick="showCoupon()"></a></td>												
							<td><img src="/movieJoa/img/joaStore_img/store_total_pay_same.jpg"></td>												
							<td><input type="text" name="pay_total_sum" id="totalSum" size="20" readonly></td>
						</tr>
					</tbody>
				</table>
				<div class="store_cart_button_final">
					<input type="button" value="구매하기" onclick="cartSubmit(2)">
				</div>
			</div>
		</form>
	</div>
<c:import url="../footer.jsp"></c:import>
</body>
</html>