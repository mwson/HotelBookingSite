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

	@Override
	public int saveComment(NoticeCommentVO vo) {
		return commentDao.saveComment(vo);
	}

	@Override
	public int deleteComment(int comment_seq) {
		return commentDao.deleteComment(comment_seq);
	}

	@Override
	public int countCommentList(int nseq) {
		return commentDao.countCommentList(nseq);
	}

	@Override
	public List<NoticeCommentVO> getCommentListWithPaging(Criteria criteria, int nseq) {
		return commentDao.getCommentListWithPaging(criteria, nseq);
	}

}
