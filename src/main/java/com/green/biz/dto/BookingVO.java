package com.green.biz.dto;

import java.sql.Timestamp;

public class BookingVO {
	
	private int bseq;
	private String id;
	private int rid;
	private String checkin;
	private String checkout;
	private int people;
	private String cancel;
	private String result;
	private Timestamp indate;
	// "MemberVO" name
	private String name;
	// "RoomVO" type
	private String type;
	// "RoomVO" type
	private int price;
	
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
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
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
	
	public String getCancel() {
		return cancel;
	}
	public void setCancel(String cancel) {
		this.cancel = cancel;
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "BookingVO [bseq=" + bseq + ", id=" + id + ", rid=" + rid + ", checkin=" + checkin + ", checkout="
				+ checkout + ", people=" + people + ", cancel=" + cancel + ", result=" + result + ", indate=" + indate
				+ ", name=" + name + ", type=" + type + ", price=" + price + "]";
	}
	
}
