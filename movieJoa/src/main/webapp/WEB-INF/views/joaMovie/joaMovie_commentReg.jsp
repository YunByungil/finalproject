<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
function openPop(){
	document.getElementById('popup_layer').style.display='block';
}
function closePop(){
	document.getElementById('popup_layer').style.display = 'none';
}
const drawStar = (target) => {
    document.querySelector(`.star span`).style.width = target.value * 10+'%';
    document.getElementById('val').innerText=target.value;
    document.getElementById('score').value=target.value;
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
</style>
<div class="sect-grade"><c:forEach var="list" items="${list }">
	<div class="movie_grade">
	    <div class="egg_point">
	        <div class="rating">
	            <div class="box box_golden">
	                <span class="sprite_preegg big great"></span>
	                <span class="desc">Golden Egg</span>
	                <span class="percent">92%</span>
	                <span class="tooltip">실관람평지수</span>
	            </div>
			</div>
		</div>
	</div>
	<div class="real-rating">
	    <p class="title">관람일 포함 7일 이내 관람평을 남기시면 <strong>CJ ONE 20P</strong>가 적립됩니다. </p>
	    <p class="desc"><span><em>37,950</em> 명의 실관람객이 평가해주셨습니다.</span></p>
	    <div class="wrap_btn">
	        <a class="link-gradewrite" href="javascript:openPop();"><span>평점작성</span></a>
	        <div class="popup_layer" id="popup_layer" style="display: none;">
				<div class="popup_box">
					<!--팝업 컨텐츠 영역-->
						<h2 style="padding: 10px;">평점작성</h2>
						<hr>
						<h3 align="center">${list.mov_title }</h3>
						
					<div class="popup_cont" style="float: left">
									<span class="star">
								 	  ★★★★★
								  	<span>★★★★★</span>
									<input type="range" oninput="drawStar(this)" value="1" step="1" min="0" max="10">
									</span>
					</div>
						
					 	<b id="val" style="font-size: 4rem;"></b>			
					 	<form class="mb-3" name="myform" id="myform" action="commentWrite.do" method="post" target="blankifr">
					 	<input type="hidden" name="rev_id" value="test">
					 	<input type="hidden" name="rev_movie_title" value="${list.mov_title }">
					 	<input type="hidden" name="rev_score" id="score">
					 	
							<div>
								<textarea class="col-auto form-control" id="reviewContents" name="rev_comment"></textarea>
							</div>
						</form>		<iframe name="blankifr" style="display:none;"></iframe>	
					<!--팝업 버튼 영역-->
					<div>
            <div style="background-color:#DDDDDD;text-align: center;padding-bottom: 10px;padding-top: 10px; width: 50%; float: left;" onClick="closePop();">
                <span class="pop_bt" style="font-size: 13pt;" >
                     닫기
                </span>
            </div>					
			<div style="background-color:#DDDDDD;text-align: center;padding-bottom: 10px;padding-top: 10px; width: 50%; float: right;" onClick="document.getElementById('myform').submit();closePop();">
                <span class="pop_bt" style="font-size: 13pt;" >
                     확인
                </span>
            </div>	
          			</div>		
				</div>
			</div>
	        <a class="link-reviewwrite" href="/movies/point/my-list.aspx"><span>내 평점</span></a>
	    </div>
	    
	</div>
	<ul class="sort" id="sortTab">
	    <li class="sortTab on" data-order-type="0" id="test"><a href="javascript:void(0);" title="현재선택">최신순<span class="arrow-down"></span></a></li>
	    <li class="sortTab" data-order-type="3"><a href="javascript:void(0);">추천순<span class="arrow-down"></span></a></li>
	</ul>
	<div class="wrap-persongrade">
	    <ul id="movie_point_list_container" class="point_col2"></ul>
	</div></c:forEach>
</div>
<c:forEach var="list" items="${commentList }">
${list.rev_id }<br>
관람평: ${list.rev_score }<br> 
${list.rev_comment }<br>
${list.rev_date } ${list.rev_like }<br><br>
</c:forEach>
<div class="paging">
	<ul id="paging_point"></ul>
</div>
