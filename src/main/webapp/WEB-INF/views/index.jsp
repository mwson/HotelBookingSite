<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>
	
<section class="hero spad set-bg" data-setbg="images/hero.png">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="hero__text">
                    <h5>호텔그린에 오신걸 환영합니다.</h5>
                    <h2>최고의 추억으로<br>만들어 드리겠습니다.</h2>
                </div>
				<div class="col-lg-11" style="margin: 0 5%;">
	                <form method="get" id="index_booking_form" name="index_booking_form">
						<div class="filter__form">
		                    <div class="filter__form__item">
		                        <p>체크인</p>
		                        <div class="filter__form__datepicker">
		                            <span class="icon_calendar"></span>
		                            <input type="text" class="datepicker_pop check__in" id="checkin" name="checkin">
		                            <i class="arrow_carrot-down"></i>
		                        </div>
		                    </div>
		                    <div class="filter__form__item">
		                        <p>체크아웃</p>
		                        <div class="filter__form__datepicker">
		                            <span class="icon_calendar"></span>
		                            <input type="text" class="datepicker_pop check__out" id="checkout" name="checkout">
		                            <i class="arrow_carrot-down"></i>
		                        </div>
		                    </div>
		                    <div class="filter__form__item filter__form__item--select">
		                        <p>인원</p>
		                        <div class="filter__form__select">
		                            <span class="icon_group"></span>
		                            <select id="people" name="people">
		                                <option value="1">1명</option>
		                                <option value="2">2명</option>
		                                <option value="3">3명</option>
		                                <option value="4">4명</option>
		                            </select>
		                        </div>
		                    </div>
		                    <input type="button" class="filter__form__button" onclick="index_booking_search()" value="예약하기">
	                    </div>
	                </form>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="home-about">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <div class="home__about__text">
                    <div class="section-title">
                        <h5>유구한 역사를 가진 호텔</h5>
                        <h2>호텔그린에 오신 여러분을<br>진심으로 환영합니다.</h2>
                    </div>
                    <p class="first-para">
                    	1981년 봄, 시가지와 교통발달에 유리한 서울특별시 동남부에 위치한 강남구에서 처음 창립된
						호텔그린은 풍수지리적으로 최고의 위치에 투숙객들을 편히 쉬게 하고자하는 경영자의 사상이 담겨있습니다.
						풍수에는 음양오행설을 바탕으로 한 동아시아의 자연관이 잘 나타나 있습니다.
					</p>
                    <p class="last-para">
						저희 호텔그린은 세련되고 고급진 인테리어 및 객실 디자인,
						넓은 야외수영장과 각종 편의시설들을 토대로
						투숙객 여러분께 최상의 서비스를 제공해드리기 위해 최선을 다하고 있습니다.
						저희와 함께 최고의 추억으로 만들어 드리겠습니다.
					</p>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="home__about__pic">
                    <img src="images/home-about/home-about.png" alt="메인소개">
                </div>
            </div>
        </div>
    </div>
</section>

<section class="home-room spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title">
                    <h5>객실 안내</h5>
                    <h2>그린호텔의 객실들을 둘러보세요</h2>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid">
	    <div class="row">
	        <div class="col-lg-3 col-md-6 col-sm-6 p-0">
	            <div class="home__room__item set-bg" data-setbg="images/home-room/hr-1.png">
	                <div class="home__room__title">
	                    <h4>스위트 룸</h4>
	                    <h2><sup>&#8361;</sup>400,000<span> / 1박</span></h2>
	                </div>
	                <a href="suite_room_detail">상세보기</a>
	            </div>
	        </div>
	        <div class="col-lg-3 col-md-6 col-sm-6 p-0">
	            <div class="home__room__item set-bg" data-setbg="images/home-room/hr-2.png">
	                <div class="home__room__title">
	                    <h4>슈페리어 룸</h4>
	                    <h2><sup>&#8361;</sup>300,000<span> / 1박</span></h2>
	                </div>
	                <a href="superior_room_detail">상세보기</a>
	            </div>
	        </div>
	        <div class="col-lg-3 col-md-6 col-sm-6 p-0">
	            <div class="home__room__item set-bg" data-setbg="images/home-room/hr-3.png">
	                <div class="home__room__title">
	                    <h4>디럭스 룸</h4>
	                    <h2><sup>&#8361;</sup>200,000<span> / 1박</span></h2>
	                </div>
	                <a href="deluxe_room_detail">상세보기</a>
	            </div>
	        </div>
	        <div class="col-lg-3 col-md-6 col-sm-6 p-0">
	            <div class="home__room__item set-bg" data-setbg="images/home-room/hr-4.png">
	                <div class="home__room__title">
	                    <h4>스탠다드 룸</h4>
	                    <h2><sup>&#8361;</sup>150,000<span> / 1박</span></h2>
	                </div>
	                <a href="standard_room_detail">상세보기</a>
	            </div>
	        </div>
	    </div>
	</div>
