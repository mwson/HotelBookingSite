package com.green.biz.notice;

import java.util.List;

import com.green.biz.dto.NoticeVO;
import com.green.biz.utils.Criteria;

public interface NoticeService {
	
	// "사용자 및 관리자, 공지사항" 조회
	public List<NoticeVO> listNotice();
	
	// "사용자 및 관리자, 공지사항" 총 개수 조회
	public int countNoticeList(String subject);
	
	// "사용자 및 관리자, 공지사항" 조회 및 페이징
	public List<NoticeVO> listNoticewithPaging(Criteria criteria, String key);

	// "사용자 및 관리자, 공지사항" 상세 조회
	public NoticeVO getNotice(int nseq);
	
	// "사용자, 공지사항" 상세에서 하단 조회  
	public List<NoticeVO> getNoticeBottomList();
	
	// "관리자, 공지사항목록" 등록
	public void insertNotice(NoticeVO vo);
	
	// "관리자, 공지사항목록" 수정
	public void updateNotice(NoticeVO vo);
	
	// "관리자, 공지사항목록" 삭제
	public void deleteNotice(int nseq);
	
}
