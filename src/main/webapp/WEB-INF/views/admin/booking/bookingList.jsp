<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../sideMenu.jsp"%>
<%@include file="../header.jsp"%>

<main class="content">
	<div class="container-fluid p-0">
		<div class="mb-3">
			<h1 class="h3 d-inline align-middle">예약목록</h1>
		</div>
		
        <form method="post" id="booking_list_form" name="booking_list_form">         
			<div class="row">
				<div class="col-8 col-lg-9">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">예약목록</h5>
							<h6 class="card-subtitle text-muted">전체 예약목록입니다.</h6>
						</div>
						<div class="card-body text-center">
							<table class="table table-striped" style="text-align: center;">
								<thead>
									<tr>
										<th style="width: 15%">예약상태</th> 
										<th style="width: 10%">예약번호</th>
										<th style="width: 10%">예약자</th>
										<th style="width: 15%">체크인</th>
										<th style="width: 15%">체크아웃</th>
										<th style="width: 15%">객실타입</th>
										<th style="width: 10%">투숙인원</th>
										<th style="width: 10%">예약상세</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${bookingList}" var="bookingVO">
										<tr>  
											<td>
												<c:choose>
													<c:when test='${bookingVO.cancel=="2"}'>
														<input type="checkbox" checked="checked" disabled="disabled"> <span style="color: #dc3545">예약취소</span>
													</c:when>
												
													<c:otherwise>
														<c:choose>
															<c:when test='${bookingVO.result=="1"}'>
																<input type="checkbox" id="result" name="result" value="${bookingVO.bseq}"> <span style="color: #dc3545">예약대기</span>
															</c:when>
									
															<c:otherwise>
																<input type="checkbox" checked="checked" disabled="disabled"> <span style="color: #3b7ddd">예약완료</span>
															</c:otherwise>
														</c:choose>			
													</c:otherwise>
												</c:choose>
											</td>    
											<td>${bookingVO.bseq}</td>      
											<td>${bookingVO.name}</td>
											<td>
												<input type="hidden" value="<fmt:parseDate value="${bookingVO.checkin}" pattern="yyyy-MM-dd HH:mm:ss" var="checkin"/>">
												<fmt:formatDate value="${checkin}" pattern="yyyy. M. dd"/>
											</td>
											<td>
												<input type="hidden" value="<fmt:parseDate value="${bookingVO.checkout}" pattern="yyyy-MM-dd HH:mm:ss" var="checkout"/>">
												<fmt:formatDate value="${checkout}" pattern="yyyy. M. dd"/>
											</td>
											<td>${bookingVO.type}</td>
											<td>${bookingVO.people}명</td>
											<td><a href="admin_booking_detail?bseq=${bookingVO.bseq}">조회</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						
						<%@include file="bookingPageArea.jsp"%>
						
					</div>
				</div>
	
				<div class="col-4 col-lg-3">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">예약목록 검색</h5>
							<h6 class="card-subtitle text-muted">예약자를 입력하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="text" class="form-control" id="key" name="key">
                                <input type="button" class="btn btn-secondary" value="검색" onclick="booking_search()">
							</div>
						</div>
                        <hr>
                        <div class="card-header">
							<h5 class="card-title">예약 승인</h5>
							<h6 class="card-subtitle text-muted">예약을 승인하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
                                <input type="button" class="btn btn-primary btn-lg" value="예약 승인" onClick="booking_approve()">
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</main>

<%@include file="../footer.jsp"%>