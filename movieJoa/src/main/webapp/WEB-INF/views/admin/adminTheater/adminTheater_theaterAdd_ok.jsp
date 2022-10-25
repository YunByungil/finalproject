<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty check }">
	<script>
	window.alert('${msg}');
	location.href='theaterList.do';
	</script>
</c:if>
<c:if test="${not empty check }">
	<script>
	window.alert('${msg}');
	</script>
</c:if>

