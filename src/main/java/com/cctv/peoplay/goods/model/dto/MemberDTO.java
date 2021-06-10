package com.cctv.peoplay.goods.model.dto;

import java.util.Date;

public class MemberDTO {
	
	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String userAddress;
	private String email;
	private String phone;
	private java.util.Date birthday;
	private String userRole;
	private java.util.Date userRegister;
	private String userStatus;
	private String spoilerYn;
	private String movieReviewYn;
	private java.util.Date blacklistDate;
	private java.util.Date withdrawDate;
	private int reportCumulative;
	public MemberDTO(int userNo, String userId, String userPwd, String userName, String userAddress, String email,
			String phone, Date birthday, String userRole, Date userRegister, String userStatus, String spoilerYn,
			String movieReviewYn, Date blacklistDate, Date withdrawDate, int reportCumulative) {
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userAddress = userAddress;
		this.email = email;
		this.phone = phone;
		this.birthday = birthday;
		this.userRole = userRole;
		this.userRegister = userRegister;
		this.userStatus = userStatus;
		this.spoilerYn = spoilerYn;
		this.movieReviewYn = movieReviewYn;
		this.blacklistDate = blacklistDate;
		this.withdrawDate = withdrawDate;
		this.reportCumulative = reportCumulative;
	}
	public MemberDTO() {
	}
	@Override
	public String toString() {
		return "MemberDTO [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", userAddress=" + userAddress + ", email=" + email + ", phone=" + phone + ", birthday=" + birthday
				+ ", userRole=" + userRole + ", userRegister=" + userRegister + ", userStatus=" + userStatus
				+ ", spoilerYn=" + spoilerYn + ", movieReviewYn=" + movieReviewYn + ", blacklistDate=" + blacklistDate
				+ ", withdrawDate=" + withdrawDate + ", reportCumulative=" + reportCumulative + "]";
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public java.util.Date getUserRegister() {
		return userRegister;
	}
	public void setUserRegister(java.util.Date userRegister) {
		this.userRegister = userRegister;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getSpoilerYn() {
		return spoilerYn;
	}
	public void setSpoilerYn(String spoilerYn) {
		this.spoilerYn = spoilerYn;
	}
	public String getMovieReviewYn() {
		return movieReviewYn;
	}
	public void setMovieReviewYn(String movieReviewYn) {
		this.movieReviewYn = movieReviewYn;
	}
	public java.util.Date getBlacklistDate() {
		return blacklistDate;
	}
	public void setBlacklistDate(java.util.Date blacklistDate) {
		this.blacklistDate = blacklistDate;
	}
	public java.util.Date getWithdrawDate() {
		return withdrawDate;
	}
	public void setWithdrawDate(java.util.Date withdrawDate) {
		this.withdrawDate = withdrawDate;
	}
	public int getReportCumulative() {
		return reportCumulative;
	}
	public void setReportCumulative(int reportCumulative) {
		this.reportCumulative = reportCumulative;
	}
	
	
}
