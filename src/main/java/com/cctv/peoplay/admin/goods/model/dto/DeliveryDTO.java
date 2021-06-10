package com.cctv.peoplay.admin.goods.model.dto;
import com.cctv.peoplay.member.model.dto.MemberDTO;
public class DeliveryDTO {
	
	private int deliveryNumber;
	private PaymentDTO paymentNumber;
	private GoodsDTO goodsNum;
	private MemberDTO userNo;
	private DeliveryMemoDTO shipmentCode;
	private DeliveryStatusDTO shipmentMemoCode;
	public DeliveryDTO(int deliveryNumber, PaymentDTO paymentNumber, GoodsDTO goodsNum, MemberDTO userNo,
			DeliveryMemoDTO shipmentCode, DeliveryStatusDTO shipmentMemoCode) {
		this.deliveryNumber = deliveryNumber;
		this.paymentNumber = paymentNumber;
		this.goodsNum = goodsNum;
		this.userNo = userNo;
		this.shipmentCode = shipmentCode;
		this.shipmentMemoCode = shipmentMemoCode;
	}
	public DeliveryDTO() {
	}
	public int getDeliveryNumber() {
		return deliveryNumber;
	}
	public void setDeliveryNumber(int deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
	}
	public PaymentDTO getPaymentNumber() {
		return paymentNumber;
	}
	public void setPaymentNumber(PaymentDTO paymentNumber) {
		this.paymentNumber = paymentNumber;
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
	@Override
	public String toString() {
		return "DeliveryDTO [deliveryNumber=" + deliveryNumber + ", paymentNumber=" + paymentNumber + ", goodsNum="
				+ goodsNum + ", userNo=" + userNo + ", shipmentCode=" + shipmentCode + ", shipmentMemoCode="
				+ shipmentMemoCode + "]";
	}
	
	

}
