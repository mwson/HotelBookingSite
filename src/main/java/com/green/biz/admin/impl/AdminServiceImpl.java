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
	
	/*
	 * �Է� �Ķ���� :
	 * id - ����� �Է� id
	 * pwd - ����� �Է� ��ȣ
	 */
	@Override
	public int workerCheck(String id, String pwd) {
		int result = -1;
		
		String pwd_id_db = adminDAO.workerCheck(id); // ���̺� �����ϴ� ������id�� pwd��ȯ
		
		if(pwd_id_db == null) {
			result = -1; // id�� �������� ����
		} else {
			if(pwd.equals(pwd_id_db)) {	// �Է� pwd�� DB���� pwd�� ��ġ
				result = 1;
			} else {
				result = 0;
			}
		}
		
		return result;
	}

	@Override
	public WorkerVO getEmployee(String id) {
		return adminDAO.getEmployee(id);
	}

}