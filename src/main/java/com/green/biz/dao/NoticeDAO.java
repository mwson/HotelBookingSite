package com.green.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.NoticeVO;

@Repository("noardDAO")
public class NoticeDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<NoticeVO> listNotice() {
		return mybatis.selectList("NoticeDAO.listNotice");
	}
	
	public List<NoticeVO> listNoticeView() {
		return mybatis.selectList("NoticeDAO.listNoticeView");
	}
	
	public NoticeVO getNotice(int nseq) {
		return mybatis.selectOne("NoticeDAO.getNotice", nseq);
	}
	
	public void insertNotice(NoticeVO vo) {
		mybatis.insert("NoticeDAO.insertNotice", vo);
	}
	
	public void updateNotice(NoticeVO vo) {
		mybatis.update("NoticeDAO.updateNotice", vo);
	}
	
	public void deleteNotice(int nseq) {
		mybatis.delete("NoticeDAO.deleteNotice", nseq);
	}
	
}
