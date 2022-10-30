<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 페이지</title>
</head>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/event.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie.css">
</head>
<body>
<c:import url="../header.jsp"></c:import>
<div id="content">
	<div class="tit-heading-wrap tit-evt">
	    <h3>EVENT</h3>
	</div>
	
	<div class="evt-nav-area">
	    <ul class="evt-tab-menu">
	    </ul>    
	    <div class="submenu">
	        <a href="#" class="round red on"><i>당첨자 발표</i></a>
	        <a href="/movieJoa//joaEventEnded.do" class="round red on"><i>종료된 이벤트</i></a>
	    </div>
	</div>
	<c:if test="${empty userEvent}">
		<tr>
			<td rowspan="2">진행중인 '관리자 등록' 이벤트가 존재하지 않습니다.</td>
		</tr>
	</c:if>
	<c:if test="${empty systemEvent}">
		<tr>
			<td rowspan="2">진행중인 '관리자 등록' 이벤트가 존재하지 않습니다.</td>
		</tr>
	</c:if>
	<div class="cols-content">
		<div class="col-detail event">
		      <ul class="sect-evt-item-list">
		      		 
					<c:forEach var="sysdto" items="${systemEvent }">
					<c:url var="sysDetail" value="${sysdto.eve_idx }.do">
							<c:param name="eve_idx">${sysdto.eve_idx }</c:param>
					</c:url>
					<li>
			           <a id="tile_0" href="${sysDetail}" >
			          			 <div class="evt-thumb"> <img src="/movieJoa/img/joaEvent_img/${sysdto.eve_thumb_img }"></div>
			          			 <div class="evt-desc"> <p class="txt1">${sysdto.eve_subject }</p><p class="txt2">${sysdto.eve_start_date } ~ ${sysdto.eve_end_date }</p> </div>
						</a>
					</li>
					</c:forEach>
					<c:forEach var="dto" items="${userEvent }">
					<c:url var="detail" value="joaEventInfo.do">
							<c:param name="eve_idx">${dto.eve_idx }</c:param>
					</c:url>
					<li>
			           <a id="tile_1" href="${detail}" >
			          			 <div class="evt-thumb"> <img src="/movieJoa/img/joaEvent_img/${dto.eve_thumb_img }"></div>
			          			 <div class="evt-desc"> <p class="txt1">${dto.eve_subject }</p><p class="txt2">${dto.eve_start_date } ~ ${dto.eve_end_date }</p> </div>
						</a>
					</li>
					</c:forEach>
		      </ul>
		</div>
		 <div class="col-aside">
    	<div class="ad-event">
            <div class="ad-partner01">
                <img src="/movieJoa/img/joaEvent_img/add1.jpg" width="160" height="300" title="" frameborder="0" scrolling="no" marginwidth="0" marginheight="0" name="M_Rectangle" id="M_Rectangle"></iframe>
            </div>
            <div class="ad-partner01">
                <img src="/movieJoa/img/joaEvent_img/add2.jpg" width="160" height="300" title="" frameborder="0" scrolling="no" marginwidth="0" marginheight="0" name="C_Rectangle" id="C_Rectangle"></iframe>
            </div>
            <div class="ad-partner02">
                <img src="/movieJoa/img/joaEvent_img/add3.jpg" width="160" height="35" title="" frameborder="0" scrolling="no" marginwidth="0" marginheight="0" name="Image_text" id="Image_text"></iframe>
            </div>
        </div>
    </div>
	</div>
</div>
<c:import url="../footer.jsp"></c:import>
</body>
</html>