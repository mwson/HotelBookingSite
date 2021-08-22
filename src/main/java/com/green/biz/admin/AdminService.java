package com.green.biz.admin;

import com.green.biz.dto.WorkerVO;

public interface AdminService {
	
	// "관리자" 아이디로 비밀번호 조회 
	public int workerCheck(String id, String pwd);
	
	// "관리자" 아이디 조회
	public WorkerVO getEmployee(String id);
	
}