<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
function counter(){
	document.getElementById("counting").innerHTML = document.getElementById("reviewContents").value.length; 
}
function submitCom(){
	if(document.getElementById('score').value==""){
		window.alert('이 영화에 대한 별점을 선택해주세요.');
	}else if(document.getElementById("reviewContents").value==""){
		window.alert('내용을 입력하지 않았습니다.');
	}else{
		document.getElementById('myform').submit();
		closePop();
	}
}
</script>
<c:forEach var="list" items="${list }">
<h2 style="padding: 10px;">평점작성</h2>
<hr>
<h3 align="center">${list.mov_title }</h3>
<div class="popup_cont" style="float: left">
	<span class="star">
 	  ★★★★★
  	<span>★★★★★</span>
		<input type="range" oninput="drawStar(this)" value="1" step="1" min="1" max="10">
	</span>
</div>
<b id="val" style="font-size: 4rem;"></b>			
<form class="mb-3" name="myform" id="myform" action="commentWrite.do" method="post" target="blankifr">
<input type="hidden" name="rev_id" value="${sid }">
<input type="hidden" name="rev_movie_title" value="${list.mov_title }">
<input type="hidden" name="rev_score" id="score">
<div>
	<textarea class="col-auto form-control" id="reviewContents" name="rev_comment" onkeyup="counter()" maxlength="100"></textarea>
	<span id="counting">0</span>/100
</div>
</form>
<iframe name="blankifr" style="display:none;"></iframe>	
<!--팝업 버튼 영역-->
<div>
	<div style="background-color:#DDDDDD;text-align: center;padding-bottom: 10px;padding-top: 10px; width: 50%; float: left;" onClick="closePop();">
		<span class="pop_bt" style="font-size: 13pt;" >
        	닫기
    	</span>
	</div>					
	<div style="background-color:#DDDDDD;text-align: center;padding-bottom: 10px;padding-top: 10px; width: 50%; float: right;" onClick="submitCom();">
		<span class="pop_bt" style="font-size: 13pt;">
			확인
	    </span>
	</div>	
</div>
</c:forEach>