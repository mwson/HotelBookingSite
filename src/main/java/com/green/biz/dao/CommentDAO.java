package com.green.biz.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.NoticeCommentVO;
import com.green.biz.utils.Criteria;

@Repository("commentDAO")
public class CommentDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// "�����, �������� ���" ��ȸ
	public NoticeCommentVO getComment(NoticeCommentVO vo) {
		return mybatis.selectOne("CommentDAO.getComment", vo);
	}
	
	// "�����, �������� ���" ��� ��ȸ
	public List<NoticeCommentVO> getCommentList(int nseq) {
		return mybatis.selectList("CommentDAO.getCommentList", nseq);
	}
	
	// "�����, �������� ���" �� ���� ��ȸ
	public int countCommentList(int nseq) {
		return mybatis.selectOne("CommentDAO.countCommentList", nseq);
	}
	
	// "�����, �������� ���" ��� ��ȸ �� ����¡
	public List<NoticeCommentVO> getCommentListWithPaging(Criteria criteria, int nseq) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("nseq", nseq);
		
		return mybatis.selectList("CommentDAO.getCommentListWithPaging", map);
	}
	
	// "�����, �������� ���" ���
	public int saveComment(NoticeCommentVO vo) {
		return mybatis.insert("CommentDAO.saveComment", vo);
	}
	
	// "�����, �������� ���" ����
	public int updateComment(NoticeCommentVO vo) {
		return mybatis.update("CommentDAO.updateComment", vo);
	}
	
	// "�����, �������� ���" ����
	public int deleteComment(NoticeCommentVO vo) {
		return mybatis.delete("CommentDAO.deleteComment", vo);
	}
	
}
