package com.cctv.peoplay.movie.model.dto;

import java.util.Date;

import com.cctv.peoplay.member.model.dto.MemberDTO;

public class MovieWatchListDTO {

	private MemberDTO userNo;
	private MovieDTO no;
	private java.util.Date watchListDate;
	private int userNo2;
	private int no2;
	public MovieWatchListDTO() {
	}
	public MovieWatchListDTO(MemberDTO userNo, MovieDTO no, Date watchListDate, int userNo2, int no2) {
		this.userNo = userNo;
		this.no = no;
		this.watchListDate = watchListDate;
		this.userNo2 = userNo2;
		this.no2 = no2;
	}
	public MemberDTO getUserNo() {
		return userNo;
	}
	public void setUserNo(MemberDTO userNo) {
		this.userNo = userNo;
	}
	public MovieDTO getNo() {
		return no;
	}
	public void setNo(MovieDTO no) {
		this.no = no;
	}
	public java.util.Date getWatchListDate() {
		return watchListDate;
	}
	public void setWatchListDate(java.util.Date watchListDate) {
		this.watchListDate = watchListDate;
	}
	public int getUserNo2() {
		return userNo2;
	}
	public void setUserNo2(int userNo2) {
		this.userNo2 = userNo2;
	}
	public int getNo2() {
		return no2;
	}
	public void setNo2(int no2) {
		this.no2 = no2;
	}
	@Override
	public String toString() {
		return "MovieWatchListDTO [userNo=" + userNo + ", no=" + no + ", watchListDate=" + watchListDate + ", userNo2="
				+ userNo2 + ", no2=" + no2 + "]";
	}
	
	
	
}

