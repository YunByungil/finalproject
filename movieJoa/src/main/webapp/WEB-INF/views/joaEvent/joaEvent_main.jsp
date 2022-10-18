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
	        <a href="" class="round red on"><i>당첨자 발표</i></a>
	        <a href="" class="round red on"><i>종료된 이벤트</i></a>
	    </div>
	</div>
	<c:if test="${empty userEvent}">
		<tr>
			<td>진행중인 이벤트가 존재하지 않습니다.</td>
		</tr>
	</c:if>
	<div class="cols-content">
		<div class="col-detail event">
		      <ul class="sect-evt-item-list">
		      		 <li>
			           <a id="tile_0" href="joaEventNewJoin.do">
			          			 <div class="evt-thumb"> <img src="/movieJoa/img/joaEvent_img/join_thumb.png"></div>
			          			 <div class="evt-desc"> <p class="txt1">신규 고객 감사 할인쿠폰 증정 이벤트</p><p class="txt2">2022.10.01 ~ 2022.12.13</p> </div>
						</a>
					</li>
					
					<li>
			           <a id="tile_1" href="joaEventPoint.do">
			          			 <div class="evt-thumb"> <img src="/movieJoa/img/joaEvent_img/coupon_thumb.jpg" ></div>
			          			 <div class="evt-desc"> <p class="txt1">MJOA 랜덤 선물 응모 이벤트</p><p class="txt2">2022.10.15 ~ 2022.12.25</p> </div>
						</a>
					</li>
					
					<li>
			           <a id="tile_2" href="joaEventApply.do">
			          			 <div class="evt-thumb"> <img src="/movieJoa/img/joaEvent_img/apply_thumb.jpg" ></div>
			          			 <div class="evt-desc"> <p class="txt1">401호의 탐정 개봉 기념 시사회 응모 이벤트</p><p class="txt2">2022.10.01 ~ 2022.12.15</p> </div>
						</a>
					</li>
		          
					
					<c:forEach var="dto" items="${userEvent }">
					<c:url var="detail" value="joaEventInfo.do">
							<c:param name="eve_idx">${dto.eve_idx }</c:param>
					</c:url>
					<li>
			           <a id="tile_3" href="${detail}" >
			          			 <div class="evt-thumb"> <img src="/movieJoa/img/joaEvent_img/${dto.eve_thumb_img }"></div>
			          			 <div class="evt-desc"> <p class="txt1">${dto.eve_subject }</p><p class="txt2"></p> </div>
						</a>
					</li>
					</c:forEach>
					
		      </ul>
		</div>
		 <div class="col-aside">
    	<div class="ad-event">
            <div class="ad-partner01">
                <img src="/movieJoa/img/joaEvent_img/apply_thumb.jpg" width="160" height="300" title="" frameborder="0" scrolling="no" marginwidth="0" marginheight="0" name="M_Rectangle" id="M_Rectangle"></iframe>
            </div>
            <div class="ad-partner01">
                <img src="/movieJoa/img/joaEvent_img/coupon_thumb.jpg" width="160" height="300" title="" frameborder="0" scrolling="no" marginwidth="0" marginheight="0" name="C_Rectangle" id="C_Rectangle"></iframe>
            </div>
            <div class="ad-partner02">
                <img src="/movieJoa/img/joaEvent_img/join_thumb.png" width="160" height="35" title="" frameborder="0" scrolling="no" marginwidth="0" marginheight="0" name="Image_text" id="Image_text"></iframe>
            </div>
        </div>
    </div>
	</div>
	
</div>
<c:import url="../footer.jsp"></c:import>
</body>
</html>