<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css?ver=14">
<link rel="stylesheet" type="text/css" href="css/joaMypage.css?ver=14">
<title>Insert title here</title>
</head>
<script>
	var count = 0;
	var inputse = document.getElementsByClassName('p_content');
	function inputs(){
		count++;
		if(count%2==1){
			for(var i = 0; i<inputse.length; i++){
				inputse[i].readOnly = false;
			}
		}else{
			for(var i = 0; i<inputse.length; i++){
				inputse[i].readOnly = true;
			}
		}
		
		}
</script>
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
			<div class="tiket_subject">프로필 등록</div>
			<div class="p_button1"><input type="button" value="변경하기" id="p_button1_b" onclick="inputs()"></div>
			<br>
			<div class="my_ticet">
			<hr class="ti_hr">
			<input type="hidden" name="pro_id" value="${mem_id }">
			<div class="P_title">닉네임</div><div class="p_content1"><input type="text" name="pro_nickname" class="p_content" readonly></div>
			<hr class="ti_hr">
			<div class="ad">
			각 서비스(이벤트, 매거진, 영화리뷰 등)의 리뷰 및 덧글작성시 등록하신 대표이미지가 노출됩니다.<br>
			프로필 이미지 종류를 선택해 주세요.
			<hr class="ad_hr">
			</div>
			<div class="P_title" id="P_title1">프로필 이미지</div><div class="p_content2_2"><div class="fileimage">이미지</div><input type="file" name="pro_image" value="파일선택" class="file"></div>
			<hr class="ti_hr">
			<div class="p_button2"><input type="button" value="변경완료" id="p_button2_b"></div>
			<hr class="ti_hr">
			</div>
			</div>
		</div>
</div>
</section>
<c:import url="../footer.jsp"></c:import>
</body>
</html>