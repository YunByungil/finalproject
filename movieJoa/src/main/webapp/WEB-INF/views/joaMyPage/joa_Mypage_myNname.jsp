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
		<img height="90" width="90" src="${pro_image }">
		
		</div>
		<div class="mynickname">
			<ul class="ul_p">
				<li class="li_o"><l>${dto.mem_name } 님</l> 환영합니다.</li>
				<li class="li_p"><l1>회원 아이디</l1> | ${dto.mem_id }</li>
				<li class="li_p" id="li_p"><l1>프로필 닉네임</l1> | ${pro_nickname}</li>
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
		
		<c:if test="${!empty pro_nickname }">
		<form name="update_pro_Fm" aciton="">
		<div class="joaMypage_ti">
			<div class="tiket_subject">프로필 변경</div>
			<div class="p_button1"><input type="button" value="변경하기" id="p_button1_b" onclick="inputs()"></div>
			<br>
			<div class="my_ticet">
			<hr class="ti_hr">
			<input type="hidden" name="pro_id" value="${mem_id }">
			<div class="P_title">닉네임</div><div class="p_content1"><input type="text" name="pro_nickname" class="p_content" value="${pro_nickname }" readonly></div>
			<hr class="ti_hr">
			<div class="ad">
			각 서비스(이벤트, 매거진, 영화리뷰 등)의 리뷰 및 덧글작성시 등록하신 대표이미지가 노출됩니다.<br>
			프로필 이미지 종류를 선택해 주세요.
			<hr class="ad_hr">
			</div>
			<div class="P_title" id="P_title1">프로필 이미지</div><div class="p_content2_2"><div class="fileimage"><img height="90" width="90" src="${pro_image }"></div><input type="file" name="pro_image" value="파일선택" class="file"></div>
			<hr class="ti_hr">
			<div class="p_button2"><input type="button" value="변경완료" id="p_button2_b"></div>
			<hr class="ti_hr">
			</div>
			</div>
		</div>
		</form>
		</c:if>
		<c:if test="${empty pro_nickname }">
		<form name="add_pro_FM" action="addProfile.do" method="post" enctype="multipart/form-data">
			<div class="joaMypage_ti">
			<div class="tiket_subject">프로필 등록</div>
			<br>
			<div class="my_ticet">
			<hr class="ti_hr">
			<div class="P_title">닉네임</div><div class="p_content1"><input type="text" name="pro_nickname" class="p_content"></div>
			<hr class="ti_hr">
			<div class="ad">
			각 서비스(이벤트, 매거진, 영화리뷰 등)의 리뷰 및 덧글작성시 등록하신 대표이미지가 노출됩니다.<br>
			프로필 이미지 종류를 선택해 주세요.
			<hr class="ad_hr">
			</div>
			<div class="P_title" id="P_title1">프로필 이미지</div><div class="p_content2_2"><div class="fileimage"><img height="90" width="100" src="/movieJoa/img/joaPofiel_img/noimage.PNG"></div><input type="file" accept="image/*" name="img" value="파일선택" class="file"></div>
			<hr class="ti_hr">
			<div class="p_button2"><input type="submit" value="등록하기" id="p_button2_b"></div>
			<hr class="ti_hr">
			</div>
			</div>
		</div>
		</form>
		</c:if>
		
</div>
</section>
<c:import url="../footer.jsp"></c:import>
</body>
</html>