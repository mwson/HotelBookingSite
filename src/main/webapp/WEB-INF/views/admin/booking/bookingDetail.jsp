<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../sideMenu.jsp"%>
<%@include file="../header.jsp"%>

<main class="content">
	<div class="container-fluid p-0">
		<div class="mb-3">
			<h1 class="h3 d-inline align-middle">예약 상세</h1>
		</div>
		
		<form method="post" id="booking_detail_form" name="booking_detail_form">
			<input type="hidden" id="bseq" name="bseq" value="${bookingVO.bseq}">       
			<div class="row">
				<div class="col-8 col-lg-9">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">예약 상세</h5>
							<h6 class="card-subtitle text-muted">선택한 예약의 상세 내용입니다.</h6>
						</div>
						<div class="card-body text-center">
							<table class="table table-striped" style="text-align: left">
								<tr>
									<th style="width: 15%">예약상태</th>
									<td>
										<c:choose>
											<c:when test='${bookingVO.cancel=="2"}'>
												<input type="checkbox" id="cancel" name="cancel" checked="checked" disabled="disabled"> <span style="color: #dc3545">예약취소</span>
											</c:when>
										
											<c:otherwise>
												<c:choose>
													<c:when test='${bookingVO.result=="1"}'>
														<input type="hidden" id="cancel" name="cancel" disabled="disabled">
														<input type="checkbox" id="result" name="result" disabled="disabled"> <span style="color: #dc3545">예약대기</span>
													</c:when>
							
													<c:otherwise>
														<input type="hidden" id="cancel" name="cancel" disabled="disabled">
														<input type="checkbox" id="result" name="result" checked="checked" disabled="disabled"> <span style="color: #3b7ddd">예약완료</span>
													</c:otherwise>
												</c:choose>			
											</c:otherwise>
										</c:choose>
									</td>
								</tr>
								<tr>
									<th style="width: 15%">예약번호</th>
									<td>${bookingVO.bseq}</td>
								</tr>
								<tr>
									<th style="width: 15%">예약자</th>
									<td>${bookingVO.name}</td>
								</tr>	
								<tr>
									<th style="width: 15%">체크인 날짜</th>
									<td>${checkin}</td>
								</tr>
								<tr>
									<th style="width: 15%">체크아웃 날짜</th>
                                    <td>${checkout}</td> 
								</tr>
								<tr>
									<th style="width: 15%">객실타입</th>
                                    <td>${bookingVO.type}</td> 
								</tr>
								<tr>
									<th style="width: 15%">투숙인원</th>
                                    <td>${bookingVO.people}명</td>
								</tr>
								<tr>
								</tr>
								<tr>
									<th style="width: 15%">객실요금 (${checkinout_cal}박)</th>
									<td>
										<fmt:formatNumber type="currency" value="${roomPrice}"/> (1박: <fmt:formatNumber type="currency" value="${bookingVO.price}"/>)
									</td>
								</tr>
								<tr>
									<th style="width: 15%">부가가치세</th>
									<td>
										<fmt:formatNumber type="currency" value="${vat}"/> (10%)
									</td>
								</tr>
								<tr>
									<th style="width: 15%">요금합계</th>
									<td>
										<fmt:formatNumber type="currency" value="${totalPrice}"/>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
	
				<div class="col-4 col-lg-3">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">예약 승인</h5>
							<h6 class="card-subtitle text-muted">예약을 승인하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="button" class="btn btn-primary" value="예약 승인" onClick="booking_detail_approve()">
							</div>
						</div>
						<hr>
						<div class="card-header">
							<h5 class="card-title">예약 취소</h5>
							<h6 class="card-subtitle text-muted">예약을 취소하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="button" class="btn btn-danger btn-lg" value="예약 취소" onClick="booking_cancel()">
							</div>
						</div>
						<hr>
						<div class="card-header">
							<h5 class="card-title">예약목록</h5>
							<h6 class="card-subtitle text-muted">예약목록으로 이동하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="button" class="btn btn-secondary btn-lg" value="객실목록" onClick="booking_list('${criteria.pageNum}', '${criteria.numPerPage}')">
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</main>

<%@include file="../footer.jsp"%>