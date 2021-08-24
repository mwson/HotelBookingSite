// "사용자, 객실" 선택
$("#room").change(function() {
    $("#room").val($(this).val());
    alert("예약 당 1개의 객실만 가능합니다.");
});

//"사용자, 예약" 스위트 룸 예약 
function booking_suite_detail() {
	$("#booking_form").attr("action", "booking_suite_detail").submit();
}

//"사용자, 예약" 슈페리어 룸 예약 
function booking_superior_detail() {
	$("#booking_form").attr("action", "booking_superior").submit();
}

//"사용자, 예약" 디럭스 룸 예약 
function booking_deluxe_detail() {
	$("#booking_form").attr("action", "booking_deluxe_detail").submit();
}

//"사용자, 예약" 스탠다드 룸 예약 
function booking_standard_detail() {
	$("#booking_form").attr("action", "booking_standard_detail").submit();
}

// "사용자, 예약" 예약불가
function booking_n() {
	alert("예약이 불가합니다. 다른 조건으로 검색하세요.");
}

