package com.cctv.peoplay.goods.model.dto;

import java.util.Date;
import com.cctv.peoplay.member.model.dto.MemberDTO;

public class GoodsReviewDTO {
	
	private int goodsReviewNum;
	private PaymentDTO paymentNum;
	private GoodsDTO goodsNum;
	private MemberDTO memNum;
	private java.util.Date reviewDate;
	private String goodsReviewContent;

	public GoodsReviewDTO() {
	}

	public GoodsReviewDTO(int goodsReviewNum, PaymentDTO paymentNum, GoodsDTO goodsNum, MemberDTO memNum,
			Date reviewDate, String goodsReviewContent) {
		this.goodsReviewNum = goodsReviewNum;
		this.paymentNum = paymentNum;
		this.goodsNum = goodsNum;
		this.memNum = memNum;
		this.reviewDate = reviewDate;
		this.goodsReviewContent = goodsReviewContent;
	}

	@Override
	public String toString() {
		return "GoodsReviewDTO [goodsReviewNum=" + goodsReviewNum + ", paymentNum=" + paymentNum + ", goodsNum="
				+ goodsNum + ", memNum=" + memNum + ", reviewDate=" + reviewDate + ", goodsReviewContent="
				+ goodsReviewContent + "]";
	}

	public int getGoodsReviewNum() {
		return goodsReviewNum;
	}

	public void setGoodsReviewNum(int goodsReviewNum) {
		this.goodsReviewNum = goodsReviewNum;
	}

	public PaymentDTO getPaymentNum() {
		return paymentNum;
	}

	public void setPaymentNum(PaymentDTO paymentNum) {
		this.paymentNum = paymentNum;
	}

	public GoodsDTO getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(GoodsDTO goodsNum) {
		this.goodsNum = goodsNum;
	}

	public MemberDTO getMemNum() {
		return memNum;
	}

	public void setMemNum(MemberDTO memNum) {
		this.memNum = memNum;
	}

	public java.util.Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(java.util.Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getGoodsReviewContent() {
		return goodsReviewContent;
	}

	public void setGoodsReviewContent(String goodsReviewContent) {
		this.goodsReviewContent = goodsReviewContent;
	}
	
	

}
