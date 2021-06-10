package com.cctv.peoplay.Community.model.dto;

import java.sql.Date;

public class FaqDTO {
	
	private int faqNo;
	private int userNo;
	private String faqTitle;
	private String faqContent;
	private java.sql.Date faqDrawupDate;
	private int faqWatched;
	private String faqStatus;
	
	public FaqDTO() {
	}

	public FaqDTO(int faqNo, int userNo, String faqTitle, String faqContent, Date faqDrawupDate, int faqWatched,
			String faqStatus) {
		this.faqNo = faqNo;
		this.userNo = userNo;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.faqDrawupDate = faqDrawupDate;
		this.faqWatched = faqWatched;
		this.faqStatus = faqStatus;
	}

	public int getFaqNo() {
		return faqNo;
	}

	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getFaqTitle() {
		return faqTitle;
	}

	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}

	public String getFaqContent() {
		return faqContent;
	}

	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}

	public java.sql.Date getFaqDrawupDate() {
		return faqDrawupDate;
	}

	public void setFaqDrawupDate(java.sql.Date faqDrawupDate) {
		this.faqDrawupDate = faqDrawupDate;
	}

	public int getFaqWatched() {
		return faqWatched;
	}

	public void setFaqWatched(int faqWatched) {
		this.faqWatched = faqWatched;
	}

	public String getFaqStatus() {
		return faqStatus;
	}

	public void setFaqStatus(String faqStatus) {
		this.faqStatus = faqStatus;
	}

	@Override
	public String toString() {
		return "FaqDTO [faqNo=" + faqNo + ", userNo=" + userNo + ", faqTitle=" + faqTitle + ", faqContent=" + faqContent
				+ ", faqDrawupDate=" + faqDrawupDate + ", faqWatched=" + faqWatched + ", faqStatus=" + faqStatus + "]";
	}
	
}
