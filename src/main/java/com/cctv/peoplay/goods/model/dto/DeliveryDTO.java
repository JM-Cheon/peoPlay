package com.cctv.peoplay.goods.model.dto;

import com.cctv.peoplay.member.model.dto.MemberDTO;

public class DeliveryDTO {
	
	private int deliveryNumber;
	private PaymentDTO paymentNum;
	private GoodsDTO goodsNum;
	private com.cctv.peoplay.member.model.dto.MemberDTO userNo;
	private DeliveryMemoDTO shipmentCode;
	private DeliveryStatusDTO shipmentMemoCode;
	
	public DeliveryDTO(int deliveryNumber, PaymentDTO paymentNum, GoodsDTO goodsNum, MemberDTO userNo,
			DeliveryMemoDTO shipmentCode, DeliveryStatusDTO shipmentMemoCode) {
		this.deliveryNumber = deliveryNumber;
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
		return "DeliveryDTO [deliveryNumber=" + deliveryNumber + ", paymentNum=" + paymentNum + ", goodsNum=" + goodsNum
				+ ", userNo=" + userNo + ", shipmentCode=" + shipmentCode + ", shipmentMemoCode=" + shipmentMemoCode
				+ "]";
	}
	public int getDeliveryNumber() {
		return deliveryNumber;
	}
	public void setDeliveryNumber(int deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
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
	public com.cctv.peoplay.member.model.dto.MemberDTO getUserNo() {
		return userNo;
	}
	public void setUserNo(com.cctv.peoplay.member.model.dto.MemberDTO userNo) {
		this.userNo = userNo;
	}
	public DeliveryMemoDTO getShipmentCode() {
		return shipmentCode;
	}
	public void setShipmentCode(DeliveryMemoDTO shipmentCode) {
		this.shipmentCode = shipmentCode;
	}
	public DeliveryStatusDTO getShipmentMemoCode() {
		return shipmentMemoCode;
	}
	public void setShipmentMemoCode(DeliveryStatusDTO shipmentMemoCode) {
		this.shipmentMemoCode = shipmentMemoCode;
	}
	
	

}
