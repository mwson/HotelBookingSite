package com.green.biz.dto;

import java.util.Date;

public class NoticeCommentVO {
	
	private int notice_comment_seq;
	private int nseq;
	private String content;
	private String writer;
	private Date regDate;
	private Date modifyDate;
	public int getNotice_comment_seq() {
		return notice_comment_seq;
	}
	public void setNotice_comment_seq(int notice_comment_seq) {
		this.notice_comment_seq = notice_comment_seq;
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
		return "NoticeCommentVO [notice_comment_seq=" + notice_comment_seq + ", nseq=" + nseq + ", content=" + content
				+ ", writer=" + writer + ", regDate=" + regDate + ", modifyDate=" + modifyDate + "]";
	}
	

}
