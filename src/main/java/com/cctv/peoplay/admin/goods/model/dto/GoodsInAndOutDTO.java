package com.cctv.peoplay.admin.goods.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class GoodsInAndOutDTO implements Serializable{
	
	private static final long serialVersionUID = 7210137275523961858L;
	
	private int inAndOutCode;
	private GoodsDTO goodsNum;
	private PaymentDTO paymentNum;
	private Date goodsInOutDate;
	private int goodsCount;
	private String inAndOutStatus;
	
	public int getInAndOutCode() {
		return inAndOutCode;
	}
	public void setInAndOutCode(int inAndOutCode) {
		this.inAndOutCode = inAndOutCode;
	}
	public GoodsDTO getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(GoodsDTO goodsNum) {
		this.goodsNum = goodsNum;
	}
	public PaymentDTO getPaymentNum() {
		return paymentNum;
	}
	public void setPaymentNum(PaymentDTO paymentNum) {
		this.paymentNum = paymentNum;
	}
	public Date getGoodsInOutDate() {
		return goodsInOutDate;
	}
	public void setGoodsInOutDate(Date goodsInOutDate) {
		this.goodsInOutDate = goodsInOutDate;
	}
	public int getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}
	public String getInAndOutStatus() {
		return inAndOutStatus;
	}
	public void setInAndOutStatus(String inAndOutStatus) {
		this.inAndOutStatus = inAndOutStatus;
	}
	@Override
	public String toString() {
		return "GoodsInAndOutDTO [inAndOutCode=" + inAndOutCode + ", goodsNum=" + goodsNum + ", paymentNum="
				+ paymentNum + ", goodsInOutDate=" + goodsInOutDate + ", goodsCount=" + goodsCount + ", inAndOutStatus="
				+ inAndOutStatus + "]";
	}
	protected GoodsInAndOutDTO() {
	}
	protected GoodsInAndOutDTO(int inAndOutCode, GoodsDTO goodsNum, PaymentDTO paymentNum, Date goodsInOutDate,
			int goodsCount, String inAndOutStatus) {
		this.inAndOutCode = inAndOutCode;
		this.goodsNum = goodsNum;
		this.paymentNum = paymentNum;
		this.goodsInOutDate = goodsInOutDate;
		this.goodsCount = goodsCount;
		this.inAndOutStatus = inAndOutStatus;
	}
	

}
