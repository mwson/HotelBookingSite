package com.green.biz.notice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.NoticeDAO;
import com.green.biz.dto.NoticeVO;
import com.green.biz.notice.NoticeService;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public List<NoticeVO> listNotice() {
		return noticeDAO.listNotice();
	}

	@Override
	public List<NoticeVO> listNoticeView() {
		return noticeDAO.listNoticeView();
	}
	
	@Override
	public NoticeVO getNotice(int nseq) {
		return noticeDAO.getNotice(nseq);
	}

	@Override
	public void insertNotice(NoticeVO vo) {
		noticeDAO.insertNotice(vo);
	}

	@Override
	public void updateNotice(NoticeVO vo) {
		noticeDAO.updateNotice(vo);
	}

	@Override
	public void deleteNotice(int nseq) {
		noticeDAO.deleteNotice(nseq);
	}

}