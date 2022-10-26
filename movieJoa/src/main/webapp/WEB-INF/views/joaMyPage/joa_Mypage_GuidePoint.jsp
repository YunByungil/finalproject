<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css?ver=6">
<link rel="stylesheet" type="text/css" href="css/joaMypage.css?ver=6">
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
		
		<div class="joaMypage_home" style="">
		<div class="tiket_subject">포인트 적립/사용안내</div>
		<br>
		<div class="my_guidepoint">
		<hr>
		<br>
			※참고하세요※<br>
			‘영화 상영일 이전’이란?<br>
			‘예매일자가 상영일자 이전’인 경우를 말합니다. 단, 24시 이후 상영하는 심야영화는 당일 영화로 구분합니다.<br>
			<br>
			예시) 4월 7일 24시 10분 영화(4월 8일 밤 12시 10분)의 경우,<br>
			4월 6일 23시 59분까지 예매할 시 사전예매 적립율이 적용되며,<br>
			4월 7일 00시 01분(4월 6일 밤 12시 01분)에 예매할 경우 당일 예매 적립율 적용<br>
			<br>
			※세부 사항※
			<br>
			① 영화 예매 시<br>
			온라인(모바일, 홈페이지)을 통한 티켓 구매 시 또는 전 극장에서 멤버십 회원이 티켓을 구매하면서 회원 전화번호를 제공한 경우, 유료영화관람금액(실 결제 금액)에 영화 예매 시점에 해당하는 포인트를 적립할 수 있습니다.<br>
			포인트 적립은 유료 구매 시에만 가능하며, 상영 이후 사후 적립은 불가능 합니다.<br>
			포인트는 상영일 익일에 적립되며, 적립된 포인트 내역은 영화 관람 다음날 확인할 수 있습니다. 적립된 포인트의 유효기간은 적립월 기준 2년간 입니다.<br>
			포인트 적립 규모의 한도는 없으나, 구매/적립 횟수는 1일 6회(현장 및 온라인) 또는 구매/적립매수 1일 24매(온라인 예매 시)로 제한됩니다. (2매씩 예매 시 6회 12매까지 가능, 8매씩 예매 시 3회 24매까지 가능) 단체 관람을 통해 할인을 받을 경우 포인트는 적립되지 않습니다.<br>
			② 매점 이용 시<br>
			매점 상품 구매 시 유료구매금액(실 결제 금액)의 0.5%에 해당하는 포인트를 적립할 수 있습니다.<br>
			③ 스토어샵 이용 시<br>
			스토어샵 식음료 이용 시에는 유료 이용금액의 0.1%에 해당하는 포인트를 적립할 수 있습니다.<br>
			④ 공통<br>
			포인트는 적립된 포인트가 1,000 포인트 이상이 될 경우 전국 MOVIEJOA에서 영화 관람 또는 매점 이용 시 1포인트를 1원으로 현금처럼 사용할 수 있습니다. 온라인 예매는 1,000 포인트 이상 10포인트 단위로 사용가능하며, 극장에서 티켓을 구매하거나 매점에서 사용 시에는 500포인트 단위로 사용 가능합니다.<br>
			<br>
			무비머니(영화관람 상품권, 4Dplex 관람권, 3D 관람권 등)와 골드클래스 관람권, 스토어샵 상품권 등의 유가 증권, 기프티켓(모바일 영화관람권) 구매 시 포인트는 적립되지 않습니다. 무비머니(영화관람 상품권, 4Dplex 관람권, 3D 관람권 등)와 골드클래스 관람권, 씨네드쉐프 상품권 등의 유가 증권, 기프티켓(모바일 영화관람권)으로 영화 관람 시 포인트는 적립되지 않습니다. 포인트로 무비머니(영화관람 상품권, 4Dplex 관람권, 3D 관람권 등)와 골드클래스 관람권, 스토어샵 상품권 등의 유가 증권, 기프티켓(모바일 영화관람권)을 구매할 수 없습니다.<br>
			<br>
			일부 할인/관람 쿠폰, 일부 상품, 일부 극장/매장의 경우 포인트가 적립되지 않거나 별도의 적립율이 적용될 수 있으며, 상세 내용은 해당 쿠폰, 상품, 극장/매장 등에 별도 공지 합니다.<br>
			일부 제휴 관람권의 적립은 제휴사와의 계약에 따라 적립율이 정해집니다. 세부 적립율은 제휴사의 서비스 약관 등을 통해 안내합니다. 일부 제휴 포인트의 경우 포인트와 중복 적립되지 않으며 적립이 제한될 경우 제휴사 홈페이지 등에서 안내합니다.<br>
			<br>
			<hr>
		</div>
	</div>
</div>
</section>
<c:import url="../footer.jsp"></c:import>
</body>
</html>