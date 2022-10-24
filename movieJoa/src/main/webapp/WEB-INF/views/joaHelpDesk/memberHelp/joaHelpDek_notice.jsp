<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css?ver=7">
<link rel="stylesheet" type="text/css" href="css/joaHelpDesk.css?ver=7">
</head>
<body>
<c:import url="../../header.jsp"></c:import>
<br>
<section>
<div class="helpDesk_main">
<div class="manyHelpMain">
	<h4 class="NoticeMainSubject">공지사항</h4>
	<div class="manyHelpIntroduce">주요한 이슈 및 여러가지 소식들을<br>
	확인하실 수 있습니다.</div>
	<br>
	<form name="NoticeSerchFM" action="serchNotice.do">
	<div class="manyHelpSerch"><input class="serchbar" type="text" name="keyword">&nbsp;<input class="button" type="submit" value="검색하기"></div>
	</form>
	<br>
	<div class="box">
		<ul class="manyHelpSerchBarFeild">
			<li class="menuli"><a style="${backA_color}"class="a" href="notice.do">전체</a></li>
			<li class="menuli"><a style="${backB_color}"class="a" href="noticeType.do?type=시스템점검">시스템점검</a></li>
			<li class="menuli"><a style="${backC_color}"class="a" href="noticeType.do?type=극장">극장</a></li>
			<li class="menuli"><a style="${backD_color}"class="a" href="noticeType.do?type=기타">기타</a></li>
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
			<c:url var="noticeUrlCL" value="noticeBorder.do">
					<c:param name="idx">
					${dto.ntc_idx }
					</c:param>
			</c:url>
			
			<tr>
				<td class="manyHelpBordertype">${dto.ntc_type }</td><td><a href="${noticeUrlCL }">${dto.ntc_subject }</a></td><td class="manyHelpBorderReadnum">${dto.ntc_readnum }</td>
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
		<li><a href="helpDesk.do">고객센터</a></li>
		<li><a href="manyHelp.do">자주찾는 질문</a></li>
		<li><a href="notice.do">공지게시판</a></li>
		<li><a href="emailHelp.do">이메일문의</a></li>
		<li><a href="oneByOneHelp.do">1:1문의</a></li>
	</ul>
	
</div>
</section>
<c:import url="../../footer.jsp"></c:import>
</body>
</html>