package com.cctv.peoplay.goods.model.dto;

public class GoodsShipmentClassifyDTO {
	
	private int goodsShipmentClassifyCode;
	private String goodsShipmentClassifyName;
	public GoodsShipmentClassifyDTO(int goodsShipmentClassifyCode, String goodsShipmentClassifyName) {
		this.goodsShipmentClassifyCode = goodsShipmentClassifyCode;
		this.goodsShipmentClassifyName = goodsShipmentClassifyName;
	}
	public GoodsShipmentClassifyDTO() {
	}
	@Override
	public String toString() {
		return "GoodsShipmentClassifyDTO [goodsShipmentClassifyCode=" + goodsShipmentClassifyCode
				+ ", goodsShipmentClassifyName=" + goodsShipmentClassifyName + "]";
	}
	public int getGoodsShipmentClassifyCode() {
		return goodsShipmentClassifyCode;
	}
	public void setGoodsShipmentClassifyCode(int goodsShipmentClassifyCode) {
		this.goodsShipmentClassifyCode = goodsShipmentClassifyCode;
	}
	public String getGoodsShipmentClassifyName() {
		return goodsShipmentClassifyName;
	}
	public void setGoodsShipmentClassifyName(String goodsShipmentClassifyName) {
		this.goodsShipmentClassifyName = goodsShipmentClassifyName;
	}
	

}
