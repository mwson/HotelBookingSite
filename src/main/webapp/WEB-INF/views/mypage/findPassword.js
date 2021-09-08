// 엔터키 방지
document.addEventListener('keydown', function(event) {
    if (event.keyCode === 13) {
        event.preventDefault();
    }
}, true);

// "아이디, 비밀번호 찾기" 화면 팝업 창
function pwdCheck_find_pwd_form() {
	var url = "pwdCheck_find_pwd_form";
	
	window.open(url, "_blank", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=550");
}

// "비밀번호 찾기" 처리
function pwdCheckFindPwd() {
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
		$("#findPwd").attr("action", "find_password").submit();
	}
}