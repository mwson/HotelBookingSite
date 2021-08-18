<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../header.jsp"%>   

<div class="breadcrumb-option set-bg" data-setbg="img/breadcrumb-bg.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h1>예약상세</h1>
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
                        </ul>
                    </div>
                </div>
            </div>
            <div class="orderDetail col-lg-9 col-md-9">
                <h2 class="mb-4">예약상세</h2>
                <form method="post" id="formm" name="formm">
                    <div class="orderDetail_form col-lg-12 col-md-12">
                        <c:choose>
                            <c:when test="${orderList.size() == 0}">
                                <div class="orderDetail_form_empty">
                                    <h4 style="text-align: center;">주문내역이 없습니다.</h4>     
                                </div>
                                <br>
								<div class="orderDetail_form_empty_button col-lg-3 col-md-3">
							    	<input type="button" class="btn btn-warning btn-lg btn-block" value="예약하기" onclick="location.href='index'">
								</div> 
                            </c:when>

                            <c:otherwise>
                                <div class="orderDetail_form_table">
                                    <h5 class="mb-4">주문자 상세</h5>
                                    <div class="orderDetail_form_table_now">
                                        <table class="table table-striped" style="text-align: center;">
                                            <thead>
                                                <tr>
                                                    <th style="width: 20%">예약번호</th>
                                                    <th style="width: 30%">예약일자</th>
                                                    <th style="width: 20%">주문자</th>
													<th style="width: 30%">결제총액</th>    
                                                </tr>
                                            </thead>
                                            <tbody>
												<tr>  
												    <td>${orderDetail.oseq}</td>  
												    <td>
												        <fmt:formatDate type="date" value="${orderDetail.indate}"/>
												    </td>        
												    <td>${orderDetail.mname}</td>
												    <td>
												        <fmt:formatNumber type="currency" value="${totalPrice}"/>
												    </td>
												</tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <hr class="mb-5">
                                    <h5 class="mb-4">예약 상세</h5>
                                    <div class="orderDetail_form_table_now_past">
                                        <table class="table table-striped" style="text-align: center;">
                                            <thead>
                                                <tr>
                                                	<th style="width: 25%">상세 예약번호</th>
                                                	<th style="width: 25%">방</th>
                                                    <th style="width: 15%">수량</th>
                                                    <th style="width: 20%">가격</th>
                                                    <th style="width: 15%">처리상태</th>    
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${orderList}" var="orderVO">
                                                        <tr>  
                                                            <td>${orderVO.odseq}</td>       
                                                            <td>${orderVO.pname}</td>  
                                                            <td>${orderVO.quantity}</td>
                                                            <td> 
                                                                <fmt:formatNumber type="currency" value="${orderVO.price2*orderVO.quantity}"/>
                                                            </td>
                                                            <td>
                                                                <c:choose>
																	<c:when test='${orderVO.result=="1"}'>
																		예약중
																	</c:when>
																	<c:otherwise>
																		<h5>예약완료</h5>
																	</c:otherwise>
																</c:choose>
                                                            </td>
                                                        </tr>
                                                </c:forEach> 
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <br>
                               	<div class="orderDetail_button col-lg-12 col-md-12">
			                        <div class="orderList_button_list col-lg-3 col-md-3">
			                            <input type="button" class="btn btn-secondary btn-lg btn-block" value="예약목록" onclick="location.href='order_all'">
			                        </div>
		                            <div class="orderDetail_button_booking col-lg-3 col-md-3">
		                                <input type="button" class="btn btn-warning btn-lg btn-block" value="예약 계속하기" onclick="location.href='index'">
		                            </div>
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