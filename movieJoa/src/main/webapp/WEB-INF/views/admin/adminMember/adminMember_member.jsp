<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<style>
body{
	text-align:center;
}
.search{
	position:relative;
	width:300px;
	text-align:center;
	margin:auto;
	display:inline;
}
input{
	
	border:1px solid #bbb;
	border-radius:8px;
	padding:10px 12px;
	font-size:14px;
}
img{
	position:absolute;
	width:17px;
	top:10px;
	right:12px;
}
.search_tag{
	width:70px;
	text-align:center;
	margin:auto;
	display:inline;
}
select{
	
	border:1px solid #bbb;
	border-radius:8px;
	padding:10px 12px;
	font-size:14px;
}
</style>
<script>
function searchInfo(){
	if(document.getElementById('mem_category')==mem_id){
		document.getElementById('mem_search').setAttribute('name','mem_id');
	}else{
		document.getElementById('mem_search').setAttribute('name','mem_name');
	}
	document.getElementById('adminMemberSubmit').submit();
}
</script>
</head>
<body>
<c:import url="/WEB-INF/views/header.jsp"></c:import>
<h1>회원 검색</h1>
<form action="adminMemberSearch.do" id="adminMemberSubmit">
<div class="search_tag">
	<select>
		<option value="mem_id">ID</option>
		<option value="mem_name">이름</option>
	</select>
</div>
<div class="search">
	<c:if test=""></c:if>
	<input type="text" placeholder="search..">
	<a onclick="searchInfo()"><img src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png"></a>
</div>
</form>
<c:forEach var="dto" items="${list}">
		<tr>
			<td>${dto.mem_id }</td>
			<td>${dto.mem_name }</td>
			<td>${dto.mem_pwd }</td>
			<td>${dto.mem_idx }</td>
		</tr>
	</c:forEach>
<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</body>
</html>