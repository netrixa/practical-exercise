package com.jumia.exercise.dto;

public class Payload {

	private String scheme;
	private String type;
	private String bank;
	public Payload(){
		this.setBank("");
		this.setScheme("");
		this.setType("");
	}
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	
	
	
}
