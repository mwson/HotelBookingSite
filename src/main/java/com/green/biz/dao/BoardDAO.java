package com.green.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.BoardVO;

@Repository("boardDAO")
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<BoardVO> listBoard() {
		return mybatis.selectList("BoardDAO.listBoard");
	}
	
	public BoardVO getBoard(int bseq) {
		return mybatis.selectOne("BoardDAO.getBoard", bseq);
	}
	
	public void insertBoard(BoardVO vo) {
		mybatis.insert("BoardDAO.insertBoard", vo);
	}
	
	public void updateBoard(BoardVO vo) {
		mybatis.update("BoardDAO.updateBoard", vo);
	}
	
	public void deleteBoard(int bseq) {
		mybatis.delete("BoardDAO.deleteBoard", bseq);
	}
	
}
