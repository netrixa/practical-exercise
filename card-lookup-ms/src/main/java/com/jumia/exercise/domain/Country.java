package com.jumia.exercise.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Country extends BaseEntity implements Serializable {

	 private String alpha2;
	    public String getAlpha2() {
		return alpha2;
	}
	public void setAlpha2(String alpha2) {
		this.alpha2 = alpha2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumeric() {
		return numeric;
	}
	public void setNumeric(int numeric) {
		this.numeric = numeric;
	}
	public int getLatitude() {
		return latitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	public int getLongitude() {
		return longitude;
	}
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
		private String name;
		@Column(name="inumeric")
	    private int numeric;
	    private int latitude;
	    private int longitude;
		@Override
		public String toString() {
			return "Country [alpha2=" + alpha2 + ", name=" + name + ", numeric=" + numeric + ", latitude=" + latitude
					+ ", longitude=" + longitude + "]";
		}
	    
	    
}
