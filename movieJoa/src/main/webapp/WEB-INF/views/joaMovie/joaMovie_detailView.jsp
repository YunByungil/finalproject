<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="js/httpRequest.js"></script>
<script>
function show(num){
	const urlParams = new URL(location.href).searchParams;
	const mov_idx = urlParams.get('mov_idx');
	if(num==0){
		location.href='detailView.do?mov_idx='+mov_idx+'&show=0';
	}else if(num==1){
		location.href='detailView.do?mov_idx='+mov_idx+'&show=1';
	}
}
function slow(){
	setTimeout(function(){location.reload();},100);
}
</script>
<style>
body{
	width: 1100px;
	margin: 0px auto;
}
img{
	width: 180px;
	height: 230px;
}
#image{
	float: left;
	width: 250px;
}
#menu li{
	list-style-type: none;
	float: left;
	text-align: center;
}
dt{
	float: left;
}
a:visited, a{
	color: black;
}
#chart li{
	list-style-type: none;
	float: left;
}
.bb{
	border-bottom: 1px solid;"
}
body, input, button, select, textarea {
    font-family:'SUIT-Medium';
}
</style>
</head>
<body onload="plz();counter2();document.querySelector(`.star2 span`).style.width = document.getElementById('range').value * 10+'%';document.getElementById('score2').value=document.getElementById('range').value;">
<c:import url="../header.jsp"/>
<br>
<div class="sect-base-movie">
	<c:forEach var="list" items="${list }">
    <div id="image">
        <a href="/movieJoa/img/movie_poster/${list.mov_poster }" title="포스터 크게 보기 새창" target="_blank">
            <span class="thumb-image"> 
                <img src="/movieJoa/img/movie_poster/${list.mov_poster }">
            </span> 
        </a> 
    </div>
    <div class="box-contents">
        <div class="title"> 
            <strong>${list.mov_title }</strong>
        </div>
        <div class="score"> 예매율&nbsp;<span>${list.mov_booking_percent }</span>
            <div class='egg-gage small'>
	            <span class='percent'>관람평&nbsp;
		            <c:if test="${list.mov_score!=0.0 }">
						${list.mov_score }
		            </c:if>
		            <c:if test="${list.mov_score==0.0 }">
						?
		            </c:if>
	            </span>
            </div>
        </div>
        <div class="spec">
            <dl>
            	<dt>감독 :&nbsp;</dt>
            	<dd>${list.mov_director }</dd>
            	<dt>출연 :&nbsp;</dt>
            	<dd>${list.mov_cast }</dd>
                <dt>장르 :&nbsp;</dt> 
                <dd>${list.mov_genre }</dd>
                <dt>기본 :&nbsp;</dt>
                <dd class="on">${list.mov_rate },&nbsp;${list.mov_running_time }분,&nbsp;${list.mov_country }</dd>
                <dt>개봉 :&nbsp;</dt>
                <dd class="on">
				<c:set var="mov_start_date" value="${list.mov_start_date }"/>
		       	${fn:substring(mov_start_date,0,10) }</dd>
            </dl>
        </div>
        <div>
	        <span class="like">
	            <button onclick="location.href='book.do'" style="background-color: red;border: none;color: white;border-radius: 15px;">&nbsp예매하기&nbsp</button>
	        </span>
        </div>
    </div>
    </c:forEach>
</div>
<br>
<div id="menu" style="clear: both;font-size: 18px;">
	<ul id="tabMenu">
		<c:choose>
			<c:when test="${param.show eq 0 }">
				<li class="on" style="width: 50%"><div onclick="show(0)" id="info" class="bb"><strong>주요정보</strong></div></li>
				<li style="width: 50%"><div onclick="show(1)" id="comm"><strong>평점/리뷰</strong></div></li>
			</c:when>
			<c:when test="${param.show eq 1 }">
				<li class="on" style="width: 50%"><div onclick="show(0)" id="info"><strong>주요정보</strong></div></li>
				<li style="width: 50%"><div onclick="show(1)" id="comm" class="bb"><strong>평점/리뷰</strong></div></li>
			</c:when>
		</c:choose>
	</ul>
</div>
<br>
<br>
<div id="show" style="clear:both;">
	<c:choose>
		<c:when test="${param.show eq 0 }">
			<c:import url="/info.do"/>
		</c:when>
		<c:when test="${param.show eq 1 }">
			<c:import url="/commentReg.do"/>
		</c:when>
	</c:choose>
</div>
<c:import url="../footer.jsp"/>
</body>
</html>