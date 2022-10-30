<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무비조아</title>
<script>
function show(num){
	if(num==0){
		document.getElementById('il0').style.display = 'block';
		document.getElementById('h0').style.fontWeight = 'bold';
		document.getElementById('h1').style.fontWeight = 'normal';
		document.getElementById('il1').style.display = 'none';
	}else{
		document.getElementById('il1').style.display = 'block';
		document.getElementById('h1').style.fontWeight = 'bold';
		document.getElementById('h0').style.fontWeight = 'normal';
		document.getElementById('il0').style.display = 'none';
	}
}
function go(){
	if(document.getElementById('il0').style.display=='block'){
		location.href='/movieJoa/joaMovie.do'
	}else{
		location.href='/movieJoa/joaPreMovie.do'
	}
}
</script>
<link rel="stylesheet" type="text/css" href="css/main.css">
<style>
body{
	width: 1100px;
	margin: 0px auto;
}
a:visited, a{
	color: black;
}
#movimg{
	width: 180px;
	height: 230px;
}
</style>
</head>
<body>
<c:import url="header.jsp"></c:import>
<section class="main">
	<article>
		<div class="movieChart"><a href="joaMovie.do">영화차트</a></div>
		<div class="event">이벤트</div>
		<div class="fnb">스토어상품</div>
		<div class="notice">공지사항</div>
		<div class="helpDesk"><a href="helpDesk.do">고객센터</a></div>
	</article>
</section>
<div class="movieChartBeScreen_wrap">
	<div class="contents">
	    <div class="movieChartBeScreen_btn_wrap">
	        <div style="display: inline;">
	            <h3 style="display: inline;" id="h0"><a href="javascript:show(0);" id="btnMovie">무비차트</a></h3> |
	            <h3 style="display: inline;font-weight: normal;" id="h1"><a href="javascript:show(1)" id="btnReserMovie">상영예정작</a></h3>
	        </div>
	        <a href="javascript:go();" id="btn_allView_Movie" style="float: right;"><button style="border-radius: 15px;">전체보기</button></a>
	    </div>
	    <div class="swiper movieChart_list" id="movieChart_list">
	    	<br>
	    	<div id="il0" style="display:block;">
		    	<c:forEach var="list" items="${list0 }">
				    <div style="display: inline-block;width: 19%;">
				        <div class="img_wrap" data-scale="false">
				            <a href="detailView.do?mov_idx=${list.mov_idx }&show=0">
				            <img id="movimg"src="/movieJoa/img/movie_poster/${list.mov_poster }"></a>
				        </div>
				        <div class="movie_info_wrap">
				            <a href="detailView.do?mov_idx=${list.mov_idx }&show=0">
				            <strong class="movieName">
	  	                	<c:if test="${fn:length(list.mov_title)>15 }">
		                		${fn:substring(list.mov_title,0,12) }...
		                	</c:if>
		                	<c:if test="${fn:length(list.mov_title)<=15 }">
		                		${list.mov_title}
		                	</c:if></strong></a><br>
				            <span> 관람평 ${list.mov_score }</span> |
				            <span>예매율 ${list.mov_booking_percent }</span><br>
				            <button onclick="location.href='book.do'" style="background-color: red;border: none;color: white;border-radius: 15px;">&nbsp예매하기&nbsp</button>
				        </div>
					</div>
				</c:forEach>
			</div>
			<div id="il1" style="display:none;">
				<c:forEach var="list" items="${list1 }">
			        <div style="display: inline-block;width: 19%;">
					    <div class="img_wrap" data-scale="false">
					        <a href="detailView.do?mov_idx=${list.mov_idx }&show=0">
					        <img id="movimg" src="/movieJoa/img/movie_poster/${list.mov_poster }"></a>
					    </div>
					    <div class="movie_info_wrap">
					        <a href="detailView.do?mov_idx=${list.mov_idx }&show=0">
					        <strong style="width: 180px;float: center;">
							<c:if test="${fn:length(list.mov_title)>15 }">
		                		${fn:substring(list.mov_title,0,12) }...
		                	</c:if>
		                	<c:if test="${fn:length(list.mov_title)<=15 }">
		                		${list.mov_title}
		                	</c:if></strong></a><br>
					        <span> 관람평 ${list.mov_score }</span> |
					        <span>예매율 ${list.mov_booking_percent }</span><br>
					        <button onclick="location.href='book.do'" style="background-color: red;border: none;color: white;border-radius: 15px;">&nbsp예매하기&nbsp</button>
					    </div>
			        </div>
				</c:forEach>
			</div>
	    </div>
	</div>
</div>
<c:import url="footer.jsp"></c:import>
</body>
</html>