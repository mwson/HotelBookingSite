<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../header.jsp"%>   

<div class="breadcrumb-option set-bg" data-setbg="images/hbg-1.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h1>문의하기</h1>
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
            <div class="qnaWrite col-lg-9 col-md-9">
                <h2 class="mb-5">문의하기</h2>
                <form method="post" id="formm" name="formm">
                    <div class="qnaWrite_form col-lg-12 col-md-12 mb-4">
                        <div class="qnaWrite_form_q mb-3">
                            <h5 class="mb-2">문의입력</h5>
                            <div class="qnaWrite_form_input">
                            	<div class="mb-3">
                                    <label for="subject">작성자</label>
                                    <input type="text" class="form-control" value="${sessionScope.loginUser.name}(${sessionScope.loginUser.id})" readonly>
                                </div>
                                <div class="mb-3">
                                    <label for="subject">제목</label>
                                    <input type="text" id="subject" name="subject" class="form-control">
                                </div>
                                <div>
                                    <label for="content">문의내용</label>
                                    <textarea class="form-control" id="content" name="content" rows="6"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="qnaWrite_form_button col-lg-12 col-md-12">
                        <div class="qnaWrite_form_button_reset col-lg-3 col-md-3">
                            <input type="reset" class="btn btn-secondary btn-lg btn-block" value="취소">
                        </div>
                        <div class="qnaWrite_form_button_write col-lg-3 col-md-3">
                            <input type="button" class="btn btn-warning btn-lg btn-block" value="문의하기" onclick="go_qna_write()">
                        </div>
                    </div>
                </form>
			</div>
        </div>
    </div>
</section>

<%@include file="../footer.jsp"%>  