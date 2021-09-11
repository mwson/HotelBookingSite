// 엔터키 방지
document.addEventListener('keydown', function(event) {
    if (event.keyCode === 13) {
        event.preventDefault();
    }
}, true);

// "사용자, 메인" 예약하기 화면 이동	
function index_booking_search() {
    if ($("#checkin").val() >= $("#checkout").val()) {
        alert("날짜가 잘못 입력 되었습니다. 올바른 날짜를 입력해주세요.");

		return false;
    } else {
    	$("#index_booking_form").attr("action", "booking_search").submit();
    }
}

// "사용자" 예약하기 화면 이동	
function booking_search() {
    if ($("#checkin").val() >= $("#checkout").val()) {
        alert("날짜가 잘못 입력 되었습니다. 올바른 날짜를 입력해주세요.");
        
		return false;
    } else {
    	$("#booking_form").attr("action", "booking_search").submit();
    }
}

// "사용자, 예약" rid1(스위트 룸) 예약
function booking_rid1() {
    if ($("#checkin").val() >= $("#checkout").val()) {
        alert("날짜가 잘못 입력 되었습니다. 올바른 날짜를 입력해주세요.");

        return false;
    } else {
    	$('#roomRid').val(1);
    	$("#booking_form").attr("action", "booking").submit();
    }
}
// "사용자, 예약" rid2(슈페리어 룸) 예약 
function booking_rid2() {
    if ($("#checkin").val() >= $("#checkout").val()) {
        alert("날짜가 잘못 입력 되었습니다. 올바른 날짜를 입력해주세요.");

        return false;
    } else {
		$('#roomRid').val(2);
		$("#booking_form").attr("action", "booking").submit();
    }
}
// "사용자, 예약" rid3(디럭스 룸) 예약 
function booking_rid3() {
    if ($("#checkin").val() >= $("#checkout").val()) {
        alert("날짜가 잘못 입력 되었습니다. 올바른 날짜를 입력해주세요.");

        return false;
    } else {
		$('#roomRid').val(3);
		$("#booking_form").attr("action", "booking").submit();
    }
}
// "사용자, 예약" rid4(스탠다드 룸) 예약 
function booking_rid4() {
    if ($("#checkin").val() >= $("#checkout").val()) {
        alert("날짜가 잘못 입력 되었습니다. 올바른 날짜를 입력해주세요.");

        return false;
    } else {
		$('#roomRid').val(4);
		$("#booking_form").attr("action", "booking").submit();
    }
}

// "사용자, 예약" rid1(스위트 룸) 예약 불가
function booking_rid1_fail() {
	$('#roomRid').val(1);
	$("#booking_form").attr("action", "booking_fail").submit();
}
// "사용자, 예약" rid2(슈페리어 룸) 예약 불가
function booking_rid2_fail() {
	$('#roomRid').val(2);
	$("#booking_form").attr("action", "booking_fail").submit();
}
// "사용자, 예약" rid3(디럭스 룸) 예약 불가
function booking_rid3_fail() {
	$('#roomRid').val(3);
	$("#booking_form").attr("action", "booking_fail").submit();
}
// "사용자, 예약" rid4(스탠다드 룸) 예약 불가
function booking_rid4_fail() {
	$('#roomRid').val(4);
	$("#booking_form").attr("action", "booking_fail").submit();
}

// "사용자" 결제완료 화면 취소	
function booking_cancel() {
	if(confirm("결제를 취소하시습니까?")) {
		$("#booking_payment_form").attr("action", "booking_button").submit();
	} else {
		alert("취소되었습니다. 결제를 계속 진행해주세요.");
		
		return false;
	}
}

// "사용자" 결제완료 화면 이동	
function booking_complete() {
	if(confirm("결제 하시겠습니까?")) {
	    if ($("#checkin").val() >= $("#checkout").val()) {
	        alert("날짜가 잘못 입력 되었습니다. 올바른 날짜를 입력해주세요.");

	        $("#booking_payment_form").attr("action", "booking_button").submit();
	    } else {
	    	$("#booking_payment_form").attr("action", "booking_complete").submit();
	    }
	} else {
		alert("결제가 취소되었습니다.");
		
		return false;
	}
}
