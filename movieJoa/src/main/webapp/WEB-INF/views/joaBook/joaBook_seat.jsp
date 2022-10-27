<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
li {
	list-style: none;
}

a {
  text-decoration: none;
}

a:hover {
	color: red;
}

a:visited {
	color: black;
}
#codeList {
	color: blue;
}
.person {
	color: green;
}
.base1 {
	
}
</style>
</head>
<body>
<div align="center">
<form>
<div>
<span>인원수 선택</span>
<ul>
<li id="person0" class="person"><a href="javascript:ticket(0);">0</a></li>
<li id="person1" class="person"><a href="javascript:ticket(1);">1</a></li>
<li id="person2" class="person"><a href="javascript:ticket(2);">2</a></li>
</ul>
<input type="hidden" id="pcheck" name="pcheck"> 
</div>

<h1 align="center">SCREEN</h1>
<h1>빨간색 좌석만 선택 가능.</h1>
<table border="1" cellspacing="0">
	<tbody>
	<c:if test="${not empty seats }">
		<c:forEach var="i" begin="0" end="${height-1}" step="1">
			<tr>
				<c:forEach var="j" begin="0" end="${width}" step="1">
					<c:if test="${j==0 }">
						<td width="50px" height="50px" align="center">${rows[i] }</td>
					</c:if>
					<c:if test="${j!=0 }">
						<c:if test="${fn:substring(seats[i][j-1],seats[i][j-1].length()-1,seats[i][j-1].length())!='N' }">
							<td width="50px" bgcolor="red" height="50px" id="${seats[i][j-1] }" onclick="checkSeat('${seats[i][j-1] }');">${seats[i][j-1] }</td>
						</c:if>
						<c:if test="${fn:substring(seats[i][j-1],seats[i][j-1].length()-1,seats[i][j-1].length())=='N' }">
							<td width="50px" height="50px" id="${seats[i][j-1] }"></td>
						</c:if>
					</c:if>
				</c:forEach>
			</tr>
		</c:forEach>
	</c:if>
	</tbody>
</table>

<input type="hidden" name="sidx" value="${idx }">
<input type="hidden" name="code" id="code">
<input type="hidden" name="name" value="dool">
<input type="hidden" name="sch_mov_title" id="sch_mov_title" value="${sch_start_min }">
<input type="hidden" name="sch_branch" id="sch_branch" value="${sch_branch }">
<input type="hidden" name="sch_day" id="sch_day" value="${sch_day }">
<input type="hidden" name="sch_theater" id="sch_theater" value="${sch_theater }">
<input type="hidden" name="sch_start_hour" id="sch_start_hour" value="${sch_start_hour }">
<input type="hidden" name="sch_start_min" id="sch_start_min" value="${sch_start_min }">
<input type="submit" value="testz">
</form>
</div>
</body>

<script>
function checkSeat(seat) {
	if (seat.length == 3) {
		window.alert('이미 선택 판매 된 좌석입니다');
		return;
	}
	if ($('#code').val() == '') {
		document.getElementById(seat).style.backgroundColor = 'blue';
		
	}else {
		document.getElementById($('#code').val()).style.backgroundColor = 'red';		
		document.getElementById(seat).style.backgroundColor = 'blue';
	}
	
		$('#code').val(seat);
		document.getElementById('payid').style.color = 'red';
	//window.alert(seat);
	
	
	
	var subText = document.getElementById('s');
	subText.innerHTML = seat;
}
function hi(k) {
	var first = k; // 보내는 값
	var first1 = document.getElementById(k); //span의 id
	var buy = document.getElementById("buy"); // submit block으로 해놓은ㄱ ㅓ바꾸는 거
	
	if ($('#pcheck').val() == 1) {
		
		if($('#code').val()=='') {
			if(buy.style.display == 'none') {
				buy.style.display = 'block';
			}
			$('#code').val(k); // id = code에 값 저장
			first1.style.color = 'red';
			return;
		}
		
		if($('#code').val() == k) {
			buy.style.display = 'none';
			first1.style.color = 'blue';
			$('#code').val('');
		}else if ($('#code').val() != k) {
			window.alert('이미 선택 완료!');	
		}
		/////////////////////////////////
	}else if ($('#pcheck').val() == 2){
		if ($('#code').val()!='' && $('#code2').val()!='') {
			if ($('#code').val()!=k && $('#code2').val()!=k){
			window.alert('모두 선택되었습니다!')
			return;
			}
		}
		
		if($('#code').val()==k) {
			$('#code').val('');
			first1.style.color = 'blue';
			buy.style.display = 'none';
			return;
		}else if ($('#code2').val()==k){
			$('#code2').val('');
			first1.style.color = 'blue';
			buy.style.display = 'none';
			return;
		}
		
		if ($('#code').val()=='') {
			$('#code').val(k);
			first1.style.color = 'red';
		}else if($('#code').val()!='') {
			$('#code2').val(k);
			first1.style.color = 'red';
			buy.style.display = 'block';
		}
		
		if ($('#code').val()!='' && $('#code2').val()!='') {
			buy.style.display = 'block';
		}
	}
}

function ticket(num) {
	var person0 = document.getElementById("person0");
	var person1 = document.getElementById("person1");
	var person2 = document.getElementById("person2");
	var pcheck = document.getElementById("pcheck");
	var sc = document.getElementById("screen");
	window.alert(num);
	if(num==0 && $('#code').val() != '') {
		window.alert('이미 선택 완료');
		return;
	}
	
	if(num==0) {
		person0.style.color = 'red';
		person1.style.color = 'black';
		person2.style.color = 'black';
		pcheck.value = 0;
		//var basecolor = document.getElementsByClassName('base1');
		//for (var i=0; i<basecolor.length; i++) {
		//	basecolor[i].style.color = 'black';
		//}
		sc.style.display = 'none';
	}else if(num==1) {
		if ($('#code2').val()!='' && $('#code').val() != '') {
			window.alert('이미 두 자리를 선택하셨습니다');
			return;
		}
		if($('#code').val()!='' || $('#code2').val() != '') {
			buy.style.display = 'block';
			if($('#code').val()=='' || $('#code2').val() != '') {
				$('#code').val($('#code2').val());
				$('#code2').val('');
			}
		}
		
		person1.style.color = 'red';
		person0.style.color = 'black';
		person2.style.color = 'black';
		pcheck.value = 1;
		
		sc.style.display = 'block';
	}else if(num==2) {
		if ($('#code2').val() == '') {
			buy.style.display = 'none';
		}
		person2.style.color = 'red';
		person0.style.color = 'black';
		person1.style.color = 'black';
		pcheck.value = 2;
		
		sc.style.display = 'block';
		
	}
}

function base() {
	ticket(0);
	var sc = document.getElementById("screen");
	sc.style.display = 'none';
}
</script>
</html>