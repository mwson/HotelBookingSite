package com.green.biz.dto;

import java.sql.Timestamp;

public class RoomVO {
	
	private int rid;
	private String name;
	private int people;
	private int price;
	private String content;
	private String image;
	private String useyn;
	private Timestamp regdate;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
		return "RoomVO [rid=" + rid + ", name=" + name + ", people=" + people + ", price=" + price + ", content="
				+ content + ", image=" + image + ", useyn=" + useyn + ", regdate=" + regdate + "]";
	}
	
}
