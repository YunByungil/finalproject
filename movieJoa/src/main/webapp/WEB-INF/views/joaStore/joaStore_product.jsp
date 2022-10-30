<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품페이지</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/joaStore.css">

<script>

function count(type)  {
  // 결과를 표시할 element
  const countElement = document.getElementById('count');
  
  // 현재 화면에 표시된 값
  let number = countElement.innerText;
  
  // 더하기/빼기
  if(type == 'plus') {
	  if(number < 10){
    number = parseInt(number) + 1;
	  }else if(number = 10){
		  window.alert('최대 10까지만 가능합니다.');
	  }
	  
  }else if(type == 'minus')  {
	  if(number > 1){
    number = parseInt(number) - 1;
	  }
  }
  
  // 결과 출력
  countElement.innerText = number;
}

function productSubmit() {
	var productCount=document.getElementById('count').innerText;
	var finalCount = document.getElementById('car_count');
	finalCount.value = productCount;
	
		  
		  if(${userInfo.mem_id==null}){
			window.alert('로그인 후 이용해주세요')
		  }else{
			document.joaStoreCategory.action='joaStoreCart.do';			  
		  }


	  document.joaStoreCategory.submit();
	}

</script>

</head>
<body>
<c:import url="../header.jsp"></c:import>
	<div class="store_spaceMaker"></div>
	<c:set var="dto" value="${storeProductInfo }"></c:set>
		<div class="product_container">
		<h1>${dto.pro_name }</h1>
		<hr color="black" size="2px">
		</div>
		<form name="joaStoreCategory" method='post'>
			<input type="hidden" name="car_mem_id" value="${userInfo.mem_id }">	
			<input type="hidden" name="car_pro_idx" value="${dto.pro_idx }">
			<div class="product_space">
				<div class="product_img">
					<img src="/movieJoa/img/joaStore_img/${dto.pro_filename }" alt="콤보" width="430" height="450">
				</div>
				<div class="product_select">
					<b><fmt:formatNumber value="${dto.pro_price }" pattern="#,###"/></b>
					<hr color="#dcdcdc"/>
					<table>
						<tr>
							<td>상품구성</td><td>${dto.pro_name }</td>
						</tr>
						<tr>
							<td>유효기간</td><td>구매일로부터 6개월 이내</td>
						</tr>
					</table>
					<hr color="#dcdcdc"/>
					<div class="product_count">
						<input type='button' onclick='count("minus")' value='-'/>
							<span id="count">1</span>
						<input type='button' onclick='count("plus")' value='+'/>
						<input type="hidden" name="car_count" id="car_count">
					</div>
					<hr>
					<span>총 구매금액</span><span class="product_right_price"><fmt:formatNumber value="${dto.pro_price }" pattern="#,###"/></span>
					<div>
						<input type="button" value="장바구니" onclick='productSubmit()'>
					</div>			
				</div>
			</div>
		</form>
		<hr color="black" size="2px" width="1100px">
	
		<div class="product_info">
			<p class='category_product_detail_txtbox'>${dto.pro_info }</p>
		</div>
<c:import url="../footer.jsp"></c:import>
</body>
</html>