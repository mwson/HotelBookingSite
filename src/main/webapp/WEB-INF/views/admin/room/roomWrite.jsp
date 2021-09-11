<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../sideMenu.jsp"%>
<%@include file="../header.jsp"%>

<main class="content">
	<div class="container-fluid p-0">
		<div class="mb-3">
			<h1 class="h3 d-inline align-middle">객실 등록</h1>
		</div>
		
		<form method="post" id="room_write_form" name="room_write_form" enctype="multipart/form-data">
			<div class="row">
				<div class="col-8 col-lg-9">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">객실 등록</h5>
							<h6 class="card-subtitle text-muted">객실등록 화면입니다.</h6>
						</div>
						
						<div class="card-body text-center">
							<table class="table table-striped" style="text-align: left">
								<tr>
									<th style="width: 15%">객실명</th>
									<td>
										<input type="text" class="form-control" id="type" name="type">
									</td>
								</tr>
								<tr>
									<th style="width: 15%">최대인원</th>
									<td>
										<select class="form-select" id="people" name="people">
											<option selected="selected">----</option>
											<option value="1">1명</option>
											<option value="2">2명</option>
											<option value="3">3명</option>
											<option value="4">4명</option>
										</select>
									</td>
								</tr>
								<tr>
									<th style="width: 15%">침대</th>
									<td>
										<input type="text" class="form-control" id="bed" name="bed" value="${roomVO.bed}">
									</td>
								</tr>
								<tr>
									<th style="width: 15%">가격</th>
									<td>
										<input type="text" class="form-control" id="price" name="price" onKeyUp='NumFormat(this)'>
									</td>
								</tr>								
								<tr>
									<th style="width: 15%">객실 이미지</th>
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
							<h5 class="card-title">객실 등록</h5>
							<h6 class="card-subtitle text-muted">객실을 등록하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="button" class="btn btn-primary" value="등록" onClick="room_write()">
							</div>
						</div>
						<hr>
						<div class="card-header">
							<h5 class="card-title">객실 등록 취소</h5>
							<h6 class="card-subtitle text-muted">객실 등록을 취소하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="reset" class="btn btn-warning" value="취소">
							</div>
						</div>
						<hr>
						<div class="card-header">
							<h5 class="card-title">객실목록</h5>
							<h6 class="card-subtitle text-muted">객실목록으로 이동하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="button" class="btn btn-secondary btn-lg" value="객실목록" onClick="room_list1('${criteria.pageNum}', '${criteria.numPerPage}')">
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</main>
<%@include file="../footer.jsp"%>