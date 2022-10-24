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
		<a href="helpDesk.do" class="HM_bar_a"><li class="HM_bar">고객센터</li></a>
		<a href="manyHelp.do" class="HM_bar_a"><li class="HM_bar">자주찾는 질문</li></a>
		<a href="notice.do" class="HM_bar_a"><li class="HM_bar">공지게시판</li></a>
		<a href="emailHelp.do" class="HM_bar_a"><li class="HM_bar">이메일문의</li></a>
		<a href="oneByOneHelp.do" class="HM_bar_a"><li class="HM_bar">1:1문의</li></a>
	</ul>
	
</div>
</section>
<c:import url="../footer.jsp"></c:import>
</body>
</html>