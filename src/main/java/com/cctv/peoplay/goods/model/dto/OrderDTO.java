package com.cctv.peoplay.goods.model.dto;

import java.util.Date;
import java.util.HashMap;

import com.cctv.peoplay.member.model.dto.MemberDTO;

public class OrderDTO {

	private int orderNo;
	private GoodsDTO goodsNo;
	private MemberDTO userNo;
	private java.util.Date orderDate;
	private int orderCount;
	private String orderCancelOrNot;
	private String paidOrNot;
	
	public OrderDTO() {
	}

	public OrderDTO(int orderNo, GoodsDTO goodsNo, MemberDTO userNo, Date orderDate, int orderCount,
			String orderCancelOrNot, String paidOrNot) {
		this.orderNo = orderNo;
		this.goodsNo = goodsNo;
		this.userNo = userNo;
		this.orderDate = orderDate;
		this.orderCount = orderCount;
		this.orderCancelOrNot = orderCancelOrNot;
		this.paidOrNot = paidOrNot;
	}

	@Override
	public String toString() {
		return "OrderDTO [orderNo=" + orderNo + ", goodsNo=" + goodsNo + ", userNo=" + userNo + ", orderDate="
				+ orderDate + ", orderCount=" + orderCount + ", orderCancelOrNot=" + orderCancelOrNot + ", paidOrNot="
				+ paidOrNot + "]";
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public GoodsDTO getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(GoodsDTO goodsNo) {
		this.goodsNo = goodsNo;
	}

	public MemberDTO getUserNo() {
		return userNo;
	}

	public void setUserNo(MemberDTO userNo) {
		this.userNo = userNo;
	}

	public java.util.Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(java.util.Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public String getOrderCancelOrNot() {
		return orderCancelOrNot;
	}

	public void setOrderCancelOrNot(String orderCancelOrNot) {
		this.orderCancelOrNot = orderCancelOrNot;
	}

	public String getPaidOrNot() {
		return paidOrNot;
	}

	public void setPaidOrNot(String paidOrNot) {
		this.paidOrNot = paidOrNot;
	}

	
	
}
