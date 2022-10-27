<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<style>
ul {
	list-style: none;
	padding-left: 0;
}

li {
	display: inline;
	list-style: none;
}


</style>
</head>
<body>
<div align="center">

<div>
<c:import url="../header.jsp"></c:import>
</div>

<form>
<h1>결제페이지</h1>

<div>
최종결제 수단
<ul>
<li>
<input type="radio" name="payMov_method" value="신용카드" checked>신용카드
<input type="radio" name="payMov_method" value="휴대폰 결제">휴대폰 결제
<input type="radio" name="payMov_method" value="간편결제">간편결제
<input type="radio" name="payMov_method" value="내통장결제">내통장결제
</li>
</ul>
</div>

<input type="hidden" name="payMov_the_idx" value="${idx }">
<input type="hidden" name="payMov_sch_seat" id="${seat }">
<input type="hidden" name="payMov_mem_id" value="dool">

<input type="hidden" name="payMov_price" value="${price }">
<input type="hidden" name="payMov_mov_title" value="${title }">
<input type="hidden" name="payMov_the_city" value="${city }">
<input type="hidden" name="payMov_the_branch" value="${branch }">
<input type="hidden" name="payMov_sch_day"  value="${day }">
<input type="hidden" name="payMov_sch_theater" value="${theater }">
<input type="hidden" name="payMov_sch_start_hour" value="${hour }">
<input type="hidden" name="payMov_sch_start_min" value="${min }">

<br><br><br><br><br><br><br><br><br>
<div align="center">

<div style="width: 25%; height: 25%; float: left;">
<span id="sub2"><img src="/movieJoa/img/theater/${title }.jpg" width="100px" height="100px"></span>
<span id="sub">${title }</span>
</div>

<div style="width: 25%; height: 25%; float: left;">
<span id="br">${branch }</span><br>
<span id="date">${day }</span><br>
<span id="to">${theater }관/${hour }:${min }</span>
</div>

<div style="width: 25%; height: 25%; float: left;">
<span id="s">좌석명 : ${seat }</span><br>
<span id="money">가격 : ${price }</span>
</div>

<div style="width: 25%; height: 25%; float: left;"><input type="submit" value="결제하기" style="color: red;" id="finalpay"></div>
<br><br><br><br><br><br><br><br><br>
<div>
<c:import url="../footer.jsp"></c:import>
</div>

</div>

</form>
</div>
</body>
</html>