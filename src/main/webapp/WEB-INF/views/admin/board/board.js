function go_board_write_form() {
	$("#board_list").attr("action", "admin_board_write_form").submit();
}

function go_board_write() {
	if($("#subject").val() == "") {
		alert("제목을 입력해 주세요!");
		$("#subject").focus();
		return false;
	} else if($("#content").val() == "") {
		alert("내용을 입력해 주세요!");
		$("#content").focus();
		return false;
	} else if($("#board_image").val() == "") {
		alert("이미지를 등록해 주세요!");
		$("#board_image").focus();
		return false;
	} else {
		$("#board_write_form").attr("encoding", "multipart/form-data");
		$("#board_write_form").attr("action", "admin_board_write").submit();
	}
}

function go_board_detail(bseq) {
	$("#board_list").attr("action", "admin_board_detail?bseq=" + bseq).submit();
}

function go_board_update_form(bseq) {
	$("#board_detail_form").attr("action", "admin_board_update_form?bseq=" + bseq).submit();
}

function go_board_update(bseq) {
	if($("#subject").val() == "") {
		alert("제목을 입력해 주세요!");
		$("#subject").focus();
		return false;
	} else if($("#content").val() == "") {
		alert("내용을 입력해 주세요!");
		$("#content").focus();
		return false;
	} else {
		if(confirm("수정하시겠습니까?")) {
			$("#board_update_form").attr("encoding", "multipart/form-data");
			$("#board_update_form").attr("action", "admin_board_update").submit();
		}
	}
}

function go_board_delete(bseq) {
	if(confirm("삭제하시겠습니까?")) {
		$("#board_detail_form").attr("action", "admin_board_delete").submit();
	}

}