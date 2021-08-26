// "사용자, 객실" 선택
$("#room").change(function() {
    $("#room").val($(this).val());
    alert("예약 당 1개의 객실만 가능합니다.");
});

//"사용자" 예약하기 화면 이동	
function booking_search() {
	$("#booking_form").attr("action", "booking_search").submit();
}

//"사용자, 예약" 스위트 룸 예약 
function booking_suite() {
	$("#booking_form").attr("action", "booking_suite").submit();
}

//"사용자, 예약" 슈페리어 룸 예약 
function booking_superior() {
	$("#booking_form").attr("action", "booking_superior").submit();
}

//"사용자, 예약" 디럭스 룸 예약 
function booking_deluxe() {
	$("#booking_form").attr("action", "booking_deluxe").submit();
}

//"사용자, 예약" 스탠다드 룸 예약 
function booking_standard() {
	$("#booking_form").attr("action", "booking_standard").submit();
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
