/**
 * 
 */
function go_cart() {
	/*
	 * quantity 입력필드에 값이 있는지 확인
	 * 값이 없으면 alert 출력
	 * 값이 있으면 : url => "cart_insert" submit
	 */
	if($("#quantity").val() == "") {
		alert("값을 입력해 주세요!");
		$("#quantity").focus();
		return false;
	} else if($("#quantity").val() != "") {
		$("#theform").attr("action", "cart_insert").submit();
	}
}