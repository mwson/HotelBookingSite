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
	
	// "����� �� ������, ��������" ��ȸ
	@Override
	public List<NoticeVO> listNotice() {
		return noticeDAO.listNotice();
	}
	
	// "����� �� ������, ��������" �� ���� ��ȸ
	@Override
	public int countNoticeList(String subject) {
		return noticeDAO.countNoticeList(subject);
	}
	
	// "����� �� ������, ��������" ��ȸ �� ����¡
	@Override
	public List<NoticeVO> listNoticewithPaging(Criteria criteria, String key) {
		return noticeDAO.listNoticewithPaging(criteria, key);
	}
	
	// "����� �� ������, ��������" �� ��ȸ
	@Override
	public NoticeVO getNotice(int nseq) {
		return noticeDAO.getNotice(nseq);
	}
	
	// "�����, ��������" �󼼿��� �ϴ� ��ȸ  
	@Override
	public List<NoticeVO> getNoticeBottomList() {
		return noticeDAO.getNoticeBottomList();
	}
	
	// "������, �������׸��" ���
	@Override
	public void insertNotice(NoticeVO vo) {
		noticeDAO.insertNotice(vo);
	}
	
	// "������, �������׸��" ����
	@Override
	public void updateNotice(NoticeVO vo) {
		noticeDAO.updateNotice(vo);
	}
	
	// "������, �������׸��" ����
	@Override
	public void deleteNotice(int nseq) {
		noticeDAO.deleteNotice(nseq);
	}

}