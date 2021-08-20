<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../header.jsp"%>   

<div class="breadcrumb-option set-bg" data-setbg="img/breadcrumb-bg.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h1>예약확인</h1>
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
            <div class="orderList col-lg-9 col-md-9">
                <h2 class="mb-4">예약확인</h2>
                <form method="post" id="formm" name="formm">
                    <div class="orderList_form col-lg-12 col-md-12">
                        <c:choose>
                            <c:when test="${orderList.size() == 0}">
                                <div class="orderList_form_empty">
                                    <h4 style="text-align: center;">주문내역이 없습니다.</h4>     
                                </div>
                                <br>
								<div class="orderList_form_empty_button col-lg-3 col-md-3">
							    	<input type="button" class="btn btn-warning btn-lg btn-block" value="예약하기" onclick="location.href='index'">
								</div> 
                            </c:when>

                            <c:otherwise>
                                <div class="orderList_form_table">
                                    <h5 class="mb-4">현재 예약내역</h5>
                                    <div class="orderList_form_table_now">
                                        <table class="table table-striped" style="text-align: center;">
                                            <thead>
                                                <tr>
                                                    <th style="width: 15%">예약번호</th>
                                                    <th style="width: 15%">예약일자</th>
                                                    <th style="width: 35%">방</th>
                                                    <th style="width: 20%">결제금액</th>
                                                    <th style="width: 15%">예약상세</th>    
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${orderList}" var="orderVO">
                                                        <tr>  
                                                            <td>${orderVO.oseq}</td>  
                                                            <td>
                                                                <fmt:formatDate value="${orderVO.indate}" type="date"/>
                                                            </td>        
                                                            <td>${orderVO.pname}</td>
                                                            <td> 
                                                                <fmt:formatNumber value="${orderVO.price2}" type="currency"/>
                                                            </td>
                                                            <td>
                                                                <a href="order_detail?oseq=${orderVO.oseq}">조회</a>
                                                            </td>
                                                        </tr>
                                                </c:forEach> 
                                            </tbody>
                                        </table>
                                    </div>
                                    <hr class="mb-5">
                                    <h5 class="mb-4">이전 예약내역</h5>
                                    <div class="orderList_form_table_now_past">
                                        <table class="table table-striped" style="text-align: center;">
                                            <thead>
                                                <tr>
                                                    <th style="width: 15%">예약번호</th>
                                                    <th style="width: 15%">예약일자</th>
                                                    <th style="width: 35%">방</th>
                                                    <th style="width: 20%">결제금액</th>
                                                    <th style="width: 15%">예약상세</th>    
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${orderList}" var="orderVO">
                                                        <tr>  
                                                            <td>${orderVO.oseq}</td>  
                                                            <td>
                                                                <fmt:formatDate value="${orderVO.indate}" type="date"/>
                                                            </td>        
                                                            <td>${orderVO.pname}</td>
                                                            <td> 
                                                                <fmt:formatNumber value="${orderVO.price2}" type="currency"/>
                                                            </td>
                                                            <td>
                                                                <a href="order_detail?oseq=${orderVO.oseq}">조회</a>
                                                            </td>
                                                        </tr>
                                                </c:forEach> 
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <br>
	                            <div class="orderList_button_booking col-lg-3 col-md-3">
	                                <input type="button" class="btn btn-warning btn-lg btn-block" value="예약 계속하기" onclick="location.href='index'">
	                            </div>
                            </c:otherwise>  
                        </c:choose>
                    </div>
                </form>
			</div>
        </div>
    </div>
</section>

<%@include file="../footer.jsp"%>  