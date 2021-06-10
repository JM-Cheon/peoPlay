package com.cctv.peoplay.Community.model.dto;

import java.sql.Date;

import com.cctv.peoplay.member.model.dto.MemberDTO;

public class QnaDTO {
	
	private int inquiryNo;
	private int userNo;
	private String inquiryTitles; 
	private String inquiryContent;
	private java.sql.Date creationDate;
	private String inquiryYn;
	private String inquiryStatus;
	private String disclosureStatus;
	private MemberDTO writer;
	private commentDTO comment;
	public QnaDTO() {
	}
	public QnaDTO(int inquiryNo, int userNo, String inquiryTitles, String inquiryContent, Date creationDate,
			String inquiryYn, String inquiryStatus, String disclosureStatus, MemberDTO writer, commentDTO comment) {
		this.inquiryNo = inquiryNo;
		this.userNo = userNo;
		this.inquiryTitles = inquiryTitles;
		this.inquiryContent = inquiryContent;
		this.creationDate = creationDate;
		this.inquiryYn = inquiryYn;
		this.inquiryStatus = inquiryStatus;
		this.disclosureStatus = disclosureStatus;
		this.writer = writer;
		this.comment = comment;
	}
	public int getInquiryNo() {
		return inquiryNo;
	}
	public void setInquiryNo(int inquiryNo) {
		this.inquiryNo = inquiryNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getInquiryTitles() {
		return inquiryTitles;
	}
	public void setInquiryTitles(String inquiryTitles) {
		this.inquiryTitles = inquiryTitles;
	}
	public String getInquiryContent() {
		return inquiryContent;
	}
	public void setInquiryContent(String inquiryContent) {
		this.inquiryContent = inquiryContent;
	}
	public java.sql.Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(java.sql.Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getInquiryYn() {
		return inquiryYn;
	}
	public void setInquiryYn(String inquiryYn) {
		this.inquiryYn = inquiryYn;
	}
	public String getInquiryStatus() {
		return inquiryStatus;
	}
	public void setInquiryStatus(String inquiryStatus) {
		this.inquiryStatus = inquiryStatus;
	}
	public String getDisclosureStatus() {
		return disclosureStatus;
	}
	public void setDisclosureStatus(String disclosureStatus) {
		this.disclosureStatus = disclosureStatus;
	}
	public MemberDTO getWriter() {
		return writer;
	}
	public void setWriter(MemberDTO writer) {
		this.writer = writer;
	}
	public commentDTO getComment() {
		return comment;
	}
	public void setComment(commentDTO comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "QnaDTO [inquiryNo=" + inquiryNo + ", userNo=" + userNo + ", inquiryTitles=" + inquiryTitles
				+ ", inquiryContent=" + inquiryContent + ", creationDate=" + creationDate + ", inquiryYn=" + inquiryYn
				+ ", inquiryStatus=" + inquiryStatus + ", disclosureStatus=" + disclosureStatus + ", writer=" + writer
				+ ", comment=" + comment + "]";
	}
	
	
	
	
	
}
