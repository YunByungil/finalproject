<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/main.css?ver=8">
<link rel="stylesheet" type="text/css" href="css/joaHelpDesk.css?ver=8">
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	
document.addEventListener('DOMContentLoaded', function() {
    var checkboxes = document.querySelectorAll('input[type=checkbox][name=off]');
 
    for (var checkbox of checkboxes)
    {
        checkbox.addEventListener('change', function(event)
        {
            if (event.target.checked) {
             var region=document.getElementById('region');
			 region.setAttribute('disabled',true);
            var cinema= document.getElementById('cinema');
            cinema.setAttribute('disabled',true);
             region[0].selected = true;
             cinema[0].selected = true;
            }
            else {
            	document.getElementById('region').removeAttribute("disabled");
            	document.getElementById('cinema').removeAttribute("disabled"); 
            	
    
            }
        });
    }
}, false);
</script>

<script>

	function categoryChange(e) {
	  var seoul = ['영화관선택','강남점', '역삼점' '삼성점', '신사점', '청담점', '압구정점','잠실점', '강동점',
          '을지로점', '명동점', '서울역점', '이태원점', '종로점', '인사동점','홍대점', '영등포점', '구로점'];
	  var incheon = ['영화관선택','송도점', '소래포점', '인천점', '강화점'];
	  var gyeonggi = ['영화관선택','가평점', '청평점', '양평점', '수원점', '화성점', '파주점', '김포점', '의정부점'];
	  var gangwon = ['영화관선택','속초점', '양양점', '고성점', '춘천점', '강릉점', '평창점'];
	  var select = ['영화관선택','영화관선택'];
	  var target = document.getElementById("cinema");
	 
	  if(e.value == "서울") var d = seoul;
	  else if(e.value == "인천") var d = incheon;
	  else if(e.value == "경기") var d = gyeonggi;
	  else if(e.value == "강원") var d = gangwon;
	  else if(e.value == "온라인") var d = select;
	 
	  target.options.length = 0;
	 
	  for (x in d) {
	    var opt = document.createElement("option");
	    opt.value = d[x];
	    opt.innerHTML = d[x];
	    target.appendChild(opt);
	  } 
	}

</script>

<script>
function checkIt(){
	if (!document.getElementsByName("hqt_type").value){	                    
		alert("문의 유형을 선택해주세요.");
		document.oneByOneFM.focus();
		return false;
	}
</script>

</head>
<body>
<c:import url="../../header.jsp"></c:import>
<section>
<div class="helpDesk_main">
<div class="manyHelpMain">
	<h4 class="manyHelpSubject">1:1문의</h4>
	<div class="manyHelpIntroduce">문의 내용을 남겨주시면 저희가 성심 성의껏 답변을 해드립니다.<br>
	답변은 마이페이지에서 받아 보실 수 있습니다.</div>
	<br>
	<br>
	<form name="oneByOneFM" action="oneByOneHelpWrite.do"  onsubmit="return checkIt()">
	<br>
	<div><label>문의유형 </label>
		&nbsp;
		<label><input type="radio" name="hqt_type" value="편의">편의</label>
		&nbsp;
		<label><input type="radio" name="hqt_type" value="결제">결제</label>
		&nbsp;
		<label><input type="radio" name="hqt_type" value="이벤트">이벤트</label>
		&nbsp;
		<label><input type="radio" name="hqt_type" value="분실">분실</label>
		&nbsp;
		<label><input type="radio" name="hqt_type" value="서비스">서비스</label>
	</div>
	<hr class="hr">
	<div><label>영화관선택 </label>
		&nbsp;
		<label><input name="off" type="checkbox">선택안함</label>
		&nbsp;
		<select id="region" onchange="categoryChange(this)" name="hqt_region">
			<option value="온라인">지역선택</option>
			<option value="서울">서울</option>
		  	<option value="경기">경기</option>
		  	<option value="인천">인천</option>
		  	<option value="강원">강원</option>
		</select>
		&nbsp;
		<select id="cinema" name="hqt_cinema">
		<option value="온라인">영화관선택</option>
		
		</select>
		<hr class="hr">
	</div>
</div>

	<div class="emailContent">
		<table class="ta"align="center">
			<tr>
				<td class="je">제목</td>
				<td><input id="subject" type="text" name="hqt_subject"></td>
			</tr>
			<tr>
				<td class="mun">문의내용</td>
				<td><textarea rows="31" cols="76" name="hqt_content" id="bordercontent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right" class="sub"><input type="submit" value="등록하기" class="submitbutton"></td>
			</tr>
		</table>
	</div>
	</form>
	<ul class="helpMenu">
		<a href="helpDesk.do" class="HM_bar_a"><li class="HM_bar">고객센터</li></a>
		<a href="manyHelp.do" class="HM_bar_a"><li class="HM_bar">자주찾는 질문</li></a>
		<a href="notice.do" class="HM_bar_a"><li class="HM_bar">공지게시판</li></a>
		<a href="emailHelp.do" class="HM_bar_a"><li class="HM_bar">이메일문의</li></a>
		<a href="oneByOneHelp.do" class="HM_bar_a"><li class="HM_bar">1:1문의</li></a>
	</ul>
	
</div>
</section>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>