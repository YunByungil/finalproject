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
.tt {
	width: 100%; 
	border-bottom: 1px;
}
.trtr {
	background-color: black;
}
.trtrtr {
	background-color: #fcf2ce;
}

li {
	list-style: inline;
}
a {
  text-decoration: none;
}

.checkSubject {
	color: red;
}

.checkBranch {
	color: red;
}

.checkYoil {
	color: red;
}

.checkSt {
	color: red;
}

.noClick {
	color: gray;
}

table {
	text-align: center;
}

th {
	text-align: center;
	color: white;
}

.bar {
	display: inline;
}
.subjectBar {
	display: inline;
}
.branchBar {
	display: inline;
}

</style>
</head>
<body>
<form action="theaterPay.do" method="post">
<div> <!-- 전체 div영역 -->

<div>
<c:import url="../header.jsp"></c:import>
</div>

<div id="all2">


<div id="all">
<h1 align="center">예매 페이지</h1>
<div align="center" style="background-color: ">

<div style="width: 25%; height: 25%; float: left;"> <!-- 제목 -->
<table id="ajaxSubject" class="tt">
	<tr class="trtr">
		<th>영화 제목</th>
	</tr>
	
	<c:forEach var="dto" items="${subjectList }">
		<tr class="trtrtr">
			<td id="${dto.sch_mov_title }"><a href="javascript:next('${dto.sch_mov_title }')" >${dto.sch_mov_title }</a></td>
		</tr>
	</c:forEach>
</table>
</div>

<div style="width: 25%; height: 25%; float: left;"> <!-- 극장 -->
<table id="ajaxBranch" class="tt">
	<tr class="trtr">
		<th>극장</th>
	</tr>
</table>
</div>

<div style="width: 25%; height: 25%; float: left;">  <!-- 상영날짜 -->
<table id="ajaxDate" class="tt">
	<tr class="trtr">
		<th>날짜</th>
	</tr>
</table>
</div>


<div style="width: 25%; height: 25%; float: left;"> <!-- 관 + 상영 시간 -->
<table id="ajaxTime" class="tt">
	<tr class="trtr">
		<th>관/시간</th>
	</tr>
</table>
</div>

</div>

</div>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

<div align="center" style="background-color: #392f31; width: 100%; height: 200px; ">

<div style="width: 25%; height: 25%; float: left;">
<span id="sub2" style="color: white;"></span>
<span id="sub" style="color: white;">영화선택</span>
</div>

<div style="width: 25%; height: 25%; float: left;">
<span id="br" style="color: white;">극장선택</span><br>
<span id="date" style="color: white;"></span><br>
<span id="to" style="color: white;"></span>
</div>

<div style="width: 25%; height: 25%; float: left;">
<span id="s" style="color: white;">좌석선택</span><br>
<span id="s2" style="color: white;"></span><br>
<span id="money" style="color: white;"></span>
</div>

<div style="width: 25%; height: 25%; float: left;">
<input type="button" value="좌석선택" onclick="no();" id="noid" style="width: 418px; height: 200px;">
<input type="button" value="좌석선택" onclick="yes();" style="display: none; background-color: red; width: 418px; height: 200px;" id="yesid">
<input type="button" value="결제선택" onclick="pay();" style="display: none; width: 418px; height: 200px;" id="payid">
<input type="submit" value="결제선택" style="display: none; background-color: red; width: 418px; height: 200px;" id="realpayid">
</div>

</div>


</div>

<div>
<c:import url="../footer.jsp"></c:import>
</div>


</div>
</form>
<input type="hidden" name="sch_mov_title" id="sch_mov_title">
<input type="hidden" name="sch_branch" id="sch_branch">
<input type="hidden" name="sch_day" id="sch_day">
<input type="hidden" name="sch_theater" id="sch_theater">
<input type="hidden" name="sch_start_hour" id="sch_start_hour">
<input type="hidden" name="sch_start_min" id="sch_start_min">
</body>

