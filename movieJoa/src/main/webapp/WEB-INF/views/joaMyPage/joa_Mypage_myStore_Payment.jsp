<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css?ver=3">
<link rel="stylesheet" type="text/css" href="css/joaMypage.css?ver=3">
<title>Insert title here</title>
<script>
 function select(){
	
 }
</script>
</head>
<body>
<c:import url="../header.jsp"></c:import>
<section>
<div class="mypage_main">
	<div class="myInformation">
		<div class="myproF">
		<c:if test="${empty pdto.pro_image }">
			<img height="90" width="100" src="/movieJoa/img/joaPofiel_img/noimage.PNG">
		</c:if>
		<c:if test="${!empty pdto.pro_image }">
		<img height="90" width="90" src="/movieJoa/img/joaPofiel_img/${pdto.pro_image }">
		</c:if>
		</div>
		<div class="mynickname">
			<ul class="ul_p">
				<li class="li_o"><l>${dto.mem_name } 님</l> 환영합니다.</li>
				<li class="li_p"><l1>회원 아이디</l1> | ${dto.mem_id }</li>
				<li class="li_p" id="li_p"><l1>프로필 닉네임</l1> | ${pdto.pro_nickname}</li>
			</ul>
		</div>
		<hr class="hr">
		<div class="mygrade">
			<li class="li_o">등급 ${m_grade }</li>
			<li class="li_i"><input type="button" value="지난등급 이력 조회" class="gradebutton"></li>
		</div>
		<div class="mycoupon">
			<li class="my_c_p">My Coupon</li>
			<li><br></li>
			<li>보유 관람권 | ${couponCount } 개</li>
			<li><br></li>
			<li>최근 관람권 사용내역</li>
			<li><br></li>
			<c:if test="${empty datelist }">
			<li>최근 사용하신 관람권이 없습니다.</li>
			</c:if>
			<c:forEach var="date" items="${datelist }">
				<li>${date.own_use_date }</li>
			</c:forEach>
		</div>
		<div class="mypoint">
			<li class="my_c_p">My Point</li>
			<li><br></li>
			<li>보유 포인트 ${dto.mem_point }</li>
			<li><br></li>			
		</div>
	</div>
	<br>
	<div class="mypagecontaniner">
		<dl class="mymenubar">
			<a href="myPage_tiket.do" class="My_bar_a"><dt class="My_bar">나의 예매내역</dt></a>
				<a href="myPage_cancle_Movie_Move.do" class="My_bar_a"><dd>예매취소</dd></a>
			<a href="myPage_coupon.do" class="My_bar_a"><dt class="My_bar">관람권 관리</dt></a>
			<a href="myPage_coupon.do" class="My_bar_a"><dd>MovieJoa 영화관람권</dd></a>
			<a href="myPage_GuidePoint.do" class="My_bar_a"><dt class="My_bar">포인트 관리</dt></a>
				<a href="myPage_GuidePoint.do" class="My_bar_a"><dd>포인트 적립/사용안내</dd></a>
				<a href="myPage_Point.do" class="My_bar_a"><dd>포인트 적립/사용내역</dd></a>
			<a href="myPage_Event.do" class="My_bar_a"><dt class="My_bar">이벤트 참여내역</dt></a>
			<a href="myPage_Store.do" class="My_bar_a"><dt class="My_bar">스토어</dt></a>
				<a href="myPage_Store.do" class="My_bar_a"><dd>내 스토어</dd></a>
				<a href="myPage_Store_Payment.do" class="My_bar_a"><dd>결제내역</dd></a>
			<a href="myPage_PW_Check_M.do" class="My_bar_a"><dt class="My_bar">회원정보</dt></a>
				<a href="myPage_PW_Check_M.do" class="My_bar_a"><dd>회원정보 관리</dd></a>
				<a href="myPage_PW_Check_E.do" class="My_bar_a"><dd>회원탈퇴</dd></a>
			<a href="myPage_PW_Check_P.do" class="My_bar_a"><dt class="My_bar">프로필 관리</dt></a>
			<a href="myPage_myService.do" class="My_bar_a"><dt class="My_bar">나의 문의내역</dt></a>
		</dl>
		
		
		<div class="joaMypage_ti">
			<div class="tiket_subject">내 스토어샵</div>
			<br>
			<div class="serchBar_usedCoupon">
				<div class="serchBar_sub2">조회유형</div>
				<div class="serchBar_sub1">조회기간</div>
				<div class="serchBar_type">
				<input type="radio" id="radio1" name="type" value="사용가능" class="serchBar_button_1">
				<label for="radio1">사용가능</label>
				&nbsp;<input type="radio" id="radio2" name="type" value="사용완료" class="serchBar_button_1">
				<label for="radio2">사용완료</label>
				&nbsp;<input type="radio" id="radio3" name="type" value="기간만료" class="serchBar_button_1">
				<label for="radio3">기간만료</label>
				&nbsp;<input type="radio" id="radio4" name="type" value="취소/환불" class="serchBar_button_1">
				<label for="radio4">취소/환불</label>
				</div>
				<div class="serchBar_date"><input type="date" class="serchBar_input">&nbsp;~&nbsp;<input type="date" class="serchBar_input">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="조회하기" class="serchBar_i_button"></div>
			</div>
		<div class="my_ticet">
			<hr class="ti_hr">
			<br>
			<table class="ti_border">
			<thead>
				<th>스토어.NO</th>
				<th>상품명</th>
				<th>구매일</th>
				<th>가격</th>
				<th>수량</th>
			</thead>
		
			<tbody>
			<c:if test="${empty list }">
				<tr><td colspan="5"><br></td></tr>
				<tr>
					<td colspan="5">내역이 존재하지 않습니다.</td>
				</tr>
			</c:if>
				<c:forEach var="p_dto" items="${list }">
					<tr>
						<td>${p_dto.prs_idx }</td>
						<td>${p_dto.prs_pro_name }</td>
						<td>${p_dto.prs_date }</td>
						<td>${p_dto.prs_pro_price }</td>
						<td>${p_dto.prs_pro_count  }</td>
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