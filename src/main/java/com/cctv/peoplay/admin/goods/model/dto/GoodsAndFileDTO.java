package com.cctv.peoplay.admin.goods.model.dto;

import java.util.List;

public class GoodsAndFileDTO {

	private int goodsNum;
	List<GoodsFileDTO> goodsFile;
	public GoodsAndFileDTO(int goodsNum, List<GoodsFileDTO> goodsFile) {
		this.goodsNum = goodsNum;
		this.goodsFile = goodsFile;
	}
	public GoodsAndFileDTO() {
	}
	@Override
	public String toString() {
		return "[goodsNum=" + goodsNum + ", goodsFile=" + goodsFile + "]";
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public List<GoodsFileDTO> getGoodsFile() {
		return goodsFile;
	}
	public void setGoodsFile(List<GoodsFileDTO> goodsFile) {
		this.goodsFile = goodsFile;
	}


}
