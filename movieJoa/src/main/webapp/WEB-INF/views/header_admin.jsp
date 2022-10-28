<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<style>
    ul, ol, li { list-style:none; margin:0; padding:0; }
   
    ul.myMenu {}
    ul.myMenu > li { display:inline-block; width:120px; padding:5px 10px; background:white; text-align:center; position:relative; }
    ul.myMenu > li:hover { background:#fff; }
    ul.myMenu > li ul.submenu { display:none; position:absolute; border:1px solid #eee; top:30px; left:0; }
    ul.myMenu > li:hover ul.submenu { display:block; }
    ul.myMenu > li ul.submenu > li { display:inline-block; width:120px; padding:5px 10px; background:white; border:1px solid #eee; text-align:center; }
    ul.myMenu > li ul.submenu > li:hover { background:#fff; }
    
    .menu_space{
    	height:150px;
    }
</style>
<script>
function openLogin(){
	window.open('/shoeStore/member/sign.jsp','login','width=450,height=850');
}
</script>
</head>
<header>
	<div class="nav">
		<div class="logo">
			<a href="adminLogout.do"><h1>MJOA manage</h1></a>
		</div>
		<div class="nav_menu">
			<a href="adminLogout.do"><span class="material-symbols-outlined">account_circle</span>사용자 페이지</a>
		</div>	
	</div>
	<hr size="1px" color="#c0c0c0">
	<div class="category_admin">
		<div class="category_menu">
			<ul class="myMenu">
				<li class="menu1"><a href="/movieJoa/listMovie.do">영화 관리</a>
					<ul class="menu1_s submenu">
					    <li><a href="/movieJoa/listMovie.do">영화 목록</a></li>
					    <li><a href="/movieJoa/addMovieForm.do">영화 등록</a></li> 				
					</ul>
				</li>
				<li class="menu2"><a href="#">극장관리</a>
					<ul class="menu2_s submenu">
					    <li><a href="theaterList.do">상영관 좌석</a></li>
					    <li><a href="scheduleList.do">상영 스케줄</a></li>
					</ul>
				</li>
				<li class="menu2"><a href="/movieJoa/listAdminPay.do">예매현황</a>
					<ul class="menu2_s submenu">
					    <li>예매현황</li>
					</ul>
				</li>
				<li class="menu2"><a href="/movieJoa/listReview.do">평점관리</a>
					<ul class="menu2_s submenu">
					    <li>평점 목록</li>
					</ul>
				</li>
				<li class="menu2"><a href="/movieJoa/listEvent.do">이벤트관리</a>
					<ul class="menu2_s submenu">
					    <li><a href="/movieJoa/listEvent.do">이벤트 목록</a></li>
					    <li><a href="/movieJoa/addEvent.do">이벤트 등록</a></li>
					    <li><a href="/movieJoa/listApplycant.do">이벤트 참여 현황</a></li>
					</ul>
				</li>
				<li class="menu2"><a href="#">고객센터</a>
					<ul class="menu2_s submenu">
					    <li>공지게시판</li>
					    <li>자주 찾는 질문</li>
					    <li>지점 관리자 답변 내역</li>
					    <li>고객 문의내역</li>
					    <li>이메일 문의</li>
					</ul>
				</li>
				<li class="menu2"><a href="/movieJoa/listCoupon.do">쿠폰관리</a>
					<ul class="menu2_s submenu">
					    <li><a href="/movieJoa/addCouponForm.do">쿠폰 등록</a></li>
					    <li><a href="/movieJoa/listCoupon.do">쿠폰 목록</a></li>
					    <li><a href="/movieJoa/listOwncou.do">쿠폰 보유 현황</a></li>
					</ul>
				</li>
				<li class="menu2"><a href="#">스토어관리</a>
					<ul class="menu2_s submenu">
					    <li><a href="adminStore.do">상품 목록</a></li>
					    <li><a href="adminStoreAdd.do">상품 등록</a></li>
					</ul>
				</li>
				<li class="menu2"><a href="adminMemberMain.do">회원관리</a>
					<ul class="menu2_s submenu">
					    <li>일반회원</li>
					    <li>관리자</li>
					</ul>
				</li>
				<li class="menu2"><a href="adminRevenueMain.do">매출관리</a>
					<ul class="menu2_s submenu">
					    <li>지점별</li>
					    <li>영화별</li>
					    <li>스토어</li>
					    <li>성별</li>					    
					    <li>나이</li>
					    <li>관람객</li>
					</ul>
				</li>
			</ul> 	
		</div>
	</div>
	<hr size="2px" color="#808080">
	<div class="menu_space"></div>
</header>
</body>
</html>