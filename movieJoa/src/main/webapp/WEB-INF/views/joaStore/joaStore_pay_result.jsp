<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매완료</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/joaStore.css">
</head>
<body>
<c:import url="../header.jsp"></c:import>
	<table class="store_cart_table">
				<thead>
					<th>상품명</th>
					<th>수량</th>
					<th>총 상품금액</th>
					<th>할인금액</th>
					<th>총 결제금액</th>
					<th>결제수단</th>
				</thead>
				<tbody>
					<tr>				
						<td>${payList.payPro_pro_name}</td>
						<td>payPro_pro_count</td>						
						<td>${payList.payPro_price_sum }</td>
						<td>${payList.payPro_discount }</td>					
						<td>${payList.payPro_total_price }</td>
						<td>${payList.payPro_pg }</td>
					</tr>			
				</tbody>
			</table>
<c:import url="../footer.jsp"></c:import>
</body>
</html>