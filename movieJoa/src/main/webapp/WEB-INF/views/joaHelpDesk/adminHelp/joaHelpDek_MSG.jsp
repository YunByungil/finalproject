<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	window.alert('${msg}');
	setTimeout(function sleep(){
		if(${link_tf}){
			window.location.href='adminHelpDesk.do';
		}else{
			window.location.href='${link}';
		}
	}, 300);

</script>