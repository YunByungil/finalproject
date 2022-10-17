<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function drawStar(target){
	window.alert(target.value*0.1);
}
</script>
</head>
<body>
<input type="range" oninput="drawStar(this)" value="1" step="1" min="0" max="10">
</body>
</html>