package com.cctv.peoplay.Community.model.dto;

public class commentDTO {
	
	
	private int commentNo;
	private int inquiryNo;
	private String replyContent;
	private java.util.Date creationDate;
	private String commentStatus;
	private String answer;
	
	
	public commentDTO() {
	}


	public commentDTO(int commentNo, int inquiryNo, String replyContent, java.util.Date creationDate, String commentStatus,
			String answer) {
		this.commentNo = commentNo;
		this.inquiryNo = inquiryNo;
		this.replyContent = replyContent;
		this.creationDate = creationDate;
		this.commentStatus = commentStatus;
		this.answer = answer;
	}


	public int getCommentNo() {
		return commentNo;
	}


	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}


	public int getInquiryNo() {
		return inquiryNo;
	}


	public void setInquiryNo(int inquiryNo) {
		this.inquiryNo = inquiryNo;
	}


	public String getReplyContent() {
		return replyContent;
	}


	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}


	public java.util.Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(java.util.Date creationDate) {
		this.creationDate = creationDate;
	}


	public String getCommentStatus() {
		return commentStatus;
	}


	public void setCommentStatus(String commentStatus) {
		this.commentStatus = commentStatus;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	@Override
	public String toString() {
		System.out.println("creationDate : " + creationDate);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String sdfCreationDate = sdf.format(new java.util.Date(creationDate.getTime()));
		
		return "commentDTO [commentNo=" + commentNo + ", inquiryNo=" + inquiryNo + ", replyContent=" + replyContent
				+ ", creationDate=" + creationDate + ", commentStatus=" + commentStatus + ", answer=" + answer + "]";
	}


	
	
	
}
