<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<table width="550" border="1" cellspacing="0">
	<thead>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>작성날짜</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tfoot>
		<tr>
			<td colspan="4" align="center">${pageStr }</td>
			<td><a href="bbsWrite.do">글쓰기</a></td>
		</tr>
	</tfoot>
	<tbody>
		<c:if test="${empty list }">
		<tr>
			<td colspan="5" align="center">등록된 게시글이 없습니다.</td>
		</tr>
		</c:if>
		<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.sch_mov_title }</td>
			<td>${dto.sch_start_hour }</td>
			<td>${dto.sch_end_hour }</td>
			<td>${dto.sch_theater }</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>