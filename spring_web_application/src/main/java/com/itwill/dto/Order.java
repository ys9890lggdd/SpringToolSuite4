package com.itwill.dto;

public class Order {
	
	private String name;
	private String cardNo;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	@Override
	public String toString() {
		return "Order [name=" + name + ", cardNo=" + cardNo + ", address=" + address + "]";
	}
	
	
}
