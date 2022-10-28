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
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['성별', '이번 달'],
          ['남자',     ${mangender}],
          ['여자',      ${allgender-mangender}],       
        ]);

        var options = {
          title: '성별간 매출 현황'
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
          ['나이', '이번 달'],
          ['10대',     ${arr[0]}],
          ['20대',      ${arr[1]}],
          ['30대',  ${arr[2]}],
          ['40대', ${arr[3]}],
          ['그 외',    ${arr[4]}]
        ]);

        var options = {
          title: '나이대별 매출 현황'
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
	<div class="sidebarmenu"><a href="adminRevenueMain.do"><br>매출현황</a></div>
	<div class="sidebarmenu"><a href="adminRevenueShop.do"><br>지점별매출</a></div>
	<div class="sidebarmenu"><a href="adminRevenueMovie.do"><br>영화별매출</a></div>
	<div class="sidebarmenu"><a href="adminRevenueProduct.do"><br>상품별매출</a></div>
	<div class="sidebarmenu"><a href="adminRevenueSpectator.do"><br>관람객 수</a></div>
</div>
<div class="container">
  <div class="item" id="itemresult">
    <div class="header">${nowYear }년 ${nowMonth }월 총 매출<hr></div>
    <div class="content"><br>${nowMonthMovieRevenue+nowMonthProductRevenue }원</div>
    <div class="footer"><hr><a href="#">&nbsp</a></div>
  </div>
  <div class="item"><div class="header">${nowYear }년 ${nowMonth }월 영화 매출<hr></div>
    <div class="content"><br>${nowMonthMovieRevenue }원</div>
    <div class="footer"><hr><a href="adminRevenueMovie.do">확인하기</a></div></div>
  <div class="item"><div class="header">${nowYear }년 ${nowMonth }월 상품 매출<hr></div>
    <div class="content"><br>${nowMonthProductRevenue }원</div>
    <div class="footer"><hr><a href="adminRevenueProduct.do">확인하기</a></div></div>
  <div class="item"><div class="header">${nowYear }년 ${nowMonth }월 관람객 수<hr></div>
    <div class="content"><br>${nowMonthSpectator }명</div>
    <div class="footer"><hr><a href="adminRevenueSpectator.do">확인하기</a></div></div>
  <div class="item"><div class="header">${nowYear }년 ${nowMonth }월 최고 영화<hr></div>
    <div class="content"><br>${nowMonthBestMovie }</div>
    <div class="footer"><hr><a>&nbsp</a></div></div>
  <div class="item"><div class="header">${nowYear }년 ${nowMonth }월 최고 상품<hr></div>
    <div class="content"><br>${nowMonthBestProduct }</div>
    <div class="footer"><hr><a>&nbsp</a></div></div>
  <div class="container2">
  	<div id="piechart" style="width: 500px; height: 300px;"></div>
  	<div id="piechart1" style="width: 500px; height: 300px;"></div>
  </div>  
</div>
</div>
</body>
</html>