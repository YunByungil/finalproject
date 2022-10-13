<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				<a href="joaStoreCombo.do">콤보</a>
				<a href="joaStorePopcorn.do">팝콘</a>
				<a href="joaStoreSnack.do">스낵</a>
				<a href="joaStoreDrink.do">음료</a>
		</div>
		<hr color="#dcdcdc">
		<div class="store_container">
			<div class="left">
				<div class="combo"><h1>콤보<a href="joaStoreCombo.do"><span class="material-symbols-outlined">add_circle</span></a></h1></div>
			</div>
			<div class="right">
				<div class="popcorn"><h1>팝콘<a href="joaStorePopcorn.do"><span class="material-symbols-outlined">add_circle</span></a></h1></div>
			</div>
		</div>
		<div class="store_container">
			<div class="left">
				<div class="snack"><h1>스낵<a href="joaStoreSnack.do"><span class="material-symbols-outlined">add_circle</span></a></h1></div>
			</div>
			<div class="right">
				<div class="drink"><h1>음료<a href="joaStoreDrink.do"><span class="material-symbols-outlined">add_circle</span></a></h1></div>
			</div>
		</div>
	</section>
<c:import url="../footer.jsp"></c:import>
</body>
</html>