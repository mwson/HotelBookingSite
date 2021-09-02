package com.green.biz.notice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.NoticeDAO;
import com.green.biz.dto.NoticeVO;
import com.green.biz.notice.NoticeService;
import com.green.biz.utils.Criteria;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	// "사용자, 메인" 하단 프로모션 조회
	@Override
	public List<NoticeVO> getPromotionIndexBottomList() {
		return noticeDAO.getPromotionIndexBottomList();
	}
	
	//"사용자, 메인" 하단 공지사항 조회
	@Override
	public List<NoticeVO> getNoticeIndexBottomList() {
		return noticeDAO.getNoticeIndexBottomList();
	}
	
	// "사용자 및 관리자, 공지사항" 조회
	@Override
	public List<NoticeVO> listNotice() {
		return noticeDAO.listNotice();
	}
	
	// "사용자 및 관리자, 공지사항" 총 개수 조회
	@Override
	public int countNoticeList(String subject) {
		return noticeDAO.countNoticeList(subject);
	}
	
	// "사용자 및 관리자, 공지사항" 조회 및 페이징
	@Override
	public List<NoticeVO> noticeListWithPaging(Criteria criteria, String key) {
		return noticeDAO.noticeListWithPaging(criteria, key);
	}
	
	// "사용자 및 관리자, 공지사항" 상세 조회
	@Override
	public NoticeVO getNotice(int nseq) {
		return noticeDAO.getNotice(nseq);
	}
	
	// "사용자, 공지사항" 상세에서 하단 조회  
	@Override
	public List<NoticeVO> getNoticeBottomList() {
		return noticeDAO.getNoticeBottomList();
	}
	
	// "관리자, 공지사항목록" 등록
	@Override
	public void insertNotice(NoticeVO vo) {
		noticeDAO.insertNotice(vo);
	}
	
	// "관리자, 공지사항목록" 수정
	@Override
	public void updateNotice(NoticeVO vo) {
		noticeDAO.updateNotice(vo);
	}
	
	// "관리자, 공지사항목록" 삭제
	@Override
	public void deleteNotice(int nseq) {
		noticeDAO.deleteNotice(nseq);
	}

}