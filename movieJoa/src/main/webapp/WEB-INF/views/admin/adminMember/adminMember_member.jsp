<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<style>
body{
	text-align:center;
	margin:auto;
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
table {
  border-collapse: separate;
  border-spacing: 0;
  width: 80%;
  margin:auto;
}
th,
td {
  padding: 6px 15px;
}
th {
  background: #42444e;
  color: #fff;
}
tr:first-child th:first-child {
  border-top-left-radius: 6px;
}
tr:first-child th:last-child {
  border-top-right-radius: 6px;
}
td {
  border-right: 1px solid #c6c9cc;
  border-bottom: 1px solid #c6c9cc;
}
td:first-child {
  border-left: 1px solid #c6c9cc;
}
tr:nth-child(even) td {
  background: #eaeaed;
}
tr:last-child td:first-child {
  border-bottom-left-radius: 6px;
}
tr:last-child td:last-child {
  border-bottom-right-radius: 6px;
}
</style>
<script>
function searchInfo(){
	if(document.getElementById('mem_category').value=='mem_id'){
		document.getElementById('mem_search').setAttribute('name','mem_id');
	}else{
		document.getElementById('mem_search').setAttribute('name','mem_name');
	}
	document.getElementById('adminMemberSubmit').submit();
}
function adminMemberUpdate(id){
	location.href='adminMemberUpdate.do?id='+id;
}
</script>
</head>
<body>
<c:import url="/WEB-INF/views/header_admin.jsp"></c:import>
<h1>회원 검색</h1>
<form action="adminMemberSearch.do" id="adminMemberSubmit">
<div class="search_tag">
	<select id=mem_category>
		<option value="mem_id">ID</option>
		<option value="mem_name">이름</option>
	</select>
</div>
<div class="search" >
	<input type="text" placeholder="search.." id="mem_search" onkeypress="if(window.event.keyCode==13){searchInfo()}">
	<img src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png" onclick="searchInfo()">
</div>
</form>
<c:if test="${not empty list }">
<table>
	<thead>
		<tr>
			<th>고유번호</th>
			<th>ID</th>
			<th>이름</th>
			<th>성별</th>
			<th>등급</th>
			<th>가입날짜</th>
			<th>비고</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="dto" items="${list}" varStatus="status">
		<tr>
			<td>${dto.mem_idx }</td>
			<td>${dto.mem_id }</td>
			<td>${dto.mem_name }</td>
			<td>${dto.mem_gender }</td>
			<td>${dto.mem_grade }</td>
			<td>${dto.mem_joindate }</td>
			<td><input type="button" value="수정" onclick="adminMemberUpdate('${dto.mem_id}')"></td>
		</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="7" align="center">${pageStr }</td>
		</tr>
	</tfoot>
</table>
</c:if>
</body>
</html>