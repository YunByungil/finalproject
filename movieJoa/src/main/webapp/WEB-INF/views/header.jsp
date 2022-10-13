<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<a href="index.do"><h1>MJOA</h1></a>
		</div>
		<div class="nav_menu">

			<c:if test="${userInfo.mem_id==null }">
			<a href="memberLogin.do"><span class="material-symbols-outlined">person</span>로그인</a>
			</c:if>
			<c:if test="${userInfo.mem_id!=null }">
			<a href="memberLogout.do"><span class="material-symbols-outlined">person</span>로그아웃</a>
			</c:if>

			<a href="memberJoin.do"><span class="material-symbols-outlined">person_add</span>회원가입</a>
			<a href="myPage.do"><span class="material-symbols-outlined">account_circle</span>마이페이지</a>
			<a href="helpDest.do"><span class="material-symbols-outlined">support_agent</span>고객센터</a>
			<a href="adminStore.do">관리자페이지</a>
		</div>		
	</div>
	<hr size="1px" color="#dcdcdc">
	<div class="category">
		<div class="category_menu">
			<a href="#">영화</a>
			<a href="#">극장/예매</a>
			<a href="joaStore.do">스토어</a>
			<a href="#">이벤트</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="text"><span class="material-symbols-outlined">search</span>
		</div>
	</div>
	<hr size="2px" color="red">
</header>
</body>
</html>