<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/main.css?ver=17">
<link rel="stylesheet" type="text/css" href="css/joaHelpDesk.css?ver=17">
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<c:import url="../../header.jsp"></c:import>
<br>
<section>
<div class="helpDesk_main_m">
<div class="manyHelpMain">
	<h4 class="manyHelpSubject">자주찾는 질문 - 게시글</h4> 
	<div class="manyHelpIntroduce">회원님들께서 가장 자주하시는 질문을 모았습니다.<br>
	궁금하신 내용에 대해 검색해보세요.</div>
	<br>
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
			<td class="bordertype">${dto.lfq_type }</td>
			<td class="bordersubject">${dto.lfq_subject }</td>
			<td class="readnum">${dto.lfq_readnum }</td>
			</tr>
			<tr>
			<td colspan="3"><br></td>
			</tr>
			<tr>
			<td colspan="3" class="bordercontent">${dto.lfq_content }</td>
			</tr>
			<tr>
			<td colspan="3"><hr><br></td>
			</tr>
			<tr>
				<td colspan="3" align="right"><input type="button" value="목차" class="bordersubmit" onclick="location.href='manyHelp.do'"></td>
			</tr>
			<tr>
			<td><br></td>
			</tr>
		</table>
		
	</div>
	
	<ul class="helpMenu">
		<a href="helpDesk.do" class="HM_bar_a"><li class="HM_bar">고객센터</li></a>
		<a href="manyHelp.do" class="HM_bar_a"><li class="HM_bar">자주찾는 질문</li></a>
		<a href="notice.do" class="HM_bar_a"><li class="HM_bar">공지게시판</li></a>
		<a href="emailHelp.do" class="HM_bar_a"><li class="HM_bar">이메일문의</li></a>
		<a href="oneByOneHelp.do" class="HM_bar_a"><li class="HM_bar">1:1문의</li></a>
	</ul>
</div>
</section>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>