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
		<div name="movieChart">영화차트</div>
		<div name="event">이벤트</div>
		<div name="fnb">스토어상품</div>
		<div name="notice">공지사항</div>
		<div name="helpDesk">고객센터</div>
		<a href="adminMember.do">관리자(회원확인용)</a>
	</article>
</section>
<c:import url="footer.jsp"></c:import>
</body>
</html>