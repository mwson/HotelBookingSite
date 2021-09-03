package com.green.biz.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.WorkerVO;

@Repository("adminDAO")
public class AdminDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// "������" ��й�ȣ ��ȸ 
	public String workerCheck(String id) {
		return mybatis.selectOne("AdminDAO.workerCheck", id);
	}
	
	// "������, ����" ��ȸ
	public WorkerVO getEmployee(String id) {
		return mybatis.selectOne("AdminDAO.getEmployee", id);
	}
	
}