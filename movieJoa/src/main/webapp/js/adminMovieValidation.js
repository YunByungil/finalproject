function addMovieNumberCheck() {
	var run_value = document.addMovieForm.mov_running_time.value;
	var notnumber = /[^0-9]/;
	var newtext = "";
	
	if(notnumber.test(run_value) && run_value != ""){
		newtext = "숫자만 입력해주세요.";
		document.getElementById("mrt").focus();
		document.getElementById("ersp").innerHTML = newtext;
		return false;
	}else if(run_value > 999 && run_value != ""){
		newtext = "999 이하의 숫자만 가능합니다.";
		document.getElementById("mrt").focus();
		document.getElementById("ersp").innerHTML = newtext;
		return false;
	}else if(run_value == ""){
		newtext = "";
		document.getElementById("ersp").innerHTML = newtext;
	}
}
function updateMovieNumberCheck() {
	var run_value = document.updateMovieForm.mov_running_time.value;
	var notnumber = /[^0-9]/;
	var newtext = "";
	if(notnumber.test(run_value) && run_value != ""){
		newtext = "숫자만 입력해주세요.";
		document.getElementById("mrt").focus();
		document.getElementById("ersp").innerHTML = newtext;
		return false;
	}else if(run_value > 999 && run_value != ""){
		newtext = "999 이하의 숫자만 가능합니다.";
		document.getElementById("mrt").focus();
		document.getElementById("ersp").innerHTML = newtext;
		return false;
	}else if(run_value == ""){
		newtext = "";
		document.getElementById("ersp").innerHTML = newtext;
	}
}
function addMovieSubmitCheck(){
	var rv = addMovieNumberCheck();
	if(rv == false){
		return false;
	}else{
		return true;
	}
}
function updateMovieSubmitCheck(){
	var rv = updateMovieNumberCheck();
	if(rv == false){
		return false;
	}else{
		return true;
	}
}