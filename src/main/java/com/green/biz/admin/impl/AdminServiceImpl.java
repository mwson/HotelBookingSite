package com.green.biz.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.admin.AdminService;
import com.green.biz.dao.AdminDAO;
import com.green.biz.dto.WorkerVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDAO adminDAO;
	
	// "������" ���̵�� ��й�ȣ ��ȸ 
	@Override
	public int workerCheck(String id, String pwd) {
		int result = -1;
		
		String pwd_id_db = adminDAO.workerCheck(id);
		
		if(pwd_id_db == null) {
			result = -1;
		} else {
			if(pwd.equals(pwd_id_db)) {
				result = 1;
			} else {
				result = 0;
			}
		}
		return result;
	}
	
	// "������" ���̵� ��ȸ
	@Override
	public WorkerVO getEmployee(String id) {
		return adminDAO.getEmployee(id);
	}

}