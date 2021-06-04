package com.cctv.peoplay.member.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class SubscribePaymentDTO implements Serializable{
	
	private static final long serialVersionUID = -2631303369462760959L;
	
	private int paymentNo;
	private SubscriptionDTO subscription;
	private int userNo;
	private java.sql.Date paymentDate;
	private java.sql.Date paymentValidity;
	private int paymentPrice;
	
	public SubscribePaymentDTO() {}

	public SubscribePaymentDTO(int paymentNo, SubscriptionDTO subscription, int userNo, Date paymentDate,
			Date paymentValidity, int paymentPrice) {
		this.paymentNo = paymentNo;
		this.subscription = subscription;
		this.userNo = userNo;
		this.paymentDate = paymentDate;
		this.paymentValidity = paymentValidity;
		this.paymentPrice = paymentPrice;
	}

	public int getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}

	public SubscriptionDTO getSubscription() {
		return subscription;
	}

	public void setSubscription(SubscriptionDTO subscription) {
		this.subscription = subscription;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public java.sql.Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(java.sql.Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public java.sql.Date getPaymentValidity() {
		return paymentValidity;
	}

	public void setPaymentValidity(java.sql.Date paymentValidity) {
		this.paymentValidity = paymentValidity;
	}

	public int getPaymentPrice() {
		return paymentPrice;
	}

	public void setPaymentPrice(int paymentPrice) {
		this.paymentPrice = paymentPrice;
	}

	@Override
	public String toString() {
		return "SubscribePaymentDTO [paymentNo=" + paymentNo + ", subscription=" + subscription + ", userNo=" + userNo
				+ ", paymentDate=" + paymentDate + ", paymentValidity=" + paymentValidity + ", paymentPrice="
				+ paymentPrice + "]";
	}

}