</section>

<section class="latest-blog spad_bottom">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title">
                    <h5>프로모션 &amp; 공지사항</h5>
                    <h2>놓치지마세요!</h2>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-3 p-0 order-lg-1 col-md-6 order-md-1">
                <div class="latest__blog__pic set-bg" data-setbg="notice_images/${pList1.image}"></div>
            </div>
            <div class="col-lg-3 p-0 order-lg-2 col-md-6 order-md-2">
                <div class="latest__blog__text">
                    <div class="label">${pList1.kind}</div>
                    <h5>${pList1.subject}</h5>
					<p>
                    	<i class="fa fa-clock-o"></i>
                    	<fmt:formatDate value="${pList1.indate}" type="date"/>
                    </p>
                    <a href="notice_detail?nseq=${pList1.nseq}">상세보기</a>
                </div>
            </div>
            <div class="col-lg-3 p-0 order-lg-3 col-md-6 order-md-4">
                <div class="latest__blog__pic set-bg" data-setbg="notice_images/${pList2.image}"></div>
            </div>
            <div class="col-lg-3 p-0 order-lg-4 col-md-6 order-md-3">
                <div class="latest__blog__text">
                    <div class="label">${pList2.kind}</div>
                    <h5>${pList2.subject}</h5>
                    <p>
                    	<i class="fa fa-clock-o"></i>
                    	<fmt:formatDate value="${pList2.indate}" type="date"/>
                    </p>
                    <a href="notice_detail?nseq=${pList2.nseq}">상세보기</a>
                </div>
            </div>
            <div class="col-lg-3 p-0 order-lg-6 col-md-6 order-md-5">
                <div class="latest__blog__pic latest__blog__pic__last__row set-bg" data-setbg="notice_images/${nList1.image}"></div>
            </div>
            <div class="col-lg-3 p-0 order-lg-5 col-md-6 order-md-6">
                <div class="latest__blog__text">
                    <div class="label">${nList1.kind}</div>
                    <h5>${nList1.subject}</h5>
					<p>
                    	<i class="fa fa-clock-o"></i>
                    	<fmt:formatDate value="${nList1.indate}" type="date"/>
                    </p>
                    <a href="notice_detail?nseq=${nList1.nseq}">상세보기</a>
                </div>
            </div>
            <div class="col-lg-3 p-0 order-lg-8 col-md-6 order-md-8">
                <div class="latest__blog__pic latest__blog__pic__last__row set-bg" data-setbg="notice_images/${nList2.image}"></div>
            </div>
            <div class="col-lg-3 p-0 order-lg-7 col-md-6 order-md-7">
                <div class="latest__blog__text">
                    <div class="label">${nList2.kind}</div>
                    <h5>${nList2.subject}</h5>
					<p>
                    	<i class="fa fa-clock-o"></i>
                    	<fmt:formatDate value="${nList2.indate}" type="date"/>
                    </p>
                    <a href="notice_detail?nseq=${nList2.nseq}">상세보기</a>
                </div>
            </div>
		</div>
    </div>
</section>
	    
<%@include file="footer.jsp"%>    