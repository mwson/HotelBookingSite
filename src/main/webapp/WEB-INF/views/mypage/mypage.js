// "사용자, 회원정보 수정" 비밀번호 확인
function update_member_form_pwdCheck() {
	if ($("#pwd").val() == "") {
		alert("비밀번호를 입력해 주세요.");
		$("#pwd").focus();
	
		return false;
	} else {
		$("#pwdCheck_form").attr("action", "update_member_form_pwdCheck").submit();
	}
}

// "사용자, 회원정보 수정" 수정
function updateMember() {
	var regExpPwd = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
	var regExpPhone = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
	var regExpEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
	if(confirm("회원정보를 수정 하시겠습니까?")) {
		if($("#pwd").val() != "") {
			if(!regExpPwd.test($("#pwd").val())) {
				alert("비밀번호는 영문자와 숫자 조합으로 8자 이상 입력해주세요.");
				$("#pwd").focus();
				
				return false;
			} else if ($("#pwd").val() != $("#pwdCheck").val()) {
				alert("비밀번호가 일치하지 않습니다.");
				$("#pwdcheck").focus();
				
				return false;
			} else if ($("#phone").val() == "") {
				alert("휴대폰번호를 입력해주세요.");
				$("#phone").focus();
				
				return false;
			} else if(!regExpPhone.test($("#phone").val())) {
				alert("휴대폰 번호 형태로 입력해주세요. (ex: 01012345678 또는 010-1234-5678)");
				$("#phone").focus();
				
				return false;
			} else if ($("#email").val() == "") {
				alert("이메일을 입력해주세요.");
				$("#email").focus();
				
				return false;
			} else if(!regExpEmail.test($("#email").val())) {
				alert("이메일 형태로 입력해주세요. (ex: email@email.com)");
				$("#email").focus();
				
				return false;
			} else {
				$("#updateMember_form").attr("action", "update_member").submit();
				
				alert("회원정보 수정이 완료되었습니다.");
			}
		} else if ($("#phone").val() == "") {
			alert("휴대폰번호를 입력해주세요.");
			$("#phone").focus();
			
			return false;
		} else if(!regExpPhone.test($("#phone").val())) {
			alert("휴대폰 번호 형태로 입력해주세요. (ex: 01012345678 또는 010-1234-5678)");
			$("#phone").focus();
			
			return false;
		} else if ($("#email").val() == "") {
			alert("이메일을 입력해주세요.");
			$("#email").focus();
			
			return false;
		} else if(!regExpEmail.test($("#email").val())) {
			alert("이메일 형태로 입력해주세요. (ex: email@email.com)");
			$("#email").focus();
			
			return false;
		} else {
			$("#updateMember_form").attr("action", "update_member").submit();
			
			alert("회원정보 수정이 완료되었습니다.");
		}
	} else {
		alert("회원정보 수정이 취소되었습니다.");
		
		return false;
	}
}