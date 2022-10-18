<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<script>
function openLogin(){
	window.open('/shoeStore/member/sign.jsp','login','width=450,height=850');
}
</script>
</head>
<header>
	<div class="nav">
		<div class="logo">
			<a href="index.do"><span class="title_main">MJOA</span><span class="title_sub"> manage</span></a>
		</div>
		<div class="nav_menu">
			<a href="index.do"><span class="material-symbols-outlined">account_circle</span>사용자 페이지</a>
		</div>	
	</div>
	<hr size="1px" color="#6799FF">
	<div class="category">
		<div class="category_menu">
			<a href="listMovie.do">영화 관리</a>
			<a href="#">상영관 관리</a>
			<a href="#">상영 스케줄 관리</a>
			<a href="joaStore.do">내 지점 매출 확인</a>
			<a href="#">질답</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="text" class="header_search"><span class="material-symbols-outlined">search</span>
		</div>
	</div>
	<hr size="2px" color="#6799FF">
</header>
</body>
</html>