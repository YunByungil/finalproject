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
				<th>상품번호</th>
				<th>상품이미지</th>
				<th>상품명</th>
				<th>가격</th>
				<th>카테고리</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td colspan="4" align="center">
				${adminStorePageStr }
				</td>
			</tr>
		</tfoot>
		<tbody>
		<c:if test="${empty adminStoreList }">
			<tr>
				<td colspan="5" align="center">
					등록된 상품이 없습니다.
				</td>
			</tr>
		</c:if>
		<c:forEach var="dto" items="${adminStoreList }">
			<tr>
				<td>${dto.pro_idx }</td>
				<td><img src="/movieJoa/img/joaStore_img/${dto.pro_filename }" width="200" height="200"></td>
				<c:url var="contentUrl" value="adminStoreContent.do">
					<c:param name="idx">${dto.pro_idx }</c:param>
				</c:url>
				<td><a href="${contentUrl}">${dto.pro_name }</a></td>
				<td>${dto.pro_price }</td>
				<td>${dto.pro_category }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>