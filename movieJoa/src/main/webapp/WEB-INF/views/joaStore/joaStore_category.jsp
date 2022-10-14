<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스토어 상품</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/joaStore.css">
</head>
<body>
<c:import url="../header.jsp"></c:import>
		<div class="store_category">
			<c:url var="comboUrl" value="joaStoreCategory.do">
				<c:param name="category">콤보</c:param>
			</c:url>
			<c:url var="popcornUrl" value="joaStoreCategory.do">
				<c:param name="category">팝콘</c:param>
			</c:url>
			<c:url var="snackUrl" value="joaStoreCategory.do">
				<c:param name="category">스낵</c:param>
			</c:url>
			<c:url var="drinkUrl" value="joaStoreCategory.do">
				<c:param name="category">음료</c:param>
			</c:url>
			<a href="${comboUrl }">콤보</a>
			<a href="${popcornUrl }">팝콘</a>
			<a href="${snackUrl }">스낵</a>
			<a href="${drinkUrl }">음료</a>
		</div>
	<hr color="#dcdcdc"/>
	<div class="store_spaceMaker"></div>
	<div class="product_container">
	<c:set var="title" value="${category }"></c:set>
		<h1>${category }</h1>
		<hr size="2px"/>
		<c:if test="${empty storeCategoryList }">
				<tr>
					<td colspan="5" align="center">
						등록된 상품이 없습니다.
					</td>
				</tr>
		</c:if>
		<table>
			<tr>
				<c:forEach var="dto" items="${storeCategoryList }" varStatus="aa">
						<td>
							<table>							
								<tr>
									<c:url var="productUrl" value="joaStoreProduct.do">
										<c:param name="pro_idx">${dto.pro_idx }</c:param>
									</c:url>
									<td><a href="${productUrl}"><img src="/movieJoa/img/joaStore_img/${dto.pro_filename }" alt="콤보" width="350" height="400"></a></td>
								</tr>
								<tr>
									<td class="product_list_name"><b>${dto.pro_name }</b></td>
								</tr>
								<tr>
									<td class="product_list_price"><b>${dto.pro_price }</b></td>
								</tr>		
							</table>
						</td>
					<c:if test="${aa.count mod 3 ==0}"></tr><tr></c:if>
				</c:forEach>
		</table>
	</div>
	<div class="store_spaceMaker"></div>
<c:import url="../footer.jsp"></c:import>
</body>
</html>