// 엔터키 방지
document.addEventListener('keydown', function(event) {
    if (event.keyCode === 13) {
        event.preventDefault();
    }
}, true);

// "관리자, 예약목록" 검색 
function booking_search() {
	$("#booking_list_form").attr("action", "admin_booking_list").submit();
}

// "관리자, 예약목록" 예약 승인 
function booking_approve() {
	var count = 0;
	
	if(document.booking_list_form.result.length == undefined) {
		if(document.booking_list_form.result.checked == true) {
			count++;
		}
	} else {
		for(var i = 0; i < document.booking_list_form.result.length; i++) {
			if(document.booking_list_form.result[i].checked == true) {
				count++;
			}
		}
	}
	
	if (count == 0) {
		alert("예약 승인 항목을 선택해 주세요.");
		
		return false;
	} else {
		if(confirm("예약 승인 하시겠습니까?")) {
			document.booking_list_form.action = "admin_booking_approve";
			document.booking_list_form.submit();
			
			alert("예약 승인이 완료되었습니다.");
		} else {
			alert("예약 승인이 취소되었습니다.");
			
			return false;
		}
	}
}

// "관리자, 예약목록" 예약 상세 승인 
function booking_detail_approve() {
	if(document.booking_detail_form.cancel.checked == true) {
		alert("이미 예약 취소 되어있습니다.");
		
		return false;
	} else if(document.booking_detail_form.result.checked == true) {
		alert("이미 예약 승인 되어있습니다.");
		
		return false;
	} else {
		if(confirm("예약 승인 하시겠습니까?")) {
			$("#booking_detail_form").attr("action", "admin_booking_detail_approve").submit();
			
			alert("예약 승인이 완료되었습니다.");
		} else {
			alert("예약 승인이 취소되었습니다.");
			
			return false;
		}
	}
}

// "관리자, 예약목록" 예약 취소 
function booking_cancel() {
	if(document.booking_detail_form.cancel.checked == true) {
		alert("이미 예약 취소 되어있습니다.");
		
		return false;
	} else {
		if(confirm("예약 취소 하시겠습니까?")) {
			$("#booking_detail_form").attr("action", "admin_booking_detail_cancel").submit();
			
			alert("예약 취소가 완료되었습니다.");
		} else {
			alert("예약 취소가 취소되었습니다.");
			
			return false;
		}
	}
}

// "관리자, 예약목록" 예약 상세에서 예약목록 이동
function booking_list(page, items_cnt) {
	$("#booking_detail_form").attr("action", "admin_booking_list").submit();
}