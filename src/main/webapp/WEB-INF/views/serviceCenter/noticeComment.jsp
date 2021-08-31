<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="blog__details__comment">
    <h3 id="cCnt"></h3>
    <div class="blog__details__comment__item">
        <div class="blog__details__comment__item__text">
            <form id="commentListForm" name="commentListForm">
                <div id="commentList"></div>
            </form>
        </div>
    </div>
    <div class="col-lg-12 col-md-12">
        <div class="pagination__number blog__pagination" style="text-align: center">
            <div id="pagination"></div>
        </div>
    </div>
</div>
<hr class="mb-5">
<div class="blog__details__comment__form">
    <h3>댓글 입력</h3>
    <div class="blog__details__comment__form__item">
        <form id="commentForm" name="commentForm">
            <input type="hidden" id="nseq" name="nseq" value="${noticeVO.nseq}"/>
            <div class="row">
                <div class="col-lg-4">
                    <input type="text" id="writer" value="${sessionScope.loginUser.name}" placeholder="로그인이 필요합니다." readonly>
                </div>
            </div>        
            <textarea rows="3" cols="80" id="content" name="content" placeholder="댓글을 입력하세요."></textarea>
            <div class="col-lg-2" style="float: right;">
                <input type="button" class="btn btn-warning btn-lg" onclick="save_comment('${noticeVO.nseq}')" value="등록">
            </div>
        </form>
    </div>
    <div style="clear: both;"></div>
</div>

