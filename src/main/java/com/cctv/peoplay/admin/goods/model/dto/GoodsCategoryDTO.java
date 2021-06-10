package com.cctv.peoplay.admin.goods.model.dto;

public class GoodsCategoryDTO {

	private int goodsCategoryNum;
	private String goodsCategoryName;
	public int getGoodsCategoryNum() {
		return goodsCategoryNum;
	}
	public void setGoodsCategoryNum(int goodsCategoryNum) {
		this.goodsCategoryNum = goodsCategoryNum;
	}
	public String getGoodsCategoryName() {
		return goodsCategoryName;
	}
	public void setGoodsCategoryName(String goodsCategoryName) {
		this.goodsCategoryName = goodsCategoryName;
	}
	@Override
	public String toString() {
		return "GoodsCategoryDTO [goodsCategoryNum=" + goodsCategoryNum + ", goodsCategoryName=" + goodsCategoryName
				+ "]";
	}
	public GoodsCategoryDTO() {
	}
	public GoodsCategoryDTO(int goodsCategoryNum, String goodsCategoryName) {
		this.goodsCategoryNum = goodsCategoryNum;
		this.goodsCategoryName = goodsCategoryName;
	}
}
