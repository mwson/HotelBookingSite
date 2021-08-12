/**
 * MatchPassword JS.
 */

function passwordCheck2() {	
	var originPwd = $("#originPwd").val();
	var inputPwd = $("#inputPwd").val();
	if(inputPwd == "") {
		alert("암호를 입력해 주세요!");
		$("#inputPwd").focus();
		return false;
	} else if (originPwd != inputPwd) {	
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	} else if (originPwd == inputPwd) {
		opener.document.location.href="update_member";
		self.close();
	}
}
