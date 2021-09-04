<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  

<%@include file="../header.jsp"%>  

<div class="breadcrumb-option set-bg" data-setbg="images/breadcrumb-bg.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h1>회원정보 수정</h1>
                    <div class="breadcrumb__links">
                        <a href="index">메인</a>
                        <span>마이페이지</span>
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
                        <h4>마이페이지</h4>
                        <hr>
                        <ul>
                            <li><a href="booking_list">예약확인</a></li>
                            <li><a href="qna_list">문의내역</a></li>
                            <li><a href="update_member_form">회원정보 수정</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="login col-lg-9 col-md-9">
                <h2 class="mb-4">비밀번호 확인</h2>
                <form method="post" id="pwdCheck_form" name="pwdCheck_form">
                    <div style="padding: 10px;">
                        <div class="login_form col-lg-5 col-md-5">
                            <div class="login_form_input">
                                <div class="mb-4">
                                    <label for="pwd">비밀번호</label> 
                                    <input type="password" class="form-control" id="pwd" name="pwd" placeholder="비밀번호">
                                </div>
                            </div>
                            <hr>
                            <div class="login_form_button mb-4">
                                <div class="register">
                                    <a href="#" class="a" onclick="pwdCheck_find_pwd_form()">비밀번호 찾기</a>
                                </div>
                                <div class="login_form_button_clear"></div>
                            </div>
                            <div class="login_form_button">
                                <input type="button" class="btn btn-warning btn-lg btn-block" onclick="update_member_form_pwdCheck()" value="확인">
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<%@include file="../footer.jsp"%>