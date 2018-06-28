package com.jumia.exercise.domain;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Number extends BaseEntity implements Serializable {
	 private int length;
	 private String prefix;
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	@Override
	public String toString() {
		return "Number [length=" + length + ", prefix=" + prefix + "]";
	}
	 
}
