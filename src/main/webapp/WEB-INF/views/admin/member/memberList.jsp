<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../sideMenu.jsp"%>
<%@include file="../header.jsp"%>

<main class="content">
	<div class="container-fluid p-0">
		<div class="mb-3">
			<h1 class="h3 d-inline align-middle">회원목록</h1>
		</div>
		
        <form method="post" id="member_form" name="member_form">         
			<div class="row">
				<div class="col-8 col-lg-9">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">회원목록</h5>
							<h6 class="card-subtitle text-muted">전체 회원들의 목록입니다.</h6>
						</div>
						<div class="card-body text-center">
							<table class="table table-striped" style="text-align: center;">
								<thead>
									<tr>
										<th style="width: 10%">탈퇴여부</th>
										<th style="width: 10%">아이디</th>
										<th style="width: 10%">이름</th>
										<th style="width: 15%">이메일</th>
										<th style="width: 10%">우편번호</th>
										<th style="width: 15%">주소</th>
										<th style="width: 15%">전화</th>
										<th style="width: 15%">가입일</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${memberList}" var="memberVO">
										<tr>  
											<td>
												<c:choose>
													<c:when test='${memberVO.useyn == "n"}'>
														<input type="checkbox" id="useyn" name="useyn" disabled="disabled"> <span style="color: #dc3545">탈퇴회원</span>
													</c:when>
							
													<c:otherwise>
														<input type="checkbox" id="useyn" name="useyn" checked="checked" disabled="disabled"> <span style="color: #3b7ddd">회원</span>
													</c:otherwise>
												</c:choose>			
											</td>    
											<td>${memberVO.id}</td>      
											<td>${memberVO.name}</td>
											<td>${memberVO.email}</td>
											<td>${memberVO.zip_num}</td>
											<td>${memberVO.address}</td>
											<td>${memberVO.phone}</td>
											<td><fmt:formatDate value="${memberVO.regdate}"/></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						
						<%@include file="memberPageArea.jsp"%>
						
					</div>
				</div>
	
				<div class="col-4 col-lg-3">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">검색</h5>
							<h6 class="card-subtitle text-muted">회원의 이름을 입력하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="text" class="form-control" id="key" name="key">
                                <input type="button" class="btn btn-secondary" value="검색" onclick="go_search_member()">
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</main>

<%@include file="../footer.jsp"%>