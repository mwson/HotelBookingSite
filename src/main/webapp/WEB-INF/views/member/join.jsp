<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../header.jsp"%>   

<div class="breadcrumb-option set-bg" data-setbg="img/breadcrumb-bg.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h1>로그인</h1>
                    <div class="breadcrumb__links">
                        <a href="index">메인</a>
                        <span>로그인</span>
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
                        <h4>회원가입</h4>
                        <ul>
                            <li><a href="login_form">로그인</a></li>
                            <li><a href="contract">회원가입</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="join_form col-lg-9 col-md-9">
                <h2 class="mb-5">회원가입</h2>
                <form method="post" action="join" id="join" name="formm">
                    <div class="join_form_input col-lg-6 col-md-6">
                        <div class="mb-4">
                            <label for="id">아이디</label>
                            <input type="text" class="form-control mb-1" id="id" name="id" placeholder="아이디">
                            <input type="hidden" id="reid" name="reid" value="${reid}">
                            <input type="button" class="btn btn-primary btn-sm btn-block" value="아이디 중복확인" onclick="idcheck()">
                        </div>
                        <div class="mb-4">
                            <label for="pwd">비밀번호</label> 
                            <input type="password" class="form-control" id="pwd" name="pwd" placeholder="비밀번호">
                        </div>
                        <div class="mb-4">
                            <label for="pwdCheck">이름</label> 
                            <input type="password" class="form-control" id="pwdCheck" name="pwdCheck" placeholder="이름">
                        </div>
                        <div class="mb-4">
                            <label for="email">이메일</label> 
                            <input type="text" class="form-control" id="email" name="email" placeholder="이메일">
                        </div>
                        <div class="mb-4">
                            <label for="id">우편번호</label>
                            <input type="text" class="form-control mb-1" id="zip_num" name="zip_num" placeholder="우편번호">

                            <input type="button" class="btn btn-primary btn-sm btn-block" value="우편번호 검색" onclick="post_zip()">
                        </div>
                        <div class="mb-1">
                            <label for="addr1">주소</label> 
                            <input type="text" class="form-control" id="addr1" name="addr1" placeholder="주소">
                        </div>
                        <div class="mb-4">
                            <input type="text" class="form-control" id="addr2" name="addr2">
                        </div>
                        <div>
                            <label for="phone">휴대폰번호</label> 
                            <input type="text" class="form-control" id="phone" name="phone" placeholder="휴대폰번호">
                        </div>
                    </div>
                    <div class="join_form_button col-lg-6 col-md-6">
                        <div class="join_form_button_reset">
                            <input type="reset" class="btn btn-secondary btn-lg btn-block" value="취소">
                        </div>
                        <div class="join_form_button_submit">
                            <input type="button" class="btn btn-warning btn-lg btn-block" value="회원가입" onclick="go_save()">
                        </div>
                    </div>
                </form>
			</div>
        </div>
    </div>
</section>

<%@include file="../footer.jsp"%>  