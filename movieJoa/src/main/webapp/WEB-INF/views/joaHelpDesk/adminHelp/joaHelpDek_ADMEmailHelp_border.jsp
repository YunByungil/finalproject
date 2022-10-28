<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/main_admin.css?ver=16">
<link rel="stylesheet" type="text/css" href="css/joaHelpDesk.css?ver=16">
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<br>
<section>
<form name="emailAnswerFM" action="answerEmailHelp.do">
<div class="helpDesk_main">
<div class="manyHelpMain">
	<h4 class="manyHelpSubject">이메일문의 - 문의사항</h4> 
	<div class="manyHelpIntroduce">이메일문의 문의사항 글입니다.<br>
	관리자들을 성심 성의껏 고객님의 이메일로 답변 후 답변완료 버튼을 눌러주시길 바랍니다.</div>
	<br>
	
	<div class="manyHelpbutton">
	<input type="submit" value="답변완료" class="updatebutton">
	</div>
	<br>
	<div class="box">

	</div>
	<br>
	
</div>
	<div class="manyBorderHelpContent">
	
		<table class="manyHelpBorderW">
			<tr>
				<td colspan="3"><hr>
				<input type="hidden" name="hqt_idx" value="${dto.hqt_idx }">
				<input type="hidden" name="hqt_answerwrite" value="testAdmin">
				<input type="hidden" name="hqt_answerrank" value="testAdminRank">
				<input type="hidden" name="hqt_answercontent" value="이메일답변입니다.">
				</td>
			</tr>
			<tr>
				<td class="bordertype">지역 : ${dto.hqt_region }</td>
			<td class="bordersubject">영화관 : ${dto.hqt_cinema }</td>
			<td class="readnum">등록일 : ${dto.hqt_writedate }</td>
			</tr>
			<tr class="borderhead">
				<td class="bordertype">${dto.hqt_type }</td>
				<td class="bordersubject">${dto.hqt_subject }</td>
				<td class="readnum">${dto.hqt_email }</td>
			</tr>
			<tr>
			<td colspan="3"><br></td>
			</tr>
			<tr>
			<td colspan="3" class="bordercontent">${dto.hqt_content }</td>
			</tr>
			<tr>
			<td colspan="3"><hr><br></td>
			</tr>
			<tr>
				<td colspan="3" align="right"><input type="button" value="목차" class="bordersubmit" onclick="location.href='adminEmailHelp.do'"></td>
			</tr>
			<tr>
			<td><br></td>
			</tr>
		</table>
		
	</div>
	<ul class="helpMenu">
	<a href="adminHelpDesk.do" class="HM_bar_a"><li class="HM_bar">자주찾는 질문</li></a>
		<a href="adminNotice.do" class="HM_bar_a"><li class="HM_bar">공지게시판</li></a>
		<a href="adminEmailHelp.do" class="HM_bar_a"><li class="HM_bar">이메일문의</li></a>
		<a href="memberHelp.do" class="HM_bar_a"><li class="HM_bar">1:1문의</li></a>
		<c:if test="${sid eq 'admin_master' }">
		<a href="topAdmin_answer.do" class="HM_bar_a"><li class="HM_bar">지점관리자 답변내역</li></a>
		</c:if>
	</ul>
</div>
</form>
</section>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>