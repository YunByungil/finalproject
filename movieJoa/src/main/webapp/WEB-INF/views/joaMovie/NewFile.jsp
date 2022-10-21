<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/httpRequest.js"></script>
<script>
function show(){
	window.alert('인');
	sendRequest('getStudent.do',null,showResult,'GET');
}
function showResult(){
	window.alert('인2');
	if(XHR.readyState==4){
		if(XHR.status==200){
			var data=XHR.responseText;
			var jsonData=JSON.parse(data);
			
			var students=jsonData.students;
			var msg='총 학생수:'+students.length+'명\n'
			for(var i=0;i<students.length;i++){
				var student=students[i];
				msg+='이름:'+student.name+'('+student.age+'세)/주소:'+student.addr+'\n'
			}
			window.alert(msg);
		}
	}
}
</script>
</head>
<body>
<input type="button" value="학생정보확인" onclick="show()">
</body>
</html>