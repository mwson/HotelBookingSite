<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  

<%@include file="../header.jsp"%>

<div class="breadcrumb-option set-bg" data-setbg="images/breadcrumb-bg.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h1>예약하기</h1>
                    <div class="breadcrumb__links">
                        <a href="index">메인</a>
                        <span>예약</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="room-details spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <form method="get" id="booking_form" name="booking_form">
                    <div class="room__details__content">
                        <div class="room__details__title">
                            <h2>예약하기</h2>
                        </div>
                        <hr>
                        <div class="col-lg-11" style="margin: 0 5%;">
                            <div class="filter__form">
                                <div class="filter__form__item">
                                    <p>체크인</p>
                                    <div class="filter__form__datepicker">
                                        <span class="icon_calendar"></span>
                                        <input type="text" class="datepicker_pop" id="checkin" name="checkin" value="${bookingVO.checkin}">
                                        <i class="arrow_carrot-down"></i>
                                    </div>
                                </div>
                                <div class="filter__form__item">
                                    <p>체크아웃</p>
                                    <div class="filter__form__datepicker">
                                        <span class="icon_calendar"></span>
                                        <input type="text" class="datepicker_pop" id="checkout" name="checkout" value="${bookingVO.checkout}">
                                        <i class="arrow_carrot-down"></i>
                                    </div>
                                </div>
                                <div class="filter__form__item filter__form__item--select">
                                    <p>인원</p>
                                    <div class="filter__form__select">
                                        <span class="icon_group"></span>
                                        <select id="people" name="people">
                                            <c:choose>
                                                <c:when test='${bookingVO.people==1}'>
                                                    <option value="1" selected="selected">1명</option>
                                                    <option value="2">2명</option>
                                                    <option value="3">3명</option>
                                                    <option value="4">4명</option>
                                                </c:when>
                                                <c:when test='${bookingVO.people==2}'>
                                                    <option value="1">1명</option>
                                                    <option value="2" selected="selected">2명</option>
                                                    <option value="3">3명</option>
                                                    <option value="4">4명</option>
                                                </c:when>
                                                <c:when test='${bookingVO.people==3}'>
                                                    <option value="1">1명</option>
                                                    <option value="2">2명</option>
                                                    <option value="3" selected="selected">3명</option>
                                                    <option value="4">4명</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="1">1명</option>
                                                    <option value="2">2명</option>
                                                    <option value="3">3명</option>
                                                    <option value="4" selected="selected">4명</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </select>
                                    </div>
                                </div>
                                <input type="button" class="filter__form__button" onclick="booking_search()" value="검색하기">
                            </div>
                        </div>
                        <hr class="mb-5">
                        <div class="BookingSearch">
                            <div class="col-lg-4 col-md-4">
                                <div class="BookingSearch__item__large">
                                    <div class="BookingSearch__item__large__pic">
                                        <a href="suite_room_detail"><img src="images/booking-search/bs-1.png" alt=""></a>
                                        <div class="tag">스위트 룸</div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-8 col-md-8">
                                <div class="BookingSearch__details__rating">
                                    <div class="BookingSearch__details__hotel mb-2">
                                        <a href="suite_room_detail">스위트 룸</a>
                                        <div class="BookingSearch__details__hotel__rating">
                                            <span class="icon_star"></span>
                                            <span class="icon_star"></span>
                                            <span class="icon_star"></span>
                                            <span class="icon_star"></span>
                                            <span class="icon_star"></span>
                                        </div>
                                    </div>
                                    <div class="BookingSearch__details__advisor">
                                        <img src="images/booking-search/tripadvisor.png" alt="">
                                        <c:choose>
                                            <c:when test='${suiteRoom=="1"}'>
                                                <span class="review" style="color: #007BFF">예약가능</span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="review" style="color: #f44336">예약불가</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                    <div class="BookingSearch__details__facilities mb-3">
                                        <ul>
                                            <li><span class="icon_check"></span> 크기 : 30평</li>
                                            <li><span class="icon_check"></span> 최대인원 : 4인실</li>
                                            <li><span class="icon_check"></span> 침대 : 킹사이즈 2개</li>
                                        </ul>
                                    </div>
                                    <div class="BookingSearch__text">
                                        <h5><sup>&#8361; </sup>400,000<span> / 1박</span></h5>
                                        <c:choose>
                                            <c:when test='${suiteRoom=="1"}'>
                                                <input type="button" class="btn btn-warning" id="suite_room" name="suite_room" onclick="booking_suite()" value="예약하기">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="button" class="btn btn-secondary" onclick="booking_fail()" value="예약불가">
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr class="mb-5">
                        <div class="BookingSearch">
                            <div class="col-lg-4 col-md-4">
                                <div class="BookingSearch__item__large">
                                    <div class="BookingSearch__item__large__pic">
                                        <a href="superior_room_detail"><img src="images/booking-search/bs-2.png" alt=""></a>
                                        <div class="tag">슈페리어 룸</div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-8 col-md-8">
                                <div class="BookingSearch__details__rating">
                                    <div class="BookingSearch__details__hotel mb-2">
                                        <a href="superior_room_detail">슈페리어 룸</a>
                                        <div class="BookingSearch__details__hotel__rating">
                                            <span class="icon_star"></span>
                                            <span class="icon_star"></span>
                                            <span class="icon_star"></span>
                                            <span class="icon_star"></span>
                                            <span class="icon_star-half_alt"></span>
                                        </div>
                                    </div>
                                    <div class="BookingSearch__details__advisor">
                                        <img src="images/booking-search/tripadvisor.png" alt="">
                                        <c:choose>
                                            <c:when test='${superiorRoom=="1"}'>
                                                <span class="review" style="color: #007BFF">예약가능</span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="review" style="color: #f44336">예약불가</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                    <div class="BookingSearch__details__facilities mb-3">
                                        <ul>
                                            <li><span class="icon_check"></span> 크기 : 20평</li>
                                            <li><span class="icon_check"></span> 최대인원 : 3인실</li>
                                            <li><span class="icon_check"></span> 침대 : 킹사이즈 1개, 퀸사이즈 1개</li>
                                        </ul>
                                    </div>
                                    <div class="BookingSearch__text">
                                        <h5><sup>&#8361; </sup>300,000<span> / 1박</span></h5>
                                        <c:choose>
                                            <c:when test='${superiorRoom=="1"}'>
                                                <input type="button" class="btn btn-warning" id="superior_room" name="superior_room" onclick="booking_superior()" value="예약하기">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="button" class="btn btn-secondary" onclick="booking_fail()" value="예약불가">
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr class="mb-5">
                        <div class="BookingSearch">
                            <div class="col-lg-4 col-md-4">
                                <div class="BookingSearch__item__large">
                                    <div class="BookingSearch__item__large__pic">
                                        <a href="deluxe_room_detail"><img src="images/booking-search/bs-3.png" alt=""></a>
                                        <div class="tag">디럭스 룸</div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-8 col-md-8">
                                <div class="BookingSearch__details__rating">
                                    <div class="BookingSearch__details__hotel mb-2">
                                        <a href="deluxe_room_detail">디럭스 룸</a>
                                        <div class="BookingSearch__details__hotel__rating">
                                            <span class="icon_star"></span>
                                            <span class="icon_star"></span>
                                            <span class="icon_star"></span>
                                            <span class="icon_star"></span>
                                            <span class="icon_star_alt"></span>
                                        </div>
                                    </div>
                                    <div class="BookingSearch__details__advisor">
                                        <img src="images/booking-search/tripadvisor.png" alt="">
                                        <c:choose>
                                            <c:when test='${deluxeRoom=="1"}'>
                                                <span class="review" style="color: #007BFF">예약가능</span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="review" style="color: #f44336">예약불가</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                    <div class="BookingSearch__details__facilities mb-3">
                                        <ul>
                                            <li><span class="icon_check"></span> 크기 : 15평</li>
                                            <li><span class="icon_check"></span> 최대인원 : 2인실</li>
                                            <li><span class="icon_check"></span> 침대 : 킹사이즈 1개</li>
                                        </ul>
                                    </div>
                                    <div class="BookingSearch__text">
                                        <h5><sup>&#8361; </sup>250,000<span> / 1박</span></h5>
                                        <c:choose>
                                            <c:when test='${deluxeRoom=="1"}'>
                                                <input type="button" class="btn btn-warning" id="deluxe_room" name="deluxe_room" onclick="booking_deluxe()" value="예약하기">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="button" class="btn btn-secondary" onclick="booking_fail()" value="예약불가">
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr class="mb-5">
                        <div class="BookingSearch">
                            <div class="col-lg-4 col-md-4">
                                <div class="BookingSearch__item__large">
                                    <div class="BookingSearch__item__large__pic">
                                        <a href="standard_room_detail"><img src="images/booking-search/bs-4.png" alt=""></a>
                                        <div class="tag">스탠다드 룸</div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-8 col-md-8">
                                <div class="BookingSearch__details__rating">
                                    <div class="BookingSearch__details__hotel mb-2">
                                        <a href="standard_room_detail">스탠다드 룸</a>
                                        <div class="BookingSearch__details__hotel__rating">
                                            <span class="icon_star"></span>
                                            <span class="icon_star"></span>
                                            <span class="icon_star"></span>
                                            <span class="icon_star-half_alt"></span>
                                            <span class="icon_star_alt"></span>
                                        </div>
                                    </div>
                                    <div class="BookingSearch__details__advisor">
                                        <img src="images/booking-search/tripadvisor.png" alt="">
                                        <c:choose>
                                            <c:when test='${standardRoom=="1"}'>
                                                <span class="review" style="color: #007BFF">예약가능</span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="review" style="color: #f44336">예약불가</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                    <div class="BookingSearch__details__facilities mb-3">
                                        <ul>
                                            <li><span class="icon_check"></span> 크기 : 12평</li>
                                            <li><span class="icon_check"></span> 최대인원 : 2인실</li>
                                            <li><span class="icon_check"></span> 침대 : 트윈사이즈 침대 2개</li>
                                        </ul>
                                    </div>
                                    <div class="BookingSearch__text" style="margin-bottom: 0;">
                                        <h5><sup>&#8361; </sup>200,000<span> / 1박</span></h5>
                                        <c:choose>
                                            <c:when test='${standardRoom=="1"}'>
                                                <input type="button" class="btn btn-warning" id="standard_room" name="standard_room" onclick="booking_standard()" value="예약하기">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="button" class="btn btn-secondary" onclick="booking_fail()" value="예약불가">
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<%@include file="../footer.jsp"%>