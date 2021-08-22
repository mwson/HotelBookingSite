<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  

<%@include file="../header.jsp"%>

<div class="breadcrumb-option set-bg" data-setbg="img/breadcrumb-bg.jpg">
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
                            <li><a href="#">자주하는 질문</a></li>
                            <li><a href="#">문의하기</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="faqList col-lg-9 col-md-9">
                <h2 class="mb-4">자주하는 질문</h2>
                <div class="faqList_form col-lg-12 col-md-12">
                    <div class="faqList_form_table">
                        <div class="contact__widget__item">
                            <h4>일찍 체크인하고 늦게 체크아웃할 수 있나요?</h4>
                            <p>호텔 체크인은 원칙상 오후 3시 이후, 체크아웃은 오후 1시 이전으로 하고 있으나<br>
								 호텔에 미리 문의하시면 시간을 조정해드릴 수 있습니다.<br>
								 호텔 문의 전화번호는 하단에서 확인하실 수 있습니다.</p>
                        </div>
                        <div class="contact__widget__item">
                            <h4>객실 예약 시 추가 인원을 등록할 수 있나요?</h4>
                            <p>더 많은 투숙객을 수용하고 싶으신 경우 예약을 바꾸셔야 합니다.<br>
								인원수 추가에 따른 추가비용은 업데이트된 예약사항을 확인하시기 전에 공지해 드립니다.</p>
                        </div>
                        <div class="contact__widget__item">
                            <h4>객실 예약 시 나이제한이 있나요?</h4>
                            <p>객실을 예약하기 위해서는 만 18세 이상이셔야 합니다.</p>
                        </div>
                        <div class="contact__widget__item">
                            <h4>아기 동반 시 유아용 침대를 제공해주실 수 있나요?</h4>
                            <p>투숙객 여러분의 편의를 위해 가능한 모든 것을 제공해 드립니다.<br>
								예약 시, 혹은 체크인 시 말씀해주시면 됩니다.</p>
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