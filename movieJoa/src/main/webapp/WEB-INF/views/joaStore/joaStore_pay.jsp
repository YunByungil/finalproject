<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품구매</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/joaStore.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script>
$(document).ready(function(){ 
	$("#iamportPayment").click(function(){ 
    	payment(); //버튼 클릭하면 호출 
    }); 
})

function payment(data) {
    IMP.init('imp80406606');//아임포트 관리자 콘솔에서 확인한 '가맹점 식별코드' 입력
    IMP.request_pay({// param
        pg: "kakaopay.TC0ONETIME", //pg사명 or pg사명.CID (잘못 입력할 경우, 기본 PG사가 띄워짐)
        pay_method: "card", //지불 방법
        merchant_uid: "${payPro_merchatUid}", //가맹점 주문번호 (아임포트를 사용하는 가맹점에서 중복되지 않은 임의의 문자열을 입력)
        name: "${payPro_pro_name}", //결제창에 노출될 상품명
        amount: ${payPro_total_price}, //금액
        buyer_email : "${payPro_email}", 
        buyer_name : "${payPro_name}",
        buyer_tel : "${payPro_mem_id}"
    }, function (rsp) { // callback
        if (rsp.success) {
            alert("완료 -> imp_uid : "+rsp.imp_uid+" / merchant_uid(orderKey) : " +rsp.merchant_uid);
            console.log(rsp);
        } else {
            alert("실패 : 코드("+rsp.error_code+") / 메세지(" + rsp.error_msg + ")");
        }
    });
}
</script>
<style>
</style>
</head>
<body>
<c:import url="../header.jsp"></c:import>
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
						<td><input id="iamportPayment" type="button" value="카카오페이"></td>	
					</tr>
				</table>			
			</div>
			<div class="store_pay_payments_final">	
			</div>
		</div>
	</div>
<c:import url="../footer.jsp"></c:import>
</body>
</html>