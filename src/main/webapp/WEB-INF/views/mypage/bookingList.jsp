<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../header.jsp"%>   

<div class="breadcrumb-option set-bg" data-setbg="images/hbg-1.jpg">
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
                        	<li><a href="booking_list">예약확인</a></li>
							<li><a href="qna_list">문의내역</a></li>
                            <li><a href="update_member_form">회원정보 수정</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="orderList col-lg-9 col-md-9">
                <h2 class="mb-4">예약확인</h2>
                <div class="orderList_form col-lg-12 col-md-12">
                    <c:choose>
                        <c:when test="${bookingList.size() == 0}">
                            <div class="orderList_form_empty">
                                <h4 style="text-align: center;">예약내역이 없습니다.</h4>     
                            </div>
                            <br>
							<div class="orderList_form_empty_button col-lg-3 col-md-3">
						    	<input type="button" class="btn btn-warning btn-lg btn-block" value="예약하기" onclick="location.href='booking_button'">
							</div> 
                        </c:when>

                        <c:otherwise>
                            <div class="orderList_form_table">
                                <h5 class="mb-4">예약내역</h5>
                                <div class="orderList_form_table_now">
                                    <table class="table table-striped" style="text-align: center;">
                                        <thead>
                                            <tr>
                                                <th style="width: 15%">예약번호</th>
												<th style="width: 15%">체크인</th>
                                                <th style="width: 15%">체크아웃</th>
                                                <th style="width: 20%">방</th>
                                                <th style="width: 15%">예약일자</th>
                                                <th style="width: 20%">예약상태(상세)</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${bookingList}" var="bookingVO">
                                                    <tr>  
                                                        <td>${bookingVO.bseq}</td>  
                                                        <td>
                                                            <input type="hidden" value="<fmt:parseDate value="${bookingVO.checkin}" pattern="yyyy-MM-dd HH:mm:ss" var="checkin"/>">
                                                            <fmt:formatDate value="${checkin}" pattern="yyyy. M. dd"/>
                                                        </td>
                                                        <td>
                                                            <input type="hidden" value="<fmt:parseDate value="${bookingVO.checkout}" pattern="yyyy-MM-dd HH:mm:ss" var="checkout"/>">
                                                            <fmt:formatDate value="${checkout}" pattern="yyyy. M. dd"/>
                                                        </td>
                                                        <td>${bookingVO.type}</td>
														<td> 
                                                            <fmt:formatDate type="date" value="${bookingVO.indate}"/>
                                                        </td>      
                                                        <td>
															<c:choose>
																<c:when test='${bookingVO.cancel=="1"}'>
																	<c:choose>
		                                            					<c:when test='${bookingVO.result=="1"}'>
		                                                					<span class="review">
		                                                						<span class="review" style="color: #f44336">예약대기<a href="booking_detail?bseq=${bookingVO.bseq}">(조회)</a></span>
		                                                					</span>
		                                            					</c:when>
		                                            					
		                                            					<c:otherwise>
		                                                					<span class="review">
		                                                						<span class="review" style="color: #007BFF">예약완료<a href="booking_detail?bseq=${bookingVO.bseq}">(조회)</a></span>
		                                                					</span>
		                                            					</c:otherwise>
	                                            					</c:choose>
	                                            				</c:when>
	                                            				
	                                            				<c:otherwise>
	                                            					<span class="review">
	                                                						<span class="review" style="color: #f44336">예약취소<a href="booking_detail?bseq=${bookingVO.bseq}">(조회)</a></span>
	                                                					</span>
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
                            
          					<%@include file="bookingPageArea.jsp"%>
                            
							<div class="orderList_button_booking col-lg-3 col-md-3">
							    <input type="button" class="btn btn-warning btn-lg btn-block" value="예약 계속하기" onclick="location.href='booking_button'">
							</div>
                        </c:otherwise>  
                    </c:choose>
                </div>
			</div>
        </div>
    </div>
</section>

<%@include file="../footer.jsp"%>  