package com.cctv.peoplay.member.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class MemberDTO implements Serializable{
	
	private static final long serialVersionUID = 4286983780754726575L;
	
	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String nickname;
	private String userAddress;
	private String email;
	private String phone;
	private java.sql.Date birthday;
	private String userRole;
	private java.sql.Date userRegister;
	private String userStatus;
	private String spoilerYN;
	private String movieReviewYN;
	private java.sql.Date blacklistDate;
	private java.sql.Date withdrawDate;
	private int reportCumulative;
	private java.sql.Date subscribeValidity;
	private int action;
	private int fantasy;
	private int romance;
	private int comedy;
	private int horror;
	
	public MemberDTO() {
	}

	public MemberDTO(int userNo, String userId, String userPwd, String userName, String nickname, String userAddress,
			String email, String phone, Date birthday, String userRole, Date userRegister, String userStatus,
			String spoilerYN, String movieReviewYN, Date blacklistDate, Date withdrawDate, int reportCumulative,
			Date subscribeValidity, int action, int fantasy, int romance, int comedy, int horror) {
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.nickname = nickname;
		this.userAddress = userAddress;
		this.email = email;
		this.phone = phone;
		this.birthday = birthday;
		this.userRole = userRole;
		this.userRegister = userRegister;
		this.userStatus = userStatus;
		this.spoilerYN = spoilerYN;
		this.movieReviewYN = movieReviewYN;
		this.blacklistDate = blacklistDate;
		this.withdrawDate = withdrawDate;
		this.reportCumulative = reportCumulative;
		this.subscribeValidity = subscribeValidity;
		this.action = action;
		this.fantasy = fantasy;
		this.romance = romance;
		this.comedy = comedy;
		this.horror = horror;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public java.sql.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.sql.Date birthday) {
		this.birthday = birthday;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public java.sql.Date getUserRegister() {
		return userRegister;
	}

	public void setUserRegister(java.sql.Date userRegister) {
		this.userRegister = userRegister;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getSpoilerYN() {
		return spoilerYN;
	}

	public void setSpoilerYN(String spoilerYN) {
		this.spoilerYN = spoilerYN;
	}

	public String getMovieReviewYN() {
		return movieReviewYN;
	}

	public void setMovieReviewYN(String movieReviewYN) {
		this.movieReviewYN = movieReviewYN;
	}

	public java.sql.Date getBlacklistDate() {
		return blacklistDate;
	}

	public void setBlacklistDate(java.sql.Date blacklistDate) {
		this.blacklistDate = blacklistDate;
	}

	public java.sql.Date getWithdrawDate() {
		return withdrawDate;
	}

	public void setWithdrawDate(java.sql.Date withdrawDate) {
		this.withdrawDate = withdrawDate;
	}

	public int getReportCumulative() {
		return reportCumulative;
	}

	public void setReportCumulative(int reportCumulative) {
		this.reportCumulative = reportCumulative;
	}

	public java.sql.Date getSubscribeValidity() {
		return subscribeValidity;
	}

	public void setSubscribeValidity(java.sql.Date subscribeValidity) {
		this.subscribeValidity = subscribeValidity;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public int getFantasy() {
		return fantasy;
	}

	public void setFantasy(int fantasy) {
		this.fantasy = fantasy;
	}

	public int getRomance() {
		return romance;
	}

	public void setRomance(int romance) {
		this.romance = romance;
	}

	public int getComedy() {
		return comedy;
	}

	public void setComedy(int comedy) {
		this.comedy = comedy;
	}

	public int getHorror() {
		return horror;
	}

	public void setHorror(int horror) {
		this.horror = horror;
	}

	@Override
	public String toString() {
		return "MemberDTO [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", nickname=" + nickname + ", userAddress=" + userAddress + ", email=" + email + ", phone=" + phone
				+ ", birthday=" + birthday + ", userRole=" + userRole + ", userRegister=" + userRegister
				+ ", userStatus=" + userStatus + ", spoilerYN=" + spoilerYN + ", movieReviewYN=" + movieReviewYN
				+ ", blacklistDate=" + blacklistDate + ", withdrawDate=" + withdrawDate + ", reportCumulative="
				+ reportCumulative + ", subscribeValidity=" + subscribeValidity + ", action=" + action + ", fantasy="
				+ fantasy + ", romance=" + romance + ", comedy=" + comedy + ", horror=" + horror + "]";
	}

}
