/*
 * "주문목록" 예약 처리 
 */
function go_order_save() {
	var count = 0;
	var orderConfirm = confirm("주문처리 하시겠습니까?");
	
	if(orderConfirm) {
		if(document.order_form.result.length == undefined) {
			if(document.order_form.result.checked == true) {
				count++;
			}
		} else {
			for(var i = 0; i < document.order_form.result.length; i++) {
				if(document.order_form.result[i].checked == true) {
					count++;
				}
			}
		}
		
		if (count == 0) {
			alert("주문을 처리 할 항목을 선택해 주세요.");
		} else {
			document.order_form.action = "admin_order_save";
			document.order_form.submit();
			
			alert("주문처리가 완료되었습니다.");
		}
	} else {
		alert("주문처리가 취소되었습니다.");
		
		return false;
	}
	
}

/*
 * "주문목록" 검색 처리 
 */
function go_search_order() {
	$("#order_form").attr("action", "admin_order_list").submit();
}