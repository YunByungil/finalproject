<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<style>
    ul, ol, li { list-style:none; margin:0; padding:0; }
   
    ul.myMenu {}
    ul.myMenu > li { z-index:2; display:inline-block; width:120px; padding:5px 10px; background:white; text-align:center; position:relative; }
    ul.myMenu > li:hover { background:#fff; }
    ul.myMenu > li ul.submenu { display:none; position:absolute; border:1px solid #eee; top:30px; left:0; }
    ul.myMenu > li:hover ul.submenu { display:block; }
    ul.myMenu > li ul.submenu > li { display:inline-block; width:120px; padding:5px 10px; background:white; border:1px solid #eee; text-align:center; }
    ul.myMenu > li ul.submenu > li:hover { background:#fff; }

   .login_area{
      width:1200px;
      text-align: right
   }   
</style>
</head>
<header>
   <div class="login_area">
      <c:choose>
         <c:when test="${userInfo.mem_id!=null }">${userInfo.mem_name }님</c:when>
         <c:when test="${adminInfo.admin_id!=null }">${adminInfo.admin_area } ${adminInfo.admin_shop }지점 관리자</c:when>
      </c:choose>
   </div>
   <div class="nav">
      <div class="logo">
         <a href="index.do"><h1>MJOA</h1></a>
      </div>
      <div class="nav_menu">


         <c:choose>
            <c:when test="${userInfo.mem_id==null&&adminInfo.admin_id==null }">
               <a href="memberLogin.do"><span
                  class="material-symbols-outlined">person</span>로그인</a>
            </c:when>
            <c:when test="${userInfo.mem_id!=null }">
               <a href="memberLogout.do"><span
                  class="material-symbols-outlined">person</span>로그아웃</a>
            </c:when>
            <c:when test="${adminInfo.admin_id!=null }">
               <a href="adminLogout.do"><span
                  class="material-symbols-outlined">person</span>로그아웃</a>
            </c:when>
         </c:choose>

         <a href="memberJoin.do"><span class="material-symbols-outlined">person_add</span>회원가입</a>
         <a href="myPage.do?sid=test"><span class="material-symbols-outlined">account_circle</span>마이페이지</a>
         <a href="helpDest.do"><span class="material-symbols-outlined">support_agent</span>고객센터</a>
         <c:if test="${adminInfo.admin_id!=null }">
         <a href="adminStore.do">관리자페이지</a></c:if>
      </div>      
   </div>
   <hr size="1px" color="#dcdcdc">
   <div class="category">
      <div class="category_menu">
         <ul class="myMenu">
            <li class="menu1"><a href="joaMovie.do">영화</a>
               <ul class="menu1_s submenu">
                   <li><a href="joaMovie.do">무비차트</a></li>
                   <li><a href="joaPreMovie.do">상영예정작</a></li> 
                </ul>
            </li>
            <li class="menu2"><a href="#">극장</a>
               <ul class="menu2_s submenu">
                   <li><a href="joaTheater.do">극장</a></li>
                   <li><a href="book.do">예매</a></li>
               </ul>
            </li>
            <li class="menu3"><a href="joaStore.do">스토어</a>
               <ul class="menu3_s submenu">
                  <c:url var="comboUrl" value="joaStoreCategory.do">
                     <c:param name="category">콤보</c:param>
                  </c:url>
                  <c:url var="popcornUrl" value="joaStoreCategory.do">
                     <c:param name="category">팝콘</c:param>
                  </c:url>
                  <c:url var="snackUrl" value="joaStoreCategory.do">
                     <c:param name="category">스낵</c:param>
                  </c:url>
                  <c:url var="drinkUrl" value="joaStoreCategory.do">
                     <c:param name="category">음료</c:param>
                  </c:url>
                   <li><a href="${comboUrl }">콤보</a></li>
                   <li><a href="${popcornUrl }">팝콘</a></li>
                   <li><a href="${snackUrl }">스낵</a></li>
                   <li><a href="${drinkUrl }">음료</a></li>
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