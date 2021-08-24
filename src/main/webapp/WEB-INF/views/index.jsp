<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>
	
<section class="hero spad set-bg" data-setbg="img/hero.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="hero__text">
                    <h5>호텔그린에 오신걸 환영합니다.</h5>
                    <h2>최고의 추억으로<br>만들어 드리겠습니다.</h2>
                </div>
                <form method="get" action="booking_search">
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
	                    <div class="filter__form__item filter__form__item--select">
	                        <p>객실</p>
	                        <div class="filter__form__select">
	                            <span class="icon_check_alt"></span>
	                            <select id="room" name="room">
	                                <option value="1">1</option>
	                            </select>
	                        </div>
	                    </div>
	                    <input type="submit" class="filter__form__button" value="예약하기">
                    </div>
                </form>
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
                    <p class="first-para">1981년 봄, 서울 중심부인 남산 아래, 한강을 내려다보는 위치에 처음 창립된
                    	호텔그린은 풍수지리적으로 최고의 위치에 투숙객들을 편히 쉬게 하고자하는 경영자의 사상이 담겨있습니다.
			                           풍수에는 음양오행설을 바탕으로 한 동아시아의 자연관이 잘 나타나 있습니다.</p>
			        <p class="last-para">저희 호텔그린은 세련되고 고급진 인테리어 및 객실 디자인,
			                            넓은 야외수영장과 각종 편의시설들을 토대로
			                            투숙객 여러분께 최상의 서비스를 제공해드리기 위해 최선을 다하고 있습니다.</p>
                    <img src="img/home-about/sign.png" alt="">
                </div>
            </div>
            <div class="col-lg-6">
                <div class="home__about__pic">
                    <img src="img/home-about/home-about.png" alt="">
                </div>
            </div>
        </div>
    </div>
</section>

<section class="services spad">
    <div class="container">
        <div class="row">
			<div class="col-lg-4 col-md-4 col-sm-6">
			    <div class="services__item">
			        <img src="img/services/services-1.png" alt="">
			        <h4>Free Wi-Fi</h4>
			        <p>호텔로비, 전 객실에 무료 와이파이를 제공하고 있습니다. 쾌적하게 이용하세요.</p>
			    </div>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-6">
			    <div class="services__item">
			        <img src="img/services/services-2.png" alt="">
			        <h4>Premium Pool</h4>
			        <p>7500 제곱미터에 달하는 넓은 야외 수영장에서 호캉스를 마음껏 즐기세요. </p>
			    </div>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-6">
			    <div class="services__item">
			        <img src="img/services/services-3.png" alt="">
			        <h4>Coffee Maker</h4>
			        <p>한강뷰 카페에서 여유로운 커피 한잔 어떠신가요?</p>
			    </div>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-6">
			    <div class="services__item">
			        <img src="img/services/services-4.png" alt="">
			        <h4>Rooftop Bar</h4>
			        <p>서울시내가 내려다보이는 루프탑바에서 숙련된 바텐더의 칵테일을 즐겨보세요.</p>
			    </div>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-6">
			    <div class="services__item">
			        <img src="img/services/services-5.png" alt="">
			        <h4>TV HD</h4>
			        <p>전 객실에 65인치 TV가 설치되어 있습니다.</p>
			    </div>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-6">
			    <div class="services__item">
			        <img src="img/services/services-6.png" alt="">
			        <h4>Restaurant</h4>
			        <p>미식의 향연! 7층 푸드코트에서 다양한 프랜차이즈 레스토랑들을 만나보세요.</p>
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
                <div class="home__room__item set-bg" data-setbg="img/home-room/hr-1.jpg">
                    <div class="home__room__title">
                        <h4>스탠다드 룸</h4>
                        <h2><sup>&#8361;</sup>150,000<span> / 1박</span></h2>
                    </div>
                    <a href="#">예약하기</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6 p-0">
                <div class="home__room__item set-bg" data-setbg="img/home-room/hr-2.jpg">
                    <div class="home__room__title">
                        <h4>디럭스 룸</h4>
                        <h2><sup>&#8361;</sup>200,000<span> / 1박</span></h2>
                    </div>
                    <a href="#">예약하기</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6 p-0">
                <div class="home__room__item set-bg" data-setbg="img/home-room/hr-3.jpg">
                    <div class="home__room__title">
                        <h4>슈페리어 룸</h4>
                        <h2><sup>&#8361;</sup>300,000<span> / 1박</span></h2>
                    </div>
                    <a href="#">예약하기</a>
                </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6 p-0">
                <div class="home__room__item set-bg" data-setbg="img/home-room/hr-4.jpg">
                    <div class="home__room__title">
                        <h4>스위트 룸</h4>
                        <h2><sup>&#8361;</sup>400,000<span> / 1박</span></h2>
                    </div>
                    <a href="#">예약하기</a>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Home Room Section End -->

