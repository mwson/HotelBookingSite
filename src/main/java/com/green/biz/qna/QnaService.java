package com.green.biz.qna;

import java.util.List;

import com.green.biz.dto.QnaVO;
import com.green.biz.utils.Criteria;

public interface QnaService {
	
	// "사용자, Q&A" 목록 조회
	public List<QnaVO> userQnaList(String id);
	
	// "사용자, Q&A" 목록 수 조회
	public int userCountQnaList(String id);
	
	// "사용자, Q&A" 목록 조회 및 페이징
	public List<QnaVO> userQnaListWithPaging(Criteria criteria, String id);

	// "관리자 Q&A" 목록 조회
	public List<QnaVO> adminQnaList();
	
	// "관리자, Q&A" 목록 수 조회
	public int adminCountQnaList(String name);
	
	// "관리자, Q&A" 목록 조회 및 페이징
	public List<QnaVO> adminQnaListWithPaging(Criteria criteria, String key);
	
	// "사용자, 관리자 Q&N" 상세 조회	
	public QnaVO getQna(int qseq);

	// "사용자, Q&A" 등록
	public void insertQna(QnaVO vo);
	
	// "관리자, Q&A" 답변 등록
	public void updateQna(QnaVO vo);
	
}
