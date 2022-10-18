<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/joaHelpDesk.css">
<title>Insert title here</title>
</head>
<body>
<c:import url="../header.jsp"></c:import>
<br>
<section>
<div class="helpDesk_main">
<div class="HelpMain">
	<br>
	<br>
	<br>
	<br>
	<br>
</div>
	<ul class="helpMenu">
		<li><a href="helpDesk.do">고객센터</a></li>
		<li><a href="manyHelp.do">자주찾는 질문</a></li>
		<li><a href="notice.do">공지게시판</a></li>
		<li><a href="emailHelp.do">이메일문의</a></li>
		<li><a href="oneByOneHelp.do">1:1문의</a></li>
	</ul>
	
</div>
</section>
<c:import url="../footer.jsp"></c:import>
</body>
</html>