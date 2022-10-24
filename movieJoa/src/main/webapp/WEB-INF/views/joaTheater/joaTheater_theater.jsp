<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="welcome('${sch_city}')">
<div>
<h1>극장 페이지</h1>

<div>
<ul>
<c:forEach var="dto" items="${testCity }" varStatus="c">
<li id="${dto }" class="">
<a href="javascript:checkCity('${dto }');">
${dto } 
&nbsp;
</a>
</li>
</c:forEach>
</ul>
</div>

<div id="1" style="display: block;">
<ul>
<c:forEach var="branch1" items="${branchList }">
<li id="${branch1.sch_branch }" class=""><a href="javascript:checkBranch('${branch1.sch_branch }')">${branch1.sch_branch }</a></li>
</c:forEach>
</ul>
</div>

<div id="2" style="display: none;">
하이염ㅋㅋ2번임
</div>

</div>
</body>
<script>
function welcome(city) {
	window.alert(city);
	window.alert('${sch_branch}');
	var classAdd = document.getElementById(city); // 서울지역 기본
	classAdd.classList.add('checkCitys'); // 서울 기본
	
	var classAdd = document.getElementById('${branch}'); // 강남 기본
	classAdd.classList.add('checkBranchs'); // 강남 기본
	
	
	
	document.getElementById('city').value = city;
	document.getElementById('branch').value = '${branch}';
	document.getElementById('yoil').value = '${yoil}';
	document.getElementById('1').style.display = 'block';
}
</script>
</html>