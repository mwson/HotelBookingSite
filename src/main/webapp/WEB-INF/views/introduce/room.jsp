<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  

<%@include file="../header.jsp"%>     

<div class="breadcrumb-option set-bg" data-setbg="images/breadcrumb-bg.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h1>객실안내</h1>
                    <div class="breadcrumb__links">
                        <a href="index">메인</a>
                        <span>호텔소개</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="rooms spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 p-0 order-lg-2 order-md-2 col-md-6">
                <div class="room__pic__slider owl-carousel">
                    <div class="room__pic__item set-bg" data-setbg="images/rooms/room-1.png"></div>
                    <div class="room__pic__item set-bg" data-setbg="images/rooms/room-5.png"></div>
                    <div class="room__pic__item set-bg" data-setbg="images/rooms/room-6.png"></div>
                    <div class="room__pic__item set-bg" data-setbg="images/rooms/room-7.png"></div>
                </div>
            </div>
            <div class="col-lg-6 p-0 order-lg-1 order-md-1 col-md-6">
                <div class="room__text">
                    <h3>${roomRid1.type}</h3>
                    <h2><sup>&#8361; </sup><fmt:formatNumber value="${roomRid1.price}" pattern="#,###"/><span> / 1박</span></h2>
                    <ul>
                        <li><span>크기:</span>30평</li>
                        <li><span>최대인원:</span>${roomRid1.people}인실</li>
                        <li><span>침대:</span>킹사이즈 2개</li>
                        <li><span>서비스:</span>와이파이, 65인치 티비, 욕조, 안마기, 소파, 에어드레서</li>
                        <li><span>뷰:</span>한강 뷰</li>
                    </ul>
                    <a href="suite_room_detail">상세보기</a>
                </div>
            </div>
            <div class="col-lg-6 p-0 order-lg-3 order-md-3 col-md-6">
                <div class="room__pic__slider owl-carousel">
                    <div class="room__pic__item set-bg" data-setbg="images/rooms/room-2.png"></div>
                    <div class="room__pic__item set-bg" data-setbg="images/rooms/room-5.png"></div>
                    <div class="room__pic__item set-bg" data-setbg="images/rooms/room-6.png"></div>
                    <div class="room__pic__item set-bg" data-setbg="images/rooms/room-7.png"></div>
                </div>
            </div>
            <div class="col-lg-6 p-0 order-lg-4 order-md-4 col-md-6">
                <div class="room__text right__text">
                    <h3>${roomRid2.type}</h3>
                    <h2><sup>&#8361; </sup><fmt:formatNumber value="${roomRid2.price}" pattern="#,###"/><span> / 1박</span></h2>
                    <ul>
                        <li><span>크기:</span>20평</li>
                        <li><span>최대인원:</span>${roomRid2.people}인실</li>
                        <li><span>침대:</span>킹사이즈 1개, 퀸사이즈 1개</li>
                        <li><span>서비스:</span>와이파이, 65인치 티비, 욕조, 안마기, 에어드레서</li>
                        <li><span>뷰:</span>한강 뷰</li>
                    </ul>
                    <a href="superior_room_detail">상세보기</a>
                </div>
            </div>
            <div class="col-lg-6 p-0 order-lg-6 order-md-6 col-md-6">
                <div class="room__pic__slider owl-carousel">
                    <div class="room__pic__item set-bg" data-setbg="images/rooms/room-3.png"></div>
                    <div class="room__pic__item set-bg" data-setbg="images/rooms/room-5.png"></div>
                    <div class="room__pic__item set-bg" data-setbg="images/rooms/room-6.png"></div>
                    <div class="room__pic__item set-bg" data-setbg="images/rooms/room-7.png"></div>
                </div>
            </div>
            <div class="col-lg-6 p-0 order-lg-5 order-md-5 col-md-6">
                <div class="room__text">
                    <h3>${roomRid3.type}</h3>
                    <h2><sup>&#8361; </sup><fmt:formatNumber value="${roomRid3.price}" pattern="#,###"/><span> / 1박</span></h2>
                    <ul>
                        <li><span>크기:</span>15평</li>
                        <li><span>최대인원:</span>${roomRid3.people}인실</li>
                        <li><span>침대:</span>킹사이즈 1개</li>
                        <li><span>서비스:</span>와이파이, 65인치 티비, 욕조, 에어드레서</li>
                        <li><span>뷰:</span>한강 뷰</li>
                    </ul>
                    <a href="deluxe_room_detail">상세보기</a>
                </div>
            </div>
            <div class="col-lg-6 p-0 order-lg-7 order-md-7 col-md-6">
                <div class="room__pic__slider owl-carousel">
                    <div class="room__pic__item set-bg" data-setbg="images/rooms/room-4.png"></div>
                    <div class="room__pic__item set-bg" data-setbg="images/rooms/room-5.png"></div>
                    <div class="room__pic__item set-bg" data-setbg="images/rooms/room-6.png"></div>
                    <div class="room__pic__item set-bg" data-setbg="images/rooms/room-7.png"></div>
                </div>
            </div>
            <div class="col-lg-6 p-0 order-lg-8 order-md-8 col-md-6">
                <div class="room__text right__text">
                    <h3>${roomRid4.type}</h3>
                    <h2><sup>&#8361; </sup><fmt:formatNumber value="${roomRid4.price}" pattern="#,###"/><span> / 1박</span></h2>
                    <ul>
                        <li><span>크기:</span>12평</li>
                        <li><span>최대인원:</span>${roomRid4.people}인실</li>
                        <li><span>침대:</span>트윈사이즈 2개</li>
                        <li><span>서비스:</span>와이파이, 65인치 티비, 욕조</li>
                        <li><span>뷰:</span>한강 뷰</li>
                    </ul>
                    <a href="standard_room_detail">상세보기</a>
                </div>
            </div>
        </div>
    </div>
</section>

<%@include file="../footer.jsp"%>