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
<style>
.wrap_box .apply_btn {
     display: block;
    position: absolute;
    left: 0px;
    width: 90%;
    right: 0;
    margin: 0 auto;
    top: 60%;
}
</style>
<script>
function getApply(){
	window.location.href="joaEventGetApply.do?sid=syseyear&event_code=333&event_subject=401호의 탐정 개봉 기념 시사회 응모 이벤트"
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
        401호의 탐정 개봉 기념 시사회 응모 이벤트
    </h3> 
    <em class="date"><span>기간: 2022.10.01 ~ 2022.12.15</span></em>
</div>

<div class="tbl-viw-content">
 
<div class="evt_wrap cf ir">
	  <div class="wrap_box ir">    
	    <img src="/movieJoa/img/joaEvent_img/apply_main.jpg" class="main_img">
	    <a href="javascript:getApply()" class="apply_btn">
	        <img src="/movieJoa/img/joaEvent_img/apply_btn.png"  >
	    </a>   
	   </div>  
</div>

<div class="tbl-viw-nav">
    <div class="dir-prev">
        <a href="/movieJoa/joaEventMain.do"">목록</a>
    </div>
</div>
	</div>
  </div>
  </div>
    

<c:import url="../footer.jsp"></c:import>
</body>
</html>