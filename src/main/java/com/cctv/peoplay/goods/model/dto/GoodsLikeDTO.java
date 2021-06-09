package com.cctv.peoplay.goods.model.dto;

import com.cctv.peoplay.member.model.dto.MemberDTO;

public class GoodsLikeDTO {
	
	private GoodsDTO goodsNum;
	private MemberDTO userNo;
	public GoodsLikeDTO(GoodsDTO goodsNum, MemberDTO userNo) {
		this.goodsNum = goodsNum;
		this.userNo = userNo;
	}
	public GoodsLikeDTO() {
	}
	@Override
	public String toString() {
		return "GoodsLikeDTO [goodsNum=" + goodsNum + ", userNo=" + userNo + "]";
	}
	public GoodsDTO getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(GoodsDTO goodsNum) {
		this.goodsNum = goodsNum;
	}
	public MemberDTO getUserNo() {
		return userNo;
	}
	public void setUserNo(MemberDTO userNo) {
		this.userNo = userNo;
	}
	

}
