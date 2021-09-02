<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  

<%@include file="../header.jsp"%>

<div class="breadcrumb-option set-bg" data-setbg="img/breadcrumb-bg.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h1>공지사항</h1>
                    <div class="breadcrumb__links">
                        <a href="index">메인</a>
                        <span>고객센터</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="blog spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-3">
                <div class="blog__sidebar">
                    <div class="blog__sidebar__search">
                        <h4>검색</h4>
                        <form method="get" id="notice_form" name="notice_form">
                            <input type="text" id="key" name="key" placeholder="입력">
                            <input type="button" class="notice_form_button" value="검색" onclick="go_search_notice()">
                        </form>
                    </div>
                    <div class="blog__sidebar__categories">
                        <h4>고객센터</h4>
                        <hr>
                        <ul>
                            <li><a href="notice_list">공지사항</a></li>
                            <li><a href="faq_list">자주하는 질문</a></li>
                            <li><a href="qna_write_form">문의하기</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="col-lg-9 col-md-9">
                <div class="row">
	                <c:choose>
						<c:when test="${noticeListSize<=0}">
							<div class="noticeList_form_empty col-lg-12 col-md-12">
								<h4 style="text-align: center;">공지사항목록이 없습니다.</h4>     
							</div>
						</c:when>
						
						<c:otherwise>
		                	<c:forEach items="${noticeList}" var="noticeVO">
			                    <div class="col-lg-6 col-md-6">
			                        <div class="blog__item">
			                            <div class="blog__item__pic">
			                                <img src="img/blog/blog-1.jpg" alt="">
			                                <!-- 사진
			                                <img src="${noticeVO.image}" alt="">
			                                -->
			                                <div class="tag">${noticeVO.kind}</div>
			                            </div>
			                            <div class="blog__item__text">
			                                <p>
			                                	<i class="fa fa-clock-o"></i>
			                                	<fmt:formatDate value="${noticeVO.indate}" type="date"/>
			                                </p>
			                                <h5><a href="notice_detail?nseq=${noticeVO.nseq}">${noticeVO.subject}</a></h5>
			                            </div>
			                        </div>
			                    </div>
			                </c:forEach>
						</c:otherwise>    
					</c:choose>
					
					<%@include file="noticePageArea.jsp"%>
					 
                </div>
            </div>
        </div>
    </div>
</section>

<%@include file="../footer.jsp"%>