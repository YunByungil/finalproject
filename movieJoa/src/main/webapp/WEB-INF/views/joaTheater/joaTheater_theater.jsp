<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
* {
	text-align: center;
}

ul {
	list-style: none;
	padding-left: 0px;
	display: inline;
}

li {
	display: inline;
}

.checkBranchs {
	background-color: lightgray;
}

.checkCitys {
	background-color: lightgray;
}

.checkYoils {
	background-color: lightgray;	
}
</style>
</head>
<body onload="welcome('${sch_city}')">
<div>

<div>
<c:import url="../header.jsp"></c:import>
</div>

<h1>극장 페이지</h1>
<form>


<div style="width: 1250px;">

<div>
<div style="width: 10%; float: left;">&nbsp;</div>
<ul>
<c:forEach var="dto" items="${testCity }" varStatus="c">
<li id="${dto }" class="" style="font-size: 18px; width: 10%; float: left;">
<a href="javascript:checkCity('${dto }');">
${dto } 
&nbsp;
</a>
</li>
</c:forEach>
</ul>
<div style="width: 10%; float: left;">&nbsp;</div>
</div>


<div id="1" style="display: none;">
<ul>
<c:forEach var="branch1" items="${branchList }" varStatus="c">
<c:if test="${c.count == 5 }"> <br></c:if>
<li id="${branch1.sch_branch }" class="" style="font-size: 38px; width: 25%; float: left;"> 
<a href="javascript:checkBranch('${branch1.sch_branch }')">${branch1.sch_branch }</a></li>
</c:forEach>
</ul>
</div>

<div id="2" style="display: none;">
<ul>
<c:forEach var="branch1" items="${goyangList }" varStatus="c">
<c:if test="${c.count == 5 }"> <br></c:if>
<li id="${branch1.sch_branch }" class="" style="font-size: 38px; width: 25%; float: left;"> 
<a href="javascript:checkBranch('${branch1.sch_branch }')">${branch1.sch_branch }</a></li>
</c:forEach>
</ul>
</div>

</div>

<div style="clear: both;">
<h1>=====================Theater==================</h1>
<div>
<h3>CGV ${sch_branch }</h3>
<img src="/movieJoa/img/theater/${sch_branch }.jpg" width="1000px" height="1000px">
</div>
<h2>상영시간표</h2>
</div> <!--  -->
<hr>

<div>
<ul id="dayList">
<c:if test="${empty mm }">
상영 정보가 존재하지 않습니다.
</c:if>
${mm }
</ul>
</div>

<div>
<c:if test="${empty timeList }">
<ul>
<li>등록된 정보가 없습니다</li>
</ul>
</c:if>
<ul id = "new">
<c:forEach var="dto" items="${timeList }" varStatus="c">
<li>
${dto.rate }/
${dto.subject }/
${dto.genre }/
${dto.runningtime }분/
${dto.sdate }개봉
	<br>
	<c:forEach var="dto3" items="${realTimeList }">
		
		<c:if test="${dto.subject eq dto3.sch_mov_title}">
			<br>
			<a href="javascript:book('${dto3.sch_start_hour}')">${dto3.sch_start_hour }</a>
		</c:if>
	</c:forEach>
	<br>
<hr>
</li>
</c:forEach>
</ul>
</div>
<hr>

<input type="hidden" name="sch_city" id="sch_city">
<input type="hidden" name="sch_branch" id="sch_branch">
<input type="hidden" name="sch_dayd" id="sch_dayd">
<input type="submit" value="test">
</form>

<div>
<c:import url="../footer.jsp"></c:import>
</div>

</div>
</body>
<script>
function welcome(city) {
	window.alert(city);
	window.alert('${sch_branch}');
	var classAdd = document.getElementById(city); // 서울지역 기본
	classAdd.classList.add('checkCitys'); // 서울 기본
	
	var classAdd = document.getElementById('${sch_branch}'); // 강남 기본
	classAdd.classList.add('checkBranchs'); // 강남 기본
	
	
	document.getElementById('sch_city').value = city;
	document.getElementById('sch_branch').value = '${sch_branch}';
	//document.getElementById('yoil').value = '${yoil}';
	document.getElementById('1').style.display = 'block';
}
function checkCity(city) {
	window.alert(city);
	if(city == '서울') {
		document.getElementById('1').style.display = 'block';
		document.getElementById('2').style.display = 'none';
		//document.getElementById('3').style.display = 'none';
		//document.getElementById('4').style.display = 'none';
	}else if (city == '경기') {
		document.getElementById('1').style.display = 'none';
		document.getElementById('2').style.display = 'block';
		//document.getElementById('3').style.display = 'none';
		//document.getElementById('4').style.display = 'none';
	}else {
		window.alert('준비 중입니다.');
		return;
	}
	////////////////class 추가 삭제///////////////////////	
	var classAdd = document.getElementById(city);
	
	var menus = document.getElementsByClassName('checkCitys');
	for (var i=0; i<menus.length; i++) {
		menus[i].classList.remove('checkCitys');
	}
	classAdd.classList.add('checkCitys');
	////////////////////////////////////////////////////
	document.getElementById('sch_city').value = city;
}
function checkBranch(branch) {
	window.alert(branch);
	////////////////class 추가 삭제///////////////////////	
	var classAdd = document.getElementById(branch);
	
	var menus = document.getElementsByClassName('checkBranchs');
	for (var i=0; i<menus.length; i++) {
		menus[i].classList.remove('checkBranchs');
	}
	classAdd.classList.add('checkBranchs');
	////////////////////////////////////////////////////
	document.getElementById('sch_branch').value = branch;
	window.location.href = 'joaTheater.do?sch_city='+document.getElementById('sch_city').value+'&sch_branch='+branch;
}
function checkYoil(yoil) {
	window.alert(yoil);
	////////////////class 추가 삭제///////////////////////	
	var classAdd = document.getElementById(yoil);
	
	var menus = document.getElementsByClassName('checkYoils');
	for (var i=0; i<menus.length; i++) {
		menus[i].classList.remove('checkYoils');
	}
	classAdd.classList.add('checkYoils');
	////////////////////////////////////////////////////
	document.getElementById('yoil').value = yoil;
	
	var form = {  
		sch_city: $('#sch_city').val(),
		sch_branch: $('#sch_branch').val(),
		sch_dayd: $('#sch_dayd').val()
	}
	$.ajax ({
		url: "search.do",
		type: "POST",
		data: JSON.stringify(form),
		contentType: "application/json; charset=utf-8;",
		success: function(data) {
			window.alert('성공');
			$('#new').html(data.reset);
		}
	});
}
</script>
</html>