<!-- Testimonial Section Begin -->
<section class="testimonial spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-5">
                <div class="testimonial__pic">
                    <img src="img/testimonial-left.jpg" alt="">
                </div>
            </div>
            <div class="col-lg-7">
                <div class="testimonial__text">
                    <div class="section-title">
                        <h5>Testimonials</h5>
                        <h2>What do customers say about us?</h2>
                    </div>
                    <div class="testimonial__slider__content">
                        <div class="testimonial__slider owl-carousel">
                            <div class="testimonial__item">
                                <h5>Detailed Review:</h5>
                                <div class="rating">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star-o"></i>
                                </div>
                                <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu
                                    fugiat nulla pariatur. Excepteur sint occaecat cupidat non proident, sunt in
                                    culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde
                                    omnis iste natus error sit voluptatem accusantium doloremque laudantium.</p>
                                <div class="testimonial__author">
                                    <div class="row">
                                        <div class="col-lg-6 col-md-6">
                                            <div class="testimonial__author__title">
                                                <h5>Ridchard Houston</h5>
                                                <span>Director Colorlib</span>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6">
                                            <div class="testimonial__author__social">
                                                <a href="#"><i class="fa fa-facebook"></i></a>
                                                <a href="#"><i class="fa fa-twitter"></i></a>
                                                <a href="#"><i class="fa fa-linkedin"></i></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="testimonial__item">
                                <h5>Detailed Review:</h5>
                                <div class="rating">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star-o"></i>
                                </div>
                                <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu
                                    fugiat nulla pariatur. Excepteur sint occaecat cupidat non proident, sunt in
                                    culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde
                                    omnis iste natus error sit voluptatem accusantium doloremque laudantium.</p>
                                <div class="testimonial__author">
                                    <div class="row">
                                        <div class="col-lg-6 col-md-6">
                                            <div class="testimonial__author__title">
                                                <h5>John Smith</h5>
                                                <span>Director Colorlib</span>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6">
                                            <div class="testimonial__author__social">
                                                <a href="#"><i class="fa fa-facebook"></i></a>
                                                <a href="#"><i class="fa fa-twitter"></i></a>
                                                <a href="#"><i class="fa fa-linkedin"></i></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="testimonial__item">
                                <h5>Detailed Review:</h5>
                                <div class="rating">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star-o"></i>
                                </div>
                                <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu
                                    fugiat nulla pariatur. Excepteur sint occaecat cupidat non proident, sunt in
                                    culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde
                                    omnis iste natus error sit voluptatem accusantium doloremque laudantium.</p>
                                <div class="testimonial__author">
                                    <div class="row">
                                        <div class="col-lg-6 col-md-6">
                                            <div class="testimonial__author__title">
                                                <h5>Jack Kelly</h5>
                                                <span>Director Colorlib</span>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6">
                                            <div class="testimonial__author__social">
                                                <a href="#"><i class="fa fa-facebook"></i></a>
                                                <a href="#"><i class="fa fa-twitter"></i></a>
                                                <a href="#"><i class="fa fa-linkedin"></i></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="testimonial__item">
                                <h5>Detailed Review:</h5>
                                <div class="rating">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star-o"></i>
                                </div>
                                <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu
                                    fugiat nulla pariatur. Excepteur sint occaecat cupidat non proident, sunt in
                                    culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde
                                    omnis iste natus error sit voluptatem accusantium doloremque laudantium.</p>
                                <div class="testimonial__author">
                                    <div class="row">
                                        <div class="col-lg-6 col-md-6">
                                            <div class="testimonial__author__title">
                                                <h5>Richard Hobson</h5>
                                                <span>Director Colorlib</span>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-6">
                                            <div class="testimonial__author__social">
                                                <a href="#"><i class="fa fa-facebook"></i></a>
                                                <a href="#"><i class="fa fa-twitter"></i></a>
                                                <a href="#"><i class="fa fa-linkedin"></i></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="slide-num" id="snh-1"></div>
                        <div class="slider__progress"><span></span></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<div class="chooseus spad set-bg" data-setbg="img/chooseus-bg.jpg">
    <div class="container">
        <div class="row d-flex justify-content-center">
            <div class="col-lg-8 text-center">
                <div class="chooseus__text">
                    <div class="section-title">
                        <h5>지금 예약하세요!</h5>
                        <h2>최상의 프로모션 혜택<br>지금 연락주세요!</h2>
                    </div>
                    <a href="#" class="primary-btn">예약하기</a>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="latest-blog spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title">
                    <h5>프로모션 & 공지사항</h5>
                    <h2>놓치지마세요!</h2>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-3 p-0 order-lg-1 col-md-6 order-md-1">
                <div class="latest__blog__pic set-bg" data-setbg="img/latest-blog/lb-1.jpg"></div>
            </div>
            <div class="col-lg-3 p-0 order-lg-2 col-md-6 order-md-2">
                <div class="latest__blog__text">
                    <div class="label">호텔</div>
                    <h5>스위트 룸 같이 둘러봐요!</h5>
                    <p><i class="fa fa-clock-o"></i>(수정)공지사항 작성일 불러오기</p>
                    <a href="#">더보기</a>
                </div>
            </div>
            <div class="col-lg-3 p-0 order-lg-3 col-md-6 order-md-4">
                <div class="latest__blog__pic set-bg" data-setbg="img/latest-blog/lb-2.jpg"></div>
            </div>
            <div class="col-lg-3 p-0 order-lg-4 col-md-6 order-md-3">
                <div class="latest__blog__text">
                    <div class="label">레스토랑</div>
                    <h5>국내 최고 프랜차이즈 레스토랑들을 그린호텔에서 만나보세요!</h5>
                    <p><i class="fa fa-clock-o"></i>(수정)공지사항 작성일 불러오기</p>
                    <a href="#">더보기</a>
                </div>
            </div>
            <div class="col-lg-3 p-0 order-lg-6 col-md-6 order-md-5">
                <div class="latest__blog__pic latest__blog__pic__last__row set-bg"
                    data-setbg="img/latest-blog/lb-3.jpg"></div>
            </div>
            <div class="col-lg-3 p-0 order-lg-5 col-md-6 order-md-6">
                <div class="latest__blog__text">
                    <div class="label">여행</div>
                    <h5>용산에서 가볼만한 명소 TOP3!</h5>
                    <p><i class="fa fa-clock-o"></i>(수정)공지사항 작성일 불러오기</p>
                    <a href="#">더보기</a>
                </div>
            </div>
            <div class="col-lg-3 p-0 order-lg-8 col-md-6 order-md-8">
                <div class="latest__blog__pic latest__blog__pic__last__row set-bg"
                    data-setbg="img/latest-blog/lb-4.jpg"></div>
            </div>
            <div class="col-lg-3 p-0 order-lg-7 col-md-6 order-md-7">
                <div class="latest__blog__text">
                    <div class="label">예약</div>
                    <h5>그린호텔 예약잡는 방법 전부 공개합니다.</h5>
                    <p><i class="fa fa-clock-o"></i>(수정)공지사항 작성일 불러오기</p>
                    <a href="#">더보기</a>
                </div>
            </div>
        </div>
    </div>
</section>
	    
<%@include file="footer.jsp"%>    