<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관람평 상세 정보</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie_detail.css">
<script>
function deleteReview(didx){
	   var delQue = window.confirm('삭제한 관람평 정보는 복구할 수 없습니다. 정말 삭제하시겠습니까?');
	   	if(!delQue){ return; } 
	   window.location.href = 'deleteReview.do?rev_idx='+didx;
	}
</script>
</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<c:if test="${empty dto}">
			<div>이미 삭제된 게시글이거나 잘못된 접근입니다.</div>
</c:if>
<div class="mainBox">
<div class="div_title"><h2 class="title">| 관람평 관리 / 관람평 상세 정보</h2></div>

<div class="table_box">
<table class="main_table_detail">
<tr>
	<th class="th_basic">리뷰 코드</th>
	<td class="td_basic"> ${dto.rev_idx } </td>
</tr>
<tr>
	<th class="th_basic">영화 제목</th>
	<td colspan="3" class="td_basic"> ${dto.rev_movie_title } </td>
</tr>
<tr>
	<th class="th_basic">관람평</th>
	<td class="td_basic"> ${dto.rev_comment } </td>
</tr>
<tr>
	<th class="th_basic">평점</th>
	<td class="td_basic"> ${dto.rev_score } </td>
</tr>
<tr>
	<th class="th_basic">작성일</th>
	<td class="td_basic"> ${dto.rev_date }</td>
</tr>
<tr>
	<th class="th_basic">추천수</th>
	<td class="td_basic"> ${dto.rev_like } </td>
</tr>
</table>
</div>
</div>
<c:url var="didx" value="deleteReview.do">
</c:url>
<div class="btn_wrap">
<input type="button" value="영화 삭제" class="button_main" onclick="javascript:deleteReview(${dto.rev_idx });">
<div class="bottom_div">
<a href="#" class="fl_r"> 목록으로 </a>
</div>
</div>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>