package com.cctv.peoplay.member.model.dto;

import java.io.Serializable;

public class SubscriptionDTO implements Serializable{

	private static final long serialVersionUID = -6461003021095105776L;
	
	private int number;
	private String name;
	private int period;
	private int price;
	
	public SubscriptionDTO() {}

	public SubscriptionDTO(int number, String name, int period, int price) {
		this.number = number;
		this.name = name;
		this.period = period;
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SubscriptionDTO [number=" + number + ", name=" + name + ", period=" + period + ", price=" + price + "]";
	}

}
