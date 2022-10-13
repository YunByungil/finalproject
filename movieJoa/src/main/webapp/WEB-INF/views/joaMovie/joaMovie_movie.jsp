<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
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
}
#movie li{
	list-style-type: none;
	float: left;
	width: 25%;
}
a:visited, a{
	color: black;
}
font{
	color: red;
}
</style>
</head>
<script>
function show(){
	var ot=document.getElementById('ot').value;
	location.href='/movieJoa/joaMovie.do?ot='+ot;
}
function show2(){
	var ot=document.getElementById('now').checked;
	if(ot){
		location.href='/movieJoa/joaMovie.do?ot=1';
	}else{
		location.href='/movieJoa/joaMovie.do?ot=0';
	}
}
</script>
<body>
<c:import url="../header.jsp"></c:import>
<h2 style="float:left;">무비차트</h2>
<br>
<div style="float:right;">
		<ul id="sub">
			<li><a href="joaMovie.do"><strong>무비차트</strong></a></li>
			<li><a href="joaPreMovie.do"><strong>상영예정작</strong></a></li>
		</ul>
</div>
<hr style="clear:both;">
<div>
	<div style="float:left;">
		<c:choose>
		<c:when test="${param.ot eq 1 ||param.ot eq 2}">
			<input type="checkbox" id="now" onclick="show2()" checked>
		</c:when>
		<c:otherwise>
			<input type="checkbox" id="now" onclick="show2()">
		</c:otherwise>
		</c:choose>
		<label><strong>현재 상영작만 보기</strong></label>
	</div>
	<div style="float:right">
	<select id="ot">
		<c:choose>
		<c:when test="${param.ot eq 1 }">
			<option value="1" selected>예매율순</option>
		</c:when>
		<c:otherwise>
			<option value="1">예매율순</option>
		</c:otherwise>
		</c:choose>
		<c:choose>
		<c:when test="${param.ot eq 2 }">
			<option value="2" selected>평점순</option>
		</c:when>
		<c:otherwise>
			<option value="2">평점순</option>
		</c:otherwise>
		</c:choose>
	</select>
	<button onclick="show()">GO</button>
	</div>
</div>
<br>
	<ul id="movie" style="clear:both;">
		<c:forEach var="list" items="${list }">
		    <li>
		        <div class="box-image">
		            <a href="detailView.do?mov_idx=${list.mov_idx }">
		                <span class="thumb-image">
		                    <img src="/movieJoa/imgmovie/${list.mov_poster }">
		                </span>
		            </a>
		        </div>
		        <div class="box-contents">
		            <a href="detailView.do?mov_idx=${list.mov_idx }">
		                <strong class="title">${list.mov_title }</strong>
		            </a>
		            <div class="score">
		                <strong class="percent">예매율 
		                <span>${list.mov_booking_percent }</span>
		                <span class='egg great'>| 관람평</span>
		                <span class='percent'>
		                <c:if test="${list.mov_score!=0.0 }">
		                ${list.mov_score }
		                </c:if>
		                <c:if test="${list.mov_score==0.0 }">
		                ?
		                </c:if>
		                </span>
		                </strong>
		            </div>
		            <span class="txt-info">
		                <strong>
		                	<fmt:parseDate var="start" value="${list.mov_start_date }" pattern="yyyy-MM-dd"/>
	                  		<fmt:formatDate value="${start }" pattern="yyyy-MM-dd"/>
	                    	<fmt:parseNumber value="${now.time / (1000*60*60*24)}" integerOnly="true" var="nowTime"/>
							<fmt:parseNumber value="${start.time / (1000*60*60*24)}" integerOnly="true" var="startTime"/>
		                	개봉 
		                	<font>
		                		<c:if test="${(startTime - nowTime + 1)>0 }">
		                			D-${startTime - nowTime +1}
		                		</c:if>
		                	</font>
		                </strong>
		            </span>
		            <br>
		            <span class="like"> 
		                <a class="link-reservation" href="/ticket/?MOVIE_CD=20030774&MOVIE_CD_GROUP=20027588">예매</a>
		            </span>
		        </div>
		    </li>
		</c:forEach>
	</ul>
	<div style="clear:both;"></div>
	<br>
<c:import url="../footer.jsp"></c:import>
</body>
</html>