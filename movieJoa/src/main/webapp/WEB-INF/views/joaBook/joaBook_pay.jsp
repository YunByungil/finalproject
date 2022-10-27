<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<style>
ul {
	list-style: none;
	padding-left: 0;
}

li {
	display: inline;
	list-style: none;
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
        merchant_uid: 'merchant_' + new Date().getTime(), //가맹점 주문번호 (아임포트를 사용하는 가맹점에서 중복되지 않은 임의의 문자열을 입력)
        name: "${title }", //결제창에 노출될 상품명
        amount: ${price },
        buyer_email : "${userInfo.mem_email }", 
        buyer_name : "${userInfo.mem_name }",
        buyer_tel : "${userInfo.mem_tel }"
        
    }, function (rsp) { // callback
    	
        if (rsp.success) {
            alert("결제가 완료되었습니다");
            document.getElementById("payMov_pg").value="nice"
            document.getElementById("payMov_method").value="card"
            document.getElementById("payMov_merchant_uid").value='merchant_'+new Date().getTime();
    		document.joaMoviePay.action='joaBookPay.do';		
			document.joaMoviePay.submit();
            
        } else {
        	
            alert("결제실패");
        }
    });
}

function paymentCreditCard(){
	
    IMP.init('imp80406606');//아임포트 관리자 콘솔에서 확인한 '가맹점 식별코드' 입력
    IMP.request_pay({// param
        pg: "nice", //pg사명 or pg사명.CID (잘못 입력할 경우, 기본 PG사가 띄워짐)
        pay_method: "card", //지불 방법
        merchant_uid: 'merchant_'+new Date().getTime(), //가맹점 주문번호 (아임포트를 사용하는 가맹점에서 중복되지 않은 임의의 문자열을 입력)
        name: "${title}", //결제창에 노출될 상품명
        amount: ${price },
        buyer_email : "${userInfo.mem_email }", 
        buyer_name : "${userInfo.mem_name }",
        buyer_tel : "${userInfo.mem_tel }"
        
    }, function (rsp) { // callback
    	
        if (rsp.success) {
            alert("결제가 완료되었습니다");
            document.getElementById("payMov_pg").value="nice"
            document.getElementById("payMov_method").value="card"
            document.getElementById("payMov_merchant_uid").value='merchant_'+new Date().getTime();
    		document.joaMoviePay.action='joaBookPay.do';		
			document.joaMoviePay.submit();
            
        } else {
        	
            alert("결제실패");
        }
    });
}
</script>

</head>
<body>
<div align="center">

<div>
<c:import url="../header.jsp"></c:import>
</div>

<h1>결제페이지</h1>
<form name="joaMoviePay">
<input type="hidden" name="payMov_the_idx" value="${idx }">
<input type="hidden" name="payMov_sch_theater" value="${theater }">
<input type="hidden" name="payMov_mem_id" value="${userInfo.mem_id }">
<input type="hidden" name="payMov_sch_day"  value="${day }">
<input type="hidden" name="payMov_sch_start_hour" value="${hour }">
<input type="hidden" name="payMov_sch_start_min" value="${min }">
<input type="hidden" name="payMov_sch_seat" value="${seat }">
<input type="hidden" name="payMov_the_city" value="${city }">
<input type="hidden" name="payMov_the_branch" value="${branch }">
<input type="hidden" name="payMov_price" value="${price }">
<input type="hidden" name="payMov_pg" id="payMov_pg">
<input type="hidden" name="payMov_method" id="payMov_method">
<input type="hidden" name="payMov_mov_title" value="${title }">
<input type="hidden" name="payMov_merchant_uid" id="payMov_merchant_uid">
<ul>
<li>
<input type="button" id="creditCard" value="신용카드">
<input type="button" id="kakaoPay" value="카카오페이">
</li>
</ul>
</form>
</div>

<br><br><br><br><br><br><br><br><br>
<div align="center">

<div style="width: 25%; height: 25%; float: left;">
<span id="sub2"><img src="/movieJoa/img/theater/${title }.jpg" width="100px" height="100px"></span>
<span id="sub">${title }</span>
</div>

<div style="width: 25%; height: 25%; float: left;">
<span id="br">${branch }</span><br>
<span id="date">${day }</span><br>
<span id="to">${theater }관/${hour }:${min }</span>
</div>
<div style="width: 25%; height: 25%; float: left;">
<span id="s">좌석명 : ${seat }</span><br>
<span id="money">가격 : ${price }</span>
</div>

<div style="width: 25%; height: 25%; float: left;"><input type="submit" value="결제하기" style="color: red;" id="finalpay"></div>
<br><br><br><br><br><br><br><br><br>
<div>
<c:import url="../footer.jsp"></c:import>
</div>

</div>
</body>
</html>