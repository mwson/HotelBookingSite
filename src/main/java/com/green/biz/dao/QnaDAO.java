package com.green.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.QnaVO;

@Repository("qnaDAO")
public class QnaDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// ��ü QnA ����� ��ȸ
	public List<QnaVO> listQna(String id) {
		return mybatis.selectList("QnaDAO.listQna", id);
	}
	
	public List<QnaVO> listAllQna() {
		return mybatis.selectList("QnaDAO.listAllQna");
	}
	
	// �Ϸù�ȣ �� �Խñ� �� �� ��ȸ
	public QnaVO getQna(int qseq) {
		return mybatis.selectOne("QnaDAO.getQna", qseq);
	}
	
	// �Խñ� insert
	public void insertQna(QnaVO vo) {
		mybatis.insert("QnaDAO.insertQna", vo);
	}
	
	public void updateQna(QnaVO vo) {
		mybatis.update("QnaDAO.updateQna", vo);
	}
}
