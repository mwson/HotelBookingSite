<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../sideMenu.jsp"%>
<%@include file="../header.jsp"%>

<main class="content">
	<div class="container-fluid p-0">
		<div class="mb-3">
			<h1 class="h3 d-inline align-middle">예약목록</h1>
		</div>
		
        <form method="post" id="order_form" name="order_form">         
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
										<th style="width: 15%">처리여부</th> 
										<th style="width: 10%">예약번호</th>
										<th style="width: 10%">예약자</th>
										<th style="width: 20%">상품명</th>
										<th style="width: 10%">수량</th>
										<th style="width: 20%">전화</th>
										<th style="width: 15%">주문일</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${orderList}" var="orderVO">
										<tr>  
											<td>
												<c:choose>
													<c:when test='${orderVO.result=="1"}'>
														<input type="checkbox" id="result" name="result" value="${orderVO.odseq}"> <span style="color: #dc3545">미 처리</span>
													</c:when>
							
													<c:otherwise>
														<input type="checkbox" checked="checked" disabled="disabled"> <span style="color: #3b7ddd">처리완료</span>
													</c:otherwise>
												</c:choose>			
											</td>    
											<td>${orderVO.odseq}</td>      
											<td>${orderVO.mname}</td>
											<td>${orderVO.pname}</td>
											<td>${orderVO.quantity}</td>
											<td>${orderVO.phone}</td>
											<td><fmt:formatDate value="${orderVO.indate}"/></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						
						<%@include file="orderPageArea.jsp"%>
						
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
                                <input type="button" class="btn btn-secondary" value="검색" onclick="go_search_order()">
							</div>
						</div>
                        <hr>
                        <div class="card-header">
							<h5 class="card-title">예약처리</h5>
							<h6 class="card-subtitle text-muted">예약을 처리하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
                                <input type="button" class="btn btn-primary btn-lg" value="예약처리" onClick="go_order_save()">
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</main>

<%@include file="../footer.jsp"%>