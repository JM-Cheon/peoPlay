package com.cctv.peoplay.goods.model.dto;

import com.cctv.peoplay.member.model.dto.MemberDTO;

public class GoodsCartDTO {
	
	private GoodsDTO goodsNum;
	private MemberDTO userNum;
	private int cartCount;
	public GoodsCartDTO(GoodsDTO goodsNum, MemberDTO userNum, int cartCount) {
		this.goodsNum = goodsNum;
		this.userNum = userNum;
		this.cartCount = cartCount;
	}

	public GoodsCartDTO() {
	}

	@Override
	public String toString() {
		return "GoodsCartDTO [goodsNum=" + goodsNum + ", userNum=" + userNum + ", cartCount=" + cartCount + "]";
	}

	public GoodsDTO getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(GoodsDTO goodsNum) {
		this.goodsNum = goodsNum;
	}

	public MemberDTO getUserNum() {
		return userNum;
	}

	public void setUserNum(MemberDTO userNum) {
		this.userNum = userNum;
	}

	public int getCartCount() {
		return cartCount;
	}

	public void setCartCount(int cartCount) {
		this.cartCount = cartCount;
	}
	

}
