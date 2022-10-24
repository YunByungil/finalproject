<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<c:import url="/WEB-INF/views/header_admin.jsp"></c:import>
매출관리확인용
<div>이번년도:${nowYear }/이번달:${nowMonth }</div>
<div>이번달 영화 매출:${nowMonthMovieRevenue }</div>
<div>이번달 상품 매출:${nowMonthProductRevenue }</div>
<div>이번달 총 매출:${nowMonthMovieRevenue+nowMonthProductRevenue }</div>
<div>나이대별 매출</div>
<div>이번달 관람객 수:${nowMonthSpectator }</div>
<div>성별 매출</div>	
</body>
</html>