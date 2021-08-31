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
	
	// "�����, �������� ���" ��ȸ
	@Override
	public List<NoticeCommentVO> getCommentList(int nseq) {
		return commentDao.getCommentList(nseq);
	}
	
	// "�����, �������� ���" �� ���� ��ȸ
	@Override
	public int countCommentList(int nseq) {
		return commentDao.countCommentList(nseq);
	}
	
	// "�����, �������� ���" ��ȸ �� ����¡
	@Override
	public List<NoticeCommentVO> getCommentListWithPaging(Criteria criteria, int nseq) {
		return commentDao.getCommentListWithPaging(criteria, nseq);
	}
	
	// "�����, �������� ���" ���
	@Override
	public int saveComment(NoticeCommentVO vo) {
		return commentDao.saveComment(vo);
	}
	
	// "�����, �������� ���" ����
	@Override
	public int updateComment(NoticeCommentVO vo) {
		return commentDao.updateComment(vo);
	}
	
	// "�����, �������� ���" ����
	@Override
	public int deleteComment(int ncseq) {
		return commentDao.deleteComment(ncseq);
	}

}
