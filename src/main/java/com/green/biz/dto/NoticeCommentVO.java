package com.green.biz.dto;

import java.util.Date;

public class NoticeCommentVO {
	
	private int ncseq;
	private int nseq;
	private String content;
	private String writer;
	private Date regDate;
	private Date modifyDate;
	
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
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	@Override
	public String toString() {
		return "NoticeCommentVO [ncseq=" + ncseq + ", nseq=" + nseq + ", content=" + content + ", writer=" + writer
				+ ", regDate=" + regDate + ", modifyDate=" + modifyDate + "]";
	}

}
