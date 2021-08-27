/*
 * "장바구니" 삭제 처리
 */
function go_cart_delete() {
	var count = 0;

	if(document.formm.cseq.length == undefined) {
		if(document.formm.cseq.checked == true) {
			count++;
		}
	}
	
	for(var i=0; i<document.formm.cseq.length; i++) {
		if(document.formm.cseq[i].checked == true) {
			count++;
		}
	}
	
	if(count == 0) {
		alert("삭제할 항목을 선택해 주세요!");
	} else {
		document.formm.action = "cart_delete";
		document.formm.submit();
	}
}

/*
 * "장바구니" 주문 처리
 */
function go_order_insert() {
	$("#formm").attr("action", "order_insert").submit();
}

/*
 * "회원정보 수정" 비밀번호 확인
 */
function update_member_form_pwdCheck() {
	$("#pwdCheck_form").attr("action", "update_member_form_pwdCheck").submit();
}

/*
 * "회원정보 수정" 수정
 */
function updateMember() {
	if(confirm("회원정보를 수정 하시겠습니까?")) {
		if($("#pwd").val() != $("#pwdCheck").val()) {
			alert("비밀번호가 일치하지 않습니다!");
			$("#pwdcheck").focus();
			
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
			$("#updateMember_form").attr("action", "update_member").submit();
			alert("회원정보 수정이 완료되었습니다.");
		}
	} else {
		alert("회원정보 수정이 취소되었습니다.");
		
		return false;
	}
}