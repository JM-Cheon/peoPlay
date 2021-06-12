package com.cctv.peoplay.movie.model.dto;

import java.util.Date;

import com.cctv.peoplay.member.model.dto.MemberDTO;

public class MovieReviewDTO {
	
	private int reviewNo;
	private int userNo;
	private int no;
	private String review;
	private java.util.Date registrationDate;
	private String reviewStatus;
	private MemberDTO memberInfo;
	public MovieReviewDTO() {
	}
	public MovieReviewDTO(int reviewNo, int userNo, int no, String review, Date registrationDate, String reviewStatus,
			MemberDTO memberInfo) {
		this.reviewNo = reviewNo;
		this.userNo = userNo;
		this.no = no;
		this.review = review;
		this.registrationDate = registrationDate;
		this.reviewStatus = reviewStatus;
		this.memberInfo = memberInfo;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public java.util.Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(java.util.Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	public MemberDTO getMemberInfo() {
		return memberInfo;
	}
	public void setMemberInfo(MemberDTO memberInfo) {
		this.memberInfo = memberInfo;
	}
	@Override
	public String toString() {
		return "MovieReviewDTO [reviewNo=" + reviewNo + ", userNo=" + userNo + ", no=" + no + ", review=" + review
				+ ", registrationDate=" + registrationDate + ", reviewStatus=" + reviewStatus + ", memberInfo="
				+ memberInfo + "]";
	}
	
}
