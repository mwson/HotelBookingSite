/*
 * "공지사항 목록" 에서 상세 이동 
 */
function go_notice_detail(nseq) {
	$("#notice_form").attr("action", "admin_notice_detail?nseq=" + nseq).submit();
}

/*
 * "공지사항 목록" 검색 처리 
 */
function go_search_notice() {
	$("#notice_form").attr("action", "admin_notice_list").submit();
}

/*
 * "공지사항 목록" 에서 등록 이동 
 */
function go_notice_write_form() {
	$("#notice_form").attr("action", "admin_notice_write_form").submit();
}

/*
 * "공지사항" 등록 처리
 */
function go_notice_write() {
	if($("#kind").val() == "-----------") {
		alert("종류를 선택해주세요.");
		$("#kind").focus();
		
		return false;
	} else if($("#subject").val() == "") {
		alert("제목을 입력해주세요.");
		$("#subject").focus();
		
		return false;
	} else if($("#content").val() == "") {
		alert("내용을 입력해주세요.");
		$("#content").focus();
		
		return false;
	} else if($("#notice_image").val() == "") {
		alert("이미지를 등록해주세요.");
		$("#notice_image").focus();
		
		return false;
	} else {
		if(confirm("등록하시겠습니까?")) {
			$("#notice_write_form").attr("encoding", "multipart/form-data");
			$("#notice_write_form").attr("action", "admin_notice_write").submit();
			
			alert("등록이 완료되었습니다.");
		} else {
			alert("등록이 취소되었습니다.");
			
			return false;
		} 
	}
}

/*
 * "공지사항 등록" 에서 목록 이동 
 */
function go_notice_list1() {
	$("#notice_write_form").attr("action", "admin_notice_list").submit();
}

/*
 * "공지사항 상세" 에서 수정 이동 
 */
function go_notice_update_form(nseq) {
	$("#notice_detail_form").attr("action", "admin_notice_update_form?nseq=" + nseq).submit();
}

/*
 * "공지사항 상세" 삭제 처리 
 */
function go_notice_delete() {
	if(confirm("삭제 하시겠습니까?")) {
		$("#notice_detail_form").attr("action", "admin_notice_delete").submit();
		
		alert("삭제가 완료되었습니다.");
	} else {
		alert("삭제가 취소되었습니다.");
		
		return false;
	}
}

/*
 * "공지사항 상세" 에서 목록 이동 
 */
function go_notice_list2() {
	$("#notice_detail_form").attr("action", "admin_notice_list").submit();
}

/*
 * "공지사항 수정" 처리 
 */
function go_notice_update(nseq) {
	if($("#kind").val() == "종류를 선택하세요") {
		alert("종류를 선택해주세요.");
		$("#kind").focus();
		
		return false;
	} else if($("#subject").val() == "") {
		alert("제목을 입력해주세요.");
		$("#subject").focus();
		
		return false;
	} else if($("#content").val() == "") {
		alert("내용을 입력해주세요.");
		$("#content").focus();
		
		return false;
	} else {
		if(confirm("수정하시겠습니까?")) {
			$("#notice_update_form").attr("encoding", "multipart/form-data");
			$("#notice_update_form").attr("action", "admin_notice_update").submit();
			
			alert("수정이 완료되었습니다.");
		} else {
			alert("수정이 취소되었습니다.");
			
			return false;
		} 
	}
}

/*
 * "공지사항 수정" 에서 목록 이동 
 */
function go_notice_list3() {
	$("#notice_update_form").attr("action", "admin_notice_list").submit();
}