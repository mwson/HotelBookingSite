<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  

<%@include file="../header.jsp"%>

<div class="breadcrumb-option set-bg" data-setbg="images/breadcrumb-bg.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h1>결제하기</h1>
                    <div class="breadcrumb__links">
                        <a href="index">메인</a>
                        <span>예약</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="blog spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-7 col-md-7">
                <h2 class="mb-2">예약자 정보</h2>
                <div class="bookingPayment__left">
                    <div class="bookingPayment__left__detail">
                        <div class="mb-3">
                            <label for="subject">예약자</label>
                            <input type="text" class="form-control" value="${loginUser.name}" readonly="readonly">
                        </div>
                        <div class="mb-3">
                            <label for="indate">휴대폰번호</label>
                            <input type="text" class="form-control" value="${loginUser.phone}" readonly="readonly">
                        </div>
                        <div class="mb-3">
                            <label for="subject">이메일</label>
                            <input type="text" class="form-control" value="${loginUser.email}" readonly="readonly">
                        </div>
                    </div>
                </div>
                <hr class="mb-4">
                <h2 class="mb-2">유의사항</h2>
                <div class="bookingPayment__left">
                    <div class="bookingPayment__left__detail">
                        <div class="mb-3">
                            <label for="subject">호텔 이용안내</label>
<textarea class="form-control mb-3" rows="27" readonly>

- 금액에는 부가가치세 10%가 부과됩니다.

- 체크인은 오후 3시부터이며 체크아웃은 정오 12시까지입니다.

  오후 3시 이전 Early Check-In 또는 12시 이후 Late Check-Out 하실 경우
  추가 요금이 부과될 수 있습니다.
  
- 체크인 시 등록카드 작성 및 투숙객 본인 확인을 위해 본인 사진이 포함된
  신분증을 반드시 제시해 주시기 바랍니다.
  
- 본 홈페이지 요금은 카드사 할인 등의 할인 혜택이 적용되지 않습니다.

- 어린이 동반 고객을 위한 영유아 용품(아기 욕조, 아기 침대, 어린이 베개
  및 아동용 배스 로브와 슬리퍼)은 객실예약과를 통해 사전 요청 가능하며,
  이용 상황에 따라 조기 마감될 수 있습니다.(단, 유모차는 현장에서만 대여
  가능합니다.)
  
- 대출 요청이 완료된 영유아 용품, 엑스트라 베드는 체크인 당일 18시까지
  객실에 준비해 드립니다.
  
- 37개월 미만의 유아 동반 시 추가 인원 요금 및 조식은 무료이며,
  유아(37개월 미만) 동반 여부는 체크인 시 프런트 데스크 직원에게
  알려 주셔야 무료로 이용 가능합니다.
  
- 자세한 객실안내는 객실예약과(02-1234-5678)로 문의 바랍니다.
</textarea>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="col-lg-5 col-md-5">
                <form method="post" id="booking_payment_form" name="booking_payment_form">
                	<input type="hidden" id="rid" name="rid" value="${bookingVO.rid}">
                	<input type="hidden" id="checkin" name="checkin" value="${bookingVO.checkin}">
					<input type="hidden" id="checkout" name="checkout" value="${bookingVO.checkout}">
					<input type="hidden" id="people" name="people" value="${bookingVO.people}">
                    <h2 class="mb-2">요금상세</h2>
                    <div class="bookingPayment__right mb-3">
                        <div class="bookingPayment__right__detail">
                            <div class="mb-3">
                                <label for="content">객실 요금 (1박: <fmt:formatNumber type="currency" value="${roomVO.price}"/>)</label>
                                <input type="text" class="form-control" value="<fmt:formatNumber type="currency" value="${roomPrice}"/>" readonly="readonly">
                            </div>
                            <div class="mb-3">
                                <label for="content">부가가치세 (10%)</label>
                                <input type="text" class="form-control" value="<fmt:formatNumber type="currency" value="${vat}"/>" readonly="readonly">
                            </div>
                            <div class="mb-3">
                                <label for="content">요금합계 (객실 요금 + 부가가치세)</label>
                                <input type="text" class="form-control" value="<fmt:formatNumber type="currency" value="${totalPrice}"/>" readonly="readonly">
                            </div>
                            <div class="mb-3">
                                <label for="subject">체크인 - 체크아웃 (${checkinout_cal}박)</label>
                                
                                <input type="text" class="form-control" value="${checkin} ~ ${checkout}" readonly="readonly">
                            </div>
                            <div class="mb-3">
                                <label for="subject">객실타입</label>
                                <input type="text" class="form-control" value="${roomVO.type}" readonly="readonly">
                            </div>
                            <div class="mb-3">
                                <label for="indate">투숙인원</label>
                                <input type="text" class="form-control" value="${bookingVO.people}명" readonly="readonly">
                            </div>
                        </div>
                    </div>
                    <div class="bookingPayment__right__button">
						<input type="button" class="btn btn-secondary btn-lg left" onclick="location.href='booking_button'" value="취소하기">
						<input type="button" class="btn btn-warning btn-lg right" onclick="booking_complete()" value="결제하기">
					</div>
                </form>
            </div>
        </div>
    </div>
</section>

<%@include file="../footer.jsp"%>