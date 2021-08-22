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
	public List<QnaVO> listQna(String id) {
		return qnaDao.listQna(id);
	}
	
	// "����� �� ������ Q&A" ��� ��ȸ
	@Override
	public List<QnaVO> listAllQna() {
		return qnaDao.listAllQna();
	}
	
	// "����� �� ������, Q&A" ��� �� ���� ��ȸ
	public int countQnaList(String name) {
		return qnaDao.countQnaList(name);
	}
		
	// "����� �� ������, Q&A" ��� ��ȸ �� ����¡
	public List<QnaVO> listQnaWithPaging(Criteria criteria, String key) {
		return qnaDao.listQnaWithPaging(criteria, key);
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