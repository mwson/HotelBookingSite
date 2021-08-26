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
	
	// "�����, Q&N" ��� ��ȸ
	public List<QnaVO> userQnaList(String id) {
		return mybatis.selectList("QnaDAO.userQnaList", id);
	}
	
	// "�����, Q&A" ��� �� ��ȸ
	public int userCountQnaList(String id) {
		return mybatis.selectOne("QnaDAO.userCountQnaList", id);
	}
		
	// "�����, Q&A" ��� ��ȸ �� ����¡
	public List<QnaVO> userQnaListWithPaging(Criteria criteria, String id) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("id", id);
		
		return mybatis.selectList("QnaDAO.userQnaListWithPaging", map);
	}
	
	// "������, Q&A" ��� ��ȸ
	public List<QnaVO> adminQnaList() {
		return mybatis.selectList("QnaDAO.adminQnaList");
	}
	
	// "������, Q&A" ��� �� ��ȸ
	public int adminCountQnaList(String name) {
		return mybatis.selectOne("QnaDAO.adminCountQnaList", name);
	}
		
	// "������, Q&A" ��� ��ȸ �� ����¡
	public List<QnaVO> adminQnaListWithPaging(Criteria criteria, String key) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("key", key);
		
		return mybatis.selectList("QnaDAO.adminQnaListWithPaging", map);
	}
	
	// "����� �� ������, Q&A" �� ��ȸ
	public QnaVO getQna(int qseq) {
		return mybatis.selectOne("QnaDAO.getQna", qseq);
	}
	
	// "�����, Q&N" ���
	public void insertQna(QnaVO vo) {
		mybatis.insert("QnaDAO.insertQna", vo);
	}
	
	// "������, Q&N" �亯 ���	
	public void updateQna(QnaVO vo) {
		mybatis.update("QnaDAO.updateQna", vo);
	}
}
