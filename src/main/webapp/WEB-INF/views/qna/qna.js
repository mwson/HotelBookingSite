// 엔터키 방지
document.addEventListener('keydown', function(event) {
    if (event.keyCode === 13) {
        event.preventDefault();
    }
}, true);

// "문의하기" 처리
function go_qna_write() {
	if($("#subject").val() == "") {
		alert("제목을 입력해 주세요!");
		$("#subject").focus();
		return false;
	} else if($("#content").val() == "") {
		alert("문의내용을 입력해 주세요!");
		$("#content").focus();
		return false;
	} else {
		$("#formm").attr("action", "qna_write").submit();
	}
}