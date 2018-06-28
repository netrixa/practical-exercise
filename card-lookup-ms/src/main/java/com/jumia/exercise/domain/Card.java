package com.jumia.exercise.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.jumia.exercise.enums.CardType;

@Entity
public class Card extends BaseEntity implements Serializable {
	
	private String cardBIN;
    private String type;
    private String brand;
    private boolean prepaid;
    private String scheme; 
    
    @OneToOne(cascade = CascadeType.ALL)
    private Country country;
    @OneToOne(cascade = CascadeType.ALL)
    private Bank bank;
    @OneToOne(cascade = CascadeType.ALL)
    private Number number;
	public String getCardBIN() {
		return cardBIN;
	}
	public void setCardBIN(String cardBIN) {
		this.cardBIN = cardBIN;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public boolean isPrepaid() {
		return prepaid;
	}
	public void setPrepaid(boolean prepaid) {
		this.prepaid = prepaid;
	}
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public Number getNumber() {
		return number;
	}
	public void setNumber(Number number) {
		this.number = number;
	}
	
	@PrePersist
	private void setDate(){
		this.setCreatedOn(new Date());
	}
	
	@Override
	public String toString() {
		return "Card [cardBIN=" + cardBIN + ", type=" + type + ", brand=" + brand + ", prepaid=" + prepaid + ", scheme="
				+ scheme + ", country=" + country + ", bank=" + bank + ", number=" + number + "]";
	}
    
    
    
    
    
}
