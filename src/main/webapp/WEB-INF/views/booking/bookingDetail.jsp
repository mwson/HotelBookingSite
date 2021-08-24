<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  

<%@include file="../header.jsp"%>

<div class="room-details-slider">
    <div class="container">
        <div class="room__details__pic__slider owl-carousel">
            <div class="room__details__pic__slider__item set-bg" data-setbg="img/rooms/details/rd-1.jpg"></div>
            <div class="room__details__pic__slider__item set-bg" data-setbg="img/rooms/details/rd-2.jpg"></div>
            <div class="room__details__pic__slider__item set-bg" data-setbg="img/rooms/details/rd-3.jpg"></div>
            <div class="room__details__pic__slider__item set-bg" data-setbg="img/rooms/details/rd-4.jpg"></div>
        </div>
    </div>
</div>

<section class="blog spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-7 col-md-7">
                <h2 class="mb-2">예약자 정보</h2>
                <div class="bookingDetail__left">
                    <div class="bookingDetail__left__detail">
                        <div class="mb-3">
                            <label for="subject">예약자</label>
                            <input type="text" class="form-control" value="" readonly="readonly">
                        </div>
                        <div class="mb-3">
                            <label for="subject">이메일</label>
                            <input type="text" class="form-control" value="" readonly="readonly">
                        </div>
                        <div class="mb-3">
                            <label for="indate">휴대폰번호</label>
                            <input type="text" class="form-control" value="" readonly="readonly">
                        </div>
                    </div>
                </div>
                <hr class="mb-4">
                <h2 class="mb-2">객실 상세</h2>
                <div class="bookingDetail__left">
                    <div class="bookingDetail__left__detail">
                        <div class="mb-3">
                            <label for="subject">1</label>
                            <input type="text" class="form-control" value="" readonly="readonly">
                        </div>
                        <div class="mb-3">
                            <label for="subject">2</label>
                            <input type="text" class="form-control" value="" readonly="readonly">
                        </div>
                        <div class="mb-3">
                            <label for="indate">3</label>
                            <input type="text" class="form-control" value="" readonly="readonly">
                        </div>
                        <div class="mb-3">
                            <label for="content">4</label>
                            <textarea class="form-control mb-3" rows="8" readonly></textarea>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="col-lg-5 col-md-5">
                <form>
                    <h2 class="mb-2">결제</h2>
                    <div class="bookingDetail__right mb-3">
                        <div class="bookingDetail__right__detail">
                            <div class="mb-3">
                                <label for="content">가격</label>
                                <input type="text" class="form-control" value="" readonly="readonly">
                            </div>
                            <div class="mb-3">
                                <label for="subject">일자</label>
                                <input type="text" class="form-control" value="" readonly="readonly">
                            </div>
                            <div class="mb-3">
                                <label for="subject">객실</label>
                                <input type="text" class="form-control" value="" readonly="readonly">
                            </div>
                            <div class="mb-3">
                                <label for="indate">인원</label>
                                <input type="text" class="form-control" value="" readonly="readonly">
                            </div>
                        </div>
                    </div>
                    <div class="bookingDetail__right__button" style="text-align: center;">
                        <input type="button" class="btn btn-warning btn-lg" value="결제하기">
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<%@include file="../footer.jsp"%>