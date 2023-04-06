package com.tistory.offbyone.service;

public class PrizeVO {
	
	private String sabun;
	private Integer seq;
	private String prizeName;
	private String prizeOrg;
	
	public String getSabun() {
		return sabun;
	}
	public void setSabun(String sabun) {
		this.sabun = sabun;
	}
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public String getPrizeName() {
		return prizeName;
	}
	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}
	public String getPrizeOrg() {
		return prizeOrg;
	}
	public void setPrizeOrg(String prizeOrg) {
		this.prizeOrg = prizeOrg;
	}
	
	@Override
	public String toString() {
		return "PrizeVO [sabun=" + sabun + ", seq=" + seq + ", prizeName=" + prizeName + ", prizeOrg=" + prizeOrg + "]";
	}
}
