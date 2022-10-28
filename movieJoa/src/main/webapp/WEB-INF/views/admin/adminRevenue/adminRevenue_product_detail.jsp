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
</head>
<body>
<c:import url="/WEB-INF/views/header_admin.jsp"></c:import>
<h1>상품 조회</h1>
<c:if test="${empty list }">
	<h2>조회 결과가 존재하지 않습니다.</h2>
</c:if>
<c:if test="${not empty list }">
<table>
	<thead>
		<tr>
			<th>고유번호</th>
			<th>ID</th>
			<th>상품이름</th>
			<th>금액</th>
			<th>결제날짜</th>
			<th>비고</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="dto" items="${list}" varStatus="status">
		<tr>
			<td>${dto.payPro_idx }</td>
			<td>${dto.payPro_mem_id }</td>
			<td>${dto.payPro_pro_name }</td>
			<td>${dto.payPro_total_price }</td>
			<td>${dto.payPro_date }</td>
			<td><input type="button" value="조회"></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</c:if>
</body>
</html>