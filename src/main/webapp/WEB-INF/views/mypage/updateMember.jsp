<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../header.jsp"%>   

<div class="breadcrumb-option set-bg" data-setbg="img/breadcrumb-bg.jpg">
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

            <div class="updateMember_form col-lg-9 col-md-9">
                <h2 class="mb-4">회원정보 수정</h2>
                <form method="post" action="update" id="update" name="formm">
                    <div class="updateMember_form_input col-lg-6 col-md-6">
                        <div class="mb-4">
                            <label for="id">아이디 <span class="review" style="color: #f44336">*</span></label>
                            <input type="text" class="form-control" id="id" name="id" value="${memberVO.id}" readonly>
                        </div>
                        <div class="mb-4">
                            <label for="pwd">비밀번호</label> 
                            <input type="password" class="form-control" id="pwd" name="pwd" placeholder="비밀번호">
                            <input type="password" id="default_pwd" name="default_pwd" value="${memberVO.pwd}" hidden="hidden">
                        </div>
                        <div class="mb-4">
                            <label for="pwd">비밀번호 확인</label> 
                            <input type="password" class="form-control" id="pwdCheck" name="pwdCheck" placeholder="비밀번호 확인">
                        </div>
                        <div class="mb-4">
                            <label for="pwdCheck">이름 <span class="review" style="color: #f44336">*</span></label> 
                            <input type="text" class="form-control" id="name" name="name" value="${memberVO.name}" readonly>
                        </div>
						<div class="mb-4">
                            <label for="phone">휴대폰번호 <span class="review" style="color: #f44336">*</span></label> 
                            <input type="text" class="form-control" id="phone" name="phone" value="${memberVO.phone}">
                        </div>
                        <div class="mb-4">
                            <label for="email">이메일 <span class="review" style="color: #f44336">*</span></label> 
                            <input type="text" class="form-control" id="email" name="email" value="${memberVO.email}">
                        </div>
                        <hr>
                        <div class="mb-4">
                            <label for="id">우편번호</label>
                            <input type="text" class="form-control mb-1" id="zip_num" name="zip_num" value="${memberVO.zip_num}">
                            <input type="button" class="btn btn-primary btn-sm btn-block" value="주소 검색" onclick="post_zip()">
                        </div>
                        <div class="mb-1">
                            <label for="addr1">주소</label> 
                            <input type="text" class="form-control" id="addr1" name="addr1" value="${memberVO.address}">
                        </div>
                        <div class="mb-4">
                            <input type="text" class="form-control" id="addr2" name="addr2">
                        </div>
                    </div>
                    <br>
                    <div class="updateMember_form_button col-lg-6 col-md-6">
                        <div class="updateMember_form_button_reset col-lg-4 col-md-4">
                            <input type="reset" class="btn btn-secondary btn-lg btn-block" value="취소">
                        </div>
                        <div class="updateMember_form_button_submit col-lg-4 col-md-4">
                            <input type="button" class="btn btn-warning btn-lg btn-block" value="수정" onclick="go_update_member()">
                        </div>
                    </div>
                </form>
			</div>
        </div>
    </div>
</section>

<%@include file="../footer.jsp"%>  