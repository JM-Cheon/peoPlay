package com.cctv.peoplay.goods.model.dto;

import java.util.Date;

public class UserReportDTO {

	private int reportNo;
	private MemberDTO userNo;
	private String reportReason;
	private String otherReason;
	private java.util.Date reportDate;
	private String reportStatus;
	private int reportedPerson;
	private int reportPlaceNo;
	private String reportPlaceCode;
	public UserReportDTO(int reportNo, MemberDTO userNo, String reportReason, String otherReason, Date reportDate,
			String reportStatus, int reportedPerson, int reportPlaceNo, String reportPlaceCode) {
		this.reportNo = reportNo;
		this.userNo = userNo;
		this.reportReason = reportReason;
		this.otherReason = otherReason;
		this.reportDate = reportDate;
		this.reportStatus = reportStatus;
		this.reportedPerson = reportedPerson;
		this.reportPlaceNo = reportPlaceNo;
		this.reportPlaceCode = reportPlaceCode;
	}
	public UserReportDTO() {
	}
	@Override
	public String toString() {
		return "UserReportDTO [reportNo=" + reportNo + ", userNo=" + userNo + ", reportReason=" + reportReason
				+ ", otherReason=" + otherReason + ", reportDate=" + reportDate + ", reportStatus=" + reportStatus
				+ ", reportedPerson=" + reportedPerson + ", reportPlaceNo=" + reportPlaceNo + ", reportPlaceCode="
				+ reportPlaceCode + "]";
	}
	public int getReportNo() {
		return reportNo;
	}
	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}
	public MemberDTO getUserNo() {
		return userNo;
	}
	public void setUserNo(MemberDTO userNo) {
		this.userNo = userNo;
	}
	public String getReportReason() {
		return reportReason;
	}
	public void setReportReason(String reportReason) {
		this.reportReason = reportReason;
	}
	public String getOtherReason() {
		return otherReason;
	}
	public void setOtherReason(String otherReason) {
		this.otherReason = otherReason;
	}
	public java.util.Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(java.util.Date reportDate) {
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
	public int getReportPlaceNo() {
		return reportPlaceNo;
	}
	public void setReportPlaceNo(int reportPlaceNo) {
		this.reportPlaceNo = reportPlaceNo;
	}
	public String getReportPlaceCode() {
		return reportPlaceCode;
	}
	public void setReportPlaceCode(String reportPlaceCode) {
		this.reportPlaceCode = reportPlaceCode;
	}
	
}
