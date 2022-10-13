<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/joaMypage.css">
<title>Insert title here</title>
</head>
<body>
<c:import url="../header.jsp"></c:import>
<section>
<div class="mypage_main">
	<div class="myInformation">
		<div class="mynickname">
			<ul>
				<li>프로필사진</li>
				<li>이름</li>
				<li>아이디</li>
				<li>닉네임</li>
				<hr>
				<li>등급</li>
				<li>지난등급이력 조히</li>
			</ul>
		</div>
		<div class="mycoupon">
			<li>보유 관람권</li>
			<li>관람권 사용내역</li>
		</div>
		<div class="mypoint">
			<li>보유 포인트</li>
			<li>포인트 사용내역</li>
		</div>
	</div>
	<br>
	<div class="mypagecontaniner">
		<dl class="mymenubar">
			<dt>나의 예매내역</dt>
			<dt>관람권 관리</dt>
				<dd>MovieJoa 영화관람권</dd>
			<dt>포인트 관리</dt>
				<dd>포인트 적립/사용안내</dd>
				<dd>포인트 적립/사용내역</dd>
			<dt>이벤트 참여내역</dt>
			<dt>스토어</dt>
				<dd>내 스토어</dd>
				<dd>결제내역</dd>
			<dt>회원정보</dt>
				<dd>회원정보 관리</dd>
				<dd>회원탈퇴</dd>
			<dt>프로필 관리</dt>
			<dt>나의 문의내역</dt>
		</dl>
		
		<div class="joaMypage_home">
			<div class="mythreelink">
					<div class="myfavoritesmovie">
						<div>이미지</div>
						<div class="myfavoritesmovie_subject">기대되는 영화</div>
						<div>보고싶은 영화를 미리</div>
						<div>다운받고싶다면?</div>
					</div>
					
					<div class="mywatchingmovie">
						<div>이미지</div>
						<div class="mywatchingmovie_subject">내가 본 영화</div>
						<div>관람한 영화들을 한번에</div>
						<div>모아보고싶다면?</div>
					</div>
					
					<div class="mywrite">
						<div>이미지</div>
						<div class="mywrite_subject">내가 쓴 평점</div>
						<div>관람한 내 감상평을 적어</div>
						<div>추억하고싶다면?</div>
					</div>
				</div>
					<br>
					<div class="myticketing">
						<div>내 예매내역</div>
					</div>
				
					<div class="myinquiry">
						<div>내 문의</div>
					</div>
			</div>
		</div>
</div>
</section>
<c:import url="../footer.jsp"></c:import>
</body>
</html>