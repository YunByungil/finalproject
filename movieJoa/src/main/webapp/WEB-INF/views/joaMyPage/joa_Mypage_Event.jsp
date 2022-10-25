<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css?ver=5">
<link rel="stylesheet" type="text/css" href="css/joaMypage.css?ver=5">
<title>Insert title here</title>
</head>
<body>
<c:import url="../header.jsp"></c:import>
<section>
<div class="mypage_main">
	<div class="myInformation">
		<div class="myproF">
		프로필사진
		</div>
		<div class="mynickname">
			<ul class="ul_p">
				<li class="li_o">이름</li>
				<li class="li_p">아이디</li>
				<li class="li_p">닉네임</li>
				<li class="li_p"><input type="button" value="닉네임 변경" class="nickbutton"></li>
			</ul>
		</div>
		<hr class="hr">
		<div class="mygrade">
			<li class="li_o">등급</li>
			<li class="li_i"><input type="button" value="지난등급 이력 조회" class="gradebutton"></li>
		</div>
		<div class="mycoupon">
			<li class="my_c_p">My Coupon</li>
			<li><br></li>
			<li>보유 관람권</li>
			<li><br></li>
			<li>관람권 사용내역</li>
		</div>
		<div class="mypoint">
			<li class="my_c_p">My Point</li>
			<li><br></li>
			<li>보유 포인트</li>
			<li><br></li>
			<li>포인트 사용내역</li>
		</div>
	</div>
	<br>
	<div class="mypagecontaniner">
		<dl class="mymenubar">
			<a href="myPage_tiket.do"><dt>나의 예매내역</dt></a>
				<dd>예매취소</dd>
			<a href="myPage_coupon.do"><dt>관람권 관리</dt></a>
			<a href="myPage_coupon.do"><dd>MovieJoa 영화관람권</dd></a>
			<a href="myPage_usedCoupon.do"><dd>영화관람권 환불</dd></a>
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
		
		<div class="joaMypage_ti">
			<div class="tiket_subject">이벤트 참여 내역</div>
			<br>
			<div class="box">
			<ul class="EventSerchBarFeild">
				<li class="menuli"><a style="${backA_color}"class="a" href="myPage_Event.do">응모 내역</a></li>
				<li class="menuli"><a style="${backB_color}"class="a" href="">당첨자 발표</a></li>
			</ul>
			<hr class="ti_hr">
		</div>
		<div class="my_ticet">
			<br>
			<table class="ti_border">
			<thead>
				<th>이벤트 타입</th>
				<th>제목</th>
				<th>시작일</th>
				<th>종료일</th>
			</thead>
		
			<tbody>
			<c:if test="${empty list }">
				<tr><td colspan="4"><br></td></tr>
				<tr>
					<td colspan="4">내역이 존재하지 않습니다.</td>
				</tr>
			</c:if>
				<c:forEach var="dto" items="${list }">
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
			</table>
			
			<hr class="ti_hr">
			</div>
			<br>
</div>
</section>
<c:import url="../footer.jsp"></c:import>
</body>
</html>