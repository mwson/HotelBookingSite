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
	
	// "�����, Q&A" ��� ��ȸ
	@Override
	public List<QnaVO> userQnaList(String id) {
		return qnaDao.userQnaList(id);
	}
	
	// "�����, Q&A" ��� �� ��ȸ
	@Override
	public int userCountQnaList(String id) {
		return qnaDao.userCountQnaList(id);
	}
	
	// "�����, Q&A" ��� ��ȸ �� ����¡
	@Override
	public List<QnaVO> userQnaListWithPaging(Criteria criteria, String id) {
		return qnaDao.userQnaListWithPaging(criteria, id);
	}
	
	// "������ Q&A" ��� ��ȸ
	@Override
	public List<QnaVO> adminQnaList() {
		return qnaDao.adminQnaList();
	}
	
	// "������, Q&A" ��� �� ��ȸ
	@Override
	public int adminCountQnaList(String name) {
		return qnaDao.adminCountQnaList(name);
	}
	
	// "������, Q&A" ��� ��ȸ �� ����¡
	@Override
	public List<QnaVO> adminQnaListWithPaging(Criteria criteria, String key) {
		return qnaDao.adminQnaListWithPaging(criteria, key);
	}
	
	// "�����, ������ Q&N" �� ��ȸ	
	@Override
	public QnaVO getQna(int qseq) {
		return qnaDao.getQna(qseq);
	}
	
	// "�����, Q&A" ���
	@Override
	public void insertQna(QnaVO vo) {
		qnaDao.insertQna(vo);
	}
	
	// "������, Q&A" �亯 ���
	@Override
	public void updateQna(QnaVO vo) {
		qnaDao.updateQna(vo);
	}

}