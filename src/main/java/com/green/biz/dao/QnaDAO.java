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
	public List<QnaVO> listQna(String id) {
		return mybatis.selectList("QnaDAO.listQna", id);
	}
	
	// "관리자, Q&N" 목록 조회
	public List<QnaVO> listAllQna() {
		return mybatis.selectList("QnaDAO.listAllQna");
	}
	
	// "Q&N" 목록 총 개수 조회	
	public int countQnaList(String name) {
		return mybatis.selectOne("QnaDAO.countQnaList", name);
	}
		
	// "사용자 Q&N" 목록  조회 및 페이징 처리
	public List<QnaVO> listQnaWithPaging(Criteria criteria, String key) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("key", key);
		
		return mybatis.selectList("QnaDAO.listQnaWithPaging", map);
	}
	
	// "Q&N" 상세 조회	
	public QnaVO getQna(int qseq) {
		return mybatis.selectOne("QnaDAO.getQna", qseq);
	}
	
	// "사용자 Q&N" 등록
	public void insertQna(QnaVO vo) {
		mybatis.insert("QnaDAO.insertQna", vo);
	}
	
	// "관리자 Q&N" 답변 등록	
	public void updateQna(QnaVO vo) {
		mybatis.update("QnaDAO.updateQna", vo);
	}
}
