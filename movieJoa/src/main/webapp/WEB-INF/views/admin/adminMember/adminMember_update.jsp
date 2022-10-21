<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<style>
table.type02 {
  border-collapse: separate;
  border-spacing: 0;
  text-align: left;
  line-height: 1.5;
  border-top: 1px solid #ccc;
  border-left: 1px solid #ccc;
  margin : 20px 10px;
}
table.type02 th {
  width: 150px;
  padding: 10px;
  font-weight: bold;
  vertical-align: top;
  border-right: 1px solid #ccc;
  border-bottom: 1px solid #ccc;
  border-top: 1px solid #fff;
  border-left: 1px solid #fff;
  background: #eee;
}
table.type02 td {
  width: 350px;
  padding: 10px;
  vertical-align: top;
  border-right: 1px solid #ccc;
  border-bottom: 1px solid #ccc;
}
</style>
<script>
function adminBack(){
	location.href='adminMember.do';
}
function adminDelete(id){
	location.href='adminMemberDelete.do?id='+id;
}
</script>
</head>
<body>
<c:import url="/WEB-INF/views/header_admin.jsp"></c:import>
<section>
	<article>
		<form action="adminMemberUpdateConfirm.do">
		<table class="type02">
  			<tr>
    			<th scope="row">ID</th>
    			<td>${dto.mem_id }</td>
 			</tr>
 			<tr>
    			<th scope="row">비밀번호</th>
   			 	<td><input type="password" value="${dto.mem_pwd }" readonly></td>
 			 </tr>

  			<tr>
   				 <th scope="row">이름</th>
   				 <td><input type="text" value="${dto.mem_name }" name="mem_name"></td>
 			 </tr>
 			 <tr>
    			<th scope="row">생년월일</th>
   			 	<td><input type="text" value="${dto.mem_age }" name="mem_age"></td>
 			 </tr>
 			 <tr>
    			<th scope="row">핸드폰</th>
   			 	<td><input type="text" value="${dto.mem_tel }" name="mem_tel"></td>
 			 </tr>
 			 <tr>
    			<th scope="row">이메일</th>
   			 	<td><input type="text" value="${dto.mem_email }" name="mem_email"></td>
 			 </tr>
 			 <tr>
    			<th scope="row">등급</th>
   			 	<td>${dto.mem_grade }</td>
 			 </tr> 
		</table>
		<input type="hidden" value="${dto.mem_id }" name="mem_id">
		<input type="submit" value="수정하기"><input type="button" value="탈퇴" onclick="adminDelete('${dto.mem_id}')"><input type="button" value="뒤로가기" onclick="adminBack()">
		</form>
	</article>
</section>
<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</body>
</html>