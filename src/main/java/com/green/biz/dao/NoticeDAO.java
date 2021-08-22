package com.green.biz.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.NoticeVO;
import com.green.biz.utils.Criteria;

@Repository("noticeDAO")
public class NoticeDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// "����� �� ������, ��������" ��ȸ
	public List<NoticeVO> listNotice() {
		return mybatis.selectList("NoticeDAO.listNotice");
	}
	
	// "����� �� ������, ��������" �� ���� ��ȸ
	public int countNoticeList(String subject) {
		return mybatis.selectOne("NoticeDAO.countNoticeList", subject);
	}
	
	// "����� �� ������, ��������" ��ȸ �� ����¡
	public List<NoticeVO> listNoticewithPaging(Criteria criteria, String key) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("key", key);
		
		return mybatis.selectList("NoticeDAO.listNoticewithPaging", map);
	}
	
	// "����� �� ������, ��������" �� ��ȸ
	public NoticeVO getNotice(int nseq) {
		return mybatis.selectOne("NoticeDAO.getNotice", nseq);
	}
	
	// "�����, ��������" �󼼿��� �ϴ� ��ȸ  
	public List<NoticeVO> getNoticeBottomList() {
		return mybatis.selectList("NoticeDAO.getNoticeBottomList");
	}
	
	// "������, �������׸��" ���
	public void insertNotice(NoticeVO vo) {
		mybatis.insert("NoticeDAO.insertNotice", vo);
	}
	
	// "������, �������׸��" ����
	public void updateNotice(NoticeVO vo) {
		mybatis.update("NoticeDAO.updateNotice", vo);
	}
	
	// "������, �������׸��" ����
	public void deleteNotice(int nseq) {
		mybatis.delete("NoticeDAO.deleteNotice", nseq);
	}
	
}
