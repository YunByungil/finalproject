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
</style>
</head>
<body>
<div> <!-- 전체 div영역 -->
<c:import url="../header.jsp"></c:import>
<h1>예매 페이지</h1>

<form>
<section>
<article>
<div id="all">

<div> <!-- 제목 -->
<table id="ajaxSubject">
	<tr>
		<th>영화 제목</th>
	</tr>
	
	<c:forEach var="dto" items="${subjectList }">
		<tr>
			<td id="${dto.sch_mov_title }"><a href="javascript:next('${dto.sch_mov_title }')" >${dto.sch_mov_title }</a></td>
		</tr>
	</c:forEach>
</table>
</div>

<div> <!-- 극장 -->
<table id="ajaxBranch">
	<tr>
		<th>극장</th>
	</tr>
</table>
</div>

<div> <!-- 상영날짜 -->
<table id="ajaxDate">
	<tr>
		<th>날짜</th>
	</tr>
</table>
</div>

<div> <!-- 관 + 상영 시간 -->
<table id="ajaxTime">
	<tr>
		<th>시간</th>
	</tr>
</table>
</div>

<input type="hidden" name="sch_mov_title" id="sch_mov_title">
<input type="hidden" name="sch_branch" id="sch_branch">
<input type="hidden" name="sch_day" id="sch_day">
<input type="hidden" name="sch_theater" id="sch_theater">
<input type="hidden" name="sch_start_hour" id="sch_start_hour">
<input type="hidden" name="sch_start_min" id="sch_start_min">
<input type="submit" value="테스트">
<input type="button" value="yes" onclick="yes();">
</div>
</article>
</section>
</form>
<c:import url="../footer.jsp"></c:import>
</div>
</body>

<script>
function next(subject) {
	if (document.getElementById('sch_mov_title').value == '') {
	document.getElementById('sch_mov_title').value = subject;
	document.getElementById(subject).style.backgroundColor = 'gray';
	window.alert(subject);
	}else {
		window.alert('초기화합니다.');
		window.location.reload();
		return;
	}
	
	
	var form = {
		sch_mov_title: $('#sch_mov_title').val()
	}
	$.ajax ({
		url: "reload.do",
		type: "POST",
		data: JSON.stringify(form),
		contentType: "application/json; charset=utf-8;",
		success: function(data) {
			window.alert('성공(제목,장소 체크x)');
			$('#ajaxBranch').html(data.reloadBranch);
		}
	});
}

function next2(branch) {
	if (document.getElementById('sch_branch').value == '') {
	document.getElementById('sch_branch').value = branch;
	document.getElementById(branch).style.backgroundColor = 'gray';
	window.alert(branch);
	}else {
		window.alert('초기화합니다.');
		window.location.reload();
		return;
	}
	
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
				window.alert('성공(제목,장소 체크x)');
				$('#ajaxDate').html(data.reloadDate);
			}
		});
}

function next3(day) {
	if (document.getElementById('sch_day').value == '') {
	document.getElementById('sch_day').value = day;
	document.getElementById(day).style.backgroundColor = 'gray';
	window.alert(day);
	}else {
		window.alert('초기화합니다.');
		window.location.reload();
		return;
	}
	
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
				window.alert('성공(제목,장소 체크x)');
				$('#ajaxTime').html(data.reloadTime);
			}
		});
}

function next4(time) {
	window.alert(time);
	if (document.getElementById('sch_theater').value == '') {
		document.getElementById(time).style.backgroundColor = 'gray';
		}else {
			window.alert('초기화합니다.');
			window.location.reload();
			return;
	}
	
	if(time.length == 6) {
		var g = time.substring(0,1);
		window.alert(g);
		var h = time.substring(2,4);
		window.alert(h);
		var m = time.substring(4,6);
		window.alert(m);
		document.getElementById('sch_theater').value = g;
		document.getElementById('sch_start_hour').value = h;
		document.getElementById('sch_start_min').value = m;
	}else {
		var g = time.substring(0,2);
		window.alert(g);
		var h = time.substring(3,5);
		window.alert(h);
		var m = time.substring(5,7);
		window.alert(m);
		document.getElementById('sch_theater').value = g;
		document.getElementById('sch_start_hour').value = h;
		document.getElementById('sch_start_min').value = m;
	}
	
}

function yes() {
	$.ajax ({
		url: "bookSubmit.do?sch_mov_title="+$('#sch_mov_title').val()+"&sch_branch="+$('#sch_branch').val()
				+"&sch_day="+$('#sch_day').val()+"&sch_theater="+$('#sch_theater').val()
				+"&sch_start_hour="+$('#sch_start_hour').val()+"&sch_start_min="+$('#sch_start_min').val(),
		type: "GET",
		contentType: "application/json; charset=utf-8;",
		success: function(data) {
			window.alert('성공(브랜치,요일값 체크x)');
			$('#all').html(data);
		}
	});
}
</script>
</html>