<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/main.css?ver=2">
<link rel="stylesheet" type="text/css" href="css/joaHelpMember.css?ver=2">
<meta charset="UTF-8">
<title>Insert title here</title>


<script>

	function categoryChange(e) {
	  var seoul = ['전체선택','강남/역삼/삼성', '신사/청담/압구정', '서초/교대/사당', '잠실/송파/강동',
          '을지로/명동/중구', '서울역/이태원/용산', '종로/인사동','홍대/합정/마포/서대문',
          '영등포역', '구로/신도림/금천'];
	  var incheon = ['전체선택','송도/소래포구', '인천국제공항/강화/을왕리/영종'];
	  var gyeonggi = ['전체선택','가평/청평/양평', '수원/화성', '고양/파주/김포', '의정부/포천/동두천'];
	  var gangwon = ['전체선택','속초/양양/고성', '춘천/인제/철원', '강릉', '평창/정선/영월'];
	  var select = ['영화관선택','영화관선택'];
	  var target = document.getElementById("cinema");
	 
	  if(e.value == "서울") var d = seoul;
	  else if(e.value == "인천") var d = incheon;
	  else if(e.value == "경기") var d = gyeonggi;
	  else if(e.value == "강원") var d = gangwon;
	  else if(e.value == "온라인") var d = select;
	 
	  target.options.length = 0;
	 
	  for (x in d) {
	    var opt = document.createElement("option");
	  
		   	opt.value = d[x];
		    opt.innerHTML = d[x];
		    target.appendChild(opt);
	  
	}
	  target.children[0].setAttribute("value","");
}
</script>
</head>
<body>
<c:import url="../../header.jsp"></c:import>
<br>
<section>
<div class="memberhelpDesk_main">
<div class="memberHelpMain">
	<h4 class="memberHelpSubject">1:1 문의</h4>
	<div class="memberHelpIntroduce">회원님들께서 작성해주신 문의 사항입니다.<br>
	관리자들을 최대한 신속하게 답변바랍니다.</div>
	<br>
	<form name="memberSerchFM" action="adminSerchList.do">
	<div class="memberHelpSerch">
	<select id="type" name="hqt_type" class="selectbar">
			<option selected disabled>구분선택</option>
			<option value="편의">편의</option>
		  	<option value="결제">결제</option>
		  	<option value="이벤트">이벤트</option>
		  	<option value="분실">분실</option>
		  	<option value="서비스">서비스</option>
	</select>
	<select id="region" onchange="categoryChange(this)" name="hqt_region" class="selectbar">
			<option selected disabled>지역선택</option>
			<option value="서울">서울</option>
		  	<option value="경기">경기</option>
		  	<option value="인천">인천</option>
		  	<option value="강원">강원</option>
		</select>
		&nbsp;
		<select id="cinema" name="hqt_cinema" class="selectbar">
		<option selected disabled>영화관선택</option>
		
		</select>
	<input class="memberButton" type="submit" value="검색하기"></div>
	</form>
	<br>
	<div class="box">
		<ul class="memberHelpSerchBarFeild">
			<li class="menuli"><a style="${backA_color}"class="a" href="memberHelp.do">전체</a></li>
			<li class="menuli"><a style="${backB_color}"class="a" href="adminQuestionType.do?hqt_type=편의" onclick="addType1()">편의</a></li>
			<li class="menuli"><a style="${backC_color}"class="a" href="adminQuestionType.do?hqt_type=결제"  onclick="addType2()">결제</a></li>
			<li class="menuli"><a style="${backD_color}"class="a" href="adminQuestionType.do?hqt_type=이벤트" onclick="addType3()">이벤트</a></li>
			<li class="menuli"><a style="${backE_color}"class="a" href="adminQuestionType.do?hqt_type=분실" onclick="addType4()">분실</a></li>
			<li class="menuli"><a style="${backF_color}"class="a" href="adminQuestionType.do?hqt_type=서비스" onclick="addType5()">서비스</a></li>
		</ul>
	</div>
	</div>
	<div class="memberHelpContent">
	<div>
		<table class="memberHelpBorder">
			<thead>
				<tr>
					<th class="td_type">구분</th>
					<th class="td_subjectCL">제목</th>
					<th class="td_region">지역</th>
					<th class="td_cinema">영화관</th>
				</tr>
			</thead>
			<tbody>
			<c:if test="${empty list }">
				<tr>
					<td colspan="4" align="center">등록된 게시글이 없습니다.</td>
				</tr>
			</c:if>
		<c:forEach var="dto" items="${list }">
			
			
			<c:url var="memberHelpUrl" value="memberHelpBorder.do">
					<c:param name="idx">
					${dto.hqt_idx }
					</c:param>
				</c:url>
			<tr>
				<td class="td_type">${dto.hqt_type }</td>
				<td class="td_subjectCL"><a href="${memberHelpUrl }">${dto.hqt_subject }</a></td>
				<td class="td_region">${dto.hqt_region }</td>
				<td class="td_cinema">${dto.hqt_cinema }</td>
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
	<ul class="helpMenu_member">
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