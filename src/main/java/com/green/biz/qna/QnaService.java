package com.green.biz.qna;

import java.util.List;

import com.green.biz.dto.QnaVO;
import com.green.biz.utils.Criteria;

public interface QnaService {
	
	// "사용자, Q&A" 목록 조회
	public List<QnaVO> listQna(String id);

	// "사용자 및 관리자 Q&A" 목록 조회
	public List<QnaVO> listAllQna();
	
	// "사용자 및 관리자, Q&A" 목록 총 개수 조회
	public int countQnaList(String name);
	
	// "사용자 및 관리자, Q&A" 목록 조회 및 페이징
	public List<QnaVO> listQnaWithPaging(Criteria criteria, String key);
	
	// "사용자, 관리자 Q&N" 상세 조회	
	public QnaVO getQna(int qseq);

	// "사용자, Q&A" 등록
	public void insertQna(QnaVO vo);
	
	// "관리자, Q&A" 답변 등록
	public void updateQna(QnaVO vo);
	
}
