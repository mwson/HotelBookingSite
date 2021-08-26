package com.green.biz.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.QnaVO;
import com.green.biz.utils.Criteria;

@Repository("qnaDAO")
public class QnaDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// "사용자, Q&N" 목록 조회
	public List<QnaVO> userQnaList(String id) {
		return mybatis.selectList("QnaDAO.userQnaList", id);
	}
	
	// "사용자, Q&A" 목록 수 조회
	public int userCountQnaList(String id) {
		return mybatis.selectOne("QnaDAO.userCountQnaList", id);
	}
		
	// "사용자, Q&A" 목록 조회 및 페이징
	public List<QnaVO> userQnaListWithPaging(Criteria criteria, String id) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("id", id);
		
		return mybatis.selectList("QnaDAO.userQnaListWithPaging", map);
	}
	
	// "관리자, Q&A" 목록 조회
	public List<QnaVO> adminQnaList() {
		return mybatis.selectList("QnaDAO.adminQnaList");
	}
	
	// "관리자, Q&A" 목록 수 조회
	public int adminCountQnaList(String name) {
		return mybatis.selectOne("QnaDAO.adminCountQnaList", name);
	}
		
	// "관리자, Q&A" 목록 조회 및 페이징
	public List<QnaVO> adminQnaListWithPaging(Criteria criteria, String key) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("key", key);
		
		return mybatis.selectList("QnaDAO.adminQnaListWithPaging", map);
	}
	
	// "사용자 및 관리자, Q&A" 상세 조회
	public QnaVO getQna(int qseq) {
		return mybatis.selectOne("QnaDAO.getQna", qseq);
	}
	
	// "사용자, Q&N" 등록
	public void insertQna(QnaVO vo) {
		mybatis.insert("QnaDAO.insertQna", vo);
	}
	
	// "관리자, Q&N" 답변 등록	
	public void updateQna(QnaVO vo) {
		mybatis.update("QnaDAO.updateQna", vo);
	}
}
