<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../header.jsp"%>   

<div class="breadcrumb-option set-bg" data-setbg="img/breadcrumb-bg.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h1>문의내역</h1>
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
                        	<li><a href="order_all">예약확인</a></li>
							<li><a href="cart_list">장바구니</a></li>
							<li><a href="qna_list">문의내역</a></li>
                            <li><a href="login_form">회원정보 수정</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="qnaList col-lg-9 col-md-9">
                <h2 class="mb-4">문의내역</h2>
                <form method="post" id="formm" name="formm">
                    <div class="qnaList_form col-lg-12 col-md-12">
                        <c:choose>
                            <c:when test="${qnaList.size() == 0}">
                                <div class="qnaList_form_empty">
                                    <h4 style="text-align: center;">문의내역이 없습니다.</h4>     
                                </div>
                            </c:when>

                            <c:otherwise>
                                <div class="qnaList_form_table">
                                	<h5 class="mb-4">${sessionScope.loginUser.name}님의 문의내역</h5>
                                    <table class="table table-striped" style="text-align: center;">
                                        <thead>
                                            <tr>
                                                <th style="width: 10%">번호</th>
                                                <th style="width: 60%">제목</th>
                                                <th style="width: 15%">등록일</th>
                                                <th style="width: 15%">답변 여부</th>    
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${qnaList}" var="qnaVO">
                                                    <tr>  
                                                        <td>${qnaVO.qseq}</td>    
                                                        <td>
                                                            <a href="qna_detail?qseq=${qnaVO.qseq}">${qnaVO.subject}</a>
                                                        </td>      
                                                        <td>
                                                            <fmt:formatDate value="${qnaVO.indate}" type="date"/>
                                                        </td>
                                                        <td> 
                                                        <c:choose>
                                                            <c:when test="${qnaVO.rep==1}">미 답변</c:when>
                                                            <c:when test="${qnaVO.rep==2}">답변</c:when>
                                                        </c:choose>
                                                        </td>    
                                                    </tr>
                                            </c:forEach> 
                                        </tbody>   
                                    </table>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <br>
                    <div class="qnaList_form_button col-lg-3 col-md-3">
                        <input type="button" class="btn btn-warning btn-lg btn-block" value="문의하기" onclick="location.href='qna_write_form'">
                    </div>
                </form>
			</div>
        </div>
    </div>
</section>

<%@include file="../footer.jsp"%>  