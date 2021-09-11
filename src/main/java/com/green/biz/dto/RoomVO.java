package com.green.biz.dto;

import java.sql.Timestamp;

public class RoomVO {
	
	private int rid;
	private String type;
	private int people;
	private String bed;
	private int price;
	private String image;
	private String useyn;
	private Timestamp regdate;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	
	public String getBed() {
		return bed;
	}
	public void setBed(String bed) {
		this.bed = bed;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getUseyn() {
		return useyn;
	}
	public void setUseyn(String useyn) {
		this.useyn = useyn;
	}
	
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "RoomVO [rid=" + rid + ", type=" + type + ", people=" + people + ", bed=" + bed + ", price=" + price
				+ ", image=" + image + ", useyn=" + useyn + ", regdate=" + regdate + "]";
	}
	
}
