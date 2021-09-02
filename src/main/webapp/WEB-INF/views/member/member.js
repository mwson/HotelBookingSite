// "회원가입 동의서" 처리
function join_form() {
	if($(".agree")[0].checked == true) {
		$("#contract").attr("action", "join_form").submit();
	} else if($(".agree")[1].checked == true) {
		alert("약관에 동의해 주셔야 합니다.");
		
		return false;
	}
}

// "회원가입" 아이디 중복 처리 팝업 창
function idcheck() {
	var regExpId = /^[a-z]+[a-z0-9]{5,19}$/g;
	
	if($("#id").val() == "") {
		alert("아이디를 입력해 주세요!");
		$("#id").focus();
		
		return false;
	} else if(!regExpId.test($("#id").val())) {
		alert("아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다.");
		$("#id").focus();
		
		return false;
	}
	
	var url = "id_check_form?id=" + $("#id").val();
	
	window.open(url, "_blank", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=300");
}

// "회원가입" 우편번호 팝업 창
function post_zip() {
	var url = "find_zip_num";
	
	window.open(url, "_blank", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=500");
}

// "회원가입" 처리
function joinMember() {
	var regExpId = /^[a-z]+[a-z0-9]{5,19}$/g;
	var regExpName = /^[가-힣]{2,4}|[a-zA-Z]{2,10}\s[a-zA-Z]{2,10}$/;
	var regExpPwd = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
	var regExpPhone = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
	var regExpEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
	if($("#id").val() == "") {
		alert("아이디를 입력해주세요.");
		$("#id").focus();
		
		return false;
	} else if(!regExpId.test($("#id").val())) {
		alert("아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자로 입력해 주세요.");
		$("#id").focus();
		
		return false;
	} else if($("#id").val() != $("#reid").val()) {
		alert("아이디 중복 확인을 해주세요.");
		$("#id").focus();
		
		return false;
	} else if ($("#pwd").val() == "") {
		alert("비밀번호를 입력해 주세요.");
		$("#pwd").focus();
		
		return false;
	} else if(!regExpPwd.test($("#pwd").val())) {
		alert("비밀번호는 영문자와 숫자 조합으로 8자 이상 입력해 주세요.");
		$("#pwd").focus();
		
		return false;
	} else if ($("#pwdCheck").val() == "") {
		alert("비밀번호 확인을 입력해 주세요.");
		$("#pwdcheck").focus();
		
		return false;
	} else if($("#pwd").val() != $("#pwdCheck").val()) {
		alert("비밀번호가 일치하지 않습니다.");
		$("#pwdcheck").focus();
		
		return false;
	} else if($("#name").val() == "") {
		alert("이름을 입력해주세요.");
		$("#name").focus();
		
		return false;
	} else if(!regExpName.test($("#name").val())) {
		alert("이름 형태로 입력해주세요. (ex: 홍길동 또는 Gildong Hong)");
		$("#name").focus();
		
		return false;
	} else if($("#phone").val() == "") {
		alert("휴대폰 번호를 입력해주세요.");
		$("#phone").focus();
		
		return false;
	} else if(!regExpPhone.test($("#phone").val())) {
		alert("휴대폰 번호 형태로 입력해주세요. (ex: 01012345678 또는 010-1234-5678)");
		$("#phone").focus();
		
		return false;
	} else if($("#email").val() == "") {
		alert("이메일을 입력해주세요.");
		$("#email").focus();
		
		return false;
	} else if(!regExpEmail.test($("#email").val())) {
		alert("이메일 형태로 입력해주세요. (ex: email@email.com)");
		$("#email").focus();
		
		return false;
	} else {
		$("#join_form").attr("action", "join").submit();
	}
}