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
function getDiscount(){
	window.location.href='joaEventGetNewJoin.do?sid=${sid}&event_code=${event_code}&event_subject=${event_subject}&cou_idx=${cou_idx}';
}
</script>
</head>
<body>
<c:import url="../header.jsp"></c:import>
<div class="contaniner">
<div class="content"> 
<div class="tbl-viw-head">
    <h3>
        <em class="txt-lightblue">즉시발급형</em>
        신규 고객 감사 할인쿠폰 증정 이벤트
    </h3> 
    <em class="date"><span>기간: </span>2022.10.01 ~ 2022.12.13</em>
</div>
<div class="tbl-viw-content">
 
<div class="evt_wrap cf ir">
	  <div class="wrap_box ir">    
	    <img src="/movieJoa/img/joaEvent_img/join_main.jpg" class="main_img">
	    <a href="javascript:getDiscount()" class="join_btn">
	        <img src="/movieJoa/img/joaEvent_img/join_btn.png">
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