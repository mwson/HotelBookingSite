<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../sideMenu.jsp"%>
<%@include file="../header.jsp"%>

<main class="content">
	<div class="container-fluid p-0">
		<div class="mb-3">
			<h1 class="h3 d-inline align-middle">공지사항 상세</h1>
		</div>
		
		<form method="post" id="notice_detail_form" name="notice_detail_form">
			<input type="hidden" id="nseq" name="nseq" value="${noticeVO.nseq}">         
			<div class="row">
				<div class="col-8 col-lg-9">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">공지사항 상세</h5>
							<h6 class="card-subtitle text-muted">선택한 공지사항의 상세내용입니다.</h6>
						</div>
						<div class="card-body text-center">
							<table class="table table-striped" style="text-align: left">
								<tr>
									<th style="width: 15%">종류</th>
									<td>${noticeVO.kind}</td>
								</tr>
								<tr>
									<th style="width: 15%">제목</th>
									<td>${noticeVO.subject}</td>
								</tr>
								<tr>
									<th style="width: 15%">등록일</th>
									<td><fmt:formatDate value="${noticeVO.indate}"/></td>
								</tr>
								<tr>
									<th style="width: 15%">내용</th>
									<td>${noticeVO.content}</td>
								</tr>
								<tr>
									<th style="width: 15%">공지사항이미지</th>
									<td><img class="card-img-top" src="notice_images/${noticeVO.image}"></td>
								</tr>						
							</table>
						</div>
					</div>
				</div>
	
				<div class="col-4 col-lg-3">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">공지사항 수정</h5>
							<h6 class="card-subtitle text-muted">공지사항을 수정하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="button" class="btn btn-primary" value="수정" onClick="go_notice_update_form('${noticeVO.nseq}')">
							</div>
						</div>
						<hr>
						<div class="card-header">
							<h5 class="card-title">공지사항 삭제</h5>
							<h6 class="card-subtitle text-muted">공지사항을 삭제하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="button" class="btn btn-danger btn-lg" value="삭제" onClick="go_notice_delete()">
							</div>
						</div>
						<hr>
						<div class="card-header">
							<h5 class="card-title">공지사항 목록</h5>
							<h6 class="card-subtitle text-muted">공지사항 목록으로 이동하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="button" class="btn btn-secondary btn-lg" value="상품목록" onClick="go_notice_list2()">
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</main>

<%@include file="../footer.jsp"%>