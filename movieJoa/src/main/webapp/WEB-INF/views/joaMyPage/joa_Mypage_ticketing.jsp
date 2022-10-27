<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css?ver=2">
<link rel="stylesheet" type="text/css" href="css/joaMypage.css?ver=2">
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
		
		<div class="joaMypage_ti">
			<div class="tiket_subject">나의 예매내역</div>
			<div class="sub_ob">최근 <d>1개월</d>간의 예매내역을 확인하실 수 있습니다.</div>
		<div class="my_ticet">
			<div class="myMovie_button_div"><input type="button" value="내가 본 영화" class="myMovie_button"></div>
			<hr class="ti_hr">
			<br>
			<div class="ti_guide_1">현장에서 발권하실 경우 꼭 <d>예매번호</d>를 확인하세요.</div>
			<div class="ti_guide_2">티켓판매기에서 <d>예매번호</d>를 입력하시면 티켓을 발급받을 수 있습니다.</div>
			<br>
			<table class="ti_border">
			
			<thead>
				<th>관람영화</th>
				<th>관람영화관</th>
				<th>상영일자</th>
				<th>예매좌석</th>
				<th>예매번호</th>
				<th>결제금액</th>
			</thead>
		
			<tbody>
			<c:if test="${empty swm_list }">
				<tr><td colspan="6"><br></td></tr>
				<tr>
					<td colspan="6">고객님의 최근 예매내역이 존재하지 않습니다.</td>
				</tr>
			</c:if>
				<c:forEach var="swm_dto" items="${swm_list }">
					<tr>
						<td>${swm_dto.payMov_mov_title }</td>
						<td>${swm_dto.payMov_the_branch }</td>
						<td>${swm_dto.payMov_sch_day } / ${ payMov_sch_start_hour } / ${ payMov_sch_start_min }</td>
						<td>${swm_dto.payMov_sch_seat }</td>
						<td>${swm_dto.payMov_the_idx }</td>
						<td>${swm_dto.payMov_price }</td>
					</tr>
				</c:forEach>
			</tbody>
			</table>
			
			<hr class="ti_hr">
			</div>
			<br>
			<div class="ti_cancl_sub">MY취소내역<br>
			<div class="sub_ob">상영일 기준 지난 <d>7일</d>동안의 취소내역입니다.</div>
			</div>
			<div class="ti_cl_div">
				<hr class="ti_hr">
				
				<br>
					<table class="ti_cl_border">
					<thead>
						<th>관람영화</th>
						<th>관람영화관</th>
						<th>취소일</th>
						<th>결제취소금액</th>
					</thead>
					<tbody>
						<c:if test="${empty list_cancel }">
						<tr><td colspan="4"><br></td></tr>
						<tr>
							<td colspan="4">고객님의 최근 예매내역이 존재하지 않습니다.</td>
						</tr>
						</c:if>
						<c:forEach var="dto" items="${list_cancel }">
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
</div>
</section>
<c:import url="../footer.jsp"></c:import>
</body>
</html>