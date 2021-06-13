package com.cctv.peoplay.goods.model.dto;

import java.util.List;

public class GoodsAndDetailFileDTO {
	
	private int goodsNum;
	private List<GoodsDetailFileDTO> detailFiles;
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public List<GoodsDetailFileDTO> getDetailFiles() {
		return detailFiles;
	}
	public void setDetailFiles(List<GoodsDetailFileDTO> detailFiles) {
		this.detailFiles = detailFiles;
	}
	@Override
	public String toString() {
		return "GoodsAndDetailFileDTO [goodsNum=" + goodsNum + ", detailFiles=" + detailFiles + "]";
	}
	public GoodsAndDetailFileDTO() {
	}
	public GoodsAndDetailFileDTO(int goodsNum, List<GoodsDetailFileDTO> detailFiles) {
		this.goodsNum = goodsNum;
		this.detailFiles = detailFiles;
	}

}
