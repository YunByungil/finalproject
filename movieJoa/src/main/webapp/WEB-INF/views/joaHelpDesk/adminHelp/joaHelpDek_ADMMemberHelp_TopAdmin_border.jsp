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
<form name="reAnswerFM" action="reAnswerSet.do">
<div class="helpDesk_main">
<div class="manyHelpMain">
	<h4 class="manyHelpSubject">1:1문의 - 문의답변</h4> 
	<div class="manyHelpIntroduce">1:1 문의사항 본문내용입니다.<br>
	회원님들께서 작성해주신 문의 사항입니다.<br>
	최고관리자께서는 문의내용과 답변내용을 확인 가능합니다.</div>
	<br>
	
	<div class="manyHelpbutton">
	<input type="submit" value="재답변 요청" class="deletebutton">
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
				<input type="hidden" name="hqt_answerwrite" value="${dto.hqt_answerwrite }">
				<input type="hidden" name="hqt_answerrank" value="${dto.hqt_answerrank }">
				</td>
			</tr>
			<tr>
			<td class="bordertype">지역 : ${dto.hqt_region }</td>
			<td class="bordersubject">영화관 : ${dto.hqt_cinema }</td>
			<td class="readnumW">등록일 : ${dto.hqt_writedate }</td>
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
				<td colspan="4"><hr></td>
			</tr>
			<tr class="borderhead">
				<td class="id">관리자 ID : ${dto.hqt_answerwrite }</td>
				<td class="rank">직책 : ${dto.hqt_answerrank}</td>
				<td class="date">답변일 : ${dto.hqt_answerdate }
				<br>재답변일 : ${dto.hqt_reanswerdate }</td>
			</tr>
			<tr>
				<td colspan="3"><hr></td>
			</tr>
			<tr>
				<td colspan="3" class="bordercontent">${dto.hqt_answercontent }</td>
			</tr>
		</table>
		
		
	</div>
	
			
		
	<ul class="helpMenu">
		<a href="adminHelpDesk.do" class="HM_bar_a"><li class="HM_bar">자주찾는 질문</li></a>
		<a href="adminNotice.do" class="HM_bar_a"><li class="HM_bar">공지게시판</li></a>
		<a href="adminEmailHelp.do" class="HM_bar_a"><li class="HM_bar">이메일문의</li></a>
		<a href="memberHelp.do" class="HM_bar_a"><li class="HM_bar">1:1문의</li></a>
		<c:if test='${sid }.isEquas("admin_master")'>
		<a href="topAdmin_answer.do" class="HM_bar_a"><li class="HM_bar">지점관리자 답변내역</li></a>
		</c:if>
	</ul>
</div>
</form>
</section>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>