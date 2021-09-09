<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../sideMenu.jsp"%>
<%@include file="../header.jsp"%>

<main class="content">
	<div class="container-fluid p-0">
		<div class="mb-3">
			<h1 class="h3 d-inline align-middle">공지사항 등록</h1>
		</div>
		
		<form method="post" id="notice_write_form" name="notice_write_form" enctype="multipart/form-data">
			<div class="row">
				<div class="col-8 col-lg-9">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">공지사항 등록</h5>
							<h6 class="card-subtitle text-muted">공지사항을 등록하세요.</h6>
						</div>
						
						<div class="card-body text-center">
							<table class="table table-striped" style="text-align: left">
								<tr>
									<th style="width: 15%">종류</th>
									<td>
										<select class="form-control" name="kind" id="kind">
											<c:forEach items="${kindList}" var="kind">
												<option value="${kind}">${kind}</option>
											</c:forEach>
										</select>
										<!-- 종류 입력
										<input type="text" class="form-control" id="kind" name="kind">
										-->
									</td>
								</tr>
								<tr>
									<th style="width: 15%">작성자</th>
									<td>
										<input type="text" class="form-control" id="id" name="id" value="${sessionScope.adminUser.id}" readonly="readonly">
									</td>
								</tr>
								<tr>
									<th style="width: 15%">제목</th>
									<td>
										<input type="text" class="form-control" id="subject" name="subject">
									</td>
								</tr>
								<tr>
									<th style="width: 15%">내용</th>
									<td>
										<textarea class="form-control" id="content" name="content" rows="6"></textarea>
									</td>
								</tr>								
								<tr>
									<th style="width: 15%">이미지</th>
									<td>
										<input type="file" id="notice_image" name="notice_image">
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
	
				<div class="col-4 col-lg-3">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">공지사항 등록</h5>
							<h6 class="card-subtitle text-muted">공지사항을 등록하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="button" class="btn btn-primary" value="등록" onClick="go_notice_write()">
							</div>
						</div>
						<hr>
						<div class="card-header">
							<h5 class="card-title">공지사항 등록 취소</h5>
							<h6 class="card-subtitle text-muted">공지사항 등록을 취소하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="reset" class="btn btn-warning" value="취소">
							</div>
						</div>
						<hr>
						<div class="card-header">
							<h5 class="card-title">공지사항 목록</h5>
							<h6 class="card-subtitle text-muted">공지사항 목록으로 이동하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="button" class="btn btn-secondary btn-lg" value="공지사항 목록" onClick="go_notice_list1()">
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</main>

<%@include file="../footer.jsp"%>