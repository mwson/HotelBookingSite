package com.green.biz.admin;

import com.green.biz.dto.WorkerVO;

public interface AdminService {
	
	// "������" ���̵�� ��й�ȣ ��ȸ 
	public int workerCheck(String id, String pwd);
	
	// "������" ���̵� ��ȸ
	public WorkerVO getEmployee(String id);
	
}