<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../header.jsp"%>   

<div class="breadcrumb-option set-bg" data-setbg="img/breadcrumb-bg.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h1>문의상세</h1>
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
                        <h4>문의내역</h4>
                        <hr>
                        <ul>
                        	<li><a href="qna_list">문의내역</a></li>
							<li><a href="qna_write_form">문의하기</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="qnaView col-lg-9 col-md-9">
                <h2 class="mb-5">문의내역 상세</h2>
                <form method="post" id="formm" name="formm">
                    <div class="qnaView_form col-lg-12 col-md-12 mb-4">
                        <div class="qnaView_form_q mb-3">
                            <h5 class="mb-2">문의내역</h5>
                            <div class="qnaView_q_table">
								<div class="mb-3">
                                    <label for="subject">작성자</label>
                                    <input type="text" class="form-control" value="${sessionScope.loginUser.name}(${sessionScope.loginUser.id})" readonly>
                                </div>
                                <div class="mb-3">
                                    <label for="subject">제목</label>
                                    <input type="text" id="subject" name="subject" class="form-control" value="${qnaVO.subject}" readonly="readonly">
                                </div>
                                <div class="mb-3">
                                    <label for="indate">등록일</label>
                                    <input type="text" id="indate" id="indate" name="indate" class="form-control" value="<fmt:formatDate value="${qnaVO.indate}" type="date"/>" readonly="readonly">
                                </div>
                                <div class="mb-3">
                                    <label for="content">문의내역</label>
                                    <textarea class="form-control mb-3" rows="8" id="content" name="content" readonly>${qnaVO.content}</textarea>
                                </div>
                            </div>
                        </div>
                        <hr class="mb-4">
                        <div class="qnaView_form_a">
                            <h5 class="mb-2">답변내역</h5>
                            <div class="qnaView_a_textarea">
                                <textarea class="form-control mb-3" rows="8" readonly><c:choose><c:when test="${qnaVO.rep==1}">미 답변 상태입니다.</c:when><c:when test="${qnaVO.rep==2}">${qnaVO.reply}</c:when></c:choose></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="qnaView_form_button col-lg-12 col-md-12">
                        <div class="qnaView_form_button_list col-lg-3 col-md-3">
                            <input type="button" class="btn btn-warning btn-lg btn-block" value="문의내역 목록" onclick="location.href='qna_list'">
                        </div>
                    </div>
                </form>
			</div>
        </div>
    </div>
</section>

<%@include file="../footer.jsp"%>  