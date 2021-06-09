package com.cctv.peoplay.goods.model.dto;

import java.util.Date;

public class PaymentDTO {
	
	private int paymentNo;
	private OrderDTO orderNo;
	private java.util.Date paymentDate;
	private int paymentPrice;
	private String paymentType;
	public PaymentDTO(int paymentNo, OrderDTO orderNo, Date paymentDate, int paymentPrice, String paymentType) {
		this.paymentNo = paymentNo;
		this.orderNo = orderNo;
		this.paymentDate = paymentDate;
		this.paymentPrice = paymentPrice;
		this.paymentType = paymentType;
	}
	public PaymentDTO() {
	}
	@Override
	public String toString() {
		return "PaymentDTO [paymentNo=" + paymentNo + ", orderNo=" + orderNo + ", paymentDate=" + paymentDate
				+ ", paymentPrice=" + paymentPrice + ", paymentType=" + paymentType + "]";
	}
	public int getPaymentNo() {
		return paymentNo;
	}
	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}
	public OrderDTO getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(OrderDTO orderNo) {
		this.orderNo = orderNo;
	}
	public java.util.Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(java.util.Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public int getPaymentPrice() {
		return paymentPrice;
	}
	public void setPaymentPrice(int paymentPrice) {
		this.paymentPrice = paymentPrice;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

}
