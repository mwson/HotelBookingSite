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
	
	// "사용자 및 관리자, 공지사항" 조회
	public List<NoticeVO> listNotice() {
		return mybatis.selectList("NoticeDAO.listNotice");
	}
	
	// "사용자 및 관리자, 공지사항" 총 개수 조회
	public int countNoticeList(String subject) {
		return mybatis.selectOne("NoticeDAO.countNoticeList", subject);
	}
	
	// "사용자 및 관리자, 공지사항" 조회 및 페이징
	public List<NoticeVO> listNoticewithPaging(Criteria criteria, String key) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("key", key);
		
		return mybatis.selectList("NoticeDAO.listNoticewithPaging", map);
	}
	
	// "사용자 및 관리자, 공지사항" 상세 조회
	public NoticeVO getNotice(int nseq) {
		return mybatis.selectOne("NoticeDAO.getNotice", nseq);
	}
	
	// "사용자, 공지사항" 상세에서 하단 조회  
	public List<NoticeVO> getNoticeBottomList() {
		return mybatis.selectList("NoticeDAO.getNoticeBottomList");
	}
	
	// "관리자, 공지사항목록" 등록
	public void insertNotice(NoticeVO vo) {
		mybatis.insert("NoticeDAO.insertNotice", vo);
	}
	
	// "관리자, 공지사항목록" 수정
	public void updateNotice(NoticeVO vo) {
		mybatis.update("NoticeDAO.updateNotice", vo);
	}
	
	// "관리자, 공지사항목록" 삭제
	public void deleteNotice(int nseq) {
		mybatis.delete("NoticeDAO.deleteNotice", nseq);
	}
	
}
