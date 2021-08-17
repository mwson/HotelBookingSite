package com.green.biz.dto;

import java.sql.Timestamp;

public class BoardVO {
	
	private int bseq;
	private String subject;
	private String content;
	private String image;
	private Timestamp indate;
	
	public int getBseq() {
		return bseq;
	}
	public void setBseq(int bseq) {
		this.bseq = bseq;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	
	@Override
	public String toString() {
		return "BoardVO [bseq=" + bseq + ", subject=" + subject + ", content=" + content + ", image=" + image
				+ ", indate=" + indate + "]";
	}
	
}
