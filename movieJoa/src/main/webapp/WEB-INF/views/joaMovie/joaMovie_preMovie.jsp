<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<style>
body{
	width: 1100px;
	margin: 0px auto;
}
img{
	width: 180px;
	height: 230px;
}
#sub li{
	list-style-type: none;
	float: left;
	margin-left: 20px;
	font-weight: bold;
	
}
#movie li{
	list-style-type: none;
	float: left;
	width: 25%;
}
#rank{
	text-align: center;
	background-color: red;
}
a:visited, a{
	color: black;
}
font{
	color: red;
}
book{
	background-color: red;
}
body, input, button, select, textarea {
    font-family:'SUIT-Medium';
}
</style>
</head>
<body onload="show()">
<c:import url="../header.jsp"></c:import>
<h2 style="float:left;">상영예정작</h2>
<br>
<div style="float:right;">
	<ul id="sub">
		<li><a href="joaMovie.do">무비차트</a></li>
		<li><a href="joaPreMovie.do">상영예정작</a></li>
	</ul>
</div>
<hr style="clear:both;">
<br>
<ul id="movie">
	<c:forEach var="list" items="${list }">
	    <li>
	        <div class="box-image">
	            <a href="detailView.do?mov_idx=${list.mov_idx }&show=0">
	                <span class="thumb-image">
	                    <img src="/movieJoa/img/movie_poster/${list.mov_poster }">
	                </span>
	            </a>
	        </div>
	        <div class="box-contents">
	            <a href="detailView.do?mov_idx=${list.mov_idx }&show=0">
	                <strong class="title">
	                	<c:if test="${fn:length(list.mov_title)>20 }">
	                		${fn:substring(list.mov_title,0,17) }...
	                	</c:if>
	                	<c:if test="${fn:length(list.mov_title)<=20 }">
	                		${list.mov_title}
	                	</c:if>
	                </strong>
	            </a>
	            <div class="score">
	                예매율 
	                <span>${list.mov_booking_percent }</span>
	                <span class='egg great'>| 관람평</span>
	                <span class='percent'>
	                <c:if test="${list.mov_score!=0.0 }">
		                ${list.mov_score }
		            </c:if>
		            <c:if test="${list.mov_score==0.0 }">
		                ?
		            </c:if></span>
	            </div>
	            <span class="txt-info">
	                    <fmt:parseDate var="start" value="${list.mov_start_date }" pattern="yyyy-MM-dd"/>
	                    <fmt:formatDate value="${start }" pattern="yyyy-MM-dd"/>
	                    <fmt:parseNumber value="${now.time / (1000*60*60*24)}" integerOnly="true" var="nowTime"/>
						<fmt:parseNumber value="${start.time / (1000*60*60*24)}" integerOnly="true" var="startTime"/>
		                개봉 <font>D-${startTime - nowTime +1}</font>
	            </span>
	            <br>
	            <span id="likes"> 
	                <button onclick="location.href='book.do'" style="background-color: red;border: none;color: white;border-radius: 15px;">&nbsp예매하기&nbsp</button>
	            </span>
	            <br>&nbsp
	        </div>    
	    </li>
	</c:forEach>
</ul>	
	<div style="clear:both;"></div>
<c:import url="../footer.jsp"></c:import>
</body>
</html>