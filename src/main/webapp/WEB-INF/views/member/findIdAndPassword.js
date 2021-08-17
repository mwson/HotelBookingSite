/**
 * 아이디, 비밀번호 찾기 관련 스크립트 함수
 */
function find_id_form() {
	var url = "find_id_form";
	
	window.open(url, "_blank", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=500");
}

/*
 * 아이디를 찾기 위해 find_id URL 요청 전송
 * 이름, 이메일이 입력되어있는지 확인
 */
function findMemberId() {
	/* 이름과 이메일 입력 확인 */
	if($("#nameId").val() == "") {
		alert("이름을 입력해 주세요!");
		$("#nameId").focus();
		return false;
	} else if($("#emailId").val() == "") {
		alert("이메일을 입력해 주세요!");
		$("#emailId").focus();
		return false;
	} else {
		$("#findId").attr("action", "find_id").submit();
	}
}

function findPassword() {
	if($("#idPw").val() == "") {
		alert("아이디를 입력해 주세요!");
		$("#idPw").focus();
		return false;
	} else if($("#namePw").val() == "") {
		alert("이름을 입력해 주세요!");
		$("#namePw").focus();
		return false;
	} else if($("#emailPw").val() == "") {
		alert("이메일을 입력해 주세요!");
		$("#emailPw").focus();
		return false;
	} else {
		$("#findPw").attr("action", "find_password").submit();
	}
}

function changePassword() {
	if($("#pwd").val() == "") {
		alert("비밀번호를 입력해 주세요!");
		$("#pwd").focus();
		return false;
	} else if($("#pwdCheck").val() == "") {
		alert("비밀번호 확인을 입력해 주세요!");
		$("#pwdCheck").focus();
		return false;
	} else if($("#pwd").val() != $("#pwdCheck").val()) {
		alert("비밀번호가 일치하지 않습니다!");
		$("#pwdcheck").focus();
		return false;
	} else {
		$("#pwd_form").attr("action", "change_Password").submit();
	}
}