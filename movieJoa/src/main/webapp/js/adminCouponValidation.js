function addCouponNumberCheck() {
	var dis_value = document.addCouponForm.cou_discount.value;
	var notnumber = /[^0-9]/;
	var newtext = "";
	
	if(notnumber.test(dis_value) && dis_value != ""){
		newtext = "숫자만 입력가능합니다.";
		document.getElementById("cd").focus();
		document.getElementById("ersp").innerHTML = newtext;
		return false;
	}else if(dis_value > 99999 && dis_value != ""){
		newtext = "99999 이하의 숫자만 가능합니다.";
		document.getElementById("cd").focus();
		document.getElementById("ersp").innerHTML = newtext;
		return false;
	}else if(dis_value == ""){
		newtext = "";
		document.getElementById("ersp").innerHTML = newtext;
	}
}
function addCouponSubmitCheck() {
	var rv = addCouponNumberCheck();
	if(rv == false){
		return false;
	}else{
		return true;
	}
}