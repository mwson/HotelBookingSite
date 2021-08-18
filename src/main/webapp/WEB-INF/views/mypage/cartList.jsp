<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../header.jsp"%>   

<div class="breadcrumb-option set-bg" data-setbg="img/breadcrumb-bg.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h1>장바구니</h1>
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
            <div class="cartList col-lg-9 col-md-9">
                <h2 class="mb-4">장바구니</h2>
                <form method="post" id="formm" name="formm">
                    <div class="cartList_form col-lg-12 col-md-12">
                        <c:choose>
							<c:when test="${cartList.size()==0}">
								<div class="cartList_form_empty">
							   		<h4 style="text-align: center;">장바구니가 비어있습니다.</h4>
								</div>
								<br>
								<div class="cartList_form_empty_button col-lg-3 col-md-3">
							    	<input type="button" class="btn btn-warning btn-lg btn-block" value="예약하기" onclick="location.href='index'">
								</div>
							</c:when>
                            
                            <c:otherwise>
								<div class="cartList_form_color">
	                            	<div class="cartList_form_total">
	                 	            	<div class="cartList_form_total_text">
	                                		<h5 class="mb-4">총 주문금액　</h5>
	                                	</div>
	                                	<div class="cartList_form_total_number">
	                                		<fmt:formatNumber value="${totalPrice}" type="currency"/>
	                                	</div>
	                                	<div class="cartList_form_total_clear"></div>
	                                </div>
	                                <div class="cartList_form_table">
	                                    <table class="table table-striped" style="text-align: center;">
	                                        <thead>
	                                            <tr>
	                                                <th style="width: 45%">상품명</th>
	                                                <th style="width: 10%">수량</th>
	                                                <th style="width: 20%">가격</th>
	                                                <th style="width: 15%">주문일</th>
	                                                <th style="width: 10%">삭제</th>    
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                            <c:forEach items="${cartList}" var="cartVO">
	                                                    <tr>  
	                                                        <td>
	                                                            <a href="product_detail?pseq=${cartVO.pseq}">${cartVO.pname}</a>    
	                                                        </td>    
	                                                        <td>
	                                                            ${cartVO.quantity}
	                                                        </td>      
	                                                        <td>
	                                                            <fmt:formatNumber value="${cartVO.price2*cartVO.quantity}" type="currency"/>
	                                                        </td>
	                                                        <td> 
	                                                            <fmt:formatDate value="${cartVO.indate}" type="date"/>
	                                                        </td>
	                                                        <td>
	                                                            <input type="checkbox" id="cseq" name="cseq" value="${cartVO.cseq}"> 
	                                                        </td>
	                                                    </tr>
	                                            </c:forEach>
	                                            <tr> 
	                                                <td></td>
	                                                <td></td>
	                                                <td></td>
	                                                <td></td>
	                                                <td><input type="button" class="btn btn-secondary btn-sm btn-block" value="삭제" onclick="go_cart_delete()"></td>
	                                            </tr>
	                                        </tbody>
	                                    </table>
										<div class="cartList_form_table_clear"></div>
	                                </div>
								</div>
	   	                        <br>
								<div class="cartList_form_table_button col-lg-3 col-md-3">
								    <input type="button" class="btn btn-warning btn-lg btn-block" value="주문하기" onclick="go_order_insert()">
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