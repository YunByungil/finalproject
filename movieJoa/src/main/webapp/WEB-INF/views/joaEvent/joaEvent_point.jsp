<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 페이지</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/event.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie.css">
<script>
function getPoint(){
	window.location.href="joaEventGetPoint.do?sid=syseyear&event_code=222&event_subject=MJOA 랜덤 선물 응모 이벤트"
}
</script>
</head>
<body>
<c:import url="../header.jsp"></c:import>
<div class="contaniner">
<div class="content"> 
<div class="tbl-viw-head">
    <h3>
        <em class="txt-lightblue">응모형</em>
        MJOA 랜덤 선물 응모 이벤트
    </h3> 
    <em class="date"><span>기간: 2022.10.15 ~ 2022.12.25</span></em>
</div>

<div class="tbl-viw-content">
<div class="evt_wrap cf ir">
	  <div class="wrap_box ir">    
	    <img src="/movieJoa/img/joaEvent_img/cpupon_main.jpg" class="main_img">
	    <a href="javascript:getPoint()" class="p_btn_wrap">
	        <img src="/movieJoa/img/joaEvent_img/coupon_btn.png"  class="p_btn">
	    </a>   
	   </div>  
</div>

<div class="tbl-viw-nav">
    <div class="dir-prev">
        <a href="/movieJoa/joaEventMain.do">목록</a>
    </div>
</div>
	</div>
  </div>
  </div>
    

<c:import url="../footer.jsp"></c:import>
</body>
</html>