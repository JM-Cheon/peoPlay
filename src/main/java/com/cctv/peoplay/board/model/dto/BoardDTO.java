package com.cctv.peoplay.board.model.dto;

import java.sql.Date;

public class BoardDTO {

	
	private int no;
	private int userNo;
	private String title;
	private String content;
	private int view;
	private java.sql.Date creationDate;
	private int reportCount;
	private String status;
	private int commentCount;
	private String category;

	public BoardDTO() {}

	public BoardDTO(int no, int userNo, String title, String content, int view, Date creationDate, int reportCount,
			String status, int commentCount, String category) {
		super();
		this.no = no;
		this.userNo = userNo;
		this.title = title;
		this.content = content;
		this.view = view;
		this.creationDate = creationDate;
		this.reportCount = reportCount;
		this.status = status;
		this.commentCount = commentCount;
		this.category = category;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public java.sql.Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(java.sql.Date creationDate) {
		this.creationDate = creationDate;
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

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "BoardDTO [no=" + no + ", userNo=" + userNo + ", title=" + title + ", content=" + content + ", view="
				+ view + ", creationDate=" + creationDate + ", reportCount=" + reportCount + ", status=" + status
				+ ", commentCount=" + commentCount + ", category=" + category + "]";
	}

	
	
	
}
