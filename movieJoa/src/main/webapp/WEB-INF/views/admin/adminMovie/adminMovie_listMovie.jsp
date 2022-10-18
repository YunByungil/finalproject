<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록된 영화 목록</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie_list.css">
<script>
function deleteMovie(didx){
	   var delQue = window.confirm('삭제한 영화정보는 복구할 수 없습니다. 정말 삭제하시겠습니까?');
	   	if(!delQue){ return; } 
	   window.location.href = 'deleteMovie.do?mov_idx='+didx;
	}
</script>
</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<div class="mainBox">
<div class="div_title"><h2 class="title">| 영화 관리 / 영화 목록</h2></div>
<div class="table_wrap_list">
<fieldset class="search_wrap">
	<form>
		<select name="sc_t">
			<option value="제목" selected>제목</option>
			<option value="코드">코드</option>
			<option value="감독명">감독명</option>
		</select>
		<input type="text" name="sc_k" class="input_text_search" placeholder="검색어를 입력해주세요.">
		<button type="submit" class="button_main">검색</button>
	</form>
</fieldset>
<table class="main_table_list">
<colgroup>
	<col style="width:12%">
	<col style="wldth:14%">
	<col style="width:24%">
	<col style="width:19%">
	<col style="width:16%">
	<col style="width:16%">
</colgroup>
<thead>
<tr>
	<th scope="col" class="text_c">영화 코드</th>
	<th scope="col" class="text_c">포스터</th>
	<th scope="col" class="text_c">제목</th>
	<th scope="col" class="text_c">감독명</th>
	<th scope="col" class="text_c">개봉일</th>
	<th scope="col" class="text_c">관리 메뉴</th>
</tr>
</thead>

	<c:if test="${empty movieList}">
		<tr>
			<td>등록되어있는 영화가 존재하지 않습니다.</td>
		</tr>
	</c:if>

<tbody>
<c:forEach var="dto" items="${movieList }">
<c:url var="detail" value="detailMovie.do">
		<c:param name="mov_idx">${dto.mov_idx }</c:param>
</c:url>
<tr>
	<td class="text_c">${dto.mov_idx }</td>
	<td class="text_c"><a href="${detail}"><img src="/movieJoa/img/movie_poster/${dto.mov_poster }" class="thumb_img"></a></td>
	<td class="text_c"><a href="${detail}">${dto.mov_title }</a></td>
	<td class="text_c">${dto.mov_director }</td>
	<td class="text_c">${dto.mov_start_date }</td>
	<c:url var="uLink" value="updateMovieForm.do">
		<c:param name="mov_idx">${dto.mov_idx }</c:param>
	</c:url>
	<td class="text_c"><input type="button" value="수정" onclick="location.href='${uLink}'" class="list_s_btn up"><br>
					   <input type="button" value="삭제" onclick="javascript:deleteMovie(${dto.mov_idx });" class="list_s_btn"></td>
</tr>
</c:forEach>
</tbody>

<tfoot>
	<tr>
	<td colspan="5" align="center">
	${pageStr }
	</td>
	<td colspan="1"><a href="addMovieForm.do">새 영화 등록</a></td>
	</tr>
</tfoot>
</table>
</div>
</div>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>