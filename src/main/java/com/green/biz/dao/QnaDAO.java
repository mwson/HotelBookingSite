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
	public List<QnaVO> listQna(String id) {
		return mybatis.selectList("QnaDAO.listQna", id);
	}
	
	// "������, Q&N" ��� ��ȸ
	public List<QnaVO> listAllQna() {
		return mybatis.selectList("QnaDAO.listAllQna");
	}
	
	// "Q&N" ��� �� ���� ��ȸ	
	public int countQnaList(String name) {
		return mybatis.selectOne("QnaDAO.countQnaList", name);
	}
		
	// "����� Q&N" ���  ��ȸ �� ����¡ ó��
	public List<QnaVO> listQnaWithPaging(Criteria criteria, String key) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("key", key);
		
		return mybatis.selectList("QnaDAO.listQnaWithPaging", map);
	}
	
	// "Q&N" �� ��ȸ	
	public QnaVO getQna(int qseq) {
		return mybatis.selectOne("QnaDAO.getQna", qseq);
	}
	
	// "����� Q&N" ���
	public void insertQna(QnaVO vo) {
		mybatis.insert("QnaDAO.insertQna", vo);
	}
	
	// "������ Q&N" �亯 ���	
	public void updateQna(QnaVO vo) {
		mybatis.update("QnaDAO.updateQna", vo);
	}
}
