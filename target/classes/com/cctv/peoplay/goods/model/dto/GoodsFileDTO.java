package com.cctv.peoplay.goods.model.dto;

public class GoodsFileDTO {
	
	private int number;
	private GoodsDTO goodsNum;
	private String fileOriginName;
	private String fileSaveName;
	private String savePath;
	private String thumbnailPath;
	private String fileType;
	private String fileStatus;
	public GoodsFileDTO() {
	}
	public GoodsFileDTO(int number, GoodsDTO goodsNum, String fileOriginName, String fileSaveName, String savePath,
			String thumbnailPath, String fileType, String fileStatus) {
		this.number = number;
		this.goodsNum = goodsNum;
		this.fileOriginName = fileOriginName;
		this.fileSaveName = fileSaveName;
		this.savePath = savePath;
		this.thumbnailPath = thumbnailPath;
		this.fileType = fileType;
		this.fileStatus = fileStatus;
	}
	@Override
	public String toString() {
		return "[number=" + number + ", goodsNum=" + goodsNum + ", fileOriginName=" + fileOriginName
				+ ", fileSaveName=" + fileSaveName + ", savePath=" + savePath + ", thumbnailPath=" + thumbnailPath
				+ ", fileType=" + fileType + ", fileStatus=" + fileStatus + "]";
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public GoodsDTO getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(GoodsDTO goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getFileOriginName() {
		return fileOriginName;
	}
	public void setFileOriginName(String fileOriginName) {
		this.fileOriginName = fileOriginName;
	}
	public String getFileSaveName() {
		return fileSaveName;
	}
	public void setFileSaveName(String fileSaveName) {
		this.fileSaveName = fileSaveName;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String getThumbnailPath() {
		return thumbnailPath;
	}
	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileStatus() {
		return fileStatus;
	}
	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}


}
