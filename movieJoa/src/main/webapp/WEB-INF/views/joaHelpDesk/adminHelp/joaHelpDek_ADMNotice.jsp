<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css?ver=4">
<link rel="stylesheet" type="text/css" href="css/joaHelpDesk.css?ver=4">
</head>
<body>
<c:import url="../../header.jsp"></c:import>
<br>
<section>
<div class="helpDesk_main">
<div class="manyHelpMain">
	<h4 class="NoticeMainSubject">공지사항</h4>
	<div align="right"><input type="button" value="게시글 작성" class="writebutton" onclick="location.href='noticeWriteMove.do'"></div>
	<div class="manyHelpIntroduce">공지게시판 입니다.<br>
	관리자들은 문제 발견 시 최고 관리자에게 보고바랍니다.</div>
	<br>
	<form name="NoticeSerchFM" action="serchAdminNotice.do">
	<div class="manyHelpSerch"><input class="serchbar" type="text" name="keyword">&nbsp;<input class="button" type="submit" value="검색하기"></div>
	</form>
	<br>
	<div class="box">
		<ul class="manyHelpSerchBarFeild">
			<li class="menuli"><a style="${backA_color}"class="a" href="adminNotice.do">전체</a></li>
			<li class="menuli"><a style="${backB_color}"class="a" href="noticeAdminType.do?type=시스템점검">시스템점검</a></li>
			<li class="menuli"><a style="${backC_color}"class="a" href="noticeAdminType.do?type=극장">극장</a></li>
			<li class="menuli"><a style="${backD_color}"class="a" href="noticeAdminType.do?type=기타">기타</a></li>
		</ul>
	</div>
	<br>
	
</div>
	<div class="manyHelpContent">
	<div>
		<table class="manyHelpBorder">
			<thead>
				<tr>
					<th class="manyHelpBordertype">구분</th>
					<th>제목</th>
					<th class="manyHelpBorderReadnum">조회수</th>
				</tr>
			</thead>
			<tbody>
			<c:if test="${empty list }">
				<tr>
					<td colspan="3" align="center">등록된 게시글이 없습니다.</td>
				</tr>
			</c:if>
		<c:forEach var="dto" items="${list }">
			<c:url var="noticeUrl" value="adminNoticeBorder.do">
					<c:param name="idx">
					${dto.ntc_idx }
					</c:param>
				</c:url>
			<tr>
				<td class="manyHelpBordertype">${dto.ntc_type }</td><td><a href="${noticeUrl }">${dto.ntc_subject }</a></td><td class="manyHelpBorderReadnum">${dto.ntc_readnum }</td>
			</tr>
		</c:forEach>
			</tbody>
			<tfoot>
			<tr>
			<td colspan="4" align="center">
				${pageStr }
			</td>
			</tr>
			</tfoot>
		</table>
	</div>
	</div>
	<ul class="helpMenu">
		<li><a href="adminHelpDesk.do">자주찾는 질문</a></li>
		<li><a href="adminNotice.do">공지게시판</a></li>
		<li><a href="adminEmailHelp.do">이메일문의</a></li>
		<li><a href="memberHelp.do">1:1문의</a></li>
		<li><a href="topAdmin.do">지점관리자 답변내역</a></li>
	</ul>
	
</div>
</section>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>