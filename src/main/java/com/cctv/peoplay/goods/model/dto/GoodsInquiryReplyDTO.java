package com.cctv.peoplay.goods.model.dto;

import java.sql.Date;

public class GoodsInquiryReplyDTO {

	private int goodsreplyNo;
	private GoodsInqueryDTO goodsinquiryNo;
	private String goodsReplyContent;
	private java.sql.Date goodsReplyCreationDate;
	public int getGoodsreplyNo() {
		return goodsreplyNo;
	}
	public void setGoodsreplyNo(int goodsreplyNo) {
		this.goodsreplyNo = goodsreplyNo;
	}
	public GoodsInqueryDTO getGoodsinquiryNo() {
		return goodsinquiryNo;
	}
	public void setGoodsinquiryNo(GoodsInqueryDTO goodsinquiryNo) {
		this.goodsinquiryNo = goodsinquiryNo;
	}
	public String getGoodsReplyContent() {
		return goodsReplyContent;
	}
	public void setGoodsReplyContent(String goodsReplyContent) {
		this.goodsReplyContent = goodsReplyContent;
	}
	public java.util.Date getGoodsReplyCreationDate() {
		return goodsReplyCreationDate;
	}
	public void setGoodsReplyCreationDate(java.sql.Date goodsReplyCreationDate) {
		this.goodsReplyCreationDate = goodsReplyCreationDate;
	}
	@Override
	public String toString() {
		return "{'goodsreplyNo':" + goodsreplyNo + ", 'goodsinquiryNo':" + goodsinquiryNo.toString()
				+ ", 'goodsReplyContent':" + goodsReplyContent + ", 'goodsReplyCreationDate':" + goodsReplyCreationDate
				+ "}";
	}
	public GoodsInquiryReplyDTO() {
	}
	public GoodsInquiryReplyDTO(int goodsreplyNo, GoodsInqueryDTO goodsinquiryNo, String goodsReplyContent,
			Date goodsReplyCreationDate) {
		this.goodsreplyNo = goodsreplyNo;
		this.goodsinquiryNo = goodsinquiryNo;
		this.goodsReplyContent = goodsReplyContent;
		this.goodsReplyCreationDate = goodsReplyCreationDate;
	}
	
}
