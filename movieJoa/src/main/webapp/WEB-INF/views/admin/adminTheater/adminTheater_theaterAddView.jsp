<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
</head>
<body>
<div id="seat"></div>
<table border="1" cellspacing="0">
	<thead>
		<tr>
			<c:forEach var="cols" begin="0" end="${width }" step="1">
				<c:if test="${cols!=0 }">
					<th width="50px" height="50px">${cols }</th>
				</c:if>
				<c:if test="${cols==0 }">
					<th width="50px" height="50px">구분</th>
				</c:if>
			</c:forEach>
		</tr>
	</thead>
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
							<td width="50px" height="50px" onclick="movieSeat('${seats[i][j-1] }');"></td>
						</c:if>
						<c:if test="${fn:substring(seats[i][j-1],seats[i][j-1].length()-1,seats[i][j-1].length())=='N' }">
							<td width="50px" bgcolor="red" height="50px" onclick="movieSeat('${seats[i][j-1] }');"></td>
						</c:if>
					</c:if>
				</c:forEach>
			</tr>
		</c:forEach>
	</c:if>
	</tbody>
</table>
<input type="button" value="상영관 등록" onclick="theaterAddSubmit();">
</body>
<script>
function movieSeat(seat) {
	var choice_seat=seat.toString();
	var seats_s='';
	<c:forEach var='i' begin='0' end='${height-1 }' step='1'>
		<c:forEach var='j' begin='0' end='${width-1 }' step='1'>
			seats_s=seats_s+'${seats[i][j]},';
		</c:forEach>
	</c:forEach>
	$.ajax({
		url: "theaterAdd.do?choice_seat="+choice_seat+"&width="+${width}+"&height="+${height}+"&seats_s="+seats_s+"&theater="+$('#theater').val(),
		type: "get",
		dataType: "html",
		success: function(data) {
			$('#seat').html(data);
		},
		error: function(){
			alert('다시 시도 바람');
		}
	});
};

function theaterAddSubmit() {
	var seats_s='';
	<c:forEach var='i' begin='0' end='${height-1 }' step='1'>
		<c:forEach var='j' begin='0' end='${width-1 }' step='1'>
			seats_s=seats_s+'${seats[i][j]},';
		</c:forEach>
	</c:forEach>
	$.ajax({
		url: "theaterAddSubmit.do?seats_s="+seats_s+"&theater="+$('#theater').val()+"&width="+${width}+"&height="+${height},
		type: "get",
		dataType: "html",
		success: function(data) {
			$('#seat').html(data);
		},
		error: function(){
			alert('다시 시도 바람');
		}
	});
};
</script>
</html>