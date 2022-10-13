<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">

</head>
<body>
<c:import url="../header.jsp"></c:import>
<h1>로그인</h1>
<section>
	<article>
		<form action="memberLoginSubmit.do">
			<table>
				<tr>
					<th>ID</th>
					<td><input type="text" name="mem_id"></td> 
				</tr>
				<tr>
					<th>password</th>
					<td><input type="password" name="mem_pwd"></td>
				</tr>
				<tr>
					<td><a href="memberJoin.do">회원가입</a></td>
					<td>ID/비밀번호찾기</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="로그인"></td>
				</tr>
			</table>
		</form>
	</article>
</section>
<c:import url="../footer.jsp"></c:import>
</body>
</html>