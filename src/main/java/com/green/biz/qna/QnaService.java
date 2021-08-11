package com.green.biz.qna;

import java.util.List;

import com.green.biz.dto.QnaVO;

public interface QnaService {
	
	public List<QnaVO> listQna(String id);
	
	public List<QnaVO> listAllQna();
	
	public QnaVO getQna(int qseq);
	
	public void insertQna(QnaVO vo);
	
	public void updateQna(QnaVO vo);
	
}
