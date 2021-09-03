package com.green.biz.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.WorkerVO;

@Repository("adminDAO")
public class AdminDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// "관리자" 비밀번호 조회 
	public String workerCheck(String id) {
		return mybatis.selectOne("AdminDAO.workerCheck", id);
	}
	
	// "관리자, 정보" 조회
	public WorkerVO getEmployee(String id) {
		return mybatis.selectOne("AdminDAO.getEmployee", id);
	}
	
}