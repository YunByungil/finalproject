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
			<a href="index.do"><h1>MJOA</h1></a>
		</div>
		<div class="nav_menu">
			<a href="#"><span class="material-symbols-outlined">lock</span>로그인</a>
			<a href="memberJoin.do"><span class="material-symbols-outlined">person_add</span>회원가입</a>		
			<a href="helpDest.do"><span class="material-symbols-outlined">support_agent</span>고객센터</a>
			<a href="adminStore.do">관리자페이지</a>
		</div>		
	</div>
	<hr size="1px" color="#dcdcdc">
	<div class="category">
		<div class="category_menu">
			<ul class="myMenu">
				<li class="menu1"><a href="#">영화</a>
					<ul class="menu1_s submenu">
					    <li>무비차트</li>
					    <li>개봉예정작</li> 
				    </ul>
				</li>
				<li class="menu2"><a href="#">극장</a>
					<ul class="menu2_s submenu">
					    <li>극장</li>
					    <li>예매</li>
					</ul>
				</li>
				<li class="menu3"><a href="joaStore.do">스토어</a>
					<ul class="menu3_s submenu">
					    <li>콤보</li>
					    <li>팝콘</li>
					    <li>음료</li>
					    <li>스낵</li>
					</ul>
				</li>
				<li class="menu4"><a href="/movieJoa/joaEventMain.do">이벤트</a>
					<ul class="menu4_s submenu">
					    <li href="/movieJoa/joaEventMain.do">진행중인 이벤트</li>
					    <li href="">당첨자 발표 조회</li>
					    <li href="/movieJoa/joaEventEnded.do">종료된 이벤트</li>
				    </ul>
				</li>
				<li class="menu5"><a href="myPage.do">마이페이지</a>
					<ul class="menu5_s submenu">			    
					    <li>내정보</li>
					    <li>이벤트참여내역</li>
					    <li>포인트 사용내역</li>
					    <li>쿠폰</li> 					    
					    <li>예매내역</li>
					    <li>내가 본 영화</li> 					    
					    <li>내가 쓴 평점</li>
					    <li>나의 등급</li>
					    <li>나의 문의</li> 					    
					    <li>내 스토어샵</li>
					    <li>프로필 관리</li> 					    		     		
					</ul>		
				</ul>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="text"><span class="material-symbols-outlined">search</span>
		</div>
	</div>
	<hr size="2px" color="red">
</header>
</body>
</html>