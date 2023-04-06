package com.tistory.offbyone.service;

import java.util.List;

public class SawonVO {
	
	private String sabun;
	private String name;
	private String phone;
	private String email;
	private List<PrizeVO> prizes;
	
	public String getSabun() {
		return sabun;
	}
	public void setSabun(String sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<PrizeVO> getPrizes() {
		return prizes;
	}
	public void setPrizes(List<PrizeVO> prizes) {
		this.prizes = prizes;
	}
	
	@Override
	public String toString() {
		return "SawonVO [sabun=" + sabun + ", name=" + name + ", phone=" + phone + ", email=" + email + ", prizes="
				+ prizes + "]";
	}
}
