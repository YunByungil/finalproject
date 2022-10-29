<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/main_admin.css?ver=3">
<link rel="stylesheet" type="text/css" href="css/joaHelpDesk.css?ver=3">
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<c:import url="../../header_admin.jsp"></c:import>
<br>
<section>
<div class="helpDesk_main">
<div class="manyHelpMain">
	<h4 class="manyHelpSubject">자주찾는 질문</h4> <div align="right"><c:if test="${sid eq 'admin_master' }"><input type="button" value="게시글 작성" class="writebutton" onclick="location.href='manyWrite.do'"></c:if></div>
	<div class="manyHelpIntroduce">회원님들께서 가장 자주하시는 질문을 모았습니다.<br>
	관리자들을 문제 발견 시 최고 관리자에게 보고바랍니다.</div>
	<br>
	<form name="manyHelpSerchFM" action="adminSerchManyHelp.do">
	<div class="manyHelpSerch"><input class="serchbar" type="text" name="keyword">&nbsp;<input class="button" type="submit" value="검색하기"></div>
	</form>
	<br>
	<div class="box">
		<ul class="manyHelpSerchBarFeild">
			<li class="menuli"><a style="${backA_color}"class="a" href="adminHelpDesk.do">전체</a></li>
			<li class="menuli"><a style="${backB_color}"class="a" href="adminManyHelp.do?type=예매/매표">예매/매표</a></li>
			<li class="menuli"><a style="${backC_color}"class="a" href="adminManyHelp.do?type=결제수단">결제수단</a></li>
			<li class="menuli"><a style="${backD_color}"class="a" href="adminManyHelp.do?type=포인트/쿠폰">포인트/쿠폰</a></li>
			<li class="menuli"><a style="${backE_color}"class="a" href="adminManyHelp.do?type=할인혜택">할인혜택</a></li>
			<li class="menuli"><a style="${backF_color}"class="a" href="adminManyHelp.do?type=스토어샵">스토어샵</a></li>
			<li class="menuli"><a style="${backG_color}"class="a" href="adminManyHelp.do?type=홈페이지">홈페이지</a></li>
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
				<c:url var="manyHelpUrl" value="adminManyHelpBorder.do">
					<c:param name="idx">
					${dto.lfq_idx }
					</c:param>
					
				</c:url>
				<tr>
					<td class="manyHelpBordertype">${dto.lfq_type }</td>
					<td class="borderurl"><a href="${manyHelpUrl }">${dto.lfq_subject }</a></td>
					<td class="manyHelpBorderReadnum">${dto.lfq_readnum }</td>
				</tr>
			</c:forEach>
			</tbody>
			<tfoot>
			<c:if test="${empty list }">
				<tr>
					<td colspan="3" align="center"></td>
				</tr>
			</c:if>	
			<tr>
			<td colspan="4" align="center" class="pageStr">
				${pageStr }
			</td>
			</tr>
			</tfoot>
		</table>
	</div>
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
</section>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>