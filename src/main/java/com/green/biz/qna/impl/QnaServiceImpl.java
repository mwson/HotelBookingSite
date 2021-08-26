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
	public List<QnaVO> userQnaList(String id) {
		return qnaDao.userQnaList(id);
	}
	
	// "사용자, Q&A" 목록 수 조회
	@Override
	public int userCountQnaList(String id) {
		return qnaDao.userCountQnaList(id);
	}
	
	// "사용자, Q&A" 목록 조회 및 페이징
	@Override
	public List<QnaVO> userQnaListWithPaging(Criteria criteria, String id) {
		return qnaDao.userQnaListWithPaging(criteria, id);
	}
	
	// "관리자 Q&A" 목록 조회
	@Override
	public List<QnaVO> adminQnaList() {
		return qnaDao.adminQnaList();
	}
	
	// "관리자, Q&A" 목록 수 조회
	@Override
	public int adminCountQnaList(String name) {
		return qnaDao.adminCountQnaList(name);
	}
	
	// "관리자, Q&A" 목록 조회 및 페이징
	@Override
	public List<QnaVO> adminQnaListWithPaging(Criteria criteria, String key) {
		return qnaDao.adminQnaListWithPaging(criteria, key);
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