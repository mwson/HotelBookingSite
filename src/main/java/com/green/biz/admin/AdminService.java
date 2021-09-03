package com.green.biz.admin;

import com.green.biz.dto.WorkerVO;

public interface AdminService {
	
	// "관리자" 비밀번호 조회 
	public int workerCheck(String id, String pwd);
	
	// "관리자" 조회
	public WorkerVO getEmployee(String id);
	
}