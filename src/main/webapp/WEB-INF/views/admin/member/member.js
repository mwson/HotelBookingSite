// 엔터키 방지
document.addEventListener('keydown', function(event) {
    if (event.keyCode === 13) {
        event.preventDefault();
    }
}, true);

// "회원목록" 검색 처리 
function go_search_member() {
	$("#member_form").attr("action", "admin_member_list").submit();
}