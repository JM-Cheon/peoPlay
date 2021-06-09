package com.cctv.peoplay.board.model.dto;

public class ReportPlaceDTO {

	private int code;
	private String name;
	
	
	public ReportPlaceDTO() {
		
	}
	
	
	public ReportPlaceDTO(int code, String name) {
		super();
		this.code = code;
		this.name = name;
	}



	public int getCode() {
		return code;
	}



	public void setCode(int code) {
		this.code = code;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "ReportPlaceDTO [code=" + code + ", name=" + name + "]";
	}
	
	
	
	
}
