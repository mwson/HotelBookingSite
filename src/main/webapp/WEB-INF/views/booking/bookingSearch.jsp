<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  

<%@include file="../header.jsp"%>

<div class="breadcrumb-option set-bg" data-setbg="images/hbg-1.jpg">
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
                <input type="hidden" id="roomRid" name="roomRid">
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
                                        <!-- <a href="suite_room_detail"><img src="notice_images/${roomRid1.image}" alt=""></a> -->
                                        <div class="tag">${roomRid1.type}</div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-8 col-md-8">
                                <div class="BookingSearch__details__rating">
                                    <div class="BookingSearch__details__hotel mb-2">
                                        <a href="suite_room_detail">${roomRid1.type}</a>
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
                                            <c:when test="${bookingRid1==0}">
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
                                            <li><span class="icon_check"></span> 최대인원 : ${roomRid1.people}인실</li>
                                            <li><span class="icon_check"></span> 침대 : ${roomRid1.bed}</li>
                                        </ul>
                                    </div>
                                    <div class="BookingSearch__text">
                                        <h5><sup>&#8361; </sup><fmt:formatNumber value="${roomRid1.price}" pattern="#,###"/><span> / 1박</span> ~</h5>
                                        <c:choose>
                                            <c:when test="${bookingRid1==0}">
                                                <input type="button" class="btn btn-warning" onclick="booking_rid1()" value="예약하기">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="button" class="btn btn-secondary" onclick="booking_rid1_fail()" value="예약불가">
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
                                        <!-- <a href="suite_room_detail"><img src="notice_images/${roomRid2.image}" alt=""></a> -->
                                        <div class="tag">${roomRid2.type}</div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-8 col-md-8">
                                <div class="BookingSearch__details__rating">
                                    <div class="BookingSearch__details__hotel mb-2">
                                        <a href="superior_room_detail">${roomRid2.type}</a>
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
                                            <c:when test="${bookingRid2==0}">
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
                                            <li><span class="icon_check"></span> 최대인원 : ${roomRid2.people}인실</li>
                                            <li><span class="icon_check"></span> 침대 : ${roomRid2.bed}</li>
                                        </ul>
                                    </div>
                                    <div class="BookingSearch__text">
                                        <h5><sup>&#8361; </sup><fmt:formatNumber value="${roomRid2.price}" pattern="#,###"/><span> / 1박</span> ~</h5>
                                        <c:choose>
                                            <c:when test="${bookingRid2==0}">
                                                <input type="button" class="btn btn-warning" onclick="booking_rid2()" value="예약하기">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="button" class="btn btn-secondary" onclick="booking_rid2_fail()" value="예약불가">
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
                                        <!-- <a href="suite_room_detail"><img src="notice_images/${roomRid3.image}" alt=""></a> -->
                                        <div class="tag">${roomRid3.type}</div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-8 col-md-8">
                                <div class="BookingSearch__details__rating">
                                    <div class="BookingSearch__details__hotel mb-2">
                                        <a href="deluxe_room_detail">${roomRid3.type}</a>
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
                                            <c:when test="${bookingRid3==0}">
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
                                            <li><span class="icon_check"></span> 최대인원 : ${roomRid3.people}인실</li>
                                            <li><span class="icon_check"></span> 침대 : ${roomRid3.bed}</li>
                                        </ul>
                                    </div>
                                    <div class="BookingSearch__text">
                                        <h5><sup>&#8361; </sup><fmt:formatNumber value="${roomRid3.price}" pattern="#,###"/><span> / 1박</span> ~</h5>
                                        <c:choose>
                                            <c:when test="${bookingRid3==0}">
                                                <input type="button" class="btn btn-warning" onclick="booking_rid3()" value="예약하기">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="button" class="btn btn-secondary" onclick="booking_rid3_fail()" value="예약불가">
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
                                        <!-- <a href="suite_room_detail"><img src="notice_images/${roomRid4.image}" alt=""></a> -->
                                        <div class="tag">${roomRid4.type}</div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-8 col-md-8">
                                <div class="BookingSearch__details__rating">
                                    <div class="BookingSearch__details__hotel mb-2">
                                        <a href="standard_room_detail">${roomRid4.type}</a>
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
                                            <c:when test="${bookingRid4==0}">
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
                                            <li><span class="icon_check"></span> 최대인원 : ${roomRid4.people}인실</li>
                                            <li><span class="icon_check"></span> 침대 : ${roomRid4.bed}</li>
                                        </ul>
                                    </div>
                                    <div class="BookingSearch__text" style="margin-bottom: 0;">
                                        <h5><sup>&#8361; </sup><fmt:formatNumber value="${roomRid4.price}" pattern="#,###"/><span> / 1박</span> ~</h5>
                                        <c:choose>
                                            <c:when test="${bookingRid4==0}">
                                                <input type="button" class="btn btn-warning" onclick="booking_rid4()" value="예약하기">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="button" class="btn btn-secondary" onclick="booking_rid4_fail()" value="예약불가">
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