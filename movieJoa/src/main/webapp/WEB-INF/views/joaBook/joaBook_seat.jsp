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
</style>
</head>
<body>
<div align="center">
<div>
<h3>인원수 선택</h3>
<span id="person1" class="person" style="font-size: 38px"><a href="javascript:ticket(1);">1</a></span>
<span id="person2" class="person" style="font-size: 38px"><a href="javascript:ticket(2);">2</a></span>
<input type="hidden" id="pcheck" name="pcheck"> 
</div>

<h1 align="center">SCREEN</h1>
<h1>초록색 좌석만 선택 가능.</h1>
<div >
<img src="/movieJoa/img/joaEvent_img/coupon_thumb.jpg" style="width: 15%; height: 300px; float: left;">
</div>

<div style="width: 70%; float: left;">
<table border="1" cellspacing="0" id="realtable" width="600px">
	<tbody>
	<c:if test="${not empty seats }">
		<c:forEach var="i" begin="0" end="${height-1}" step="1">
			<tr>
				<c:forEach var="j" begin="0" end="${width}" step="1">
					<c:if test="${j==0 }">
						<td width="50px" height="50px" align="center">${rows[i] }</td>
					</c:if>
					<c:if test="${j!=0 }">
<<<<<<< HEAD
						<c:if test="${fn:substring(seats[i][j-1],seats[i][j-1].length()-1,seats[i][j-1].length())!='N' && fn:substring(seats[i][j-1],seats[i][j-1].length()-1,seats[i][j-1].length())!='B'}">
                     <td width="50px" bgcolor="green" height="50px" id="${seats[i][j-1] }" onclick="checkSeat('${seats[i][j-1] }');">${seats[i][j-1] }</td>
                  </c:if>
                  <c:if test="${fn:substring(seats[i][j-1],seats[i][j-1].length()-1,seats[i][j-1].length())=='N' }">
                     <td width="50px" height="50px" id="${seats[i][j-1] }"></td>
                  </c:if>
                  <c:if test="${fn:substring(seats[i][j-1],seats[i][j-1].length()-1,seats[i][j-1].length())=='B' }">
                     <td width="50px" bgcolor="red" height="50px" id="${seats[i][j-1] }">X</td>
                  </c:if>
=======
						<c:if test="${fn:substring(seats[i][j-1],seats[i][j-1].length()-1,seats[i][j-1].length())!='N' }">
							<c:if test="${empty seatList }">
								<td width="50px" bgcolor="green" height="50px" id="${seats[i][j-1] }" onclick="checkSeat('${seats[i][j-1] }');">${seats[i][j-1] }</td>
							</c:if>
							<c:if test="${not empty seatList }">
								<c:forEach var="seatc" items="${seatList }">
									<c:if test="${seats[i][j-1]==seatc.payMov_sch_seat }">
										<td width="50px" bgcolor="red" height="50px" id="${seats[i][j-1] }">${seats[i][j-1] }</td>
									</c:if>
									<c:if test="${seats[i][j-1]!=seatc.payMov_sch_seat }">
										<td width="50px" bgcolor="green" height="50px" id="${seats[i][j-1] }" onclick="checkSeat('${seats[i][j-1] }');">${seats[i][j-1] }</td>
									</c:if>
								</c:forEach>
							</c:if>
						</c:if>
						<c:if test="${fn:substring(seats[i][j-1],seats[i][j-1].length()-1,seats[i][j-1].length())=='N' }">
							<td width="50px" height="50px" id="${seats[i][j-1] }"></td>
						</c:if>
>>>>>>> 0cfdee4e2203d1b4f6be6d1d0b32b284971fe654
					</c:if>
				</c:forEach>
			</tr>
		</c:forEach>
	</c:if>
	</tbody>
</table>
</div>

<div>
<img src="/movieJoa/img/joaEvent_img/coupon_thumb.jpg" style="width: 15%; height: 300px; float: left;">
</div>
<input type="hidden" name="payMov_the_idx" value="${idx }">
<input type="hidden" name="payMov_sch_seat" id="code">
<input type="hidden" name="payMov_sch_seat2" id="code2">
<input type="hidden" name="payMov_mem_id" value="dool">

<input type="hidden" name="payMov_price" id="payMov_price">
<input type="hidden" name="payMov_mov_title" id="sch_mov_title" value="${sch_mov_title }">
<input type="hidden" name="payMov_the_city" id="sch_city" value="${sch_city }">
<input type="hidden" name="payMov_the_branch" id="sch_branch" value="${sch_branch }">
<input type="hidden" name="payMov_sch_day" id="sch_day" value="${sch_day }">
<input type="hidden" name="payMov_sch_theater" id="sch_theater" value="${sch_theater }">
<input type="hidden" name="payMov_sch_start_hour" id="sch_start_hour" value="${sch_start_hour }">
<input type="hidden" name="payMov_sch_start_min" id="sch_start_min" value="${sch_start_min }">
</div>
</body>

