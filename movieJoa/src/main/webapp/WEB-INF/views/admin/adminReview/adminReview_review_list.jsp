<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관람평 현황</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link rel="stylesheet" type="text/css" href="css/adminCoupon.css">
<script>
function deleteReview(didx){
	   var delQue = window.confirm('삭제한 관람평 정보는 복구할 수 없습니다. 정말 삭제하시겠습니까?');
	   	if(!delQue){return;} 
	   window.location.href = 'deleteReview.do?rev_idx='+didx;
	}
</script>
</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<div class="mainBox">
<div class="div_title"><h2 class="title">| 관람평 관리 / 관람평 목록</h2></div>
<div class="table_wrap_list">
<fieldset class="search_wrap">
	<form action="searchReview.do">
		<select name="s_k">
			<option value="all" <c:if test="${s_k eq 'all'}">selected</c:if>>전체</option>
			<option value="rev_idx" <c:if test="${s_k eq 'rev_idx'}">selected</c:if>>리뷰코드</option>
			<option value="rev_movie_title" <c:if test="${s_k eq 'rev_movie_title'}">selected</c:if>>영화제목</option>
			<option value="rev_id" <c:if test="${s_k eq 'rev_id'}">selected</c:if>>작성자</option>
		</select>
		<input type="text" name="s_v" class="input_text_search" placeholder="검색어를 입력해주세요." <c:if test="${s_v ne '--'}">value="${s_v }"</c:if>>
		<button type="submit" class="button_main">검색</button>
	</form>
</fieldset>
<table class="main_table_list">
<colgroup>
	<col style="width:10%">
	<col style="wldth:15%">
	<col style="width:20%">
	<col style="width:10%">
	<col style="wldth:20%">
	<col style="width:15%">
	<col style="width:15%">
</colgroup>
<thead>
<tr>
	<th scope="col" class="text_c">리뷰코드</th>
	<th scope="col" class="text_c">작성자</th>
	<th scope="col" class="text_c">영화명</th>
	<th scope="col" class="text_c">평점</th>
	<th scope="col" class="text_c">작성일</th>
	<th scope="col" class="text_c">추천수</th>
	<th scope="col" class="text_c">관리</th>
</tr>
</thead>
	<c:if test="${empty reviewList}">
		<tr>
			<td colspan="6">등록되어있는 평점이 존재하지 않습니다.</td>
		</tr>
	</c:if>
<tbody>
<c:forEach var="dto" items="${reviewList }">
<tr>
	<td class="text_c">${dto.rev_idx }</td>
	<td class="text_c">${dto.rev_id }</td>
	<td class="text_c">${dto.rev_movie_title}</td>
	<td class="text_c">${dto.rev_score}</td>
	<td class="text_c">${dto.rev_date}</td>
	<td class="text_c">${dto.rev_like}</td>
	<c:url var="dLink" value="detailReview.do">
		<c:param name="rev_idx">${dto.rev_idx }</c:param>
	</c:url>
	<td class="text_c"><input type="button" value="상세" onclick="location.href='${dLink}'" class="list_s_btn up"><br>
					   <input type="button" value="삭제" onclick="javascript:deleteReview(${dto.rev_idx });" class="list_s_btn"></td>
	
</tr>
</c:forEach>



</tbody>

<tfoot>
	<tr>
	<td colspan="7" align="center">
	${pageStr }
	</td>
	</tr>
</tfoot>
</table>
</div>
</div>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>