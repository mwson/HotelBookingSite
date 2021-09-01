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
	
	// "사용자, 공지사항 댓글" 조회
	public NoticeCommentVO getComment(NoticeCommentVO vo) {
		return mybatis.selectOne("CommentDAO.getComment", vo);
	}
	
	// "사용자, 공지사항 댓글" 목록 조회
	public List<NoticeCommentVO> getCommentList(int nseq) {
		return mybatis.selectList("CommentDAO.getCommentList", nseq);
	}
	
	// "사용자, 공지사항 댓글" 총 개수 조회
	public int countCommentList(int nseq) {
		return mybatis.selectOne("CommentDAO.countCommentList", nseq);
	}
	
	// "사용자, 공지사항 댓글" 목록 조회 및 페이징
	public List<NoticeCommentVO> getCommentListWithPaging(Criteria criteria, int nseq) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("nseq", nseq);
		
		return mybatis.selectList("CommentDAO.getCommentListWithPaging", map);
	}
	
	// "사용자, 공지사항 댓글" 등록
	public int saveComment(NoticeCommentVO vo) {
		return mybatis.insert("CommentDAO.saveComment", vo);
	}
	
	// "사용자, 공지사항 댓글" 수정
	public int updateComment(NoticeCommentVO vo) {
		return mybatis.update("CommentDAO.updateComment", vo);
	}
	
	// "사용자, 공지사항 댓글" 삭제
	public int deleteComment(NoticeCommentVO vo) {
		return mybatis.delete("CommentDAO.deleteComment", vo);
	}
	
}