<script>
function checkSeat(seat) {
	if (seat.length == 3) {
		window.alert('이미 선택 판매 된 좌석입니다');
		return;
	}
	
	if ($('#pcheck').val() == '') {
		window.alert('인원을 선택해주세요');
		return;
	}
	
	if ($('#pcheck').val() == 1) {
		
		if($('#code').val()=='') {
			$('#code').val(seat); // id = code에 값 저장
			document.getElementById(seat).style.backgroundColor = 'blue';
			var subText = document.getElementById('s');
			var subText2 = document.getElementById('money');
			subText.innerHTML = '좌석명 : '+seat;
			subText2.innerHTML = '가격 : 10000원';
			$('#payMov_price').val('10000');
			document.getElementById('payid').style.display = 'none';
			document.getElementById('realpayid').style.display = 'block';
			return;
		}
		
		if($('#code').val() == seat) {
			document.getElementById(seat).style.backgroundColor = 'green';
			var subText = document.getElementById('s');
			var subText2 = document.getElementById('money');
			subText.innerHTML = '좌석선택';
			subText2.innerHTML = '';
			document.getElementById('payid').style.display = 'block';
			document.getElementById('realpayid').style.display = 'none';
			$('#code').val('');
		}else if ($('#code').val() != seat) {
			window.alert('이미 선택 완료!');	
		}
		
	}
	
	/////////////////////////////
	if ($('#pcheck').val() == 2){
		
		if ($('#code').val() != '' && $('#code2').val() != '') {
			if ($('#code').val() != seat && $('#code2').val() != seat){
			window.alert('모두 선택되었습니다!')
			return;
			}
		}
		
				
		
		
		if($('#code').val() == seat) {
			if ($('#code2').val() != '') {
				$('#code').val('');
				$('#code').val($('#code2').val());
				$('#code2').val('');
				document.getElementById(seat).style.backgroundColor = 'green';
				var subText = document.getElementById('s');
				var subText3 = document.getElementById('s2');
				var subText2 = document.getElementById('money');
				subText.innerHTML = '좌석명 : '+$('#code').val();
				subText2.innerHTML = '가격 : 10000원';
				$('#payMov_price').val('10000');
				document.getElementById('payid').style.display = 'block';
				document.getElementById('realpayid').style.display = 'none';
			}else {
				$('#code').val('');
				document.getElementById(seat).style.backgroundColor = 'green';
				var subText = document.getElementById('s');
				var subText3 = document.getElementById('s2');
				var subText2 = document.getElementById('money');
				subText.innerHTML = '좌석선택';
				subText2.innerHTML = '';
				document.getElementById('payid').style.display = 'block';
				document.getElementById('realpayid').style.display = 'none';
			}
			return;
		}else if ($('#code2').val() == seat){
			$('#code2').val('');
			var subText = document.getElementById('s');
			var subText3 = document.getElementById('s2');
			var subText2 = document.getElementById('money');
			subText.innerHTML = '좌석명 : '+$('#code').val();
			subText2.innerHTML = '가격 : 10000원';
			$('#payMov_price').val('10000');
			document.getElementById('payid').style.display = 'block';
			document.getElementById('realpayid').style.display = 'none';
			document.getElementById(seat).style.backgroundColor = 'green';
			return;
		}
		
		if ($('#code').val()=='') {
			$('#code').val(seat);
			var subText = document.getElementById('s');
			var subText3 = document.getElementById('s2');
			var subText2 = document.getElementById('money');
			subText.innerHTML = '좌석명 : '+seat;
			subText2.innerHTML = '가격 : 10000원';
			document.getElementById(seat).style.backgroundColor = 'blue';
		}else if($('#code').val()!='') {
			$('#code2').val(seat);
			var subText = document.getElementById('s');
			var subText3 = document.getElementById('s2');
			var subText2 = document.getElementById('money');
			subText.innerHTML = '좌석명 : '+$('#code').val() +' | ' +seat;
			subText2.innerHTML = '가격 : 20000원';
			$('#payMov_price').val('20000');
			document.getElementById(seat).style.backgroundColor = 'blue';
		}
		
		if ($('#code').val() != '' && $('#code2').val() != '') {
			document.getElementById('payid').style.display = 'none';
			document.getElementById('realpayid').style.display = 'block';
		}
		
		if ($('#code').val() == '') {
			var subText = document.getElementById('s');
			var subText2 = document.getElementById('money');
			subText.innerHTML = '좌석선택';
			subText2.innerHTML = '';
			document.getElementById('payid').style.display = 'block';
			document.getElementById('realpayid').style.display = 'none';
		}
	}
}

function ticket(num) {
	var person1 = document.getElementById("person1");
	var person2 = document.getElementById("person2");
	var pcheck = document.getElementById("pcheck");

	if(num==1) {
		if ($('#code2').val()!='' && $('#code').val() != '') {
			window.alert('이미 두 자리를 선택하셨습니다');
			return;
		}
		if ($('#code').val() != '') {
			document.getElementById('payid').style.display = 'none';
			document.getElementById('realpayid').style.display = 'block';
		}
		
		if($('#code').val()=='' && $('#code2').val() != '') {
			$('#code').val($('#code2').val());
			$('#code2').val('');
		}
		person1.style.backgroundColor = 'gray';
		person2.style.backgroundColor = 'white';
		pcheck.value = 1;
	}
	
	if(num==2) {
		if ($('#code2').val() == '') {
			document.getElementById('payid').style.display = 'block';
			document.getElementById('realpayid').style.display = 'none';
		}
		person1.style.backgroundColor = 'white';
		person2.style.backgroundColor = 'gray';
		pcheck.value = 2;
	}
}
</script>
</html>