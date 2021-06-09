package com.cctv.peoplay.board.model.dto;

import java.sql.Date;

import com.cctv.peoplay.member.model.dto.MemberDTO;

public class BoardReplyDTO {

	private int no;
	private int postNo;
	private String content;
	private java.sql.Date date;
	private int reportCount;
	private String status;
	private int userNo;
	private MemberDTO memberDTO;
	
	public BoardReplyDTO( ) {
		
	}
	
	
	public BoardReplyDTO(int no, int postNo, String content, Date date, int reportCount, String status, int userNo,
			MemberDTO memberDTO) {
		super();
		this.no = no;
		this.postNo = postNo;
		this.content = content;
		this.date = date;
		this.reportCount = reportCount;
		this.status = status;
		this.userNo = userNo;
		this.memberDTO = memberDTO;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public int getPostNo() {
		return postNo;
	}


	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public java.sql.Date getDate() {
		return date;
	}


	public void setDate(java.sql.Date date) {
		this.date = date;
	}


	public int getReportCount() {
		return reportCount;
	}


	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public MemberDTO getMemberDTO() {
		return memberDTO;
	}


	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}


	@Override
	public String toString() {
		return "BoardReplyDTO [no=" + no + ", postNo=" + postNo + ", content=" + content + ", date=" + date
				+ ", reportCount=" + reportCount + ", status=" + status + ", userNo=" + userNo + ", memberDTO="
				+ memberDTO + "]";
	}

	

	

	
}
