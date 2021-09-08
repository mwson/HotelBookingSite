// 엔터키 방지
document.addEventListener('keydown', function(event) {
    if (event.keyCode === 13) {
        event.preventDefault();
    }
}, true);

// "관리자" 로그인
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