<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../sideMenu.jsp"%>
<%@include file="../header.jsp"%>

<main class="content">
	<div class="container-fluid p-0">
		<div class="mb-3">
			<h1 class="h3 d-inline align-middle">객실목록</h1>
		</div>
		
        <form method="get" id="room_list_form" name="room_list_form">         
			<div class="row">
				<div class="col-8 col-lg-9">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">객실목록</h5>
							<h6 class="card-subtitle text-muted">전체 객실목록입니다.</h6>
						</div>
						<div class="card-body text-center">
							<table class="table table-striped" style="text-align: center;">
								<thead>
									<tr>
										<th style="width: 15%">사용유무</th> 
										<th style="width: 10%">객실번호</th>
										<th style="width: 35%">객실명</th>
										<th style="width: 10%">최대인원</th>
										<th style="width: 15%">가격</th>
										<th style="width: 15%">등록일</th>
									</tr>
								</thead>
								
								<tbody>
                                	<c:choose>
                                        <c:when test="${roomListSize<=0}">
                                            <tr>
                                                <td colspan="6">
													객실목록이 없습니다.
                                                </td>      
                                            </tr>
                                        </c:when>
                                        
                                        <c:otherwise>
                                            <c:forEach items="${roomList}" var="roomVO">
                                                <tr>
                                                	<td>
                                                        <c:choose>
                                                            <c:when test='${roomVO.useyn=="y"}'>
																<input type="checkbox" checked="checked" disabled="disabled"> <span style="color: #3b7ddd">사용</span>
															</c:when>
															
                                                            <c:otherwise>
                                                            	<input type="checkbox" disabled="disabled"> <span style="color: #dc3545">미 사용</span>
                                                            </c:otherwise>
                                                        </c:choose>	
                                                    </td>
                                                    <td>${roomVO.rid}</td>    
                                                    <td>
                                                        <a href="admin_room_detail${pageMaker.makeQuery(pageMaker.cri.pageNum)}&rid=${roomVO.rid}">
                                                            ${roomVO.type}
                                                        </a>
                                                    </td>
													<td>${roomVO.people}명</td>   
                                                    <td><fmt:formatNumber type="currency" value="${roomVO.price}"/></td>
                                                    <td><fmt:formatDate type="date" value="${roomVO.regdate}"/></td>
                                                </tr>
                                            </c:forEach>
                                        </c:otherwise>    
                                	</c:choose>
								</tbody>                                	
							</table>
						</div>
						
						<%@include file="roomPageArea.jsp"%>
						
					</div>
				</div>
	
				<div class="col-4 col-lg-3">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">객실 검색</h5>
							<h6 class="card-subtitle text-muted">객실명을 입력하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="text" class="form-control" id="key" name="key">
                                <input type="button" class="btn btn-secondary" value="검색" onclick="room_search()">
							</div>
						</div>
						<!-- 객실 등록
                        <hr>
                        <div class="card-header">
							<h5 class="card-title">객실등록</h5>
							<h6 class="card-subtitle text-muted">객실을 등록하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
                                <input type="button" class="btn btn-primary btn-lg" value="객실등록" onclick="room_write_form()">
							</div>
						</div>
						-->
					</div>
				</div>
			</div>
		</form>
	</div>
</main>

<%@include file="../footer.jsp"%>