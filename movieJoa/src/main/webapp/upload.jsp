<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>파일 업로드 테스트 폼</h1>
<form name="fileUpload2" action="addProduct.do" method="post" enctype="multipart/form-data">
<fieldset>
	<ul>
		<li>업로드할 파일:<input type="file" name="upload"></li>
	</ul>	
	<div>
		<input type="submit" value="파일 올리기">
	</div>	
</fieldset>
</form>
</body>
</html>