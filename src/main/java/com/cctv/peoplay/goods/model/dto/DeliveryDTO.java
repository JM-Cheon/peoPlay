package com.cctv.peoplay.goods.model.dto;

import com.cctv.peoplay.member.model.dto.MemberDTO;

public class DeliveryDTO {

	private int deliveryNum;
	private PaymentDTO paymentNum;
	private GoodsDTO goodsNum;
	private MemberDTO userNo;
	private int shipmentCode;
	private int shipmentMemoCode;
	public DeliveryDTO(int deliveryNum, PaymentDTO paymentNum, GoodsDTO goodsNum, MemberDTO userNo, int shipmentCode,
			int shipmentMemoCode) {
		this.deliveryNum = deliveryNum;
		this.paymentNum = paymentNum;
		this.goodsNum = goodsNum;
		this.userNo = userNo;
		this.shipmentCode = shipmentCode;
		this.shipmentMemoCode = shipmentMemoCode;
	}
	public DeliveryDTO() {
	}
	@Override
	public String toString() {
		return "DeliveryDTO [deliveryNum=" + deliveryNum + ", paymentNum=" + paymentNum + ", goodsNum=" + goodsNum
				+ ", userNo=" + userNo + ", shipmentCode=" + shipmentCode + ", shipmentMemoCode=" + shipmentMemoCode
				+ "]";
	}
	public int getDeliveryNum() {
		return deliveryNum;
	}
	public void setDeliveryNum(int deliveryNum) {
		this.deliveryNum = deliveryNum;
	}
	public PaymentDTO getPaymentNum() {
		return paymentNum;
	}
	public void setPaymentNum(PaymentDTO paymentNum) {
		this.paymentNum = paymentNum;
	}
	public GoodsDTO getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(GoodsDTO goodsNum) {
		this.goodsNum = goodsNum;
	}
	public MemberDTO getUserNo() {
		return userNo;
	}
	public void setUserNo(MemberDTO userNo) {
		this.userNo = userNo;
	}
	public int getShipmentCode() {
		return shipmentCode;
	}
	public void setShipmentCode(int shipmentCode) {
		this.shipmentCode = shipmentCode;
	}
	public int getShipmentMemoCode() {
		return shipmentMemoCode;
	}
	public void setShipmentMemoCode(int shipmentMemoCode) {
		this.shipmentMemoCode = shipmentMemoCode;
	}
	
}
