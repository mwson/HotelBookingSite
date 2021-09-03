<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../sideMenu.jsp"%>
<%@include file="../header.jsp"%>

<main class="content">
	<div class="container-fluid p-0">
		<div class="mb-3">
			<h1 class="h3 d-inline align-middle">객실 수정</h1>
		</div>
		
		<form method="post" id="room_update_form" name="room_update_form" enctype="multipart/form-data"> 
			<input type="hidden" id="rid" name="rid" value="${roomVO.rid}">
			<input type="hidden" name="image" value="${roomVO.image}">
			<div class="row">
				<div class="col-8 col-lg-9">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">객실 수정</h5>
							<h6 class="card-subtitle text-muted">선택한 객실을 수정하세요.</h6>
						</div>
						
						<div class="card-body text-center">
							<table class="table table-striped" style="text-align: left">
								<tr>
									<th style="width: 15%">사용유무</th>
									<td>
										<c:choose>
											<c:when test='${roomVO.useyn=="y"}'>
												<input type="checkbox" id="useyn" name="useyn" value="y" checked="checked"> <span style="color: #3b7ddd">사용</span>
											</c:when>
										
											<c:otherwise>
												<input type="checkbox" id="useyn" name="useyn" value="n"> <span style="color: #dc3545">미 사용</span>
											</c:otherwise>
										</c:choose>	
									</td>
								</tr>
								<tr>
									<th style="width: 15%">객실명</th>
									<td>
										<input type="text" class="form-control" id="type" name="type" value="${roomVO.type}">
									</td>
								</tr>
								<tr>
									<th style="width: 15%">수용인원</th>
									<td>
										<input type="text" class="form-control" id="people" name="people" value="${roomVO.people}">
									</td>
								</tr>
								<tr>
									<th style="width: 15%">가격</th>
									<td>
										<input type="text" class="form-control" id="price" name="price" onKeyUp='NumFormat(this)' value="<fmt:formatNumber value="${roomVO.price}"/>">
									</td>
								</tr>							
								<tr>
									<th style="width: 15%">객실 이미지</th>
									<td>
										<img class="card-img-top" src="room_images/${roomVO.image}">
									</td>
								</tr>
								<tr>
									<th style="width: 15%">객실 이미지 추가</th>
									<td>
										<input type="file" name="room_image" id="room_image">
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
								<input type="button" class="btn btn-primary" value="수정" onClick="room_update()">
							</div>
						</div>
						<hr>
						<div class="card-header">
							<h5 class="card-title">객실목록</h5>
							<h6 class="card-subtitle text-muted">객실목록으로 이동하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="button" class="btn btn-secondary btn-lg" value="객실목록" onClick="room_list3()">
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</main>

<%@include file="../footer.jsp"%>