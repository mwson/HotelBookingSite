<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../sideMenu.jsp"%>
<%@include file="../header.jsp"%>

<main class="content">
	<div class="container-fluid p-0">
		<div class="mb-3">
			<h1 class="h3 d-inline align-middle">상품 등록</h1>
		</div>
		
		<form method="post" id="product_write_form" name="product_write_form" enctype="multipart/form-data">
			<input type="hidden" id="price1" name="price1" value="1000000">
			<input type="hidden" id="price3" name="price3" onKeyUp='NumFormat(this)'>
			<div class="row">
				<div class="col-8 col-lg-9">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">상품 등록</h5>
							<h6 class="card-subtitle text-muted">상품등록 화면입니다.</h6>
						</div>
						
						<div class="card-body text-center">
							<table class="table table-striped" style="text-align: left">
								<tr>
									<th style="width: 15%">상품분류</th>
									<td>
										<select name="kind" id="kind">
											<c:forEach items="${kindList}" var="kind" varStatus="status">
												<option value="${status.count}">${kind}</option>
											</c:forEach>
										</select> 
									</td>
								</tr>
								<tr>
									<th style="width: 15%">상품명</th>
									<td>
										<input type="text" class="form-control" id="name" name="name">
									</td>
								</tr>
								<tr>
									<th style="width: 15%">가격</th>
									<td>
										<input type="text" class="form-control" id="price2" name="price2" onBlur="go_ab()" onKeyUp='NumFormat(this)'>
									</td>
								</tr>
								<tr>
									<th style="width: 15%">상세설명</th>
									<td>
										<textarea id="content" class="form-control" name="content" rows="6"></textarea>
									</td>
								</tr>								
								<tr>
									<th style="width: 15%">상품이미지</th>
									<td>
										<input type="file" name="product_image" id="product_image">
									</td>
								</tr>
							</table>
						</div>
						
					</div>
				</div>
	
				<div class="col-4 col-lg-3">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">상품 등록</h5>
							<h6 class="card-subtitle text-muted">상품을 등록하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="button" class="btn btn-primary" value="등록" onClick="go_product_write()">
							</div>
						</div>
						<hr>
						<div class="card-header">
							<h5 class="card-title">상품 등록 취소</h5>
							<h6 class="card-subtitle text-muted">상품등록을 취소하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="reset" class="btn btn-warning" value="취소">
							</div>
						</div>
						<hr>
						<div class="card-header">
							<h5 class="card-title">상품목록</h5>
							<h6 class="card-subtitle text-muted">상품목록으로 이동하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="button" class="btn btn-secondary btn-lg" value="상품목록" onClick="go_product_list1()">
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</main>
<%@include file="../footer.jsp"%>