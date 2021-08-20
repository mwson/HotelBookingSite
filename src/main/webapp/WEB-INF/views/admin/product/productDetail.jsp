<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../sideMenu.jsp"%>
<%@include file="../header.jsp"%>

<main class="content">
	<div class="container-fluid p-0">
		<div class="mb-3">
			<h1 class="h3 d-inline align-middle">상품상세</h1>
		</div>
		
		<form method="post" id="product_detail_form" name="product_detail_form">         
			<div class="row">
				<div class="col-8 col-lg-9">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">상품상세</h5>
							<h6 class="card-subtitle text-muted">선택한 상품의 상세내용입니다.</h6>
						</div>
						<div class="card-body text-center">
							<table class="table table-striped" style="text-align: left">
								<tr>
									<th style="width: 15%">상품명</th>
									<td>${productVO.name}</td>
								</tr>
								<tr>
									<th style="width: 15%">가격</th>
									<td><fmt:formatNumber value="${productVO.price2}"/></td>
								</tr>
								<tr>
									<th style="width: 15%">상세설명</th>
									<td>${productVO.content}</td>
								</tr>								
								<tr>
									<th style="width: 15%; height: center">상품이미지</th>
									<td><img class="card-img-top" src="product_images/${productVO.image}"></td>
								</tr>
							</table>
						</div>
					</div>
				</div>
	
				<div class="col-4 col-lg-3">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">상품수정</h5>
							<h6 class="card-subtitle text-muted">상품을 수정하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="button" class="btn btn-primary" value="수정" onClick="go_order_update_form('${productVO.pseq}')">
							</div>
						</div>
						<hr>
						<div class="card-header">
							<h5 class="card-title">상품목록</h5>
							<h6 class="card-subtitle text-muted">목록으로 이동하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="button" class="btn btn-secondary btn-lg" value="상품목록" onClick="go_order_list('${criteria.pageNum}', '${criteria.numPerPage}')">
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</main>

<%@include file="../footer.jsp"%>