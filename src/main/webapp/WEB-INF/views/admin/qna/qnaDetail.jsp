<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../sideMenu.jsp"%>
<%@include file="../header.jsp"%>

<main class="content">
	<div class="container-fluid p-0">
		<div class="mb-3">
			<h1 class="h3 d-inline align-middle">Q&amp;A 상세</h1>
		</div>
		
		<form method="post" id="qna_detail_form" name="qna_detail_form">
			<input type="hidden" id="qseq" name="qseq" value="${qnaVO.qseq}">         
			<div class="row">
				<div class="col-8 col-lg-9">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">Q&amp;A 상세</h5>
							<h6 class="card-subtitle text-muted">선택한 Q&amp;A의 상세내용입니다.</h6>
						</div>
						<div class="card-body text-center">
							<table class="table table-striped" style="text-align: left">
								<tr>
									<th style="width: 15%">제목</th>
									<td>${qnaVO.subject}</td>
								</tr>
								<tr>
									<th style="width: 15%">작성자(아이디)</th>
									<td>${qnaVO.name}(${qnaVO.id})</td>
								</tr>
								<tr>
									<th style="width: 15%">등록일</th>
									<td><fmt:formatDate value="${qnaVO.indate}"/></td>
								</tr>
								<tr>
									<th style="width: 15%">내용</th>
									<td>${qnaVO.content}</td>
								</tr>						
							</table>
						</div>
					</div>
					
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">Q&amp;A 답변</h5>
							<h6 class="card-subtitle text-muted">Q&amp;A 답변을 입력하세요.</h6>
						</div>
						<div class="card-body text-center">
							<table class="table table-striped" style="text-align: left">
								<tr>
									<c:choose>          
										<c:when test='${qnaVO.rep=="1"}'>
											<th style="width: 15%">답변<span style="color: #dc3545">(미 처리)</span></th>
											<td>
												<textarea class="form-control" id="reply" name="reply" rows="8"></textarea>
											</td>
										</c:when>
										
										<c:otherwise>
											<th style="width: 15%">답변<span style="color: #3b7ddd">(처리완료)</span></th>
											<td>  
												<textarea class="form-control" id="reply" name="reply" rows="8" readonly>${qnaVO.reply}</textarea>
											</td>  
										</c:otherwise>
									</c:choose>
								</tr>		
							</table>
						</div>
					</div>
				</div>
	
				<div class="col-4 col-lg-3">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">Q&amp;A 답변</h5>
							<h6 class="card-subtitle text-muted">Q&amp;A 답변을 등록하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="button" class="btn btn-primary" value="등록" onClick="go_qna_repsave()">
							</div>
						</div>
						<hr>
						<div class="card-header">
							<h5 class="card-title">Q&amp;A 목록</h5>
							<h6 class="card-subtitle text-muted">Q&amp;A 목록으로 이동하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="button" class="btn btn-secondary btn-lg" value="Q&amp;A목록" onClick="go_qna_list()">
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</main>

<%@include file="../footer.jsp"%>