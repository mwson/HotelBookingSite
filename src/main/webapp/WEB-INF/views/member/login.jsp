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
                        <h4>로그인</h4>
                        <hr>
                        <ul>
                            <li><a href="login_form">로그인</a></li>
                            <li><a href="contract">회원가입</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="login col-lg-9 col-md-9">
				<h2 class="mb-4">로그인</h2>
		        <form method="POST" name=formm action="login">
                    <div style="padding: 10px;">
                        <div class="login_form col-lg-5 col-md-5">
                            <div class="login_form_input">
                                <div class="mb-4">
                                    <label for="id">아이디</label>
                                    <input type="text" class="form-control" id="id" name="id" placeholder="아이디">
                                </div>
                                <div class="mb-4">
                                    <label for="pwd">비밀번호</label> 
                                    <input type="password" class="form-control" id="pwd" name="pwd" placeholder="비밀번호">
                                </div>
                            </div>
                            <hr>
                            <div class="login_form_button mb-4">
                                <div class="id_pw_find">
                                    <a href="#" class="a" onclick="find_id_form()">아이디 / 비밀번호 찾기</a>
                                </div>
                                <div class="register">
                                    <a href="#" class="a" onclick="location='contract'">회원가입</a>
                                </div>
                                <div class="login_form_button_clear"></div>
                            </div>
                            <div class="login_form_button">
                                <button type="submit" class="btn btn-warning btn-lg btn-block">로그인</button>
                            </div>
                        </div>
                    </div>
		        </form>
			</div>
        </div>
    </div>
</section>

<%@include file="../footer.jsp"%>