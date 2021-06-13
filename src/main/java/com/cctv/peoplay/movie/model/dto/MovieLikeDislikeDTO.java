package com.cctv.peoplay.movie.model.dto;

import com.cctv.peoplay.member.model.dto.MemberDTO;

public class MovieLikeDislikeDTO {
	

	private MemberDTO userNo;
	private MovieDTO no;
	private String likeDislike;
	private int userNo2;
	private int no2;

	public MovieLikeDislikeDTO() {
	}
	public MovieLikeDislikeDTO(MemberDTO userNo, MovieDTO no, String likeDislike, int userNo2, int no2) {
		this.userNo = userNo;
		this.no = no;
		this.likeDislike = likeDislike;
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
	public String getLikeDislike() {
		return likeDislike;
	}
	public void setLikeDislike(String likeDislike) {
		this.likeDislike = likeDislike;
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
		return "MovieLikeDislikeDTO [userNo=" + userNo + ", no=" + no + ", likeDislike=" + likeDislike + ", userNo2="
				+ userNo2 + ", no2=" + no2 + "]";
	}
	
	
}
