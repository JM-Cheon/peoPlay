package com.cctv.peoplay.Community.model.dto;

import java.sql.Date;

import com.cctv.peoplay.member.model.dto.MemberDTO;



public class NoticeDTO {

	private int ntcNo;
	private int userNo;
	private String ntcTitle;
	private String ntcContent;
	private java.sql.Date ntcDrawipDate;
	private int ntcWatched;
	private String ntcstatus;
	private MemberDTO writer;
	
	public NoticeDTO() {
	}

	public NoticeDTO(int ntcNo, int userNo, String ntcTitle, String ntcContent, Date ntcDrawipDate, int ntcWatched,
			String ntcstatus, MemberDTO writer) {
		this.ntcNo = ntcNo;
		this.userNo = userNo;
		this.ntcTitle = ntcTitle;
		this.ntcContent = ntcContent;
		this.ntcDrawipDate = ntcDrawipDate;
		this.ntcWatched = ntcWatched;
		this.ntcstatus = ntcstatus;
		this.writer = writer;
	}

	public int getNtcNo() {
		return ntcNo;
	}

	public void setNtcNo(int ntcNo) {
		this.ntcNo = ntcNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getNtcTitle() {
		return ntcTitle;
	}

	public void setNtcTitle(String ntcTitle) {
		this.ntcTitle = ntcTitle;
	}

	public String getNtcContent() {
		return ntcContent;
	}

	public void setNtcContent(String ntcContent) {
		this.ntcContent = ntcContent;
	}

	public java.sql.Date getNtcDrawipDate() {
		return ntcDrawipDate;
	}

	public void setNtcDrawipDate(java.sql.Date ntcDrawipDate) {
		this.ntcDrawipDate = ntcDrawipDate;
	}

	public int getNtcWatched() {
		return ntcWatched;
	}

	public void setNtcWatched(int ntcWatched) {
		this.ntcWatched = ntcWatched;
	}

	public String getNtcstatus() {
		return ntcstatus;
	}

	public void setNtcstatus(String ntcstatus) {
		this.ntcstatus = ntcstatus;
	}

	public MemberDTO getWriter() {
		return writer;
	}

	public void setWriter(MemberDTO writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "NoticeDTO [ntcNo=" + ntcNo + ", userNo=" + userNo + ", ntcTitle=" + ntcTitle + ", ntcContent="
				+ ntcContent + ", ntcDrawipDate=" + ntcDrawipDate + ", ntcWatched=" + ntcWatched + ", ntcstatus="
				+ ntcstatus + ", writer=" + writer + "]";
	}

	
	
	
}
