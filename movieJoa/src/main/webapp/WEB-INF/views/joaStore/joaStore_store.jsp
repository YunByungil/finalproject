<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스토어</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/joaStore.css">
</head>
<body>
<c:import url="../header.jsp"></c:import>
	<section>
		<div class="store_main">
			<img src="/movieJoa/img/storeMain.jpg"></a>
		</div>
		<hr color="#dcdcdc">
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
		<hr color="#dcdcdc">
		<div class="store_container">
		</div>
	</section>
<c:import url="../footer.jsp"></c:import>
</body>
</html>