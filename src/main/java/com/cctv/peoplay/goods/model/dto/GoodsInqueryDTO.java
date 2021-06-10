package com.cctv.peoplay.goods.model.dto;

import java.sql.Date;

import com.cctv.peoplay.member.model.dto.MemberDTO;

public class GoodsInqueryDTO {

	private int goodsInquiryNo;
	private GoodsDTO goodsNumber;
	private MemberDTO userNo;
	private String goodsInquiryTitle;
	private String goodsInquiryContent;
	private java.sql.Date writtenDate;
	private String goodsInquiryYn;
	public GoodsInqueryDTO(int goodsInquiryNo, GoodsDTO goodsNumber, MemberDTO userNo, String goodsInquiryTitle,
			String goodsInquiryContent, Date writtenDate, String goodsInquiryYn) {
		this.goodsInquiryNo = goodsInquiryNo;
		this.goodsNumber = goodsNumber;
		this.userNo = userNo;
		this.goodsInquiryTitle = goodsInquiryTitle;
		this.goodsInquiryContent = goodsInquiryContent;
		this.writtenDate = writtenDate;
		this.goodsInquiryYn = goodsInquiryYn;
	}
	public GoodsInqueryDTO() {
	}
	@Override
	public String toString() {
		return "{'goodsInquiryNo':" + goodsInquiryNo + ", 'goodsNumber':" + goodsNumber + ", 'userNo':"
				+ userNo + ", 'goodsInquiryTitle':" + goodsInquiryTitle + ", 'goodsInquiryContent':" + goodsInquiryContent
				+ ", 'writtenDate':" + writtenDate + ", 'goodsInquiryYn':" + goodsInquiryYn + "}";
	}
	public int getGoodsInquiryNo() {
		return goodsInquiryNo;
	}
	public void setGoodsInquiryNo(int goodsInquiryNo) {
		this.goodsInquiryNo = goodsInquiryNo;
	}
	public GoodsDTO getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(GoodsDTO goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public MemberDTO getUserNo() {
		return userNo;
	}
	public void setUserNo(MemberDTO userNo) {
		this.userNo = userNo;
	}
	public String getGoodsInquiryTitle() {
		return goodsInquiryTitle;
	}
	public void setGoodsInquiryTitle(String goodsInquiryTitle) {
		this.goodsInquiryTitle = goodsInquiryTitle;
	}
	public String getGoodsInquiryContent() {
		return goodsInquiryContent;
	}
	public void setGoodsInquiryContent(String goodsInquiryContent) {
		this.goodsInquiryContent = goodsInquiryContent;
	}
	public java.util.Date getWrittenDate() {
		return writtenDate;
	}
	public void setWrittenDate(java.sql.Date writtenDate) {
		this.writtenDate = writtenDate;
	}
	public String getGoodsInquiryYn() {
		return goodsInquiryYn;
	}
	public void setGoodsInquiryYn(String goodsInquiryYn) {
		this.goodsInquiryYn = goodsInquiryYn;
	}
	
}
