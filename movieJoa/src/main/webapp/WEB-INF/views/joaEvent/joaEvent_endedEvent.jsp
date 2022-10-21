<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>종료된 이벤트</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/event.css">
<link rel="stylesheet" type="text/css" href="css/endedEvent.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie.css">
</head>
<body>
<c:import url="../header.jsp"></c:import>
</head>
<body>
	<div id="contaniner"  class="contaniner">
		 <div id="contents" class="contents">
			<div class="tit-heading-wrap tit-evt">
			    <h3>EVENT</h3>
			    <div class="submenu">
			        <a href="#" class="round red on"><span>당첨자 발표</span></a>
			    </div>
			</div>
			<h4>종료된 이벤트</h4>
			<c:if test="${empty endedEvent}">
						<div>종료된 이벤트가 존재하지 않습니다.<div>
			</c:if>
			<div class="sect-evt-entlist">
			    <ul>
			    <c:forEach var="dto" items="${endedEvent }">
								<c:url var="detail" value="joaEventInfo.do">
										<c:param name="eve_idx">${dto.eve_idx }</c:param>
								</c:url>
					 <li>
			               <div class="box-image">
			                   <a href="${detail }">
			                       <span class="thumb-image">
			                           <img src="/movieJoa/img/joaEvent_img/${dto.eve_thumb_img }" >
			                       </span>
			                   </a>
			               </div>
			               <div class="box-contents">
			                   <a href="${detail }">
			                       <em class="txt-lightblue">${dto.eve_category }</em>
			                       <strong>${dto.eve_subject }</strong>
			                   </a>
			                   <em class="date">
			                       <span>기간: </span>
			                       ${dto.eve_start_date } ~ ${dto.eve_end_date }
			                   </em>
			               </div>
			           </li>
			           </c:forEach>
			    </ul>
			    <div class="paging">${pageStr }</div>
			</div>
	 </div>
</div>
<c:import url="../footer.jsp"></c:import>
</body>
</html>