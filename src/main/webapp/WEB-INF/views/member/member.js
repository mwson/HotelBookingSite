/**
 * 
 */
// 계약서 동의 여부 확인
function go_next() {
	if($(".agree")[0].checked == true) { // 동의함에 체크되어 있으면 '회원가입'을 요청함
		$("#join").attr("action", "join_form").submit();
	} else if($(".agree")[1].checked == true) {
		alert("약관에 동의해 주셔야 합니다.");
		return false;
	}
}

// id 중복확인 화면 출력
function idcheck() {
	if($("#id").val() == "") {
		alert("아이디를 입력해 주세요!");
		$("#id").focus();
		return false;
	}
	// 아이디 중복 체크를 위한 윈도우 오픈 요청
	var url = "id_check_form?id=" + $("#id").val();
	
	window.open(url, "_blank", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=300");
}

// 사용가능한 아이디를 사용
/*
function idok() {
	$("#theform").attr("action", "id_check_confirmed").submit();
}
*/

/*
 * 회원가입 시, 필수 입력 사항 체크
 * action url: join
 */
function go_save() {
	if($("#id").val() == "") {
		alert("아이디를 입력해주세요!");
		$("#id").focus();
		return false;
	} else if($("#id").val() != $("#reid").val()) {
		alert("아이디 중복 확인을 해주세요!");
		$("#id").focus();
		return false;
	} else if ($("#pwd").val() == "") {
		alert("비밀번호를 입력해 주세요!");
		$("#pwd").focus();
		return false;
	} else if ($("#pwdcheck").val() == "") {
		alert("비밀번호 확인을 입력해 주세요!");
		$("#pwdcheck").focus();
		return false;
	} else if($("#pwd").val() != $("#pwdcheck").val()) {
		alert("비밀번호가 일치하지 않습니다!");
		$("#pwdcheck").focus();
		return false;
	} else if($("#name").val() == "") {
		alert("이름을 입력해 주세요!");
		$("#name").focus();
		return false;
	} else {
		$("#join").attr("action", "join").submit();
	}
}

/*
 * 우편번호 찾기 창 오픈
 */
function post_zip() {
	var url = "find_zip_num";
	
	window.open(url, "_blank", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=500");
}