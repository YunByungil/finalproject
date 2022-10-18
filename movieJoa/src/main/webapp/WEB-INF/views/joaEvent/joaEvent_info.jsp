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
</head>
<body>
<c:import url="../header.jsp"></c:import>

<div class="contaniner">
	<div class="content"> 
			<div class="tbl-viw-head">
			<c:if test="${empty dto}">
			<div>이미 삭제되었거나 잘못된 접근입니다.</div>
				</c:if>
			    <h3>
			        <em class="txt-lightblue">${dto.eve_category }</em>
			        ${dto.eve_subject }
			    </h3> 
			    <em class="date"><span>기간: </span>${dto.eve_start_date } ~ ${dto.eve_end_date }</em>
			</div>
			<div class="tbl-viw-content">
				<div class="evt_wrap cf ir">
					  <div class="wrap_box ir">    
					    <img src="/movieJoa/img/joaEvent_img/${dto.eve_main_img }" class="main_img">
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