<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../sideMenu.jsp"%>
<%@include file="../header.jsp"%>

<main class="content">
	<div class="container-fluid p-0">
		<div class="mb-3">
			<h1 class="h3 d-inline align-middle">Q&amp;A목록</h1>
		</div>
		
		<form method="post" id="qna_form" name="qna_form">        
			<div class="row">
				<div class="col-8 col-lg-9">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">Q&amp;A목록</h5>
							<h6 class="card-subtitle text-muted">전체 Q&amp;A목록입니다.</h6>
						</div>
						<div class="card-body text-center">
							<table class="table table-striped" style="text-align: center;">
								<thead>
									<tr>
										<th style="width: 15%">답변여부</th> 
										<th style="width: 10%">번호</th>
										<th style="width: 40%">제목</th>
										<th style="width: 10%">작성자</th>
										<th style="width: 10%">아이디</th>
										<th style="width: 15%">작성일</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${qnaList}" var="qnaVO">
										<tr>  
											<td>
												<c:choose>
													<c:when test='${qnaVO.rep=="1"}'>
														<input type="checkbox" id="rep" name="rep" disabled="disabled"> <span style="color: #dc3545">미 처리</span>
													</c:when>
							
													<c:otherwise>
														<input type="checkbox" checked="checked" disabled="disabled"> <span style="color: #3b7ddd">처리완료</span>
													</c:otherwise>
												</c:choose>			
											</td>
											<td>${qnaVO.qseq}</td>
											<td><a href="admin_qna_detail?qseq=${qnaVO.qseq}">${qnaVO.subject}</a></td>      
											<td>${qnaVO.name}</td>
											<td>${qnaVO.id}</td>
											<td><fmt:formatDate value="${qnaVO.indate}"/></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						
						<%@include file="qnaPageArea.jsp"%>
						
					</div>
				</div>
	
				<div class="col-4 col-lg-3">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">Q&amp;A목록 검색</h5>
							<h6 class="card-subtitle text-muted">작성자를 입력하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="text" class="form-control" id="key" name="key">
								<input type="button" class="btn btn-secondary" value="검색" onclick="go_search_qna()">
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</main>

<%@include file="../footer.jsp"%>