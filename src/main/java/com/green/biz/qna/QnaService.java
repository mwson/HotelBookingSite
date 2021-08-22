package com.green.biz.qna;

import java.util.List;

import com.green.biz.dto.QnaVO;
import com.green.biz.utils.Criteria;

public interface QnaService {
	
	// "�����, Q&A" ��� ��ȸ
	public List<QnaVO> listQna(String id);

	// "����� �� ������ Q&A" ��� ��ȸ
	public List<QnaVO> listAllQna();
	
	// "����� �� ������, Q&A" ��� �� ���� ��ȸ
	public int countQnaList(String name);
	
	// "����� �� ������, Q&A" ��� ��ȸ �� ����¡
	public List<QnaVO> listQnaWithPaging(Criteria criteria, String key);
	
	// "�����, ������ Q&N" �� ��ȸ	
	public QnaVO getQna(int qseq);

	// "�����, Q&A" ���
	public void insertQna(QnaVO vo);
	
	// "������, Q&A" �亯 ���
	public void updateQna(QnaVO vo);
	
}
