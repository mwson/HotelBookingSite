package com.green.biz.qna;

import java.util.List;

import com.green.biz.dto.QnaVO;
import com.green.biz.utils.Criteria;

public interface QnaService {
	
	// "�����, Q&A" ��� ��ȸ
	public List<QnaVO> userQnaList(String id);
	
	// "�����, Q&A" ��� �� ��ȸ
	public int userCountQnaList(String id);
	
	// "�����, Q&A" ��� ��ȸ �� ����¡
	public List<QnaVO> userQnaListWithPaging(Criteria criteria, String id);

	// "������ Q&A" ��� ��ȸ
	public List<QnaVO> adminQnaList();
	
	// "������, Q&A" ��� �� ��ȸ
	public int adminCountQnaList(String name);
	
	// "������, Q&A" ��� ��ȸ �� ����¡
	public List<QnaVO> adminQnaListWithPaging(Criteria criteria, String key);
	
	// "�����, ������ Q&N" �� ��ȸ	
	public QnaVO getQna(int qseq);

	// "�����, Q&A" ���
	public void insertQna(QnaVO vo);
	
	// "������, Q&A" �亯 ���
	public void updateQna(QnaVO vo);
	
}
