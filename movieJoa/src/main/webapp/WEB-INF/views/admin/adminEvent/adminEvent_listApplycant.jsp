<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>응모 회원 조회</title>
<link rel="stylesheet" type="text/css" href="css/main_admin.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie.css">
<link rel="stylesheet" type="text/css" href="css/adminMovie_list.css">
<script>
function deleteApplycant(didx){
	   var delQue = window.confirm('삭제한 정보는 복구할 수 없습니다. 정말 삭제하시겠습니까?');
	   	if(!delQue){ return; } 
	   window.location.href = 'deleteApplycant.do?app_idx='+didx;
	}
</script>
</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<div class="mainBox">
<div class="div_title"><h2 class="title">| 이벤트 관리 / 응모 회원 조회</h2></div>
<div class="table_wrap_list">
<fieldset class="search_wrap">
	<form>
		<select name="sc_t">
			<option value="아이디" selected>아이디</option>
			<option value="이벤트명">이벤트명</option>
		</select>
		<input type="text" name="sc_k" class="input_text_search" placeholder="검색어를 입력해주세요.">
		<button type="submit" class="button_main">검색</button>
	</form>
</fieldset>
<table class="main_table_list">
<colgroup>
	<col style="width:10%">
	<col style="wldth:16%">
	<col style="width:24%">
	<col style="width:20%">
	<col style="width:15%">
	<col style="width:15%">
</colgroup>
<thead>
<tr>
	<th scope="col" class="text_c">코드</th>
	<th scope="col" class="text_c">이벤트 코드</th>
	<th scope="col" class="text_c">이벤트명</th>
	<th scope="col" class="text_c">회원아이디</th>
	<th scope="col" class="text_c">참여일자</th>
	<th scope="col" class="text_c">관리 메뉴</th>
</tr>
</thead>

	<c:if test="${empty applyMember}">
		<tr>
			<td colspan="6">등록되어있는 정보가 존재하지 않습니다.</td>
		</tr>
	</c:if>
<tbody>
	<c:forEach var="dto" items="${applyMember }">
	<tr>
		<td class="text_c">${dto.app_idx }</td>
		<td class="text_c">${dto.app_event_code }</td>
		<td class="text_c">${dto.app_event_subject }</td>
		<td class="text_c">${dto.app_member_id }</td>
		<td class="text_c">${dto.app_apply_date }</td>
		<td class="text_c">
		  <input type="button" value="삭제" onclick="javascript:deleteApplycant(${dto.app_idx });" class="list_s_btn">
		  </td>
	</tr>
	</c:forEach>
</tbody>

<tfoot>
	<tr>
	<td colspan="6" align="center">
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