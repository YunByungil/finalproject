<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
function counter2(){
	document.getElementById("counting2").innerHTML = document.getElementById("reviewContents2").value.length; 
}
</script>
<h2 style="padding: 10px;">평점수정</h2>
<hr>
<c:forEach var="list" items="${commentUpdateList }">
<h3 align="center">${list.rev_movie_title }</h3>
<div class="popup_cont" style="float: left">
	<span class="star2">
 	  ★★★★★
  	<span>★★★★★</span>
		<input type="range" oninput="drawStar2(this)" value="${list.rev_score }" step="1" min="0" max="10" id="range">
	</span>
</div>
<b id="val2" style="font-size: 4rem;">${list.rev_score }</b>			
<form class="mb-3" name="myform2" id="myform2" action="commentUpdate.do" method="post" target="blankifr2">
<input type="hidden" name="rev_id" value="${list.rev_id }">
<input type="hidden" name="rev_movie_title" value="${list.rev_movie_title }">
<input type="hidden" name="rev_score" id="score2">
<div>
	<textarea class="col-auto form-control" id="reviewContents2" name="rev_comment" onkeyup="counter2()">${list.rev_comment }</textarea>
	<span id="counting2">0</span>/100
</div>
</form>
</c:forEach>
<iframe name="blankifr2" style="display:none;"></iframe>	
<!--팝업 버튼 영역-->
<div>
	<div style="background-color:#DDDDDD;text-align: center;padding-bottom: 10px;padding-top: 10px; width: 50%; float: left;" onClick="closeUpdate();">
		<span class="pop_bt" style="font-size: 13pt;" >
        	닫기
    	</span>
	</div>					
	<div style="background-color:#DDDDDD;text-align: center;padding-bottom: 10px;padding-top: 10px; width: 50%; float: right;" onClick="document.getElementById('myform2').submit();closeUpdate();">
		<span class="pop_bt" style="font-size: 13pt;">
			확인
	    </span>
	</div>	
</div>