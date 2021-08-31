package com.green.biz.comment.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.comment.CommentService;
import com.green.biz.dao.CommentDAO;
import com.green.biz.dto.NoticeCommentVO;
import com.green.biz.utils.Criteria;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDAO commentDao;
	
	// "사용자, 공지사항 댓글" 조회
	@Override
	public List<NoticeCommentVO> getCommentList(int nseq) {
		return commentDao.getCommentList(nseq);
	}
	
	// "사용자, 공지사항 댓글" 총 개수 조회
	@Override
	public int countCommentList(int nseq) {
		return commentDao.countCommentList(nseq);
	}
	
	// "사용자, 공지사항 댓글" 조회 및 페이징
	@Override
	public List<NoticeCommentVO> getCommentListWithPaging(Criteria criteria, int nseq) {
		return commentDao.getCommentListWithPaging(criteria, nseq);
	}
	
	// "사용자, 공지사항 댓글" 등록
	@Override
	public int saveComment(NoticeCommentVO vo) {
		return commentDao.saveComment(vo);
	}
	
	// "사용자, 공지사항 댓글" 수정
	@Override
	public int updateComment(NoticeCommentVO vo) {
		return commentDao.updateComment(vo);
	}
	
	// "사용자, 공지사항 댓글" 삭제
	@Override
	public int deleteComment(int ncseq) {
		return commentDao.deleteComment(ncseq);
	}

}
