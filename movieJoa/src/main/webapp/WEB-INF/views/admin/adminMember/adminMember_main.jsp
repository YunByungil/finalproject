<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<style>
.wrapper{
	display:grid;
}
</style>
</head>
<body>
<c:import url="/WEB-INF/views/header_admin.jsp"></c:import>
<c:import url="/WEB-INF/views/admin/adminMember/adminMember_sideBar.jsp"></c:import>
<div class="wrapper">
	<div>
		<div>1</div>
		<div>2</div>
		<div>3</div>
	</div>
	<div>
		<div>4</div>
		<div>5</div>
		<div>6</div>
	</div>
</div>
<span>총회원수</span><span>${memberAllCount }</span><span>오늘가입한 회원 수</span><span>${currentMemberJoin }</span><span>등록된 관리자 수</span><span>${adminAllCount }</span>
<span>남자회원수</span><span>${memberGenderCount }</span><span>여자회원수</span><span>${memberAllCount-memberGenderCount }</span>
<span>${memberAgeCount[4] }</span>
</body>
</html>