<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  

<%@include file="../header.jsp"%>

<div class="breadcrumb-option set-bg" data-setbg="images/breadcrumb-bg.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h1>결제완료</h1>
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
            <div class="bookingComplete col-lg-12 col-md-12">
                <h2 class="mb-4">결제완료</h2>
                <div class="bookingComplete_form">
                    <div class="bookingComplete_form_color">
                        <h5 class="mb-3">예약정보</h5>
                        <div class="bookingComplete_form_table">
                            <table class="table table-striped">
                                <tr>
                                    <th style="width: 15%">예약상태</th>
                                    <td>
                                        <c:choose>
                                            <c:when test='${bookingVO.result=="1"}'>
                                                <span class="review" style="color: #007BFF">예약대기</span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="review" style="color: #f44336">예약완료</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                                <tr>
                                    <th style="width: 15%">예약번호</th>
                                    <td>${bookingVO.bseq}</td> 
                                </tr>
                                <tr>
                                    <th style="width: 15%">예약자</th>
                                    <td>${bookingVO.name}</td> 
                                </tr>
                                <tr>
                                    <th style="width: 15%">체크인날짜</th>
                                    <td>${checkin}</td> 
                                </tr>
                                <tr>
                                    <th style="width: 15%">체크아웃날짜</th>    
                                    <td>${checkout}</td> 
                                </tr>
                                <tr>
                                    <th style="width: 15%">객실타입</th>
                                    <td>${bookingVO.type}</td> 
                                </tr>
                                <tr>
                                    <th style="width: 15%">투숙인원</th>
                                    <td>${bookingVO.people}명</td> 
                                </tr>
                            </table>
                        </div>
                        <hr class="mb-4">
                        <h5 class="mb-3">요금상세</h5>
                        <div class="bookingComplete_form_table">
                            <div class="mb-3">
                                <label for="indate">객실요금 (1박: <fmt:formatNumber type="currency" value="${bookingVO.price}"/>)</label>
                                <input type="text" class="form-control" value="<fmt:formatNumber type="currency" value="${roomPrice}"/> (${checkinout_cal}박)" readonly="readonly">
                            </div>
                            <div class="mb-3">
                                <label for="indate">부가가치세 (10%)</label>
                                <input type="text" class="form-control" value="<fmt:formatNumber type="currency" value="${vat}"/>" readonly="readonly">
                            </div>
                        </div>
                        <hr class="mb-4">
                        <div class="bookingComplete_form_total" style="float: right;">
                            <div class="bookingComplete_form_total_text">
                                <h5 class="mb-4" style="margin-right: 4px">요금합계:</h5>
                            </div>
                            <fmt:formatNumber type="currency" value="${totalPrice}"/>
                        </div>
                        <br>
                    </div>
                    <div class="bookingComplete_button">
                        <input type="button" class="btn btn-secondary btn-lg left" onclick="location.href='booking_button'" value="예약 계속하기">
                        <input type="button" class="btn btn-warning btn-lg right" onclick="location.href='booking_list'" value="예약조회">
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<%@include file="../footer.jsp"%>