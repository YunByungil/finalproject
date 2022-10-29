<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/main.css?ver=13">
<link rel="stylesheet" type="text/css" href="css/joaMypage.css?ver=13">
<title>Insert title here</title>
</head>
<script>
function isTrue(){
	if(document.getElementById('pwd1').value!=''&&document.getElementById('pwd2').value!=''){
		if(document.getElementById('pwd1').value==document.getElementById('pwd2').value){
			document.getElementById('checkpwd').innerHTML='비밀번호일치';
			document.getElementById('checkpwd').style.color='green';
		}else{
			document.getElementById('checkpwd').innerHTML='비밀번호불일치';
			document.getElementById('checkpwd').style.color='red';
		}
	}
}
</script>

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
<script>
function validate(){
	
	var regExp=/^[a-zA-Z0-9]{4,12}$/;
	var pwd_regExp=/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*-+_]).{4,12}$/;
	var name_regExp=/^[가-힣]{2,10}$/;
	var tel_regExp=/^010?([0-9]{3,4})?([0-9]{4})$/;
	var email_regExp=/^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z]{2,6}$/;
	
	if(document.getElementById('name').value==''){
		window.alert('이름을 입력해주세요.');
		return false;
	}
	if(!name_regExp.test(document.getElementById('name').value)){
		window.alert('올바른 이름을 적어주세요.');
		return false;
	}
	if(document.getElementById('pwd1').value==''){
		window.alert('비밀번호를 입력해주세요.');
		return false;
	}
	if(!pwd_regExp.test(document.getElementById('pwd1').value)){
		window.alert('비밀번호는 4~12자의 영문,숫자,특수기호 조합으로만 입력해주세요.');
		return false;
	}
	if(document.getElementById('tel').value==''){
		window.alert('휴대전화번호를를 입력해주세요.');
		return false;
	}
	if(!tel_regExp.test(document.getElementById('tel').value)){
		window.alert('올바른 번호를 입력해주세요.');
		return false;
	}
	if(document.getElementById('email').value==''){
		window.alert('이메일 주소를 입력해주세요.');
		return false;
	}
	if(!email_regExp.test(document.getElementById('email').value)){
		window.alert('올바른 이메일 주소를 입력해주세요.');
		return false;
	}
}
</script>

</script>
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
			<div class="tiket_subject">개인정보변경</div>
			<form name="pro_FM" action="upDateProfile.do" onsubmit="return validate();"></form>
			<div class="p_button1"><input type="button" value="변경하기" id="p_button1_b" onclick="inputs()"></div>
			<br>
			<div class="my_ticet">
			<hr class="ti_hr">
			<div class="P_title">이름</div><div class="p_content1"><input type="text" id="name" name="mem_name" class="p_content" value="${dto.mem_name }" readonly></div>
			<hr class="ti_hr">
			<div class="P_title">비밀번호 변경</div><div class="p_content1"><input type="password" name="mem_pwd" id="pwd1" onchange="isTrue()" readonly class="p_content"></div>
			<hr class="ti_hr">
			<div class="P_title">비밀번호 확인</div><div class="p_content1"><input type="password" name="mem_pwd_check" id="pwd2" onchange="isTrue()" readonly class="p_content">
				<span class="span" id="checkpwd"></span><e>비밀번호는 4~12자의 영문,숫자,특수기호 조합으로만 입력해주세요.</e></div>
			<hr class="ti_hr">
			<div class="P_title">연락처</div>
			<div class="p_content4"><input type="text" name="mem_tel" placeholder="(-)생략" id="tel"readonly class="p_content"></div>
			<hr class="ti_hr">
			<div class="P_title">E-mail</div><div class="p_content0"><input type="text" name="mem_email" value="${dto.mem_email }" id="email" readonly class="p_content">
			</div>
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