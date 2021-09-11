// 엔터키 방지
document.addEventListener('keydown', function(event) {
    if (event.keyCode === 13) {
        event.preventDefault();
    }
}, true);

// "공지사항" 검색 처리
function go_search_notice() {
	$("#notice_form").attr("action", "notice_list").submit();
}