package com.cctv.peoplay.board.model.dto;

import java.sql.Date;

public class ReportDTO {

	
	
	private int no;
	private int userNo; // 신고자
	private String reason;
	private java.sql.Date reportDate;
	private String reportStatus;
	private int reportedPerson; // 신고 당한 사람
	private int placeNo;
	private String placeCode;
	
	
	public ReportDTO() {
		
	}


	public ReportDTO(int no, int userNo, String reason, Date reportDate, String reportStatus, int reportedPerson,
			int placeNo, String placeCode) {
		super();
		this.no = no;
		this.userNo = userNo;
		this.reason = reason;
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


	public String getPlaceCode() {
		return placeCode;
	}


	public void setPlaceCode(String placeCode) {
		this.placeCode = placeCode;
	}


	@Override
	public String toString() {
		return "ReportDTO [no=" + no + ", userNo=" + userNo + ", reason=" + reason + ", reportDate=" + reportDate
				+ ", reportStatus=" + reportStatus + ", reportedPerson=" + reportedPerson + ", placeNo=" + placeNo
				+ ", placeCode=" + placeCode + "]";
	}
	
	

}
