<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../header.jsp"%>   

<div class="breadcrumb-option set-bg" data-setbg="images/breadcrumb-bg.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h1>회원정보 수정</h1>
                    <div class="breadcrumb__links">
                        <a href="index">메인</a>
                        <span>마이페이지</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="blog spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-3">
                <div class="blog__sidebar">
                    <div class="blog__sidebar__categories">
                        <h4>마이페이지</h4>
                        <hr>
                        <ul>
                        	<li><a href="booking_list">예약확인</a></li>
							<li><a href="qna_list">문의내역</a></li>
                            <li><a href="update_member_form">회원정보 수정</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="joinAndupdateMember col-lg-9 col-md-9">
                <h2 class="mb-4">회원정보 수정</h2>
                <form method="post" id="updateMember_form" name="updateMember_form">
                    <div class="joinAndupdateMember_form col-lg-6 col-md-6">
                        <div class="joinAndupdateMember_form_input">
                            <div class="mb-4">
                                <label for="id">아이디 <span class="review" style="color: #f44336">*</span></label>
                                <input type="text" class="form-control mb-1" id="id" name="id" size="14" placeholder="아이디" value="${memberVO.id}" readonly>
                            </div>
                            <div class="mb-4">
                                <label for="pwd">비밀번호 <span class="review" style="color: #f44336">*</span></label> 
                                <input type="password" class="form-control" id="pwd" name="pwd" placeholder="비밀번호">
                                <input type="password" id="default_pwd" name="default_pwd" value="${memberVO.pwd}" hidden="hidden">
                            </div>
                            <div class="mb-4">
                                <label for="pwdCheck">비밀번호 확인 <span class="review" style="color: #f44336">*</span></label> 
                                <input type="password" class="form-control" id="pwdCheck" name="pwdCheck" placeholder="비밀번호 확인">
                            </div>
                            <div class="mb-4">
                                <label for="name">이름 <span class="review" style="color: #f44336">*</span></label> 
                                <input type="text" class="form-control" id="name" name="name" placeholder="이름" value="${memberVO.name}" readonly>
                            </div>
                            <div class="mb-4">
                                <label for="phone">휴대폰번호 <span class="review" style="color: #f44336">*</span></label> 
                                <input type="text" class="form-control" id="phone" name="phone" placeholder="휴대폰번호" value="${memberVO.phone}">
                            </div>
                            <div class="mb-4">
                                <label for="email">이메일 <span class="review" style="color: #f44336">*</span></label> 
                                <input type="text" class="form-control" id="email" name="email" placeholder="이메일" value="${memberVO.email}">
                            </div>
                            <hr>
                            <div>
                                <label for="id">주소</label>
                                <div class="mb-1">
                                    <div style="float: left;">
                                        <input type="text" class="form-control mb-1" id="zip_num" name="zip_num" size="16" placeholder="우편번호" value="${memberVO.zip_num}" readonly>
                                    </div>
                                    <div style="float: right">
                                        <input type="button" class="btn btn-primary" value="우편번호 찾기" onclick="execDaumPostcode()">
                                    </div>
                                    <div style="clear: right"></div>
                                </div>
                                <div class="mb-1">
                                    <input type="text" class="form-control" id="addr1" name="addr1" placeholder="주소" value="${memberVO.address}" readonly>
                                </div>
                                <div>
                                    <input type="text" class="form-control" id="addr2" name="addr2" placeholder="상세주소">
                                </div>
                            </div>
                        </div>
                        <br>
                        <div class="joinAndupdateMember_form_button">
                            <div class="joinAndupdateMember_form_button_reset col-lg-4 col-md-4">
                                <input type="reset" class="btn btn-secondary btn-lg btn-block" value="취소">
                            </div>
                            <div class="joinAndupdateMember_form_button_submit col-lg-4 col-md-4">
                                <input type="button" class="btn btn-warning btn-lg btn-block" value="수정" onclick="updateMember()">
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 주소 변수와 참고항목 변수를 합친다.
                    addr += extraAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                $("#zip_num").val(data.zonecode);
                $("#addr1").val(addr);
             	/*
              	document.getElementById('zip_num').value = data.zonecode;
              	document.getElementById("addr1").value = addr;
              	*/
              	
                // 커서를 상세주소 필드로 이동한다.
                $("#addr2").val("");
                $("#addr2").focus();
                /*
             	document.getElementById("addr2").value = "";
              	document.getElementById("addr2").focus();
              	*/
            }
        }).open();
    }
</script>

<%@include file="../footer.jsp"%>  