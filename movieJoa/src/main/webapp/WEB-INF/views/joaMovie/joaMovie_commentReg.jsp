<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="js/httpRequest.js"></script>
<script>
function openPop(){
	document.getElementById('popup_layer').style.display = 'block';
}
function closePop(){
	document.getElementById('popup_layer').style.display = 'none';
	setTimeout(function(){location.reload();},100);
}
const drawStar = (target) => {
    document.querySelector(`.star span`).style.width = target.value * 10+'%';
    document.getElementById('val').innerText=target.value;
    document.getElementById('score').value=target.value;
}
const drawStar2 = (target) => {
    document.querySelector(`.star2 span`).style.width = target.value * 10+'%';
    document.getElementById('val2').innerText=target.value;
    document.getElementById('score2').value=target.value;
}
function show2(num){
	const urlParams = new URL(location.href).searchParams;
	const mov_idx = urlParams.get('mov_idx');
	if(num==0){
		location.href='detailView.do?mov_idx='+mov_idx+'&show=1&ot=0';
	}else{
		location.href='detailView.do?mov_idx='+mov_idx+'&show=1&ot=1';
	}
}
function openUpdate(){
	document.getElementById('update').style.display = 'block';
}
function openDelete(rev_id, rev_movie_title){
	var result=window.confirm('진짜 삭제하시겠습니까?');
	if(!result){
		return;
	}
	location.href='commentDelete.do?rev_id='+rev_id+'&rev_movie_title='+rev_movie_title;
}
function closeUpdate(){
	document.getElementById('update').style.display = 'none';
	setTimeout(function(){location.reload();},100);
}

</script>
<style>
/*popup*/
.popup_layer {position:fixed;top:0;left:0;z-index: 10000; width: 100%; height: 100%; background-color: rgba(0, 0, 0, 0.4); }
/*팝업 박스*/
.popup_box{position: relative;top:50%;left:50%; overflow: auto; height: 440px; width:750px;transform:translate(-50%, -50%);z-index:1002;box-sizing:border-box;background:#fff;box-shadow: 2px 5px 10px 0px rgba(0,0,0,0.35);-webkit-box-shadow: 2px 5px 10px 0px rgba(0,0,0,0.35);-moz-box-shadow: 2px 5px 10px 0px rgba(0,0,0,0.35);}
/*컨텐츠 영역*/
.popup_box .popup_cont {padding:10px;line-height:4rem;font-size:14px; }
/*버튼영역*//*오버레이 뒷배경*/
.popup_overlay{position:fixed;top:0px;right:0;left:0;bottom:0;z-index:1001;;background:rgba(0,0,0,0.5);}
/*popup*/
.star {
   position: relative;
   font-size: 3rem;
   color: #ddd;
}
.star input {
  width: 100%;
  height: 100%;
  position: absolute;
  left: 0;
  opacity: 0;
  cursor: pointer;
}
.star span {
  width: 0;
  position: absolute; 
  left: 0;
  color: red;
  overflow: hidden;
  pointer-events: none;
}
.star2 {
   position: relative;
   font-size: 3rem;
   color: #ddd;
}
.star2 input {
  width: 100%;
  height: 100%;
  position: absolute;
  left: 0;
  opacity: 0;
  cursor: pointer;
}
.star2 span {
  width: 0;
  position: absolute; 
  left: 0;
  color: red;
  overflow: hidden;
  pointer-events: none;
}
#reviewContents {
    width: 100%;
    height: 75px;
    padding: 10px;
    box-sizing: border-box;
    border: solid 1.5px #D3D3D3;
    border-radius: 5px;
    font-size: 16px;
    resize: none;
}
#sortTab li{
	float: left;
	font-weight: bold;
}
</style>
<div class="sect-grade">
	<c:forEach var="list" items="${list }">
		<div class="movie_grade">
		    <div class="egg_point">
		        <div class="rating">
		            <div class="box box_golden">
		                <span class="desc">관람평</span>
		                <span class="percent">
		                <c:if test="${list.mov_score!=0.0 }">
		                ${list.mov_score }
		                </c:if>
		                <c:if test="${list.mov_score==0.0 }">
		                ?
		                </c:if>
		                </span>
		            </div>
				</div>
			</div>
		</div>
		<div class="real-rating">
		    <p class="desc"><span><em>${totalCnt }</em> 명의 실관람객이 평가해주셨습니다.</span></p>
		    <div class="wrap_btn">
		        <a class="link-gradewrite" href="javascript:openPop();"><span>평점작성</span></a>
		        <div class="popup_layer" id="popup_layer" style="display: none;">
					<div class="popup_box">
						<c:import url="joaMovie_commentWrite.jsp"/>
					</div>
				</div>
		        <a class="link-reviewwrite" href="/movies/point/my-list.aspx"><span>내 평점</span></a>
		    </div>
		</div>
	</c:forEach>	
</div>
<script>
function like(rev_idx, rev_id, rev_movie_title){
	var param='rev_idx='+rev_idx+'&rev_id='+rev_id+'&rev_movie_title='+rev_movie_title;
	sendRequest('like.do',param,likeResult,'GET');
}
function likeResult(){
	if(XHR.readyState==4){
		if(XHR.status==200){
			var data=XHR.responseText;
			window.alert(data);
		}
	}
}
</script>
<ul class="sort" id="sortTab">
    <li class="sortTab on" id="test"><a href="javascript:show2(0);">최신순</a> | 
    <a href="javascript:show2(1);">추천순</a></li>
</ul>
<c:choose>
	<c:when test="${param.ot eq 0 }">
		<c:import url="/commentReg.do?ot=0"/>
	</c:when>
	<c:when test="${param.ot eq 1 }">
		<c:import url="/commentReg.do?ot=1"/>
	</c:when>
</c:choose>
<hr style="clear:both;">
<div id="junsung">
<c:forEach var="list" items="${commentList }">
	${list.rev_idx}
	${list.rev_id }<br>
	관람평: ${list.rev_score }<br> 
	${list.rev_comment }<br>
	${list.rev_date } <span onclick="like(${list.rev_idx}, '${list.rev_id}', '${list.rev_movie_title }');location.reload();">♡</span> ${list.rev_like }<br>
	<a onclick="openUpdate()">편집</a> <a onclick="openDelete('${list.rev_id}', '${list.rev_movie_title}');location.reload();">삭제</a><br>
	<hr>
</c:forEach>
</div>
	<div class="popup_layer" style="display: none;" id="update">
		<div class="popup_box">
			<c:import url="/commentUpdateForm.do?rev_id=test"/>
		</div>
	</div>	
<div class="paging">
	<ul id="paging_point">
		<li>${pageStr }</li>
	</ul>
</div>