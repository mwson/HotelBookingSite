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
	
	public int saveComment(NoticeCommentVO vo) {
		return mybatis.insert("CommentDAO.saveComment", vo);
	}
	
	public int deleteComment(int comment_seq) {
		return mybatis.delete("CommentDAO.deleteComment", comment_seq);
	}
	
	public int countCommentList(int nseq) {
		return mybatis.selectOne("CommentDAO.countCommentList", nseq);
	}
	
	public List<NoticeCommentVO> getCommentListWithPaging(Criteria criteria, int nseq) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("nseq", nseq);
		
		return mybatis.selectList("CommentDAO.getCommentListWithPaging", map);
	}
	
}
