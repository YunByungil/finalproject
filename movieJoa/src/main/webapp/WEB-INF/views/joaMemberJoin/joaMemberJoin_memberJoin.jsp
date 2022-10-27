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
<style>
.textform {
  margin: 0px;
  padding: 0px;
  text-decoration: none;
  font-family:sans-serif;
}
body {
  background-image:#34495e;
}

.joinForm {
  position:absolute;
  width:400px;
  height:400px;
  padding: 30px, 20px;
  background-color:#FFFFFF;
  text-align:center;
  top:40%;
  left:50%;
  transform: translate(-50%,-50%);
  border-radius: 15px;
}
.textForm {
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px 10px;
}
.id {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:15px;
  background: none;
}
.pw {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:15px;
  background: none;
}

.name {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:15px;
  background: none;
}

.area {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:15px;
  background: none;
}

.shop {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:16px;
  background: none;
}
.btn {
  position:relative;
  left:40%;
  transform: translateX(-50%);
  margin-bottom: 40px;
  width:80%;
  height:40px;
  background: linear-gradient(125deg,#81ecec,#6c5ce7,#81ecec);
  background-position: left;
  background-size: 200%;
  color:white;
  font-weight: bold;
  border:none;
  cursor:pointer;
  transition: 0.4s;
  display:inline;
}

.btn:hover {
  background-position: right;
}
.joinForm h2 {
  text-align: center;
  margin: 30px;
}
</style>
<script type ="text/javascript">
	$('#idCheck').keyup(function(){
		var mem_id = $('#idCheck').val();
			
		$.ajax({
			url : "memberIdCheck.do",
			type : "post",
			data : {mem_id: mem_id},
			dataType : 'json',
			success : function(result){
				if(result == 1){
					$("#confirmId").html('이미 사용중인 아이디입니다.');
					$("#confirmId").attr('color','#dc3545');
				} else{
					$("#confirmId").html('사용할 수 있는 아이디입니다.');
					$("#confirmId").attr('color','#2fb380');
				} 
			},
			error : function(){
				alert("서버요청실패");
			}
		})
			 
	})
</script>
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
		window.alert('휴대전화번호를 입력해주세요.');
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
</head>
<body>
<c:import url="../header.jsp"></c:import>
<form name="memberJoinForm" method="post" action="memberJoinFormSubmit.do" onsubmit="return validate();" class="joinForm">  
<h2>회원가입</h2>                                                                                           
      <div class="textForm">
        <input name="mem_id" id="idCheck" type="text" class="id" placeholder="아이디"></input>
        <div><font id=confirmId size="2"></font></div>
      </div>
      <div class="textForm">
        <input name="mem_name" id="name" type="text" class="name" placeholder="이름" >
      </div>
      <div class="textForm">
        <input name="mem_pwd" id="pwd1" onchange="isTrue()" type="password" class="pw" placeholder="4~12자,특수문자포함">
      </div>
       <div class="textForm">
        <input name="mem_pwd_check" id="pwd2" onchange="isTrue()" type="password" class="pw" placeholder="비밀번호 확인">
      </div>
      <div class="textForm">
      	<label id="checkpwd"></label>
      </div>
       <div class="textForm">
        <input name="mem_age" id="age" type="text" class="area" placeholder="YYYYMMDD">
      </div>
      <div class="textForm">
        <input type="radio" name="mem_gender" value="남" checked>남
				<input type="radio" name="mem_gender" value="여">여
      </div>
      <div class="textForm">
        <input name="mem_tel" placeholder="(-)생략" id="tel" type="text" class="shop" >
      </div>
      <div class="textForm">
        <input name="mem_email" placeholder="이메일을 설정해주세요." id="email" type="text" class="shop">
      </div>
      <div class="textForm">
        <input id="addr" readonly onclick="kakaoAddr()" type="text" class="shop" placeholder="주소">
      </div>
       <div class="textForm">
        <input id="addr_num" readonly type="text" class="shop" placeholder="우편번호" >
      </div>
       <div class="textForm">
        <input name="admin_shop" type="text" class="shop" placeholder="상세주소" id="addr_sub">
      </div>
      <input type="submit" class="btn" value="가입하기" >
      <input type="reset" class="btn" value="다시작성">
    </form>
</body>
</html>