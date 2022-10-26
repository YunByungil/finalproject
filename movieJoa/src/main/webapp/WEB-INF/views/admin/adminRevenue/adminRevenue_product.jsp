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
<div class="container">
<c:if test="${ not empty list}">
	<c:forEach var="dto" items="${list }">
		 <div class="item">
   			 <div class="header">${dto.admin_area} ${dto.admin_shop}지점<hr></div>
    			<div class="content"><br>${nowMonthMovieRevenue+nowMonthProductRevenue }원</div>
   		 <div class="footer"><hr><a href="#">확인하기</a></div>
  		</div>
	</c:forEach>
</c:if>
</div>
</div>
</body>
</html>