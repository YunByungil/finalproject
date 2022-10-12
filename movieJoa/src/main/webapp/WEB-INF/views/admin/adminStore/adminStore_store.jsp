<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 상품관리</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie.css">
</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
	<table width="550" border="1" cellspacing="0">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td colspan="4" align="center">
				${pageStr }
				</td>
				<td><a href="bbsWrite.do">글쓰기</a></td>
			</tr>
		</tfoot>
		<tbody>
		<c:if test="${empty list }">
			<tr>
				<td colspan="5" align="center">
					등록된 상품이 없습니다.
				</td>
			</tr>
		</c:if>
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.idx }</td>
				<c:url var="contentUrl" value="bbsContent.do">
					<c:param name="idx">${dto.idx }</c:param>
				</c:url>
				<td><a href="${contentUrl}">${dto.subject }</a></td>
				<td>${dto.writer }</td>
				<td>${dto.writedate }</td>
				<td>${dto.readnum }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>