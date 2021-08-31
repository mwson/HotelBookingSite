package com.green.biz.comment;

import java.util.List;

import com.green.biz.dto.NoticeCommentVO;
import com.green.biz.utils.Criteria;

public interface CommentService {
	
	// "사용자, 공지사항 댓글" 조회
	public List<NoticeCommentVO> getCommentList(int nseq);
	
	// "사용자, 공지사항 댓글" 총 개수 조회
	public int countCommentList(int nseq);
	
	// "사용자, 공지사항 댓글" 조회 및 페이징
	public List<NoticeCommentVO> getCommentListWithPaging(Criteria criteria, int nseq);
	
	// "사용자, 공지사항 댓글" 등록
	public int saveComment(NoticeCommentVO vo);
	
	// "사용자, 공지사항 댓글" 수정
	public int updateComment(NoticeCommentVO vo);
	
	// "사용자, 공지사항 댓글" 삭제
	public int deleteComment(int ncseq);
	
}
