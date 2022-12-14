<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품구매</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/joaStore.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<style>
.kakao_button{
	background: url( "img/joaStore_img/payment_icon_yellow_medium.png" ) no-repeat;
	border: none;
	width: 121px;
	height: 50px;
	cursor: pointer;
}
.nicepay_button{
	background: url( "img/joaStore_img/payment_icon_nicepay_logo.png" ) no-repeat;
	border: none;
	width: 217px;
	height: 60px;
	cursor: pointer;
}
</style>
<script>
$(document).ready(function(){ 
	
	$("#kakaoPay").click(function(){ 
		paymentKakaoPay(); //버튼 클릭하면 호출 
    }); 
	
	$("#creditCard").click(function(){ 
		paymentCreditCard(); //버튼 클릭하면 호출 
    }); 
})

function paymentKakaoPay(){

    IMP.init('imp80406606');//아임포트 관리자 콘솔에서 확인한 '가맹점 식별코드' 입력
    IMP.request_pay({// param
        pg: "kakaopay", //pg사명 or pg사명.CID (잘못 입력할 경우, 기본 PG사가 띄워짐)
        pay_method: "card", //지불 방법
        merchant_uid: 'merchant_'+new Date().getTime(), //가맹점 주문번호 (아임포트를 사용하는 가맹점에서 중복되지 않은 임의의 문자열을 입력)
        name: "용상민", //결제창에 노출될 상품명
        amount: ${pay_total_sum},
        buyer_email : "${userInfo.mem_email}", 
        buyer_name : "${userInfo.mem_name}",
        buyer_tel : "${userInfo.mem_tel}"
        
    }, function (rsp) { // callback
    	
        if (rsp.success) {
            alert("결제가 완료되었습니다");
            document.getElementById("payPro_pg").value="kakaopay";
            document.getElementById("payPro_method").value="card";
    		document.joaStorePay.action='joaStoreKakaoPay.do';		
			document.joaStorePay.submit();
            
        } else {
        	
            alert("결제실패");
        }
    });
}


function paymentCreditCard(){
	var merchant = 'merchant_'+new Date().getTime();
    IMP.init('imp80406606');//아임포트 관리자 콘솔에서 확인한 '가맹점 식별코드' 입력
    IMP.request_pay({// param
        pg: "nice", //pg사명 or pg사명.CID (잘못 입력할 경우, 기본 PG사가 띄워짐)
        pay_method: "card", //지불 방법
        merchant_uid: 'merchant_'+new Date().getTime(), //가맹점 주문번호 (아임포트를 사용하는 가맹점에서 중복되지 않은 임의의 문자열을 입력)
        name: "용상민", //결제창에 노출될 상품명
        amount: ${pay_total_sum} ,
        buyer_email : "${userInfo.mem_email}", 
        buyer_name : "${userInfo.mem_name}",
        buyer_tel : "${userInfo.mem_tel}"
        
    }, function (rsp) { // callback
    	
        if (rsp.success) {
            alert("결제가 완료되었습니다");
            document.getElementById("payPro_pg").value="CreditCard";
            document.getElementById("payPro_method").value="card";
    		document.joaStorePay.action='joaStoreKakaoPay.do';		
			document.joaStorePay.submit();
            
        } else {
        	
            alert("결제실패");
        }
    });

}

</script>

</head>
<body>
<c:import url="../header.jsp"></c:import>
	<div class="store_cart_container">
		<div class="store_cart_title_img">
			<img src="/movieJoa/img/joaStore_img/store_top_paying.jpg">
		</div>
		<div class="store_spaceMaker"></div>
		<h2>구매상품 정보</h2>
		<form name="joaStorePay" action="">
		<table class="store_cart_table">
			<thead>
				<th colspan="2">상품명</th>
				<th>판매금액</th>
				<th>수량</th>
				<th>구매금액</th>
			</thead>
			<c:set var="priceSum" value="0"></c:set> 
			<c:forEach var="dto" items="${jpcList }">
			<tbody>
				<tr>
					<td><img src="/movieJoa/img/joaStore_img/${dto.pro_filename }" width="100" height="100"></td>
					<td>${dto.pro_name }</td>
					<td><fmt:formatNumber value="${dto.pro_price }" pattern="#,###"/>원</td>
					<td>${dto.car_count }</td>
					<td><fmt:formatNumber value="${dto.pro_price * dto.car_count }" pattern="#,###"/>원</td>
				</tr>
			</tbody>
 				<c:set var="priceSum" value="${priceSum+(dto.pro_price * dto.car_count) }"/>	
					<input type="hidden" name="prs_mem_id" value="${userInfo.mem_id }">			
					<input type="hidden" name="prs_pro_filename" value="${dto.pro_filename }">
					<input type="hidden" name="prs_pro_name" value="${dto.pro_name }">			
					<input type="hidden" name="prs_pro_price" value="${dto.pro_price}">			
					<input type="hidden" name="prs_car_count" value="${dto.car_count}">				
			</c:forEach>
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
							<td><fmt:parseNumber var="price_sum" type="number" value="${priceSum }" /><fmt:formatNumber value="${price_sum }" pattern="#,###"/>원</td>
							<td><img src="/movieJoa/img/joaStore_img/store_total_pay_minus.jpg"></td>
							<td><fmt:parseNumber var="discount" type="number" value="${pay_discount }" /><fmt:formatNumber value="${discount  }" pattern="#,###"/>원</td>
							<td><img src="/movieJoa/img/joaStore_img/store_total_pay_same.jpg"></td>
							<td><fmt:parseNumber var="total_sum" type="number" value="${priceSum }" /><fmt:formatNumber value="${total_sum }" pattern="#,###"/>원</td>

						</tr>
					</tbody>
					
				</table>
				<h2>주문자 정보 확인</h2>
				<div class="store_pay_customer_info">
					<table class="store_pay_customer_info_table">
						<tr>
							<td>이름</td>
							<td><input type="text" value="${userInfo.mem_name }"></td>
							<td>휴대전화 번호</td>
							<td><input type="text" value="${userInfo.mem_tel }"></td>
						</tr>
					</table>			
				</div>
				<input type="hidden" name="payPro_mem_id" value="${userInfo.mem_id }">	
				<input type="hidden" name="payPro_mem_name" value="${userInfo.mem_name }">	
				<input type="hidden" name="payPro_mem_email" value="${userInfo.mem_email }">	
				<input type="hidden" name="payPro_mem_tel" value="${userInfo.mem_tel }">
				<input type="hidden" name="payPro_pro_name" value="galmae">
				<input type="hidden" name="payPro_pg" id="payPro_pg">
				<input type="hidden" name="payPro_method" id="payPro_method">			
				<input type="hidden" name="payPro_price_sum" value="${pay_price_sum }">
				<input type="hidden" name="payPro_discount" value="1">
				<input type="hidden" name="payPro_total_price" value="${pay_total_sum }">	
				<h2>결제수단</h2>
				<div class="store_pay_payments_system">
					<table class="store_pay_payments_system_table">
						<tr>
							<td><input id="creditCard" class="nicepay_button" type="button"></td>
							<td><input id="kakaoPay" class="kakao_button" type="button"></td>	
						</tr>
					</table>			
				</div>
				<div class="store_pay_payments_final">	
				</div>
			</div>
		</form>
	</div>
<c:import url="../footer.jsp"></c:import>
</body>
</html>