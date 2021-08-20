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
 * "회원정보 관리" 수정 처리
 */
function go_update_member() {
	if($("#pwd").val() != $("#pwdCheck").val()) {
		alert("비밀번호가 일치하지 않습니다!");
		$("#pwdcheck").focus();
		return false;
	} else {
	   $("#update").attr("action", "update_member").submit();
	}
}