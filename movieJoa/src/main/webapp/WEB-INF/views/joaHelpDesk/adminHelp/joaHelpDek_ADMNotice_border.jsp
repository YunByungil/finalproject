<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/main.css?ver=12">
<link rel="stylesheet" type="text/css" href="css/joaHelpDesk.css?ver=12">
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<c:import url="../../header.jsp"></c:import>
<br>
<section>
<div class="helpDesk_main">
<div class="manyHelpMain">
	<h4 class="manyHelpSubject">공지게시판</h4> 
	<div class="manyHelpIntroduce">공지게시판 본문 글입니다.<br>
	관리자들을 문제 발견 시 최고 관리자에게 보고바랍니다.</div>
	<br>
	
	<div class="manyHelpbutton">
	<input type="button" value="수정" class="updatebutton" onclick="location.href='reNoticeWriteMove.do?idx=${dto.ntc_idx}'">
	</div>
	<div class="manyHelpbutton">
	<input type="button" value="삭제" class="deletebutton" onclick="location.href='noticeDelete.do?idx=${dto.ntc_idx}'">
	</div>
	
	<br>
	<div class="box">

	</div>
	<br>
	
</div>
	<div class="manyBorderHelpContent">
	
		<table class="manyHelpBorderW">
			<tr>
				<td colspan="3"><hr></td>
			</tr>
			<tr class="borderhead">
			<td class="bordertype">${dto.ntc_type }</td>
			<td class="bordersubject">${dto.ntc_subject }</td>
			<td class="readnum">${dto.ntc_readnum }</td>
			</tr>
			<tr>
			<td colspan="3"><br></td>
			</tr>
			<tr>
			<td colspan="3" class="bordercontent">${dto.ntc_content }</td>
			</tr>
			<tr>
			<td colspan="3"><hr><br></td>
			</tr>
			<tr>
				<td colspan="3" align="right"><input type="button" value="목차" class="bordersubmit" onclick="location.href='adminNotice.do'"></td>
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
		<a href="topAdmin.do" class="HM_bar_a"><li class="HM_bar">지점관리자 답변내역</li></a>
	</ul>
</div>
</section>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>