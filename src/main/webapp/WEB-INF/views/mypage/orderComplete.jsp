<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../header.jsp"%>   

<div class="breadcrumb-option set-bg" data-setbg="img/breadcrumb-bg.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h1>주문완료</h1>
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
            <div class="orderComplete col-lg-9 col-md-9">
                <h2 class="mb-4">결제완료</h2>
                <form method="post" id="formm" name="formm">
                    <div class="orderComplete_form col-lg-12 col-md-12">
                        <c:choose>
							<c:when test="${orderList.size()==0}">
								<div class="orderComplete_form_empty">
							   		<h4 style="text-align: center;">장바구니가 비어있습니다.</h4>
								</div>
								<br>
								<div class="orderComplete_form_empty_button col-lg-3 col-md-3">
							    	<input type="button" class="btn btn-warning btn-lg btn-block" value="예약하기" onclick="location.href='index'">
								</div>
							</c:when>
                            
                            <c:otherwise>
								<div class="orderComplete_form_color">
	                            	<div class="orderComplete_form_total">
	                 	            	<div class="orderComplete_form_total_text">
	                                		<h5 class="mb-4">총 결제 금액　</h5>
	                                	</div>
	                                	<div class="orderComplete_form_total_number">
	                                		<fmt:formatNumber value="${totalPrice}" type="currency"/>
	                                	</div>
	                                	<div class="orderComplete_form_total_clear"></div>
	                                </div>
	                                <div class="orderComplete_form_table">
	                                    <table class="table table-striped" style="text-align: center;">
	                                        <thead>
	                                            <tr>
	                                                <th style="width: 35%">상품명</th>
	                                                <th style="width: 10%">수량</th>
	                                                <th style="width: 20%">가격</th>
	                                                <th style="width: 15%">주문일</th>
	                                                <th style="width: 20%">진행상태</th>    
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                            <c:forEach items="${orderList}" var="orderVO">
	                                                    <tr>  
	                                                        <td>
	                                                            <a href="product_detail?pseq=${cartVO.pseq}">${orderVO.pname}</a>    
	                                                        </td>    
	                                                        <td>
	                                                            ${orderVO.quantity}
	                                                        </td>      
	                                                        <td>
	                                                            <fmt:formatNumber value="${orderVO.price2*orderVO.quantity}" type="currency"/>
	                                                        </td>
	                                                        <td> 
	                                                            <fmt:formatDate value="${orderVO.indate}" type="date"/>
	                                                        </td>
	                                                        <td>
																진행 중 
	                                                        </td>
	                                                    </tr>
	                                            </c:forEach>
	                                        </tbody>
	                                    </table>
	                                    <hr>
	                                    <div class="orderComplete_form_complete_text"><h5>주문이 완료되었습니다!</h5></div>
										<div class="orderComplete_form_table_clear"></div>
	                                </div>
								</div>
	   	                        <br>
								<div class="orderComplete_form_button col-lg-3 col-md-3">
								    <input type="button" class="btn btn-warning btn-lg btn-block" value="예약확인" onclick="location.href='order_all'">
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