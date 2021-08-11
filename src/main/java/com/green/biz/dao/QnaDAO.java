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
	
	// 전체 QnA 목록을 조회
	public List<QnaVO> listQna(String id) {
		return mybatis.selectList("QnaDAO.listQna", id);
	}
	
	public List<QnaVO> listAllQna() {
		return mybatis.selectList("QnaDAO.listAllQna");
	}
	
	// 일련번호 별 게시글 한 건 조회
	public QnaVO getQna(int qseq) {
		return mybatis.selectOne("QnaDAO.getQna", qseq);
	}
	
	// 게시글 insert
	public void insertQna(QnaVO vo) {
		mybatis.insert("QnaDAO.insertQna", vo);
	}
	
	public void updateQna(QnaVO vo) {
		mybatis.update("QnaDAO.updateQna", vo);
	}
}
