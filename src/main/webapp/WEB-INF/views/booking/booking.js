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

//"사용자, 예약" rid1(스위트 룸) 예약
function booking_rid1() {
	$("#booking_form").attr("action", "booking_rid1").submit();
}

//"사용자, 예약" rid2(슈페리어 룸) 예약 
function booking_rid2() {
	$("#booking_form").attr("action", "booking_rid2").submit();
}

//"사용자, 예약" rid3(디럭스 룸) 예약 
function booking_rid3() {
	$("#booking_form").attr("action", "booking_rid3").submit();
}

//"사용자, 예약" rid4(스탠다드 룸) 예약 
function booking_rid4() {
	$("#booking_form").attr("action", "booking_rid4").submit();
}

// "사용자, 예약" 예약불가
function booking_fail() {
	alert("예약이 불가합니다. 다른 조건으로 예약을 검색하세요.");
}

//"사용자" 결제완료 화면 이동	
function booking_complete() {
	if(confirm("결제 하시겠습니까?")) {
		$("#booking_payment_form").attr("action", "booking_complete").submit();
		
		alert("결제가 완료되었습니다.");
	} else {
		alert("결제가 취소되었습니다.");
		
		return false;
	}
}
