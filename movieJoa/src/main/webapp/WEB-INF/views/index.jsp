<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비조아</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<c:import url="header.jsp"></c:import>
<section class="main">
	<article>
		<div class="movieChart">영화차트</div>
		<div class="event">이벤트</div>
		<div class="fnb">스토어상품</div>
		<div class="notice">공지사항</div>
		<div class="helpDesk">고객센터</div>
	</article>
</section>
<c:import url="footer.jsp"></c:import>
</body>
</html>