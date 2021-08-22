package com.green.biz.qna.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.QnaDAO;
import com.green.biz.dto.QnaVO;
import com.green.biz.qna.QnaService;
import com.green.biz.utils.Criteria;

@Service("qnaService")
public class QnaServiceImpl implements QnaService {
	
	@Autowired
	private QnaDAO qnaDao;
	
	// "사용자, Q&A" 목록 조회
	@Override
	public List<QnaVO> listQna(String id) {
		return qnaDao.listQna(id);
	}
	
	// "사용자 및 관리자 Q&A" 목록 조회
	@Override
	public List<QnaVO> listAllQna() {
		return qnaDao.listAllQna();
	}
	
	// "사용자 및 관리자, Q&A" 목록 총 개수 조회
	public int countQnaList(String name) {
		return qnaDao.countQnaList(name);
	}
		
	// "사용자 및 관리자, Q&A" 목록 조회 및 페이징
	public List<QnaVO> listQnaWithPaging(Criteria criteria, String key) {
		return qnaDao.listQnaWithPaging(criteria, key);
	}
	
	// "사용자, 관리자 Q&N" 상세 조회	
	@Override
	public QnaVO getQna(int qseq) {
		return qnaDao.getQna(qseq);
	}
	
	// "사용자, Q&A" 등록
	@Override
	public void insertQna(QnaVO vo) {
		qnaDao.insertQna(vo);
	}
	
	// "관리자, Q&A" 답변 등록
	@Override
	public void updateQna(QnaVO vo) {
		qnaDao.updateQna(vo);
	}

}