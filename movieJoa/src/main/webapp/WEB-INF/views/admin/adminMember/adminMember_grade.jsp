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
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart1);

      function drawChart1() {

        var data = google.visualization.arrayToDataTable([
          ['등급', '현황'],
          ['일반',    ${general} ],
          ['VIP',    ${vip} ],
          ['SVIP', ${svip} ],
          ['VVIP', ${vvip}],
        ]);

        var options = {
          title: '등급별 회원 현황'
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
<div id="piechart1" style="width: 1200; height: 800px;"></div>
</div>
</body>
</html>