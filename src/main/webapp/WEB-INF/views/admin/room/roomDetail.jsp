<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../sideMenu.jsp"%>
<%@include file="../header.jsp"%>

<main class="content">
	<div class="container-fluid p-0">
		<div class="mb-3">
			<h1 class="h3 d-inline align-middle">객실 상세</h1>
		</div>
		
		<form method="post" id="room_detail_form" name="room_detail_form">
			<input type="hidden" id="rid" name="rid" value="${roomVO.rid}">       
			<div class="row">
				<div class="col-8 col-lg-9">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">객실 상세</h5>
							<h6 class="card-subtitle text-muted">선택한 객실의 상세 내용입니다.</h6>
						</div>
						<div class="card-body text-center">
							<table class="table table-striped" style="text-align: left">
								<tr>
									<th style="width: 15%">사용유무</th>
									<td>
										<c:choose>
											<c:when test='${roomVO.useyn=="y"}'>
												<input type="checkbox" checked="checked" disabled="disabled"> <span style="color: #3b7ddd">사용</span>
											</c:when>
										
											<c:otherwise>
												<input type="checkbox" disabled="disabled"> <span style="color: #dc3545">미 사용</span>
											</c:otherwise>
										</c:choose>	
									</td>
								</tr>
								<tr>
									<th style="width: 15%">객실명</th>
									<td>${roomVO.type}</td>
								</tr>
								<tr>
									<th style="width: 15%">인원</th>
									<td>${roomVO.people}</td>
								</tr>	
								<tr>
									<th style="width: 15%">가격</th>
									<td>
										<fmt:formatNumber value="${roomVO.price}"/>
									</td>
								</tr>
								<tr>
									<th style="width: 15%">객실 이미지</th>
									<td>
										<img class="card-img-top" src="room_images/${roomVO.image}">
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
	
				<div class="col-4 col-lg-3">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">객실 수정</h5>
							<h6 class="card-subtitle text-muted">객실을 수정하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="button" class="btn btn-primary" value="수정" onClick="room_update_form()">
							</div>
						</div>
						<hr>
						<div class="card-header">
							<h5 class="card-title">객실 삭제</h5>
							<h6 class="card-subtitle text-muted">객실을 삭제하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="button" class="btn btn-danger btn-lg" value="삭제" onClick="room_delete()">
							</div>
						</div>
						<hr>
						<div class="card-header">
							<h5 class="card-title">객실목록</h5>
							<h6 class="card-subtitle text-muted">객실목록으로 이동하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="button" class="btn btn-secondary btn-lg" value="객실목록" onClick="room_list2('${criteria.pageNum}', '${criteria.numPerPage}')">
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</main>

<%@include file="../footer.jsp"%>