package com.green.biz.notice;

import java.util.List;

import com.green.biz.dto.NoticeVO;

public interface NoticeService {
		
	public List<NoticeVO> listNotice();
	
	public List<NoticeVO> listNoticeView();
	
	public NoticeVO getNotice(int nseq);
	
	public void insertNotice(NoticeVO vo);
	
	public void updateNotice(NoticeVO vo);
	
	public void deleteNotice(int nseq);
}
