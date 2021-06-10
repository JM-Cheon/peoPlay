package com.cctv.peoplay.admin.goods.model.dto;

public class GoodsDetailFileDTO {
	
	private int detailFileNo;
	private GoodsDTO goodsNum;
	private String detailFileOriginName;
	private String detailFileSaveName;
	private String detailSavePath;
	private String detailThumbnailPath;
	private String detailFileType;
	private String detailFileStatus;
	public GoodsDetailFileDTO(int detailFileNo, GoodsDTO goodsNum, String detailFileOriginName,
			String detailFileSaveName, String detailSavePath, String detailThumbnailPath, String detailFileType,
			String detailFileStatus) {
		this.detailFileNo = detailFileNo;
		this.goodsNum = goodsNum;
		this.detailFileOriginName = detailFileOriginName;
		this.detailFileSaveName = detailFileSaveName;
		this.detailSavePath = detailSavePath;
		this.detailThumbnailPath = detailThumbnailPath;
		this.detailFileType = detailFileType;
		this.detailFileStatus = detailFileStatus;
	}
	public GoodsDetailFileDTO() {
	}
	@Override
	public String toString() {
		return "GoodsDetailFileDTO [detailFileNo=" + detailFileNo + ", goodsNum=" + goodsNum + ", detailFileOriginName="
				+ detailFileOriginName + ", detailFileSaveName=" + detailFileSaveName + ", detailSavePath="
				+ detailSavePath + ", detailThumbnailPath=" + detailThumbnailPath + ", detailFileType=" + detailFileType
				+ ", detailFileStatus=" + detailFileStatus + "]";
	}
	public int getDetailFileNo() {
		return detailFileNo;
	}
	public void setDetailFileNo(int detailFileNo) {
		this.detailFileNo = detailFileNo;
	}
	public GoodsDTO getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(GoodsDTO goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getDetailFileOriginName() {
		return detailFileOriginName;
	}
	public void setDetailFileOriginName(String detailFileOriginName) {
		this.detailFileOriginName = detailFileOriginName;
	}
	public String getDetailFileSaveName() {
		return detailFileSaveName;
	}
	public void setDetailFileSaveName(String detailFileSaveName) {
		this.detailFileSaveName = detailFileSaveName;
	}
	public String getDetailSavePath() {
		return detailSavePath;
	}
	public void setDetailSavePath(String detailSavePath) {
		this.detailSavePath = detailSavePath;
	}
	public String getDetailThumbnailPath() {
		return detailThumbnailPath;
	}
	public void setDetailThumbnailPath(String detailThumbnailPath) {
		this.detailThumbnailPath = detailThumbnailPath;
	}
	public String getDetailFileType() {
		return detailFileType;
	}
	public void setDetailFileType(String detailFileType) {
		this.detailFileType = detailFileType;
	}
	public String getDetailFileStatus() {
		return detailFileStatus;
	}
	public void setDetailFileStatus(String detailFileStatus) {
		this.detailFileStatus = detailFileStatus;
	}

	
}