<script>
function next(subject) {
	if (document.getElementById('sch_mov_title').value == '') {
	document.getElementById('sch_mov_title').value = subject;
	document.getElementById(subject).style.backgroundColor = 'gray';
	}else {
		window.alert('초기화합니다.');
		window.location.reload();
		return;
	}
	var subText2 = document.getElementById('sub');
	var subText = document.getElementById('sub2');
	subText.innerHTML = '<img src="/movieJoa/img/theater/'+subject+'.jpg" width="200px" height="200px">';
	subText2.innerHTML = subject;
	
	var form = {
		sch_mov_title: $('#sch_mov_title').val()
	}
	$.ajax ({
		url: "reload.do",
		type: "POST",
		data: JSON.stringify(form),
		contentType: "application/json; charset=utf-8;",
		success: function(data) {
			$('#ajaxBranch').html(data.reloadBranch);
		}
	});
}

function next2(branch) {
	if (document.getElementById('sch_branch').value == '') {
	document.getElementById('sch_branch').value = branch;
	document.getElementById(branch).style.backgroundColor = 'gray';
	}else {
		window.alert('초기화합니다.');
		window.location.reload();
		return;
	}
	var subText = document.getElementById('br');
	subText.innerHTML = branch;
	
	var form = {
			sch_mov_title: $('#sch_mov_title').val(),
			sch_branch: $('#sch_branch').val()
		}
		$.ajax ({
			url: "reload2.do",
			type: "POST",
			data: JSON.stringify(form),
			contentType: "application/json; charset=utf-8;",
			success: function(data) {
				$('#ajaxDate').html(data.reloadDate);
			}
		});
}

function next3(day) {
	if (document.getElementById('sch_day').value == '') {
	document.getElementById('sch_day').value = day;
	document.getElementById(day).style.backgroundColor = 'gray';
	}else {
		window.alert('초기화합니다.');
		window.location.reload();
		return;
	}
	var subText = document.getElementById('date');
	subText.innerHTML = day;
	
	var form = {
			sch_mov_title: $('#sch_mov_title').val(),
			sch_branch: $('#sch_branch').val(),
			sch_day: $('#sch_day').val()
		}
		$.ajax ({
			url: "reload3.do",
			type: "POST",
			data: JSON.stringify(form),
			contentType: "application/json; charset=utf-8;",
			success: function(data) {
				$('#ajaxTime').html(data.reloadTime);
			}
		});
}

function next4(time) {
	if (document.getElementById('sch_theater').value == '') {
		document.getElementById(time).style.backgroundColor = 'gray';
		}else {
			window.alert('초기화합니다.');
			window.location.reload();
			return;
	}
	document.getElementById('noid').style.display = 'none';
	document.getElementById('yesid').style.display = 'inline';
	
	if(time.length == 6) {
		var g = time.substring(0,1);
		var h = time.substring(2,4);
		var m = time.substring(4,6);
		document.getElementById('sch_theater').value = g;
		document.getElementById('sch_start_hour').value = h;
		document.getElementById('sch_start_min').value = m;
	}else {
		var g = time.substring(0,2);
		var h = time.substring(3,5);
		var m = time.substring(5,7);
		document.getElementById('sch_theater').value = g;
		document.getElementById('sch_start_hour').value = h;
		document.getElementById('sch_start_min').value = m;
	}
	var subText = document.getElementById('to');
	subText.innerHTML = g+'관/'+h+':'+m;
	
}
function no() {
	window.alert('예매하실 영화 정보를 선택해주세요.');
	
}

function yes() {
	if (${userInfo.mem_id==null}) {
		window.alert('로그인 후 이용가능합니다.');
		window.location.href = '/movieJoa/memberLogin.do';
		return;
	}
	document.getElementById('yesid').style.display = 'none';
	document.getElementById('payid').style.display = 'inline';
	$.ajax ({
		url: "bookSubmit.do?sch_mov_title="+$('#sch_mov_title').val()+"&sch_branch="+$('#sch_branch').val()
				+"&sch_day="+$('#sch_day').val()+"&sch_theater="+$('#sch_theater').val()
				+"&sch_start_hour="+$('#sch_start_hour').val()+"&sch_start_min="+$('#sch_start_min').val(),
		type: "GET",
		contentType: "application/json; charset=utf-8;",
		success: function(data) {
			$('#all').html(data);
		}
	});
}

function pay() {
	if ($('#code').val() == '') {
		window.alert('좌석을 선택해주세요');
	}
}
</script>
</html>