<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/main.css?ver=14">
<link rel="stylesheet" type="text/css" href="css/joaHelpDesk.css?ver=14">
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<c:import url="../../header.jsp"></c:import>
<br>
<section>
<form name="ntc_WriteFM" action="reNoticeWrite.do">
<div class="helpDesk_main">
<div class="manyHelpMain">
	<h4 class="manyHelpSubject">자주찾는 질문 - 게시글 수정</h4> <div align="right"><input type="submit" value="수정완료" class="updatebutton"  ></div>
	<div class="manyHelpIntroduce">자주찾는 질문 게시판 수정페이지입니다.<br>
	최고 관리자께서는 전달된 양식에 맞게 작성해주시길 바랍니다.</div>
	<br>
	
	<div class="manyHelpSerch">
	</div>
	
	<br>
	<div class="box">
		<input type="hidden" name="ntc_idx" value="${dto.ntc_idx }">
	</div>
	<br>
	
</div>
	<div class="manyHelpWrite">
		<table align="center" class="manyHelpWriteFeild">
			<tr>
			<th>문의 유형</th>
			<td class="radio"><input type="radio" name="ntc_type" value="예매/매표">예매/매표</td>
			<td class="radio"><input type="radio" name="ntc_type" value="결제수단">결제수단</td>
			<td class="radio"><input type="radio" name="ntc_type" value="포인트/쿠폰">포인트/쿠폰</td>
			<td class="radio"><input type="radio" name="ntc_type" value="할인혜택">할인혜택</td>
			<td class="radio"><input type="radio" name="ntc_type" value="스토어샵">스토어샵</td>
			<td class="radio"><input type="radio" name="ntc_type" value="홈페이지">홈페이지</td>
			</tr>
			<tr>
			<td colspan="7"><hr></td>
			</tr>
			<tr>
			<th>제목</th>
			<td colspan="6"><input type="text" name="ntc_subject" id="lfq_subject" value="${dto.ntc_subject}"></td>
			</tr>
			<tr>
			<td colspan="7"><hr></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="6"><textarea rows="31" cols="76" name="ntc_content">${dto.ntc_content }</textarea></td>
			</tr>
			<tr>
			<td colspan="7"><hr><br></td>
			</tr>
			<tr>
			<td colspan="7" align="right"><input type="button" value="목차" class="bordersubmit" onclick="location.href='adminNotice.do'"></td>
			</tr>
		</table>
	</div>
	</form>
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