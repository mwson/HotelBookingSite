package com.green.biz.comment.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.comment.CommentService;
import com.green.biz.dao.CommentDAO;
import com.green.biz.dto.ProductCommentVO;
import com.green.biz.utils.Criteria;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDAO commentDao;
	
	@Override
	public List<ProductCommentVO> getCommentList(int pseq) {
		return commentDao.getCommentList(pseq);
	}

	@Override
	public int saveComment(ProductCommentVO vo) {
		return commentDao.saveComment(vo);
	}

	@Override
	public int updateComment(ProductCommentVO vo) {
		return commentDao.updateComment(vo);
	}

	@Override
	public int deleteComment(int comment_seq) {
		return commentDao.deleteComment(comment_seq);
	}

	@Override
	public int countCommentList(int pseq) {
		return commentDao.countCommentList(pseq);
	}

	@Override
	public List<ProductCommentVO> getCommentListWithPaging(Criteria criteria, int pseq) {
		return commentDao.getCommentListWithPaging(criteria, pseq);
	}

}
