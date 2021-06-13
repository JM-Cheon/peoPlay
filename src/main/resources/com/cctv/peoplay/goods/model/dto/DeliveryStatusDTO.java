package com.cctv.peoplay.goods.model.dto;

public class DeliveryStatusDTO {
	
	private int shipmentCode;
	private String shipmentStatus;
	public DeliveryStatusDTO(int shipmentCode, String shipmentStatus) {
		this.shipmentCode = shipmentCode;
		this.shipmentStatus = shipmentStatus;
	}
	public DeliveryStatusDTO() {
	}
	@Override
	public String toString() {
		return "DeliveryStatusDTO [shipmentCode=" + shipmentCode + ", shipmentStatus=" + shipmentStatus + "]";
	}
	public int getShipmentCode() {
		return shipmentCode;
	}
	public void setShipmentCode(int shipmentCode) {
		this.shipmentCode = shipmentCode;
	}
	public String getShipmentStatus() {
		return shipmentStatus;
	}
	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}
	

}
