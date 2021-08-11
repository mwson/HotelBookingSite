package com.green.biz.admin;

import com.green.biz.dto.WorkerVO;

public interface AdminService {
	
	public int workerCheck(String id, String pwd);
	
	public WorkerVO getEmployee(String id);
	
}