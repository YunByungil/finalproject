<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<style>
.wrapper{
	display:grid;
	grid-template-columns: 500px 1000px;
 	grid-template-rows: 200px 200px;
  	grid-column-gap: 20px;
	
}
.sidebar{
	text-align:center;
	margin-left: 150px;
}
.sidebarmenu{
	border: solid 1px black;
	width:200px;
	height: 120px;
	font-size:30px;
	border-radius: 30px;
}
</style>
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
  height:25px;
  background: none;
}

.pw {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}

.name {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}

.area {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}

.shop {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
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
</head>
<body>
<c:import url="/WEB-INF/views/header_admin.jsp"></c:import>
<div class="wrapper">
<div class="sidebar">
	<div class="sidebarmenu"><a href="adminRevenueMain.do"><br>매출현황</a></div>
	<div class="sidebarmenu"><a href="adminRevenueShop.do"><br>지점별매출</a></div>
	<div class="sidebarmenu"><a href="adminRevenueMovie.do"><br>영화별매출</a></div>
	<div class="sidebarmenu"><a href="adminRevenueProduct.do"><br>상품별매출</a></div>
	<div class="sidebarmenu"><a href="adminRevenueGender.do"><br>성별매출</a></div>
	<div class="sidebarmenu"><a href="adminRevenueAge.do"><br>나이대별매출</a></div>
	<div class="sidebarmenu"><a href="adminRevenueSpectator.do"><br>관람객 수</a></div>
</div>
<form name="adminForm" class="joinForm">  
<h2>관리자 수정</h2>                                                                                           
      <div class="textForm">
        <input name="admin_id" type="text" class="id" placeholder="아이디" value="${dto.admin_id }" readonly></input>
      </div>
      <div class="textForm">
        <input name="admin_pwd" type="password" class="pw" placeholder="비밀번호" onchange="isTrue()" id="pwd1">
      </div>
       <div class="textForm">
        <input name="admin_pwd_Check" type="password" class="pw" placeholder="비밀번호 확인" onchange="isTrue()" id="pwd2">
      </div>
      <div class="textForm">
        <input name="admin_name" type="text" class="name" placeholder="이름" value="${dto.admin_name }">
      </div>
       <div class="textForm">
        <input name="admin_area" type="text" class="area" placeholder="지역" value="${dto.admin_area }">
      </div>
      <div class="textForm">
        <input name="admin_shop" type="text" class="shop" placeholder="지점" value="${dto.admin_shop }">
      </div>
      <div class="textForm">
      	<label id="checkpwd"></label>
      </div>
      <div class="textForm">
        <input name="admin_shop" type="text" class="shop" placeholder="지점" value="${dto.admin_shop }">
      </div>
      <div class="textForm">
        <input name="admin_shop" type="text" class="shop" placeholder="지점" value="${dto.admin_shop }">
      </div>
      <div class="textForm">
        <input name="admin_shop" type="text" class="shop" placeholder="지점" value="${dto.admin_shop }">
      </div>
      <input type="button" class="btn" value="수정" onclick="adminUpdate()">
      <input type="button" class="btn" value="삭제" onclick="adminDelete('${dto.admin_id}')">
    </form>
</div>
</body>
</html>