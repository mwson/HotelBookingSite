<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  

<%@include file="../header.jsp"%>

<div class="breadcrumb-option set-bg" data-setbg="images/breadcrumb-bg.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h1>자주하는 질문</h1>
                    <div class="breadcrumb__links">
                        <a href="index">메인</a>
                        <span>고객센터</span>
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
                        <h4>고객센터</h4>
                        <hr>
                        <ul>
                            <li><a href="notice_list">공지사항</a></li>
                            <li><a href="faq_list">자주하는 질문</a></li>
                            <li><a href="qna_write_form">문의하기</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="faqList col-lg-9 col-md-9">
                <h2 class="mb-4">자주하는 질문</h2>
                <div class="faqList_form col-lg-12 col-md-12">
                    <div class="faqList_form_table">
                    	<div class="contact__widget__item">
                            <h4>예약 시 나이제한이 있나요?</h4>
                            <p>객실을 예약하기 위해서는 만 18세 이상이어야 합니다.</p>
                        </div>
                        <div class="contact__widget__item">
                            <h4>일찍 체크인하고 늦게 체크아웃할 수 있나요?</h4>
                            <p>
                            	호텔 체크인은 오후 3시 이후, 체크아웃은 정오 12시 이전이 원칙이며<br>
								오후 3시 이전 Early Check-In 또는 12시 이후 Late Check-Out 하실 경우 추가 요금이 부과될 수 있습니다.
							</p>
                        </div>
                        <div class="contact__widget__item">
                            <h4>예약 시 인원을 추가할 수 있나요?</h4>
                            <p>
                            	객실에 따라 인원이 정해져 있으므로 예약 시 확인하실 수 있습니다.<br>
								예약 이후 인원 변경 및 추가로 인한 문의사항은 호텔로 연락 바랍니다.
							</p>
                        </div>
                        
                        <div class="contact__widget__item">
                            <h4>어린이 동반 시 영유아 용품을 제공해주실 수 있나요?</h4>
                            <p>
                            	투숙객 여러분의 편의를 위해 영유아 용품(아기욕조, 아기 침대, 어린이 베게 및 아동용 배스 로브와 슬리퍼)<br>
                            	를 제공해 드립니다.<br>
                            	<br>
                            	객실예약과를 통해 사전 요청 가능하며, 대출 요청이 완료된 영유아 용품,<br>
                            	엑스트라 베드는 체크인 당일 18시까지 객실에 준비해 드립니다.<br>
                            	(이용 상황에 따라 조기 마감될 수 있으며, 유모차는 현장에서만 대여 가능합니다.)
                            </p>
                        </div>
                        <div class="contact__widget__item">
                            <h4>유아 동반 시 추가 인원 요금을 내야하나요?</h4>
                            <p>
                            	37개월 미만의 유아 동반 시 추가 인원 요금 및 조식은 무료이며,<br>
  								유아(37개월 미만) 동반 여부는 체크인 시 프런트 데스크 직원에게<br>
  								알려 주셔야 무료로 이용 가능합니다.
  							</p>
                        </div>
                        <hr>
                        <div class="contact__widget__item">
                            <h4>연락처</h4>
                            <ul>
                                <li>02-1234-5678</li>
                                <li>green.reserve@email.com</li>
                            </ul>
                        </div>
                        <div class="contact__widget__time">
                            <h4>상담시간</h4>
                            <div class="row">
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="contact__widget__time__item">
                                        <ul>
                                            <li>평일(월 ~ 금요일)</li>
                                            <li><span>09:00 ~ 18:00</span></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="contact__widget__time__item">
                                        <ul>
                                            <li>주말 및 공휴일</li>
                                            <li><span>10:00 - 13:00</span></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<%@include file="../footer.jsp"%>