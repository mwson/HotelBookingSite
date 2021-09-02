<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../sideMenu.jsp"%>
<%@include file="../header.jsp"%>

<main class="content">
	<div class="container-fluid p-0">
		<div class="mb-3">
			<h1 class="h3 d-inline align-middle">공지사항목록</h1>
		</div>
					
		<form method="get" id="notice_form" name="notice_form">
			<div class="row">
				<div class="col-8 col-lg-9">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">공지사항목록</h5>
							<h6 class="card-subtitle text-muted">전체 공지사항목록입니다.</h6>
						</div>
						<div class="card-body text-center">
							<table class="table table-striped" style="text-align: center;">
								<thead>
									<tr>
										<th style="width: 15%">번호</th>
										<th style="width: 20%">종류</th> 
										<th style="width: 50%">제목</th>
										<th style="width: 15%">작성일</th>
									</tr>
								</thead>
								<tbody>
                                	<c:choose>
                                        <c:when test="${noticeListSize<=0}">
                                            <tr>
                                                <td colspan="4">
													공지사항목록이 없습니다.
                                                </td>      
                                            </tr>
                                        </c:when>
                                        
                                        <c:otherwise>
											<c:forEach items="${noticeList}" var="noticeVO">
												<tr>  
													<td>${noticeVO.nseq}</td>
													<td>${noticeVO.kind}</td> 
													<td><a href="admin_notice_detail?nseq=${noticeVO.nseq}">${noticeVO.subject}</a></td>      
													<td><fmt:formatDate value="${noticeVO.indate}"/></td>
												</tr>
											</c:forEach>
                                        </c:otherwise>    
                                	</c:choose>
								</tbody>
							</table>
						</div>
						
						<%@include file="noticePageArea.jsp"%>
						
					</div>
				</div>
	
				<div class="col-4 col-lg-3">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">공지사항 검색</h5>
							<h6 class="card-subtitle text-muted">제목을 입력하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="text" class="form-control" id="key" name="key" value="${key}">
								<input type="button" class="btn btn-secondary" value="검색" onclick="go_search_notice()">
							</div>
						</div>
						<hr>
						<div class="card-header">
							<h5 class="card-title">공지사항 등록</h5>
							<h6 class="card-subtitle text-muted">공지사항을 등록하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="button" class="btn btn-primary btn-lg" value="등록" onClick="go_notice_write_form()">
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</main>

<%@include file="../footer.jsp"%>