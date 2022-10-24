<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function kakaoAddr(){
	new daum.Postcode({
        oncomplete: function(data) {
            document.getElementById('addr').value=data.address;
            document.getElementById('addr_num').value=data.zonecode;
        }
    }).open();
}
</script>
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
function validate(){
	
	var regExp=/^[a-zA-Z0-9]{4,12}$/;
	var pwd_regExp=/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*-+_]).{4,12}$/;
	var name_regExp=/^[가-힣]{2,10}$/;
	var age_regExp=/^[0-9]{8}$/;
	var tel_regExp=/^010?([0-9]{3,4})?([0-9]{4})$/;
	var email_regExp=/^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z]{2,6}$/;
	
	if(document.getElementById('idCheck').value==''){
		window.alert('아이디를 입력해주세요.');
		return false;
	}
	if(!regExp.test(document.getElementById('idCheck').value)){
		window.alert('ID는 4~12자의 영문과 숫자로만 입력해주세요.');
		return false;
	}
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
	if(document.getElementById('pwd2').value==''){
		window.alert('비밀번호를 확인해주세요.');
		return false;
	}
	if(document.getElementById('age').value==''){
		window.alert('생년월일을 입력해주세요.');
		return false;
	}
	if(!age_regExp.test(document.getElementById('age').value)){
		window.alert('생년월일을 확인해주세요.');
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
	if(document.getElementById('pwd1').value!=document.getElemetById('pwd').value){
		window.alert('비밀번호가 일치하지 않습니다.');
		return false;
	}
	if(document.getElementById('addr_sub').value==''){
		window.alert('상세주소를 입력해주세요.');
		return false;
	}
}
</script>
<script>
var XHR=null;
function getXHR(){
	if(window.ActiveXObject){
		return new ActiveXObject('Msxml2.XMLHTTP');
	}else if(window.XMLHttpRequest){
		return new XLHttpRequest();
	}else{
		return null;
	}
}
function show(){
	var name=document.memberJoinForm.mem_id.value;
	var param='mem_id='+mem_id;
	XHR=getXHR();
	XHR.onreadystatechange=showResult;
	XHR.open('GET','memberIdCheck.do'+param,true);
	XHR.send(null);
}
function showResult(){
	if(XHR.readyState==4){
		if(XHR.status==200){
			var data=XHR.responseText;
			window.alert(data);
		}	
	}
}
</script>
</head>
<body>
<c:import url="../header.jsp"></c:import>
<h1>회원가입</h1>
<section>
	<article>
	<form name="memberJoinForm" method="post" action="memberJoinFormSubmit.do" onsubmit="return validate();">
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" name="mem_id" id="idCheck" placeholder="사용할 ID를 설정하세요." onchange="shoow()">
				<span class="setId">아이디는 4~12로 설정해주세요.</span>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="mem_name" id="name"placeholder="이름을 설정해주세요."></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="mem_pwd" id="pwd1" onchange="isTrue()">
				<span>비밀번호 4~12자 입력가능</span></td>
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td><input type="password" name="mem_pwd_check" id="pwd2" onchange="isTrue()">
				<span id="checkpwd"></span></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="text" name="mem_age" id="age" placeholder="YYYYMMDD"></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><input type="radio" name="mem_gender" value="남" checked>남
				<input type="radio" name="mem_gender" value="여">여</td>
			</tr>
			<tr>
				<th>휴대전화</th>
				<td><input type="text" name="mem_tel" placeholder="(-)생략" id="tel"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="mem_email" placeholder="이메일을 설정해주세요." id="email"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" id="addr" readonly onclick="kakaoAddr()"></td>
			</tr>
			<tr>
				<th>우편 번호</th>
				<td><input type="text" id="addr_num" readonly></td>
			</tr>
			<tr>
				<th>상세 주소</th>
				<td><input type="text" id="addr_sub"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="가입하기">
				<input type="reset" value="다시작성"></td>
			</tr>
		</table>
	</form>
	</article>
</section>
<c:import url="../footer.jsp"></c:import>
</body>
</html>