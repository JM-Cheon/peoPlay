package com.cctv.peoplay.board.model.dto;

import java.sql.Date;

public class ReportAndReportPlaceDTO {

	
	private int no; // 신고 번호
	private int userNo; // 신고자
	private String reason;
	private String otherReason;
	private java.sql.Date reportDate;
	private String reportStatus;
	private int reportedPerson; // 신고 당한 사람
	private int placeNo;
	private ReportPlaceDTO placeCode;
	
	
	public ReportAndReportPlaceDTO() {
		
	}


	public ReportAndReportPlaceDTO(int no, int userNo, String reason, String otherReason, Date reportDate,
			String reportStatus, int reportedPerson, int placeNo, ReportPlaceDTO placeCode) {
		super();
		this.no = no;
		this.userNo = userNo;
		this.reason = reason;
		this.otherReason = otherReason;
		this.reportDate = reportDate;
		this.reportStatus = reportStatus;
		this.reportedPerson = reportedPerson;
		this.placeNo = placeNo;
		this.placeCode = placeCode;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public String getOtherReason() {
		return otherReason;
	}


	public void setOtherReason(String otherReason) {
		this.otherReason = otherReason;
	}


	public java.sql.Date getReportDate() {
		return reportDate;
	}


	public void setReportDate(java.sql.Date reportDate) {
		this.reportDate = reportDate;
	}


	public String getReportStatus() {
		return reportStatus;
	}


	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}


	public int getReportedPerson() {
		return reportedPerson;
	}


	public void setReportedPerson(int reportedPerson) {
		this.reportedPerson = reportedPerson;
	}


	public int getPlaceNo() {
		return placeNo;
	}


	public void setPlaceNo(int placeNo) {
		this.placeNo = placeNo;
	}


	public ReportPlaceDTO getPlaceCode() {
		return placeCode;
	}


	public void setPlaceCode(ReportPlaceDTO placeCode) {
		this.placeCode = placeCode;
	}


	@Override
	public String toString() {
		return "ReportAndReportPlaceDTO [no=" + no + ", userNo=" + userNo + ", reason=" + reason + ", otherReason="
				+ otherReason + ", reportDate=" + reportDate + ", reportStatus=" + reportStatus + ", reportedPerson="
				+ reportedPerson + ", placeNo=" + placeNo + ", placeCode=" + placeCode + "]";
	}
	
	
	
}
