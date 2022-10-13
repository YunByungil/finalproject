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
				<th>삭제</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td colspan="4" align="center">
				${pageStr }
				</td>
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
				<td>${dto.pro_idx }</td>
					<c:url var="adminStoreContentUrl" value="adminStoreContent.do">
						<c:param name="pro_idx">${dto.pro_idx }</c:param>
					</c:url>
				<td><a href="${adminStoreContentUrl}">${dto.pro_name }</a></td>
				<td>${dto.pro_price }</td>
				<td>${dto.pro_category }</td>
					<c:url var="adminStoreDeleteUrl" value="adminStoreDelete.do">
						<c:param name="pro_idx">${dto.pro_idx }</c:param>
					</c:url>
				<td><a href="${adminStoreDeleteUrl}"><input type="button" value="삭제"></a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>