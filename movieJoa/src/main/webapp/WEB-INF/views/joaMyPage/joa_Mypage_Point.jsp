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
				<dd>예매취소</dd>
			<a href="myPage_coupon.do"><dt>관람권 관리</dt></a>
			<a href="myPage_coupon.do"><dd>MovieJoa 영화관람권</dd></a>
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
			<div class="tiket_subject">포인트 적립내역</div>
			<br>
		<div class="my_ticet">
			<hr class="ti_hr">
			<br>
			<table class="po_border">
			
			<thead>
				<th class="po_type">구분</th>
				<th class="po_content">포인트</th>
			</thead>
		
			<tbody>
				<tr>
					<td>사용가능 포인트</td><td></td>
				</tr>
				<tr>	
					<td>등급선정 포인트</td><td></td>
				</tr>
				<tr>	
					<td>추가적립 포인트</td><td></td>
				</tr>		
			</tbody>
			</table>
			
			<hr class="ti_hr">
			</div>
			<br>
			<div class="ti_cancl_sub">포인트 사용내역<br></div>
			<br>
			<div class="serchBar_usedCoupon">
				<div class="serchBar_sub">조회기간</div>
				<div class="serchBar_type"><input type="button" value="2주일" class="serchBar_button">&nbsp;<input type="button" value="1개월" class="serchBar_button">&nbsp;<input type="button" value="전체" class="serchBar_button"></div>
				<div class="serchBar_date"><input type="date" class="serchBar_input">&nbsp;~&nbsp;<input type="date" class="serchBar_input">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="조회하기" class="serchBar_i_button"></div>
			</div>
			
			<div class="ti_cl_div">
				<hr class="ti_hr">
				
				<br>
					<table class="ti_cl_border">
					<thead>
						<th>구분</th>
						<th>사용처</th>
						<th>구매일</th>
						<th>소모포인트</th>
					</thead>
					<tbody>
						<c:if test="${empty list }">
						<tr><td colspan="4"><br></td></tr>
						<tr>
							<td colspan="4">고객님의 최근 포인트 소비 내역이 존재하지 않습니다.</td>
						</tr>
						</c:if>
						<c:forEach var="dto" items="${list }">
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