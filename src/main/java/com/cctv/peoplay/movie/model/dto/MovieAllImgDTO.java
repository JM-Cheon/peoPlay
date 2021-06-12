package com.cctv.peoplay.movie.model.dto;

import java.util.Date;
import java.util.List;

public class MovieAllImgDTO {
	
	private int no;
	private String name;
	private String info;
	private String director;
	private int productionYear;
	private String movieTime;
	private int like;
	private int dislike;
	private String watchFear;
	private String watchModification;
	private String watchDrug;
	private String watchSensationality;
	private String watchScript;
	private String watchTitle;
	private String watchViolence;
	private String ratingName;
	private String movieStatus;
	private java.util.Date registrationDate;
	private java.util.Date movieEndDate;
	private String genreName;
	private String movieVideoRink;

	private List<MovieFileDTO> movieFile;

	public MovieAllImgDTO() {
	}

	public MovieAllImgDTO(int no, String name, String info, String director, int productionYear, String movieTime,
			int like, int dislike, String watchFear, String watchModification, String watchDrug,
			String watchSensationality, String watchScript, String watchTitle, String watchViolence, String ratingName,
			String movieStatus, Date registrationDate, Date movieEndDate, String genreName, String movieVideoRink,
			List<MovieFileDTO> movieFile) {
		super();
		this.no = no;
		this.name = name;
		this.info = info;
		this.director = director;
		this.productionYear = productionYear;
		this.movieTime = movieTime;
		this.like = like;
		this.dislike = dislike;
		this.watchFear = watchFear;
		this.watchModification = watchModification;
		this.watchDrug = watchDrug;
		this.watchSensationality = watchSensationality;
		this.watchScript = watchScript;
		this.watchTitle = watchTitle;
		this.watchViolence = watchViolence;
		this.ratingName = ratingName;
		this.movieStatus = movieStatus;
		this.registrationDate = registrationDate;
		this.movieEndDate = movieEndDate;
		this.genreName = genreName;
		this.movieVideoRink = movieVideoRink;
		this.movieFile = movieFile;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public String getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getDislike() {
		return dislike;
	}

	public void setDislike(int dislike) {
		this.dislike = dislike;
	}

	public String getWatchFear() {
		return watchFear;
	}

	public void setWatchFear(String watchFear) {
		this.watchFear = watchFear;
	}

	public String getWatchModification() {
		return watchModification;
	}

	public void setWatchModification(String watchModification) {
		this.watchModification = watchModification;
	}

	public String getWatchDrug() {
		return watchDrug;
	}

	public void setWatchDrug(String watchDrug) {
		this.watchDrug = watchDrug;
	}

	public String getWatchSensationality() {
		return watchSensationality;
	}

	public void setWatchSensationality(String watchSensationality) {
		this.watchSensationality = watchSensationality;
	}

	public String getWatchScript() {
		return watchScript;
	}

	public void setWatchScript(String watchScript) {
		this.watchScript = watchScript;
	}

	public String getWatchTitle() {
		return watchTitle;
	}

	public void setWatchTitle(String watchTitle) {
		this.watchTitle = watchTitle;
	}

	public String getWatchViolence() {
		return watchViolence;
	}

	public void setWatchViolence(String watchViolence) {
		this.watchViolence = watchViolence;
	}

	public String getRatingName() {
		return ratingName;
	}

	public void setRatingName(String ratingName) {
		this.ratingName = ratingName;
	}

	public String getMovieStatus() {
		return movieStatus;
	}

	public void setMovieStatus(String movieStatus) {
		this.movieStatus = movieStatus;
	}

	public java.util.Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(java.util.Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public java.util.Date getMovieEndDate() {
		return movieEndDate;
	}

	public void setMovieEndDate(java.util.Date movieEndDate) {
		this.movieEndDate = movieEndDate;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public String getMovieVideoRink() {
		return movieVideoRink;
	}

	public void setMovieVideoRink(String movieVideoRink) {
		this.movieVideoRink = movieVideoRink;
	}

	public List<MovieFileDTO> getMovieFile() {
		return movieFile;
	}

	public void setMovieFile(List<MovieFileDTO> movieFile) {
		this.movieFile = movieFile;
	}

	@Override
	public String toString() {
		return "MovieAllImgDTO [no=" + no + ", name=" + name + ", info=" + info + ", director=" + director
				+ ", productionYear=" + productionYear + ", movieTime=" + movieTime + ", like=" + like + ", dislike="
				+ dislike + ", watchFear=" + watchFear + ", watchModification=" + watchModification + ", watchDrug="
				+ watchDrug + ", watchSensationality=" + watchSensationality + ", watchScript=" + watchScript
				+ ", watchTitle=" + watchTitle + ", watchViolence=" + watchViolence + ", ratingName=" + ratingName
				+ ", movieStatus=" + movieStatus + ", registrationDate=" + registrationDate + ", movieEndDate="
				+ movieEndDate + ", genreName=" + genreName + ", movieVideoRink=" + movieVideoRink + ", movieFile="
				+ movieFile + "]";
	}
	
}
