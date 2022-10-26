<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시스템 이벤트 목록</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie_list.css">
<script type="text/javascript" src="httpRequest.js"> </script>
<script>
function show(eidx){
	var btnValue=document.getElementById('btn').value;
	var param='btnValue='+btnValue+'&eidx='+eidx;
	console.log('mememe');
	window.location.href = 'switchEvent.do?'+param;
	
}
function goEvent(){
	window.location.href = 'listEvent.do';
}
</script>
</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<div class="mainBox">
<div class="div_title"><h2 class="title">| 이벤트 관리 / 시스템 이벤트 목록 <input type="button" value="이벤트 관리" onclick="javascript:goEvent();" class="list_s_btn up"></h2></div>
<div class="table_wrap_list">
<table class="main_table_list">
<colgroup>
	<col style="width:13%">
	<col style="wldth:18%">
	<col style="width:27%">
	<col style="width:23%">
	<col style="width:18%">
</colgroup>
<thead>
<tr>
	<th scope="col" class="text_c">코드</th>
	<th scope="col" class="text_c">유형</th>
	<th scope="col" class="text_c">제목</th>
	<th scope="col" class="text_c">이벤트 기간</th>
	<th scope="col" class="text_c">관리 메뉴</th>
</tr>
</thead>
<tbody>
	<c:url var="detail" value="detailEvent.do">
			<c:param name="eve_idx">111</c:param>
	</c:url>
	<tr>
		<td class="text_c">111</td>
		<td class="text_c">즉시발급형</td>
		<td class="text_c">신규 고객 감사 할인 쿠폰 증정 이벤트</td>
		<td class="text_c">2022.10.22<br>- 2022.12.31</td>
		<td class="text_c"  id="btnTd"><input type="button" id="btn" value="${firstStatus }" onclick="javascript:show(111);" class="list_s_btn"></td>
	</tr>
	<tr>
		<td class="text_c">222</td>
		<td class="text_c">응모형</td>
		<td class="text_c">MJOA 랜덤 선물 응모 이벤트</td>
		<td class="text_c">2022.10.15<br>- 2022.12.25</td>
		<td class="text_c"  id="btnTd"><input type="button" id="btn" value="${secondStatus }" onclick="javascript:show(222);" class="list_s_btn"></td>
	</tr>
	<tr>
		<td class="text_c">333</td>
		<td class="text_c">응모형</td>
		<td class="text_c">401호의 탐정 개봉 기념 시사회 응모 이벤트</td>
		<td class="text_c">2022.10.01<br>- 2022.12.15</td>
		<td class="text_c"  id="btnTd"><input type="button" id="btn" value="${thirdStatus }" onclick="javascript:show(333);" class="list_s_btn"></td>
	</tr>
</tbody>

<tfoot>
	<tr>
	<td colspan="4" align="center">
	</td>
	<td colspan="2"><a href="addEventForm.do">새 이벤트 등록</a></td>
	</tr>
</tfoot>
</table>
</div>
</div>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>