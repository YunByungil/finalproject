<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음료</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/joaStore.css">
</head>
<body>
<c:import url="../header.jsp"></c:import>
	<div class="store_category">
			<a href="joaStoreCombo.do">콤보</a>
			<a href="joaStorePopcorn.do">팝콘</a>
			<a href="joaStoreSnack.do">스낵</a>
			<a href="joaStoreDrink.do">음료</a>
	</div>
	<hr color="#dcdcdc">
	<div class="store_spaceMaker"></div>
	<div class="store_container">
	<div class="left">
		<div class="drink"><h1>음료<span class="material-symbols-outlined">add_circle</span></h1></div>
	</div></div>
<c:import url="../footer.jsp"></c:import>
</body>
</html>