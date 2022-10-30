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
				
			<a href="myPage_PW_Check_M.do" class="My_bar_a"><dt class="My_bar">회원정보</dt></a>
				<a href="myPage_PW_Check_M.do" class="My_bar_a"><dd>회원정보 관리</dd></a>
				<a href="myPage_PW_Check_E.do" class="My_bar_a"><dd>회원탈퇴</dd></a>
			<a href="myPage_PW_Check_P.do" class="My_bar_a"><dt class="My_bar">프로필 관리</dt></a>
			<a href="myPage_myService.do" class="My_bar_a"><dt class="My_bar">나의 문의내역</dt></a>
		</dl>
		
		<form name="reAnswerFM" action="reAnswerSetc.do">
				<input type="hidden" name="hqt_idx" value="${sdto.hqt_idx }">
				<input type="hidden" name="hqt_answerwrite" value="${sdto.hqt_answerwrite }">
				<input type="hidden" name="hqt_answerrank" value="${sdto.hqt_answerrank }">
		<div class="joaMypage_ti">
			<div class="tiket_subject">나의 문의 내역</div>
			<br>
			<div class="manyHelpbutton">
			<input type="submit" value="재답변 요청" class="deletebutton">
			</div>
		<table class="manyHelpBorderW">
			<tr>
			<td class="bordertype">지역 : ${sdto.hqt_region }</td>
			<td class="bordersubject">영화관 : ${sdto.hqt_cinema }</td>
			<td class="readnumW">등록일 : ${sdto.hqt_writedate }</td>
			</tr>
			<tr class="borderhead">
				<td class="bordertype">${sdto.hqt_type }</td>
				<td class="bordersubject">${sdto.hqt_subject }</td>
				<td class="readnum">${sdto.hqt_email }</td>
			</tr>
			<tr>
				<td colspan="3"><br></td>
			</tr>
			<tr>
				<td colspan="3" class="bordercontent">${sdto.hqt_content }</td>
			</tr>
			<tr>
				<td colspan="4"><hr></td>
			</tr>
			<tr class="borderhead">
				<td class="sid">관리자 ID : ${sdto.hqt_answerwrite }</td>
				<td class="rank">직책 : ${sdto.hqt_answerrank}</td>
				<td class="sdate">답변일 : ${sdto.hqt_answerdate }
				<br>재답변일 : ${sdto.hqt_reanswerdate }</td>
			</tr>
			<tr>
				<td colspan="3"><hr></td>
			</tr>
			<tr>
				<td colspan="3" class="bordercontent">${sdto.hqt_answercontent }</td>
			</tr>
		</table>
		</div>
		</form>
</div>
</section>
<c:import url="../footer.jsp"></c:import>
</body>
</html>