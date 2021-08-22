// "Q&A목록" 검색
function go_search_qna() {
	$("#qna_form").attr("action", "admin_qna_list").submit();
}

// "Q&A목록" 답변 등록
function go_qna_repsave() {
	$("#qna_detail_form").attr("action", "admin_qna_repsave").submit();
}

// "Q&A목록" 상세에서 목록 이동
function go_qna_list() {
	$("#qna_detail_form").attr("action", "admin_qna_list").submit();
}