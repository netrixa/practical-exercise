package com.jumia.exercise.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Bank extends BaseEntity implements Serializable {
	
	
	@Column
	private String name;
	@Column
    private String logo;
	@Column
    private String url;
	@Column
    private String city;
	@Column
    private String phone;

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Bank [name=" + name + ", logo=" + logo + ", url=" + url + ", city=" + city + ", phone=" + phone + "]";
	}



}
