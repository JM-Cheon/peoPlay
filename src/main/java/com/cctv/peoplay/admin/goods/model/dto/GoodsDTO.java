package com.cctv.peoplay.admin.goods.model.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class GoodsDTO implements Serializable{
	
	private static final long serialVersionUID = 2815334884492107185L;
	
	private int goodsNum;
	private GoodsCategoryDTO goodsCategoryNum;
	private int movieNum;
	private GoodsShipmentClassifyDTO goodsShipmentClassifyCode;
	private String goodsName;
	private int goodsPrice;
	private Date goodsRegistrationDate;
	private int goodsStock;
	private String goodsStatus;
	private String goodsDetail;
	private String goodsOrigin;
	private String goodsCompany;
	private int goodsLikeCount;
	private String goodsShortInfo;
	private List<GoodsFileDTO> goodsFiles;
	
	public GoodsDTO(int goodsNum, GoodsCategoryDTO goodsCategoryNum, int movieNum,
			GoodsShipmentClassifyDTO goodsShipmentClassifyCode, String goodsName, int goodsPrice,
			Date goodsRegistrationDate, int goodsStock, String goodsStatus, String goodsDetail, String goodsOrigin,
			String goodsCompany, int goodsLikeCount, String goodsShortInfo, List<GoodsFileDTO> goodsFiles) {
		this.goodsNum = goodsNum;
		this.goodsCategoryNum = goodsCategoryNum;
		this.movieNum = movieNum;
		this.goodsShipmentClassifyCode = goodsShipmentClassifyCode;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsRegistrationDate = goodsRegistrationDate;
		this.goodsStock = goodsStock;
		this.goodsStatus = goodsStatus;
		this.goodsDetail = goodsDetail;
		this.goodsOrigin = goodsOrigin;
		this.goodsCompany = goodsCompany;
		this.goodsLikeCount = goodsLikeCount;
		this.goodsShortInfo = goodsShortInfo;
		this.goodsFiles = goodsFiles;
	}
	public GoodsDTO() {
	}
	@Override
	public String toString() {
		return "GoodsDTO [goodsNum=" + goodsNum + ", goodsCategoryNum=" + goodsCategoryNum + ", movieNum=" + movieNum
				+ ", goodsShipmentClassifyCode=" + goodsShipmentClassifyCode + ", goodsName=" + goodsName
				+ ", goodsPrice=" + goodsPrice + ", goodsRegistrationDate=" + goodsRegistrationDate + ", goodsStock="
				+ goodsStock + ", goodsStatus=" + goodsStatus + ", goodsDetail=" + goodsDetail + ", goodsOrigin="
				+ goodsOrigin + ", goodsCompany=" + goodsCompany + ", goodsLikeCount=" + goodsLikeCount
				+ ", goodsShortInfo=" + goodsShortInfo + ", goodsFiles=" + goodsFiles + "]";
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public GoodsCategoryDTO getGoodsCategoryNum() {
		return goodsCategoryNum;
	}
	public void setGoodsCategoryNum(GoodsCategoryDTO goodsCategoryNum) {
		this.goodsCategoryNum = goodsCategoryNum;
	}
	public int getMovieNum() {
		return movieNum;
	}
	public void setMovieNum(int movieNum) {
		this.movieNum = movieNum;
	}
	public GoodsShipmentClassifyDTO getGoodsShipmentClassifyCode() {
		return goodsShipmentClassifyCode;
	}
	public void setGoodsShipmentClassifyCode(GoodsShipmentClassifyDTO goodsShipmentClassifyCode) {
		this.goodsShipmentClassifyCode = goodsShipmentClassifyCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public Date getGoodsRegistrationDate() {
		return goodsRegistrationDate;
	}
	public void setGoodsRegistrationDate(Date goodsRegistrationDate) {
		this.goodsRegistrationDate = goodsRegistrationDate;
	}
	public int getGoodsStock() {
		return goodsStock;
	}
	public void setGoodsStock(int goodsStock) {
		this.goodsStock = goodsStock;
	}
	public String getGoodsStatus() {
		return goodsStatus;
	}
	public void setGoodsStatus(String goodsStatus) {
		this.goodsStatus = goodsStatus;
	}
	public String getGoodsDetail() {
		return goodsDetail;
	}
	public void setGoodsDetail(String goodsDetail) {
		this.goodsDetail = goodsDetail;
	}
	public String getGoodsOrigin() {
		return goodsOrigin;
	}
	public void setGoodsOrigin(String goodsOrigin) {
		this.goodsOrigin = goodsOrigin;
	}
	public String getGoodsCompany() {
		return goodsCompany;
	}
	public void setGoodsCompany(String goodsCompany) {
		this.goodsCompany = goodsCompany;
	}
	public int getGoodsLikeCount() {
		return goodsLikeCount;
	}
	public void setGoodsLikeCount(int goodsLikeCount) {
		this.goodsLikeCount = goodsLikeCount;
	}
	public String getGoodsShortInfo() {
		return goodsShortInfo;
	}
	public void setGoodsShortInfo(String goodsShortInfo) {
		this.goodsShortInfo = goodsShortInfo;
	}
	public List<GoodsFileDTO> getGoodsFiles() {
		return goodsFiles;
	}
	public void setGoodsFiles(List<GoodsFileDTO> goodsFiles) {
		this.goodsFiles = goodsFiles;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
