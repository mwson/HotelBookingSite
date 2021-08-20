/*
 * "관리자 로그인" 처리 
 */
function worker_check() {
	if($("#workerId").val() == "") {
		alert("아이디를 입력해 주세요!");
		$("#workerId").focus();
		return false;
	} else if($("#content").val() == "") {
		alert("비밀번호를 입력해 주세요!");
		$("#password").focus();
		return false;
	} else {
		$("#formm").attr("action", "admin_login").submit();
	}
}