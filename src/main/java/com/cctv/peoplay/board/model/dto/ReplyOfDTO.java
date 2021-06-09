package com.cctv.peoplay.board.model.dto;

import java.sql.Date;

import com.cctv.peoplay.member.model.dto.MemberDTO;

public class ReplyOfDTO {

	
	private int no;
	private int refRelyNo;
	private String content;
	private int userNo;
	private java.sql.Date date;
	private String status;
	private int refBoardNo;
	private MemberDTO memberDTO;
	

	public ReplyOfDTO() {}


	public ReplyOfDTO(int no, int refRelyNo, String content, int userNo, Date date, String status, int refBoardNo,
			MemberDTO memberDTO) {
		super();
		this.no = no;
		this.refRelyNo = refRelyNo;
		this.content = content;
		this.userNo = userNo;
		this.date = date;
		this.status = status;
		this.refBoardNo = refBoardNo;
		this.memberDTO = memberDTO;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public int getRefRelyNo() {
		return refRelyNo;
	}


	public void setRefRelyNo(int refRelyNo) {
		this.refRelyNo = refRelyNo;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public java.sql.Date getDate() {
		return date;
	}


	public void setDate(java.sql.Date date) {
		this.date = date;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getRefBoardNo() {
		return refBoardNo;
	}


	public void setRefBoardNo(int refBoardNo) {
		this.refBoardNo = refBoardNo;
	}


	public MemberDTO getMemberDTO() {
		return memberDTO;
	}


	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}


	@Override
	public String toString() {
		return "ReplyOfDTO [no=" + no + ", refRelyNo=" + refRelyNo + ", content=" + content + ", userNo=" + userNo
				+ ", date=" + date + ", status=" + status + ", refBoardNo=" + refBoardNo + ", memberDTO=" + memberDTO
				+ "]";
	}

	
	
}