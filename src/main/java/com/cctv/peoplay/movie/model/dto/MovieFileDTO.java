package com.cctv.peoplay.movie.model.dto;

public class MovieFileDTO {
	
	private int mvFileNo;
	private int no;
	private String originName;
	private String saveName;
	private String savePath;
	private String fileType;
	private String fileStatus;
	
	private MovieDTO movie;

	public MovieFileDTO() {
	}

	public MovieFileDTO(int mvFileNo, int no, String originName, String saveName, String savePath, String fileType,
			String fileStatus, MovieDTO movie) {
		this.mvFileNo = mvFileNo;
		this.no = no;
		this.originName = originName;
		this.saveName = saveName;
		this.savePath = savePath;
		this.fileType = fileType;
		this.fileStatus = fileStatus;
		this.movie = movie;
	}

	public int getMvFileNo() {
		return mvFileNo;
	}

	public void setMvFileNo(int mvFileNo) {
		this.mvFileNo = mvFileNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileStatus() {
		return fileStatus;
	}

	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}

	public MovieDTO getMovie() {
		return movie;
	}

	public void setMovie(MovieDTO movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "MovieFileDTO [mvFileNo=" + mvFileNo + ", no=" + no + ", originName=" + originName + ", saveName="
				+ saveName + ", savePath=" + savePath + ", fileType=" + fileType + ", fileStatus=" + fileStatus
				+ ", movie=" + movie + "]";
	}
	
	
}