<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		// 상품상세정보 로딩 시에 상품평 목록을 조회하여 출력
		getCommentList();
	});
	
	// 상품평 목록 불러오기
	function getCommentList() {
		$.ajax({
			type: 'GET',
			url: 'comments/list',
			dataType: 'json',
			data: $("#commentForm").serialize(),
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
			success: function(data) {
				var pageMaker = data.pageInfo;
				var commentList = data.commentList;
				var totalCount = data.total;
				
				showHTML(pageMaker, commentList, totalCount);
			},
			error: function() {
				alert("댓글 목록을 조회하지 못했습니다.");
			}
		});
	}
	
	/* 
	 * 상품평 페이지별 목록 요청
	 */
	function getCommentPaging(pagenum, rowsperpage, nseq) {
		$.ajax({
			type: 'GET',
			url: 'comments/list',
			dataType: 'json',
			data: {
				"pageNum": pagenum,
				"rowsPerPage": rowsperpage,
				"nseq": nseq
			},
			contentType: 'application/x-www-form-urlencoded; charset=utf-8',
			success: function(data) {
				var pageMaker = data.pageInfo;
				var commentList = data.commentList;
				var totalCount = data.total;
				
				showHTML(pageMaker, commentList, totalCount);
			},
			error: function() {
				alert("댓글 목록을 조회하지 못했습니다.");
			}
		});
	}
	 
	function showHTML(pageMaker, commentList, totalCount) {
		var html = "";
		var p_html = "";
		var prev = "Prev";
		var next = "Next";

		if(commentList.length > 0) {
			// 상품평의 각 항목별로 HTML 생성
			$.each(commentList, function(index, item) {
				html += "<span>" + displayTime(item.regDate) + "</span>";
				html += "<h5>" + item.writer + "</h5>";
				html += "<p>" + item.content + "</p>";
				html += "<hr/>"
				
			});
			
			// 페이징 버튼 출력
			if(pageMaker.cri.prev == true) {
				p_html += "<a href='javascript:getCommentPaging("
	                 + (pageMaker.startPage - 1) + "," + pageMaker.cri.rowsPerPage + "," + ${noticeVO.nseq} +")'>" + prev + "<span class=\"arrow_left\"></span></a>";
			}
			 
			for(var i = pageMaker.startPage; i <= pageMaker.endPage; i++) {
				p_html += "<a href='javascript:getCommentPaging("
	                 + i + "," + pageMaker.cri.rowsPerPage + "," + ${noticeVO.nseq} + ")'>" + i + "</a>";
			}
			
			if(pageMaker.cri.next == true) {
				p_html += "<a href='javascript:getCommentPaging("
	                 + (pageMaker.endPage + 1) + "," + pageMaker.cri.rowsPerPage + "," + ${noticeVO.nseq} + ")'>" + next + "<span class=\"arrow_right\"></span></a>";
			}
		} else { // 조회된 상품평이 없을 경우
			html += "<div>";
			html += "<h5>등록된 댓글이 없습니다.</h5>";
			html += "</div>";
		}
		
		// 상풍평 갯수 출력
		$("#cCnt").html("댓글 " + totalCount);
		// 상품평 목록 출력
		$("#commentList").html(html);
		// 페이징 버튼 출력
		$("#pagination").html(p_html);
	}
	
	// 입력 파라미터: timeValue - 상품평 등록 시간
	function displayTime(timeValue) {
		var today = new Date();
		
		// 현재시간에서 댓글등록시간을 빼줌
		var timeGap = today.getTime() - timeValue;
		
		// timeValue를 Date객체로 변환
		var dateObj = new Date(timeValue);
		
		// timeGap이 24시간 이내인지 판단
		if(timeGap < (1000 * 60 * 60 * 24)) { // 시, 분, 초를 구함
			var hh = dateObj.getHours();
			var mi = dateObj.getMinutes();
			var ss = dateObj.getSeconds();
			
			return [(hh > 9 ? '' : '0') + hh, ':', (mi > 9 ? '' : '0') + mi, ':', (ss > 9 ? '' : '0') + ss].join('');
			
			/*
			var hh = ("0" + dateObj.getHours()).slice(-2);
			var mi = ("0" + dateObj.getMinutes()).slice(-2);
			var ss = ("0" + dateObj.getSeconds()).slice(-2);
			
			return hh + ':' + mi + ':' + ss;
			*/
		} else {
			var yy = dateObj.getFullYear();
			var mm = dateObj.getMonth() + 1;
			var dd = dateObj.getDate();
			
			return [yy, '/', (mm > 9 ? '' : '0') + mm, '/', (dd > 9 ? '' : '0') + dd].join('');
			
			/*
			var yy = dateObj.getFullYear();
			var mm = ("0" + (dateObj.getMonth() + 1)).slice(-2);
			var dd = ("0" + dateObj.getDate()).slice(-2);
			
			return yy + "-" + mm + "-" + dd; 
			*/
		}
	}
	
	// 댓글 등록	
	function save_comment(nseq) {
		$.ajax({
			type: 'POST',
			url: 'comments/save',
			data: $("#commentForm").serialize(),
			success: function(data) {
				if(data == 'success') {
					getCommentList();
					$("#content").val("");
				} else if(data == 'fail') {
					alert("댓글 등록이 실패하였습니다.");
				} else if(data == 'not_logedin') {
					alert("댓글 등록은 로그인이 필요합니다.");
					location.href="login_form"
				}
			},
			error: function(request, status, error) {
				alert("error: " + error);
			}
		});
	}
	
	// 댓글 수정
	function update_comment(nseq) {
		$.ajax({
			type: 'POST',
			url: 'comments/update',
			data: $("#commentForm").serialize(),
			success: function(data) {
				if(data == 'success') {
					getCommentList();
					$("#content").val("");
				} else if(data == 'fail') {
					alert("댓글 수정이 실패하였습니다.");
				} else if(data == 'not_logedin') {
					alert("댓글 수정은 로그인이 필요합니다.");
					location.href="login_form"
				}
			},
			error: function(request, status, error) {
				alert("error: " + error);
			}
		});
	}
	
	// 댓글 수정
	function delete_comment(nseq) {
		$.ajax({
			type: 'POST',
			url: 'comments/delete',
			data: $("#commentForm").serialize(),
			success: function(data) {
				if(data == 'success') {
					getCommentList();
					$("#content").val("");
				} else if(data == 'fail') {
					alert("댓글 삭제가 실패하였습니다.");
				} else if(data == 'not_logedin') {
					alert("댓글 삭제는 로그인이 필요합니다.");
					location.href="login_form"
				}
			},
			error: function(request, status, error) {
				alert("error: " + error);
			}
		});
	}
</script>