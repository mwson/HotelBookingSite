package com.green.biz.notice;

import java.util.List;

import com.green.biz.dto.NoticeVO;
import com.green.biz.utils.Criteria;

public interface NoticeService {
	
	// "����� �� ������, ��������" ��ȸ
	public List<NoticeVO> listNotice();
	
	// "����� �� ������, ��������" �� ���� ��ȸ
	public int countNoticeList(String subject);
	
	// "����� �� ������, ��������" ��ȸ �� ����¡
	public List<NoticeVO> listNoticewithPaging(Criteria criteria, String key);

	// "����� �� ������, ��������" �� ��ȸ
	public NoticeVO getNotice(int nseq);
	
	// "�����, ��������" �󼼿��� �ϴ� ��ȸ  
	public List<NoticeVO> getNoticeBottomList();
	
	// "������, �������׸��" ���
	public void insertNotice(NoticeVO vo);
	
	// "������, �������׸��" ����
	public void updateNotice(NoticeVO vo);
	
	// "������, �������׸��" ����
	public void deleteNotice(int nseq);
	
}
