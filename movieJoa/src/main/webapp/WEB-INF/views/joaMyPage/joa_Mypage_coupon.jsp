<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css?ver=4">
<link rel="stylesheet" type="text/css" href="css/joaMypage.css?ver=4">
<title>Insert title here</title>
<script>
	function insertCoupon(){
		window.open('self_ATNTCN.do', 'self_ATNTCN_coupon', 'width=800, height=400');
	}
</script>
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
				<a href="myPage_cancle_Coupon.do"><dd>예매취소</dd></a>
			<a href="myPage_coupon.do"><dt>관람권 관리</dt></a>
			<a href="myPage_coupon.do"><dd>MovieJoa 영화관람권</dd></a>
			<a href="myPage_GuidePoint.do"><dt>포인트 관리</dt></a>
				<a href="myPage_GuidePoint.do"><dd>포인트 적립/사용안내</dd></a>
				<a href="myPage_Point.do"><dd>포인트 적립/사용내역</dd></a>
			<a href="myPage_Event.do"><dt>이벤트 참여내역</dt></a>
			<a href="myPage_Store.do"><dt>스토어</dt></a>
				<a href="myPage_Store.do"><dd>내 스토어</dd></a>
				<a href="myPage_Store_Payment.do"><dd>결제내역</dd></a>
			<a href="myPage_PW_Check_M.do"><dt>회원정보</dt></a>
				<a href="myPage_PW_Check_M.do"><dd>회원정보 관리</dd></a>
				<a href="myPage_PW_Check_E.do"><dd>회원탈퇴</dd></a>
			<a href="myPage_PW_Check_P.do"><dt>프로필 관리</dt></a>
			<a href="myPage_myService.do"><dt>나의 문의내역</dt></a>
		</dl>
		
		<div class="joaMypage_ti">
			<div class="tiket_subject">관람권 관리</div>
			<br>
			<div class="co_sub_op">영화 관람권 보유(등록) 내역</div>
		<div class="my_ticet">
			<hr class="ti_hr">
			<br>
			<br>
			<table class="ti_border">
			<thead>
				<th>관람권(번호)</th>
				<th>분류</th>
				<th>유효기간</th>
			</thead>
		
			<tbody>
			<c:if test="${empty list }">
				<tr><td colspan="3"><br></td></tr>
				<tr>
					<td colspan="3">고객님의 관람권 내역이 존재하지 않습니다.</td>
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