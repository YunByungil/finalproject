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
.container {
  display: grid;
  grid-template-columns: 300px 300px 300px;
  grid-template-rows: 200px 200px 200px;
  grid-column-gap: 20px;
  column-gap: 30px;
   row-gap: 30px;
}
.container2{
	display:grid;
	column-gap:20px;
	grid-template-columns: 500px 500px;
	grid-template-rows: 300px;
}
.item {
  padding: 20px;
   border-radius: 30px;
  text-align:right;
}
.content{
  font-size:30px;
}
</style>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['성별', '이번 달'],
          ['남자',    ${memberGenderCount }],
          ['여자',     ${memberAllCount-memberGenderCount }],       
        ]);

        var options = {
          title: '성별 비율'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart1);

      function drawChart1() {

        var data = google.visualization.arrayToDataTable([
          ['나이', '현황'],
          ['10대',     ${memberAgeCount[0]}],
          ['20대',      ${memberAgeCount[1]}],
          ['30대',  ${memberAgeCount[2]}],
          ['40대', ${memberAgeCount[3]}],
          ['그 외',    ${memberAgeCount[4]}]
        ]);

        var options = {
          title: '나이대별 가입 현황'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart1'));

        chart.draw(data, options);
      }
    </script>
</head>
<body>
<c:import url="/WEB-INF/views/header_admin.jsp"></c:import>
<div class="wrapper">
<div class="sidebar">
	<div class="sidebarmenu"><a href="adminMemberMain.do"><br>회원현황</a></div>
	<div class="sidebarmenu"><a href="adminMemberRegister.do"><br>관리자등록</a></div>
	<div class="sidebarmenu"><a href="adminSearch.do"><br>관리자조회</a></div>
	<div class="sidebarmenu"><a href="adminMember.do"><br>회원조회</a></div>
</div>
<div class="container">
  <div class="item" id="itemresult">
    <div class="header">총회원수<hr></div>
    <div class="content"><br>${memberAllCount }명</div>
    <div class="footer"><hr><a href="adminMember.do">확인하기</a></div>
  </div>
  <div class="item"><div class="header">오늘 가입한 회원 수<hr></div>
    <div class="content"><br>${currentMemberJoin }명</div>
    <div class="footer"><hr><a href="adminMember.do">확인하기</a></div></div>
  <div class="item"><div class="header">등록된 관리자 수<hr></div>
    <div class="content"><br>${adminAllCount }</div>
    <div class="footer"><hr><a href="adminSearch.do">확인하기</a></div></div>
  <div class="item"><div class="header">남자 회원 수<hr></div>
    <div class="content"><br>${memberGenderCount }명</div>
    <div class="footer"><hr><a href="adminGender.do?mem_gender=남">확인하기</a></div></div>
  <div class="item"><div class="header">여자 회원 수<hr></div>
    <div class="content"><br>${memberAllCount-memberGenderCount }명</div>
    <div class="footer"><hr><a href="adminGender.do?mem_gender=여">확인하기</a></div></div>
  <div class="item"><div class="header">VVIP 회원 수<hr></div>
    <div class="content"><br>${memberGradeCount }</div>
    <div class="footer"><hr><a href="adminGrade.do">확인하기</a></div></div>
  <div class="container2">
  	<div id="piechart" style="width: 500px; height: 300px;"></div>
  	<div id="piechart1" style="width: 500px; height: 300px;"></div>
  </div>  
</div>
</div>
</body>
</html>