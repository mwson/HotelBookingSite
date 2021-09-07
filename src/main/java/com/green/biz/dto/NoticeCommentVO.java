package com.green.biz.dto;

import java.util.Date;

public class NoticeCommentVO {
	
	private int ncseq;
	private int nseq;
	private String id;
	private String content;
	private Date regdate;
	
	public int getNcseq() {
		return ncseq;
	}
	public void setNcseq(int ncseq) {
		this.ncseq = ncseq;
	}
	
	public int getNseq() {
		return nseq;
	}
	public void setNseq(int nseq) {
		this.nseq = nseq;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "NoticeCommentVO [ncseq=" + ncseq + ", nseq=" + nseq + ", id=" + id + ", content=" + content
				+ ", regdate=" + regdate + "]";
	}

}
