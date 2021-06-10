package com.cctv.peoplay.admin.goods.model.dto;

public class DeliveryMemoDTO {
	
	private int shipmentMemoCode;
	private String shipmentMemoName;
	public DeliveryMemoDTO(int shipmentMemoCode, String shipmentMemoName) {
		this.shipmentMemoCode = shipmentMemoCode;
		this.shipmentMemoName = shipmentMemoName;
	}
	public DeliveryMemoDTO() {
	}
	@Override
	public String toString() {
		return "DeliveryMemoDTO [shipmentMemoCode=" + shipmentMemoCode + ", shipmentMemoName=" + shipmentMemoName + "]";
	}
	public int getShipmentMemoCode() {
		return shipmentMemoCode;
	}
	public void setShipmentMemoCode(int shipmentMemoCode) {
		this.shipmentMemoCode = shipmentMemoCode;
	}
	public String getShipmentMemoName() {
		return shipmentMemoName;
	}
	public void setShipmentMemoName(String shipmentMemoName) {
		this.shipmentMemoName = shipmentMemoName;
	}
	
}
