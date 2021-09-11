// 엔터키 방지
document.addEventListener('keydown', function(event) {
    if (event.keyCode === 13) {
        event.preventDefault();
    }
}, true);

// "관리자, 객실목록" 검색 
function room_search() {
	$("#room_list_form").attr("action", "admin_room_list").submit();
}

/*
 * "관리자, 객실목록" 에서 객실등록 폼 이동
 */
function room_write_form() {
	$("#room_list_form").attr("action", "admin_room_write_form").submit();
}

/*
 * "관리자, 객실목록" 객실 등록
 */
function room_write() {
	if($("#type").val() == "") {
		alert("객실명를 입력해주세요.");
		$("#type").focus();
		
		return false;
	} else if($("#people").val() == "----") {
		alert("최대인원을 선택해주세요.");
		$("#people").focus();
		
		return false;
	} else if($("#price").val() == "") {
		alert("가격을 입력해주세요.");
		$("#price").focus();
		
		return false;
	} else if($("#room_image").val() == "") {
		alert("객실 이미지를 등록해주세요.");
		$("#room_image").focus();
		
		return false;
	} else {
		if(confirm("객실 등록 하시겠습니까?")) {
			$("#price").val(remove_comma($("#price").val()));
			
			$("#room_write_form").attr("encoding", "multipart/form-data");
			$("#room_write_form").attr("action", "admin_room_write").submit();
			
			alert("객실 등록이 완료되었습니다.");
		} else {
			alert("객실 등록이 취소되었습니다.");
			
			return false;
		}
	}
}

/*
 * "관리자, 객실목록" 객실 등록 에서 객실목록 이동
 */
function room_list1(page, items_cnt) {
	$("#room_write_form").attr("action", "admin_room_list").submit();
}

/* 
 * "관리자, 객실목록" 객실 상세 에서 객실 수정 이동
 */
function room_update_form(rid) {
	$("#room_detail_form").attr("action", "admin_room_update_form").submit();
}

/* 
 * "관리자, 객실목록" 객실 상세 에서 삭제
 */
function room_delete() {
	if(confirm("삭제 하시겠습니까?")) {
		$("#room_detail_form").attr("action", "admin_room_delete").submit();
		
		alert("삭제가 완료되었습니다.");
	} else {
		alert("삭제가 취소되었습니다.");
		
		return false;
	}
}

/*
 * "관리자, 객실목록" 객실 상세 에서 객실목록 이동
 */
function room_list2(page, items_cnt) {
	$("#room_detail_form").attr("action", "admin_room_list").submit();
}

/*
 * "관리자, 객실목록" 수정
 */
function room_update() {
	if($("#type").val() == "") {
		alert("객실명를 입력해주세요.");
		$("#type").focus();
		
		return false;
	} else if($("#people").val() == "----") {
		alert("최대인원을 선택해주세요.");
		$("#people").focus();
		
		return false;
	} else if($("#price").val() == "") {
		alert("가격을 입력해주세요.");
		$("#price").focus();
		
		return false;
	} else {
		if(confirm("객실 수정 하시겠습니까?")) {
			if($("#useyn").is(":checked")) {
				$("#useyn").val("y");
			} else {
				$("#useyn").val("n");
			}
				
			$("#price").val(remove_comma($("#price").val()));
			
			$("#room_update_form").attr("encoding", "multipart/form-data");
			$("#room_update_form").attr("action", "admin_room_update").submit();
			
			alert("객실 수정이 완료되었습니다.");
		} else {
			alert("객실 수정이 취소되었습니다.");
			
			return false;
		}
	}
}

/*
 * "관리자, 객실목록" 객실 수정 에서 객실목록 이동
 */
function room_list3(page, items_cnt) {
	$("#room_update_form").attr("action", "admin_room_list").submit();
}

/*
 * 입력된 금액을 받아 세자리 마다 ,를 추가하여 반환
 * t - 화면에 입력된 금액
 */
function NumFormat(t) {
	num = t.value;
	num = num.replace(/\D/g, '');	// \D - 정규표현식으로 숫자가 아닌 문자의미. 숫자가 아닌 문자는 모두 제거
	len = num.length - 3;
	
	while(len > 0) {
		num = num.substr(0, len) + "," + num.substr(len);	// 문자열 인덱스는 0부터 시작
		len -= 3;
	}
	
	t.value = num;
	
	return t;
}

/*
 * 문자열 내에 들어 있는 콤마를 제거
 * input : 입력문자열
 */
function remove_comma(input) {
	return input.replace(/,/gi, "");	// input 값에 ,가 포함되어 있으면 제거
}