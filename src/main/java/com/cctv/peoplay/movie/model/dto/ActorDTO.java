package com.cctv.peoplay.movie.model.dto;

public class ActorDTO {
	
	private int actorNo;
	private int no;
	private String actorName1;
	private String actorName2;
	private String actorName3;
	private String actorName4;
	private String actorName5;
	private MovieDTO movie;
	public ActorDTO() {
	}

	public ActorDTO(int actorNo, int no, String actorName1, String actorName2, String actorName3, String actorName4,
			String actorName5, MovieDTO movie) {
		this.actorNo = actorNo;
		this.no = no;
		this.actorName1 = actorName1;
		this.actorName2 = actorName2;
		this.actorName3 = actorName3;
		this.actorName4 = actorName4;
		this.actorName5 = actorName5;
		this.movie = movie;
	}

	public int getActorNo() {
		return actorNo;
	}
	public void setActorNo(int actorNo) {
		this.actorNo = actorNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getActorName1() {
		return actorName1;
	}

	public void setActorName1(String actorName1) {
		this.actorName1 = actorName1;
	}

	public String getActorName2() {
		return actorName2;
	}

	public void setActorName2(String actorName2) {
		this.actorName2 = actorName2;
	}

	public String getActorName3() {
		return actorName3;
	}

	public void setActorName3(String actorName3) {
		this.actorName3 = actorName3;
	}

	public String getActorName4() {
		return actorName4;
	}

	public void setActorName4(String actorName4) {
		this.actorName4 = actorName4;
	}

	public String getActorName5() {
		return actorName5;
	}

	public void setActorName5(String actorName5) {
		this.actorName5 = actorName5;
	}

	public MovieDTO getMovie() {
		return movie;
	}

	public void setMovie(MovieDTO movie) {
		this.movie = movie;
	}
	
	@Override
	public String toString() {
		return actorName1 + ", " + actorName2 + ", " + actorName3 + ", " + actorName4 + ", " + actorName5;
	}
//	@Override
//	public String toString() {
//		return "ActorDTO [actorNo=" + actorNo + ", no=" + no + ", actorName1=" + actorName1 + ", actorName2="
//				+ actorName2 + ", actorName3=" + actorName3 + ", actorName4=" + actorName4 + ", actorName5="
//				+ actorName5 + ", movie=" + movie + "]";
//	}

	





	
	
	
}
