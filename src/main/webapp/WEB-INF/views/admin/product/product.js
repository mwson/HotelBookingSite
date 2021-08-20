/*
 * "상품목록" 검색 
 */
function go_search_product() {
	$("#product_form").attr("action", "admin_product_list").submit();
}

/*
 * "상품목록" 등록 처리
 */
function go_search_write() {
	$("#product_form").attr("action", "admin_product_write_form").submit();
}

/*
 * 판매가(price2) - 원가(price1)를 계산하여 price3에 표시하는 함수
 * 계산 시 콤마를 제거하고 계산하도록 함.
 */
function go_ab() {
	var a = remove_comma($("#price2").val());
	var b = remove_comma($("#price1").val());
	
	$("#price3").val(a-b);
}

/*
 * 문자열 내에 들어 있는 콤마를 제거
 * input : 입력문자열
 */
function remove_comma(input) {
	return input.replace(/,/gi, "");	// input 값에 ,가 포함되어 있으면 제거
}

/*
 * 입력된 금액을 받아 세자리 마다 ,를 추가하여 반환
 * t - 화면에 입력된 금액
 */
function NumFormat(t) {
	num = t.value;
	num = num.replace(/\D/g, ''); // \D - 정규표현식으로 숫자가 아닌 문자의미. 숫자가 아닌 문자는 모두 제거
	len = num.length - 3;
	
	while(len > 0) {
		num = num.substr(0, len) + "," + num.substr(len); // 문자열 인덱스는 0부터 시작
		len -= 3;
	}
	
	t.value = num;
	
	return t;
}

/*
 * "상품등록" 처리
 */
function go_order_write() {
	var $price1 = $("#price1");
	var $price2 = $("#price2");
	var $price3 = $("#price3");
	
	if($("#kind").val() == "") {
		alert("상품분류를 선택해 주세요!");
		$("#kind").focus();
		return false;
	} else if($("#name").val() == "") {
		alert("상품명을 입력해 주세요!");
		$("#name").focus();
		return false;
	} else if($price1.val() == "") {
		alert("원가를 입력해 주세요!");
		$price1.focus();
		return false;
	} else if($price2.val() == "") {
		alert("판매가를 입력해 주세요!");
		$price2.focus();
		return false;
	} else if($("#content").val() == "") {
		alert("상세설명을 입력해 주세요!");
		$("#content").focus();
		return false;
	} else if($("#product_image").val() == "") {
		alert("상품이미지를 등록해 주세요!");
		$("#product_image").focus();
		return false;
	} else {
		$price1.val(remove_comma($price1.val()));
		$price2.val(remove_comma($price2.val()));
		$price3.val(remove_comma($price3.val()));
		
		$("#product_write_form").attr("encoding", "multipart/form-data");
		$("#product_write_form").attr("action", "admin_product_write").submit();
	}
}

/*
 * "상품등록" 에서 상품목록 이동
 */
function admin_product_list1() {
	$("#product_write_form").attr("action", "admin_product_list").submit();
}

/* 
 * "상품목록" 에서 상세보기 이동
 */
function go_detail(pseq) {
	$("#product_form").attr("action", "admin_product_detail?pseq=" + pseq).submit();
}

/* 
 * "상품목록" 에서 상품수정 이동
 */
function go_order_update_form(pseq) {
	$("#product_detail_form").attr("action", "admin_product_update_form?pseq=" + pseq).submit();
}

/*
 * "상품상세" 에서 상품목록 화면 이동
 */
function go_order_list(page, items_cnt) {
	$("#product_detail_form").attr("action", "admin_product_list").submit();
}

/*
 * "상품수정" 처리
 */
function go_order_update(pseq) {
	var $price1 = $("#price1");
	var $price2 = $("#price2");
	var $price3 = $("#price3");
	
	if($("#kind").val() == "") {
		alert("상품분류를 선택해 주세요!");
		$("#kind").focus();
		return false;
	} else if($("#name").val() == "") {
		alert("상품명을 입력해 주세요!");
		$("#name").focus();
		return false;
	} else if($price1.val() == "") {
		alert("원가를 입력해 주세요!");
		$price1.focus();
		return false;
	} else if($price2.val() == "") {
		alert("판매가를 입력해 주세요!");
		$price2.focus();
		return false;
	} else if($("#content").val() == "") {
		alert("상세설명을 입력해 주세요!");
		$("#content").focus();
		return false;
	} else {
		if(confirm("수정하시겠습니까?")) {
			if($("#useyn").is(":checked")) {
				$("#useyn").val("y");
			} else {
				$("#useyn").val("n");
			}
			
			if($("#bestyn").is(":checked")) {
				$("#bestyn").val("y");
			} else {
				$("#bestyn").val("n");
			}
			
			$price1.val(remove_comma($price1.val()));
			$price2.val(remove_comma($price2.val()));
			$price3.val(remove_comma($price3.val()));
	
			$("#product_update_form").attr("encoding", "multipart/form-data");
			$("#product_update_form").attr("action", "admin_product_update").submit();
		}
	}
}

/*
 * "상품수정" 에서 상품목록 화면 이동
 */
function admin_product_list2() {
	$("#product_update_form").attr("action", "admin_product_list").submit();
}