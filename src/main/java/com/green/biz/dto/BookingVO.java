package com.green.biz.dto;

import java.sql.Timestamp;

public class BookingVO {
	
	private int bseq;
	private String id;
	private String rid;
	private String checkin;
	private String checkout;
	private int people;
	private String cancle;
	private String result;
	private Timestamp indate;
	
	public int getBseq() {
		return bseq;
	}
	public void setBseq(int bseq) {
		this.bseq = bseq;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	
	public String getCancle() {
		return cancle;
	}
	public void setCancle(String cancle) {
		this.cancle = cancle;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	
	@Override
	public String toString() {
		return "BookingVO [bseq=" + bseq + ", id=" + id + ", rid=" + rid + ", checkin=" + checkin + ", checkout="
				+ checkout + ", people=" + people + ", cancle=" + cancle + ", result=" + result + ", indate=" + indate
				+ "]";
	}
	
}
