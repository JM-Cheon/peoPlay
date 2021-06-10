package com.cctv.peoplay.board.model.dto;

import java.sql.Date;

import com.cctv.peoplay.member.model.dto.MemberDTO;

public class ReportAndReportPlaceDTO {

	
	private int no; // 신고 번호
	private int userNo; // 신고자
	private String reason;
	private String otherReason;
	private java.sql.Date reportDate;
	private String reportStatus;
	private int reportedPerson; // 신고 당한 사람
	private int placeNo;
	private int placeCode;
	private int refBoardNo;
	private int refGoodsNo;
	private int refMovieNo;
	private ReportPlaceDTO reportPlaceDTO;
	private MemberDTO reporter;
	private MemberDTO reported;
	
	
	public ReportAndReportPlaceDTO() {
		
	}


	public ReportAndReportPlaceDTO(int no, int userNo, String reason, String otherReason, Date reportDate,
			String reportStatus, int reportedPerson, int placeNo, int placeCode, int refBoardNo, int refGoodsNo,
			int refMovieNo, ReportPlaceDTO reportPlaceDTO, MemberDTO reporter, MemberDTO reported) {
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
		this.refBoardNo = refBoardNo;
		this.refGoodsNo = refGoodsNo;
		this.refMovieNo = refMovieNo;
		this.reportPlaceDTO = reportPlaceDTO;
		this.reporter = reporter;
		this.reported = reported;
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


	public int getPlaceCode() {
		return placeCode;
	}


	public void setPlaceCode(int placeCode) {
		this.placeCode = placeCode;
	}


	public int getRefBoardNo() {
		return refBoardNo;
	}


	public void setRefBoardNo(int refBoardNo) {
		this.refBoardNo = refBoardNo;
	}


	public int getRefGoodsNo() {
		return refGoodsNo;
	}


	public void setRefGoodsNo(int refGoodsNo) {
		this.refGoodsNo = refGoodsNo;
	}


	public int getRefMovieNo() {
		return refMovieNo;
	}


	public void setRefMovieNo(int refMovieNo) {
		this.refMovieNo = refMovieNo;
	}


	public ReportPlaceDTO getReportPlaceDTO() {
		return reportPlaceDTO;
	}


	public void setReportPlaceDTO(ReportPlaceDTO reportPlaceDTO) {
		this.reportPlaceDTO = reportPlaceDTO;
	}


	public MemberDTO getReporter() {
		return reporter;
	}


	public void setReporter(MemberDTO reporter) {
		this.reporter = reporter;
	}


	public MemberDTO getReported() {
		return reported;
	}


	public void setReported(MemberDTO reported) {
		this.reported = reported;
	}


	@Override
	public String toString() {
		return "ReportAndReportPlaceDTO [no=" + no + ", userNo=" + userNo + ", reason=" + reason + ", otherReason="
				+ otherReason + ", reportDate=" + reportDate + ", reportStatus=" + reportStatus + ", reportedPerson="
				+ reportedPerson + ", placeNo=" + placeNo + ", placeCode=" + placeCode + ", refBoardNo=" + refBoardNo
				+ ", refGoodsNo=" + refGoodsNo + ", refMovieNo=" + refMovieNo + ", reportPlaceDTO=" + reportPlaceDTO
				+ ", reporter=" + reporter + ", reported=" + reported + "]";
	}

	
	
}