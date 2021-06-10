package com.cctv.peoplay.goods.model.dto;

public class ReportPlaceDTO {
	
	private String reportPlaceCode;
	private String reportPlaceName;
	public ReportPlaceDTO(String reportPlaceCode, String reportPlaceName) {
		this.reportPlaceCode = reportPlaceCode;
		this.reportPlaceName = reportPlaceName;
	}
	@Override
	public String toString() {
		return "ReportPlaceDTO [reportPlaceCode=" + reportPlaceCode + ", reportPlaceName=" + reportPlaceName + "]";
	}
	public ReportPlaceDTO() {
	}
	public String getReportPlaceCode() {
		return reportPlaceCode;
	}
	public void setReportPlaceCode(String reportPlaceCode) {
		this.reportPlaceCode = reportPlaceCode;
	}
	public String getReportPlaceName() {
		return reportPlaceName;
	}
	public void setReportPlaceName(String reportPlaceName) {
		this.reportPlaceName = reportPlaceName;
	}

}
