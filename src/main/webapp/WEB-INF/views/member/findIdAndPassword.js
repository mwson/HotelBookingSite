/*
 * "아이디, 비밀번호 찾기" 화면 팝업 창
 */
function find_idAndPwd_form() {
	var url = "find_idAndPwd_form";
	
	window.open(url, "_blank", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=500");
}

/*
 * "아이디 찾기" 처리
 */
function findMemberId() {
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

/*
 * "비밀번호 찾기" 처리
 */
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

/*
 * "비밀번호 변경" 처리
 */
function changePassword() {
	if(confirm("비밀번호를 변경 하시겠습니까?")) {
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
			
			alert("비밀번호 변경이 완료되었습니다.");
		}
	} else {
		alert("비밀번호 변경이 취소되었습니다.");
		
		return false;
	}
}