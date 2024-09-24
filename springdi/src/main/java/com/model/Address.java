package com.model;

public class Address {
	private int aid;
	private String streat;
	private String state;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getStreat() {
		return streat;
	}
	public void setStreat(String streat) {
		this.streat = streat;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", streat=" + streat + ", state=" + state + "]";
	}
	
	
	
}
