<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>콤보</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/joaStore.css">
<style>
.product_container{
	max-width:1100px;
	margin:auto;
}

.product_list_name{
	font-size:30px;
}

.product_list_price{
	font-size:20px;
}

</style>
</head>
<body>
<c:import url="../header.jsp"></c:import>
	<div class="store_category">
			<a href="joaStoreCombo.do">콤보</a>
			<a href="joaStorePopcorn.do">팝콘</a>
			<a href="joaStoreSnack.do">스낵</a>
			<a href="joaStoreDrink.do">음료</a>
	</div>
	<hr color="#dcdcdc"/>
	<div class="store_spaceMaker"></div>
	<div class="product_container">
		<h1>콤보</h1>
		<hr size="2px"/>
		<table>
			<tr>
				<td><a href="joaStoreProduct.do"><img src="/movieJoa/img/joaStore_img/combo1.jpg" alt="콤보" width="350" height="400"></a></td>
			</tr>
			<tr>
				<td class="product_list_name"><b>MJOA콤보</b></td>
			</tr>
			<tr>
				<td class="product_list_price"><b>9,000원</b></td>
			</tr>								
		</table>
	</div>
<c:import url="../footer.jsp"></c:import>
</body>
</html>