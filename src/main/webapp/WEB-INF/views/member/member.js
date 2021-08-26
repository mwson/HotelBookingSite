/*
 * "회원가입 동의서" 처리
 */ 
function go_next() {
	if($(".agree")[0].checked == true) {
		$("#join").attr("action", "join_form").submit();
	} else if($(".agree")[1].checked == true) {
		alert("약관에 동의해 주셔야 합니다.");
		return false;
	}
}

/*
 * "회원가입" 아이디 중복 처리 팝업 창
 */ 
function idcheck() {
	if($("#id").val() == "") {
		alert("아이디를 입력해 주세요!");
		$("#id").focus();
		return false;
	}
	var url = "id_check_form?id=" + $("#id").val();
	
	window.open(url, "_blank", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=300");
}

/*
 * "회원가입" 우편번호 팝업 창
 */
function post_zip() {
	var url = "find_zip_num";
	
	window.open(url, "_blank", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=500");
}

/*
 * "회원가입" 처리
 */
function go_save() {
	if($("#id").val() == "") {
		alert("아이디를 입력해주세요!");
		$("#id").focus();
		return false;
	} else if($("#id").val() != $("#reid").val()) {
		alert("아이디 중복 확인을 해주세요!");
		$("#id").focus();
		return false;
	} else if ($("#pwd").val() == "") {
		alert("비밀번호를 입력해 주세요!");
		$("#pwd").focus();
		return false;
	} else if ($("#pwdCheck").val() == "") {
		alert("비밀번호 확인을 입력해 주세요!");
		$("#pwdcheck").focus();
		return false;
	} else if($("#pwd").val() != $("#pwdCheck").val()) {
		alert("비밀번호가 일치하지 않습니다!");
		$("#pwdcheck").focus();
		return false;
	} else if($("#name").val() == "") {
		alert("이름을 입력해 주세요!");
		$("#name").focus();
		return false;
	} else if ($("#phone").val() == "") {
		alert("휴대폰번호를 입력해 주세요!");
		$("#phone").focus();
		return false;
	} else if ($("#email").val() == "") {
		alert("이메일을 입력해 주세요!");
		$("#email").focus();
		return false;
	} else {
		$("#join").attr("action", "join").submit();
	}
}